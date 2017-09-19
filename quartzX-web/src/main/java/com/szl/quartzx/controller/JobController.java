package com.szl.quartzx.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job")
public class JobController {
    static Logger logger = LogManager.getLogger(JobController.class.getName());

    @RequestMapping("/showPage")
    public String showPage(){
        logger.error("测试log4j2");
        return "job/jobList";
    }

}
