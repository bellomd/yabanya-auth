package com.yabanya.auth.api.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "updateUserDto")
public class UserUpdateDto implements Serializable {

    private static final long serialVersionUID = 8040646108712776135L;

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String contactAddress;

    private UserUpdateDto(final UpdateUserDtoBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
        this.contactAddress = builder.contactAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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

    public static class UpdateUserDtoBuilder {

        private Long id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String phoneNumber;
        private String emailAddress;
        private String contactAddress;

        public UpdateUserDtoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public UpdateUserDtoBuilder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UpdateUserDtoBuilder middleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        public UpdateUserDtoBuilder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UpdateUserDtoBuilder phoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UpdateUserDtoBuilder emailAddress(final String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public UpdateUserDtoBuilder contactAddress(final String contactAddress) {
            this.contactAddress = contactAddress;
            return this;
        }

        public UserUpdateDto build() {
            return new UserUpdateDto(this);
        }
    }
}
