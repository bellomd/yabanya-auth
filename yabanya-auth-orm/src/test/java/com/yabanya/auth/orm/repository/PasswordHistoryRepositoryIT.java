package com.yabanya.auth.orm.repository;

import com.yabanya.auth.orm.entity.PasswordHistory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PasswordHistoryRepositoryIT extends AbstractRepositoryIT {

    @Autowired
    private PasswordHistoryRepository passwordHistoryRepository;

    @Test
    @Transactional
    public void findByUserId_findPasswordHistoryByUserId_optionalPasswordHistory() {

        // Create password history
        PasswordHistory passwordHistory = PasswordHistoryStub.creatDummyPasswordHistory();
        passwordHistory = passwordHistoryRepository.saveAndFlush(passwordHistory);

        Assert.assertNotNull(passwordHistory);
        Assert.assertNotNull(passwordHistory.getId());

        // Retrieve password history
        final Optional<PasswordHistory> foundHistory =
                passwordHistoryRepository.findByUserId(passwordHistory.getUserId());

        Assert.assertTrue(foundHistory.isPresent());
        Assert.assertNotNull(foundHistory.get());
        Assert.assertNotNull(foundHistory.get().getId());
        Assert.assertEquals(passwordHistory, foundHistory.get());
    }
}
