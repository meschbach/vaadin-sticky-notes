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
    int id;

    public MemoryStickyNote(String message, int id) {
	this.message = message;
	this.id = id;
    }

    public MemoryStickyNote(int id) {
	this.id = id;
    }

    public MemoryStickyNote() {
	this("", -1);
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    @Override
    public boolean equals(Object value) {
	boolean isEqual;
	if (value instanceof MemoryStickyNote) {
	    MemoryStickyNote msn = (MemoryStickyNote) value;
	    isEqual = id == msn.id;
	} else {
	    isEqual = false;
	}
	return isEqual;
    }
}
