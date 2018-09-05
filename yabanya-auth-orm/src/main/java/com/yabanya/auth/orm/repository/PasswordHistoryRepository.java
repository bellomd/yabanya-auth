package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.PasswordHistory;
import com.yabanya.commons.orm.repository.Repository;

import java.util.Optional;

public interface PasswordHistoryRepository extends Repository<PasswordHistory> {

    /**
     * Find by user id
     *
     * @param userId to find the history with
     * @return Optional PasswordHistory
     */
    Optional<PasswordHistory> findByUserId(final Long userId);
}
