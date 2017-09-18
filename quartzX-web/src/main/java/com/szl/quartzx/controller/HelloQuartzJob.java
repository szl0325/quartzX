package com.szl.quartzx.controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloQuartzJob implements Job{
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
        System.out.println(jobKey + "在" + df.format(new Date()) + "时，输出了：Hello World!!!");
    }
}
