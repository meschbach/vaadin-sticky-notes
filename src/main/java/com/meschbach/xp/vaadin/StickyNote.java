/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import java.io.Serializable;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class StickyNote implements Serializable {

    String title;
    String message;

    public StickyNote(String title, String message) {
	this.title = title;
	this.message = message;
    }

    public StickyNote() {
	this("", "");
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }
}
