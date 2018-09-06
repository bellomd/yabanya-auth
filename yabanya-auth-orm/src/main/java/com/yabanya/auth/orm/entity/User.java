package com.yabanya.auth.orm.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.yabanya.commons.orm.entity.AbstractAuditedEntity;

@Entity
@Audited
@Table(name = "T_USER")
@Access(AccessType.FIELD)
public class User extends AbstractAuditedEntity {

    private static final long serialVersionUID = -1194951025410119392L;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @Column
    private String contactAddress;

    @Column
    private long loginCount;

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public User(final UserBuilder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
        this.contactAddress = builder.contactAddress;
        this.loginCount = builder.loginCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(final String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public void updateLoginCount(final long loginCount) {
        this.loginCount = this.loginCount + loginCount;
    }

    public static UserBuilder newBuilder(final String username, final String password) {
        return new UserBuilder(username, password);
    }

    public static class UserBuilder {

        private Long userId;
        private String firstName;
        private String middleName;
        private String lastName;
        private final String username;
        private final String password;
        private String phoneNumber;
        private String emailAddress;
        private String contactAddress;
        private long loginCount;

        private UserBuilder(final String username, final String password) {
            this.username = username;
            this.password = password;
        }

        public Long getUserId() {
            return userId;
        }

        public UserBuilder userId(final Long userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder middleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        public UserBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder phoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder emailAddress(final String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public UserBuilder contactAddress(final String contactAddress) {
            this.contactAddress = contactAddress;
            return this;
        }

        public UserBuilder loginCount(final long loginCount) {
            this.loginCount = loginCount;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
