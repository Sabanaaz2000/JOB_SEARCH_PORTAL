package com.weeklyTest.JobSearchPortal.repo;

import com.weeklyTest.JobSearchPortal.model.Job;
import com.weeklyTest.JobSearchPortal.model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job, Long> {
    List<Job> findByJobType(Type types);

    List<Job> findByCompanyName(String companyName);

    List<Job> findByCompanyNameAndJobType(String companyName, Type types);

    List<Job> findByJobTypeAndSalaryGreaterThan(Type types, Double amount);

    @Modifying
    @Query(value = "UPDATE JOBS SET SALARY = (SALARY + SALARY*(:hike)) WHERE JOB_ID = :id" ,  nativeQuery = true)
    void updateSalaryById(Long id, Float hike);

    @Modifying
    @Query(value = "DELETE FROM JOBS WHERE APPLIED_DATE < :date" , nativeQuery = true)
    void removeJobsBeforeDate(LocalDate date);

    List<Job> findByAppliedDateLessThan(LocalDate date);

    List<Job> findByAppliedDateGreaterThan(LocalDate date);
}
