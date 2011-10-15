/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin.sticky.spring;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class SpringApp extends Application {

    @Autowired
    Obj o;

    @Override
    public void init() {
	Label l = new Label("o == null ? "+(o == null));
	Window rootWindow = new Window("Spring Application");
	rootWindow.addComponent(l);
	setMainWindow(rootWindow);
    }

    public void setO(Obj o) {
	this.o = o;
    }
}
