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
public class StickyException extends Exception {

    public StickyException(Throwable cause) {
	super(cause);
    }

    public StickyException(String message, Throwable cause) {
	super(message, cause);
    }

    public StickyException(String message) {
	super(message);
    }

    public StickyException() {
    }
}
