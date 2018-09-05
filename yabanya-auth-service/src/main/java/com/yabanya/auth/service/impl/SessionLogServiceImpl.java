package com.yabanya.auth.service.impl;

import com.yabanya.auth.orm.entity.SessionLog;
import com.yabanya.auth.orm.repository.SessionLogRepository;
import com.yabanya.auth.service.SessionLogService;
import com.yabanya.commons.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionLogServiceImpl extends AbstractServiceImpl<SessionLog, SessionLogRepository>
        implements SessionLogService {

    @Autowired
    public SessionLogServiceImpl(final SessionLogRepository sessionLogRepository) {
        super(sessionLogRepository);
    }
}
