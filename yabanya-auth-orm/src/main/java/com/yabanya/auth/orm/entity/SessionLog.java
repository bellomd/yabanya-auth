package com.yabanya.auth.orm.entity;

import com.yabanya.commons.orm.entity.AbstractAuditedEntity;

import javax.persistence.*;

@Entity
@Table(name = "SESSION_LOG")
@Access(AccessType.FIELD)
public class SessionLog extends AbstractAuditedEntity {

    private static final long serialVersionUID = -4224445154227811814L;

    @Column(nullable = false)
    private String userToken;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String username;

    private SessionLog() {}

    public SessionLog(final String userToken, final Long userId, final String username) {
        this.userToken = userToken;
        this.userId = userId;
        this.username = username;
    }

    public String getUserToken() {
        return userToken;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
