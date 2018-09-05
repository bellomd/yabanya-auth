package com.yabanya.auth.exception;

import com.yabanya.commons.utils.exception.AbstractRuntimeException;

public class UserNotFoundException extends AbstractRuntimeException {

    public UserNotFoundException(final String message) { super(message); }
    public UserNotFoundException(final Throwable cause) { super(cause); }
    public UserNotFoundException(final String message, final Throwable cause) { super(message, cause); }
}
