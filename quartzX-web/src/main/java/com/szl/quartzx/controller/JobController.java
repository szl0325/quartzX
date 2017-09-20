package com.szl.quartzx.controller;

import com.szl.quartzx.domain.Pagination;
import com.szl.quartzx.domain.TestDomain;
import com.szl.quartzx.service.JobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/job")
public class JobController {
    static Logger logger = LogManager.getLogger(JobController.class.getName());

    @Autowired
    private JobService jobService;

    @RequestMapping("/showPage")
    public String showPage(){
        logger.error("JobController.showPage()");
        return "job/jobList";
    }

    @RequestMapping("/jobList")
    @ResponseBody
    public Pagination<TestDomain> jobList(){
        logger.error("JobController.jobList()");
        return jobService.jobList();
    }
}
