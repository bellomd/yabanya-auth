package com.yabanya.auth.exception;

import com.yabanya.commons.utils.exception.AbstractRuntimeException;

public class PasswordHistoryNotFoundException extends AbstractRuntimeException {

    public PasswordHistoryNotFoundException(final String message) { super(message); }
    public PasswordHistoryNotFoundException(final Throwable cause) { super(cause); }
    public PasswordHistoryNotFoundException(final String message, final Throwable cause) { super(message, cause); }
}
