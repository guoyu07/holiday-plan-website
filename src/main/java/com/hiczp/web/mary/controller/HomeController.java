package com.hiczp.web.mary.controller;

import com.hiczp.web.mary.entity.HolidayPlan;
import com.hiczp.web.mary.model.HolidayPlanFormModel;
import com.hiczp.web.mary.repository.HolidayPlanRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;

@Controller
public class HomeController {
    private HolidayPlanRepository holidayPlanRepository;

    public HomeController(HolidayPlanRepository holidayPlanRepository) {
        this.holidayPlanRepository = holidayPlanRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("home/index");
        return modelAndView;
    }

    @GetMapping("/holiday_plan")
    public ModelAndView holidayPlan(ModelAndView modelAndView, HolidayPlanFormModel holidayPlanFormModel,
                                    @Value("${holiday.start}") Date holidayStart, @Value("${holiday.end}") Date holidayEnd) {
        holidayPlanFormModel.setLeaveTime(holidayStart);
        holidayPlanFormModel.setBackTime(holidayEnd);
        modelAndView.setViewName("home/holiday_plan");
        return modelAndView.addObject("nationalDayPlanFormModel", holidayPlanFormModel);
    }

    @PostMapping("/holiday_plan")
    public ModelAndView holidayPlan(ModelAndView modelAndView,
                                    @Valid HolidayPlanFormModel holidayPlanFormModel, BindingResult bindingResult,
                                    HttpServletRequest httpServletRequest,
                                    @Value("${holiday.name}") String holidayName) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("home/holiday_plan");
            return modelAndView.addObject("nationalDayPlanFormModel", holidayPlanFormModel);
        }

        HolidayPlan holidayPlan = new HolidayPlan(holidayPlanFormModel);
        if (holidayPlanFormModel.getWhereToGo() != HolidayPlan.WhereToGo.STAY_IN_SCHOOL) {
            holidayPlan.setLeaveTime(holidayPlanFormModel.getLeaveTime());
            holidayPlan.setBackTime(holidayPlanFormModel.getBackTime());
        }
        holidayPlan.setIp(httpServletRequest.getRemoteAddr());
        holidayPlan.setSubmitTime(new Timestamp(System.currentTimeMillis()));
        holidayPlan.setHolidayName(holidayName);
        holidayPlanRepository.save(holidayPlan);
        modelAndView.setViewName("home/success");
        return modelAndView;
    }

    @GetMapping("/finished")
    public ModelAndView finished(ModelAndView modelAndView, @Value("${holiday.name}") String holidayName) {
        modelAndView.setViewName("/home/finished");
        return modelAndView.addObject("holidayPlanList", holidayPlanRepository.findAllByHolidayNameOrderById(holidayName));
    }
}
