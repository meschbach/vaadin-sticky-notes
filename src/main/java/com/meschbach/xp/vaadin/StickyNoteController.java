/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.meschbach.xp.vaadin.sticky.model.StickyNote;
import com.vaadin.data.Property;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import java.io.Serializable;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class StickyNoteController implements Serializable {

    StickyNote note;
    Window container;
    TextField input;
    Label display;

    public StickyNoteController(StickyNote note, Window container) {
	this.note = note;
	this.container = container;
	Property messageProperty = new MethodProperty(note, "message");
	container.addListener(new ClickListener() {

	    public void click(MouseEvents.ClickEvent event) {
		editMode();
	    }
	});
	display = new Label(messageProperty);
	display.setWidth("100%");
	display.setHeight("100%");
	input = new TextField(messageProperty);
	input.setWidth("100%");
	input.setHeight("100%");
	input.addListener(new BlurListener() {

	    public void blur(BlurEvent event) {
		displayMode();
	    }
	});
    }

    public void init() {
	/*
	 * Cnofigure our container
	 */
	container.setWidth("30em");
	container.addComponent(input);
	container.addComponent(display);
	displayMode();
    }

    public void editMode() {
	display.setVisible(false);
	input.setVisible(true);
	container.requestRepaint();
    }

    public void displayMode() {
	input.setVisible(false);
	display.setVisible(true);
	container.requestRepaint();
    }
}
