package com.weeklyTest.JobSearchPortal.controller;

import com.weeklyTest.JobSearchPortal.model.Job;
import com.weeklyTest.JobSearchPortal.model.Type;
import com.weeklyTest.JobSearchPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService myJob;

    @PostMapping("jobs")
    public String addAllJobs(@RequestBody List<Job> newJob){
        return myJob.addAllMyJobs(newJob);
    }

    @GetMapping("jobs")
    public List<Job> getAllJobss(){
        return myJob.getAllJobs();
    }


    @GetMapping("job/id/{id}")
    public Job getJobById(@PathVariable Long id){
        return myJob.getJobById(id);
    }

    @GetMapping("jobs/type/{types}")
    public List<Job> findJobByType(@PathVariable Type types){
        return  myJob.findJobByType(types);
    }
    @GetMapping("jobs/company/name/{companyName}")
    public List<Job> findJobByCompanyName(@PathVariable String companyName){
        return  myJob.findJobByCompanyName(companyName);
    }
    @GetMapping("jobs/company/name/{companyName}/job/type/{types}")
    public List<Job> findJobByCompanyNameAndJobTypes(@PathVariable String companyName, @PathVariable Type types){
        return  myJob.findJobByCompanyNameAndJobTypes(companyName,types);
    }
    @GetMapping("jobs/type/{types}/greater/{amount}")
    public List<Job> findJobByJobTypesAndGreaterThanAmount(@PathVariable Type types, @PathVariable Double amount){
        return  myJob.findJobByJobTypesAndGreaterThanAmount(types, amount);
    }

    @GetMapping("jobs/date/before")
    public List<Job> getJobsBeforeDate(@RequestParam LocalDate date){
        return myJob.getJobsBeforeDate(date);
    }
    @GetMapping("jobs/date/after")
    public List<Job> getJobsAfterDate(@RequestParam LocalDate date){
        return myJob.getJobsAfterDate(date);
    }
    @PutMapping("job/id/{id}")
    public String updateJobById(@PathVariable Long id, @RequestBody Job newJob){
        return myJob.updateJobById(id, newJob);
    }

    @PutMapping("job/id/salary/hike")
    public String updateSalaryByType(@RequestParam Long id, @RequestParam Float hike){
        return myJob.updateSalaryById(id, hike);
    }

    @DeleteMapping("job/id/{id}")
    public String removeJobById(@PathVariable Long id){
        return  myJob.removeJobById(id);
    }

    @DeleteMapping("jobs")
    public String removeAllJobs(){
        return myJob.removeAllJobs();
    }
    @DeleteMapping("jobs/before/date")
    public String removeJobsBeforeDate(@RequestParam LocalDate date){
        return myJob.removeJobsBeforeDate(date);
    }


}
