package com.szl.quartzx.service;

import com.szl.quartzx.domain.Pagination;
import com.szl.quartzx.domain.TestDomain;

public interface JobService {
    Pagination<TestDomain> jobList();
}
