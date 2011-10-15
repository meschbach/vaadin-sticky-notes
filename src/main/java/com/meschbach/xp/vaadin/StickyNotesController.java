/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.meschbach.xp.vaadin.sticky.model.StickyException;
import com.meschbach.xp.vaadin.sticky.model.StickyNote;
import com.meschbach.xp.vaadin.sticky.model.StickyQuotaException;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;
import java.io.Serializable;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class StickyNotesController implements Button.ClickListener, Serializable {

    StickyUser model;
    Window window;
    Button addStickyButton;
    int stickyNumber;

    public StickyNotesController(StickyUser model, Window window) {
	this.model = model;
	this.window = window;
	this.stickyNumber = 0;
    }

    public void init() {
	/*
	 * Initialize our base controls
	 */
	addStickyButton = new Button("Add Note +");
	addStickyButton.addListener(this);
	addStickyButton.setClickShortcut(KeyCode.A);
	window.addComponent(addStickyButton);
	/*
	 * Initialize our sticky notes
	 */
	try {
	    for(StickyNote note : model.getNotes()){
		displaySticky(note);
	    }
	}catch(Exception e){
	    throw new RuntimeException(e);
	}
    }

    public void displaySticky(final StickyNote note) {
	Window w = new Window();
	w.addListener(new Window.CloseListener() {

	    public void windowClose(CloseEvent e) {
		try {
		    model.removeNote(note);
		} catch (StickyException se) {
		    throw new RuntimeException(se);
		}
	    }
	});
	window.addWindow(w);

	StickyNoteController snc = new StickyNoteController(note, w);
	snc.init();
    }

    public void release() {
	window.removeComponent(addStickyButton);
    }

    public void buttonClick(ClickEvent event) {
	try {
	    StickyNote note = model.createNote();
	    note.setMessage("Stick #" + stickyNumber + ":Click to change the message");
	    stickyNumber++;

	    displaySticky(note);
	} catch (StickyQuotaException se) {
	    window.showNotification("Quota",
		    "Your sticky limit has been reached.  I will eventually add functionality to discount removed stickies!  Click on this message to get ride of it.",
		    Window.Notification.TYPE_ERROR_MESSAGE);
	} catch (StickyException t) {
	    throw new IllegalStateException(t);
	}
    }
}
