package com.weeklyTest.JobSearchPortal.service;

import com.weeklyTest.JobSearchPortal.model.Job;
import com.weeklyTest.JobSearchPortal.model.Type;
import com.weeklyTest.JobSearchPortal.repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;

    public String addAllMyJobs(List<Job> newJob) {
        jobRepo.saveAll(newJob);
        return newJob.size()+" jobs added successfully";
    }

    public List<Job> getAllJobs() {
        return  (List<Job>) jobRepo.findAll();
    }


    public Job getJobById(Long id) {
        Job presentJob = jobRepo.findById(id).orElse(null);
        if(presentJob != null){
            return presentJob;
        }
        return null;

    }

    public String updateJobById(Long id, Job newJob) {
        Job presentJob = jobRepo.findById(id).orElse(null);
        if(presentJob != null){
            presentJob.setJobTitle(newJob.getJobTitle());
            presentJob.setJobDescription(newJob.getJobDescription());
            presentJob.setCompanyLocation(newJob.getCompanyLocation());
            presentJob.setSalary(newJob.getSalary());
            presentJob.setCompanyEmail(newJob.getCompanyEmail());
            presentJob.setCompanyName(newJob.getCompanyName());
            presentJob.setEmployerName(newJob.getEmployerName());
            presentJob.setJobType(newJob.getJobType());
            presentJob.setAppliedDate(newJob.getAppliedDate());

            return "Job with id: "+id+" updated successfully.";
        }
        return "Job with id: "+id+" not found.";
    }

    public String removeJobById(Long id) {
        Job presentJob = jobRepo.findById(id).orElse(null);
        if(presentJob != null){
            jobRepo.deleteById(id);
            return "Job with id: "+id+" deleted successfully.";
        }
        return "Job with id: "+id+" not found.";
    }

    public List<Job> findJobByType(Type types) {
        return  jobRepo.findByJobType(types);
    }

    public List<Job> findJobByCompanyName(String companyName) {
        return jobRepo.findByCompanyName(companyName);
    }

    public List<Job> findJobByCompanyNameAndJobTypes(String companyName, Type types) {
        return jobRepo.findByCompanyNameAndJobType(companyName,types);
    }

    public List<Job> findJobByJobTypesAndGreaterThanAmount(Type types, Double amount) {
        return  jobRepo.findByJobTypeAndSalaryGreaterThan(types,amount);
    }

    @Transactional
    public String updateSalaryById(Long id, Float hike) {
        jobRepo.updateSalaryById(id,hike);
        return "Salary with Job id : "+id+ " is increased by "+hike*100+"%";
    }

    @Transactional
    public String removeJobsBeforeDate(LocalDate date) {
        jobRepo.removeJobsBeforeDate(date);
        return "All the listed jobs before "+ date+ " is deleted successfully.";
    }

    public String removeAllJobs() {
        jobRepo.deleteAll();
        return "All jobs are deleted successfully.";
    }

    public List<Job> getJobsBeforeDate(LocalDate date) {
        return jobRepo.findByAppliedDateLessThan(date);
    }

    public List<Job> getJobsAfterDate(LocalDate date) {
        return jobRepo.findByAppliedDateGreaterThan(date);
    }
}
