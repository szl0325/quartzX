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
        DateFormat df = new SimpleDateFormat("yyyy��MM��dd��  HHʱmm��ss��");
        System.out.println(jobKey + "��" + df.format(new Date()) + "ʱ������ˣ�Hello World!!!");
    }
}
