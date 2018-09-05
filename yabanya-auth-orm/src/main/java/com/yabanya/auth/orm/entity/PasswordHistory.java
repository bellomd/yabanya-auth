package com.yabanya.auth.orm.entity;

import com.yabanya.commons.orm.entity.AbstractAuditedEntity;

import javax.persistence.*;

@Entity
@Table(name = "PASSWORD_HISTORY")
@Access(AccessType.FIELD)
public class PasswordHistory extends AbstractAuditedEntity {

    private static final long serialVersionUID = 8317606574639590021L;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String oldPassword;

    @Column(nullable = false)
    private String newPassword;

    @Column(nullable = false)
    private Long modifierId;

    @Column(nullable = false)
    private String modifierUsername;

    private PasswordHistory() {}

    public PasswordHistory(final Long userId,
                           final String oldPassword,
                           final String newPassword,
                           final Long modifierId,
                           final String modifierUsername) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.modifierId = modifierId;
        this.modifierUsername = modifierUsername;
    }

    public Long getUserId() {
        return userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public String getModifierUsername() {
        return modifierUsername;
    }
}
