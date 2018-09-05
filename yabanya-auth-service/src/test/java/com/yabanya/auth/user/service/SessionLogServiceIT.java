package com.yabanya.auth.user.service;

import com.yabanya.auth.orm.entity.SessionLog;
import com.yabanya.auth.orm.repository.DummyGenerator;
import com.yabanya.auth.service.SessionLogService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SessionLogServiceIT extends AbstractServiceIT {

    @Autowired
    private SessionLogService sessionLogService;

    @Test
    @Transactional
    public void createSessionLog_addUserSessionLog_sessionLog() {

        SessionLog sessionLog = new SessionLog(
                DummyGenerator.dummy20CharString(),
                DummyGenerator.randomLong(),
                DummyGenerator.dummy10CharString());

        sessionLog = sessionLogService.create(sessionLog);

        Assert.assertNotNull(sessionLog);
        Assert.assertNotNull(sessionLog.getId());
        Assert.assertNotNull(sessionLog.getUserId());
        Assert.assertNotNull(sessionLog.getUsername());
        Assert.assertNotNull(sessionLog.getUserToken());
    }
}
