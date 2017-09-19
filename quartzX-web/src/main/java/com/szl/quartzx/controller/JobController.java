package com.szl.quartzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job")
public class JobController {

    @RequestMapping("/showPage")
    public String showPage(){
        System.out.println("xxx");
        return "job/jobList";
    }

}
