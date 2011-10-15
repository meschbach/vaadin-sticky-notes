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
public class StickyQuotaException extends StickyException {

    public StickyQuotaException() {
    }

    public StickyQuotaException(String message) {
	super(message);
    }

    public StickyQuotaException(String message, Throwable cause) {
	super(message, cause);
    }

    public StickyQuotaException(Throwable cause) {
	super(cause);
    }
}
