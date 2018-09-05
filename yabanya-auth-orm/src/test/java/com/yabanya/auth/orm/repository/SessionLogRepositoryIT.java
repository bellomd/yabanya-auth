package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.SessionLog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SessionLogRepositoryIT extends AbstractRepositoryIT {

    @Autowired
    private SessionLogRepository sessionLogRepository;

    @Test
    @Transactional
    public void createSessionLog_addUserSessionLog_sessionLog() {

        SessionLog sessionLog = new SessionLog(
                DummyGenerator.dummy20CharString(),
                DummyGenerator.randomLong(),
                DummyGenerator.dummy10CharString());

        sessionLog = sessionLogRepository.saveAndFlush(sessionLog);

        Assert.assertNotNull(sessionLog);
        Assert.assertNotNull(sessionLog.getId());
        Assert.assertNotNull(sessionLog.getUserId());
        Assert.assertNotNull(sessionLog.getUsername());
        Assert.assertNotNull(sessionLog.getUserToken());
    }
}
