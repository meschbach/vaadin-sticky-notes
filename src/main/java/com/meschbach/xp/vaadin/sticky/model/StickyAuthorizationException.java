/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin.sticky.model;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class StickyAuthorizationException extends StickyException {

    public StickyAuthorizationException() {
    }

    public StickyAuthorizationException(String message) {
	super(message);
    }

    public StickyAuthorizationException(String message, Throwable cause) {
	super(message, cause);
    }

    public StickyAuthorizationException(Throwable cause) {
	super(cause);
    }
}
