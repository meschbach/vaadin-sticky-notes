/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class StickyNotesController  implements Button.ClickListener {

    StickyNotesModel model;
    Window window;
    Button addStickyButton;
    int stickyNumber;

    public StickyNotesController(StickyNotesModel model, Window window) {
	this.model = model;
	this.window = window;
	stickyNumber = 0;
    }

    public void init() {
	addStickyButton = new Button("Add Note +");
	addStickyButton.addListener(this);
	window.addComponent(addStickyButton);
    }

    public void release() {
	window.removeComponent(addStickyButton);
    }

    public void buttonClick(ClickEvent event) {
	StickyNote sn = new StickyNote("Stick #" + stickyNumber, "Click to change the message");
	stickyNumber++;
	Window w = new Window();
	window.addWindow(w);

	StickyNoteController snc = new StickyNoteController(sn, w);
	snc.init();
    }
}
