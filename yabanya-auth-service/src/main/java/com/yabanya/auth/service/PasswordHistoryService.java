package com.yabanya.auth.service;

import com.yabanya.auth.orm.entity.PasswordHistory;
import com.yabanya.commons.service.AbstractService;

public interface PasswordHistoryService extends AbstractService<PasswordHistory> {

    /**
     * Find by user id
     *
     * @param userId to find the history with
     * @return Optional PasswordHistory
     */
    PasswordHistory findByUserId(final Long userId);
}
