package com.yabanya.auth.exception;

import com.yabanya.commons.utils.exception.AbstractRuntimeException;

public class RoleNotFoundException extends AbstractRuntimeException {

    private static final long serialVersionUID = 7226984943957100362L;

    public RoleNotFoundException(final String message) { super(message); }
    public RoleNotFoundException(final Throwable cause) { super(cause); }
    public RoleNotFoundException(final String message, final Throwable cause) { super(message, cause); }
}
