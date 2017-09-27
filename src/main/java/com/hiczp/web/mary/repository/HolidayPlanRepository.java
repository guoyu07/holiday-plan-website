package com.hiczp.web.mary.repository;

import com.hiczp.web.mary.entity.HolidayPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayPlanRepository extends CrudRepository<HolidayPlan, String> {
    List<HolidayPlan> findAllByHolidayNameOrderById(String holidayName);
}
