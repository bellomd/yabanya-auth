package com.yabanya.auth.service.impl;

import com.yabanya.auth.exception.PasswordHistoryNotFoundException;
import com.yabanya.auth.orm.entity.PasswordHistory;
import com.yabanya.auth.orm.repository.PasswordHistoryRepository;
import com.yabanya.auth.service.PasswordHistoryService;
import com.yabanya.commons.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PasswordHistoryServiceImpl extends AbstractServiceImpl<PasswordHistory, PasswordHistoryRepository>
        implements PasswordHistoryService {

    @Autowired
    public PasswordHistoryServiceImpl(final PasswordHistoryRepository passwordHistoryRepository) {
        super(passwordHistoryRepository);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PasswordHistory findByUserId(final Long userId) {

        return getRepository().findByUserId(userId).orElseThrow(() ->
                new PasswordHistoryNotFoundException("History not found with the given userId: " + userId));
    }
}
