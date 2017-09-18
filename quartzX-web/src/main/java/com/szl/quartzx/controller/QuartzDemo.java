package com.szl.quartzx.controller;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuartzDemo {

    public void run() throws SchedulerException {
        System.out.println("------- ��ʼ�� ----------------------");
        //ͨ��SchedulerFactory�������ȡScheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        System.out.println("------- ��ʼ����� -----------");
        //����ִ��ʱ��
//      Date runTime = DateBuilder.evenMinuteDate(new Date());
        Date runTime = DateBuilder.evenSecondDateAfterNow();
        System.out.println("------- ��Job����Scheduler��  ------");

        //��������Jobʵ���༰������һЩ��̬��Ϣ������һ����ҵʵ��
        JobDetail jobDetail = JobBuilder.newJob(HelloQuartzJob.class)
                .withIdentity("testJob_1", "group_1")
                .build();

        //���𴥷�Jobִ�е�ʱ�䴥������,Triggerʵ����һ��������
        Trigger trigger = TriggerBuilder.newTrigger()//����һ���µ�TriggerBuilder���淶һ��������
                .withIdentity("trigger_1", "group_1")//��������һ�����ֺ�����
//                      .startNow()//����ִ��
                .startAt(runTime)//���ô�����ʼ��ʱ��
                .withSchedule
                        (
                                SimpleScheduleBuilder.simpleSchedule()
                                        .withIntervalInSeconds(2)//ʱ����
                                        .withRepeatCount(5)//�ظ���������ִ��6�Σ�
                        )
                .build();//����������

        //����������ʹ��SchedulerFactory����Schedulerʵ��
        Scheduler sched = sf.getScheduler();

        //��Scheduler���һ��job��trigger
        sched.scheduleJob(jobDetail, trigger);
        System.out.println(jobDetail.getKey() + " ������: " + runTime);

        sched.start();
    }

    /**
     * ���Ȳ���
     * @param args
     * @throws SchedulerException
     */
    public static void main(String[] args) throws SchedulerException {
        QuartzDemo demo = new QuartzDemo();
        demo.run();
    }
}
