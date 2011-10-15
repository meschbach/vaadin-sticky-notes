/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin.sticky.model.memory;

import com.meschbach.xp.vaadin.sticky.model.StickyNote;
import java.io.Serializable;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class MemoryStickyNote implements Serializable, StickyNote {

    String message;

    public MemoryStickyNote( String message) {
	this.message = message;
    }

    public MemoryStickyNote() {
	this("");
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }
}
