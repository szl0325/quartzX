package com.szl.quartzx.service.impl;

import com.szl.quartzx.domain.Pagination;
import com.szl.quartzx.domain.TestDomain;
import com.szl.quartzx.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    public Pagination<TestDomain> jobList() {
        List<TestDomain> list = new ArrayList<TestDomain>();
        TestDomain testDomain1 = new TestDomain();
        testDomain1.setId(1);
        testDomain1.setName("11");
        testDomain1.setPhone("111");

        TestDomain testDomain2 = new TestDomain();
        testDomain2.setId(2);
        testDomain2.setName("22");
        testDomain2.setPhone("222");

        list.add(testDomain1);
        list.add(testDomain2);

        Pagination<TestDomain> pages = new Pagination<TestDomain>();
        pages.setPageSize(1);
        pages.setData(list);
        pages.setTotal(2);

        return pages;
    }
}
