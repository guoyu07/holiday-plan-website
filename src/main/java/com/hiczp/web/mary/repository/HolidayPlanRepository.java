package com.hiczp.web.mary.repository;

import com.hiczp.web.mary.entity.HolidayPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayPlanRepository extends CrudRepository<HolidayPlan, String> {

}
