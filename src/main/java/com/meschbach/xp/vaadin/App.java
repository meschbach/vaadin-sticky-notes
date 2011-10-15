/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class App extends Application {

    @Override
    public void init() {
	/*
	 * Configure our root window
	 */
	final Window mainWindow = new Window("Vaadin Test");
	setMainWindow(mainWindow);
	/*
	 * Assemble the authentication controller
	 */
	final AuthenticationWorkflowController ac = new AuthenticationWorkflowController();
	ac.setViewRoot(mainWindow);
	ac.setDelegate(new AuthenticationWorkflowController.Delegate() {

	    public void authenticated() {
		ac.release();
		StickyNotesController snc = new StickyNotesController(new StickyNotesModel(), mainWindow);
		snc.init();
	    }

	    public void failed() {
		mainWindow.showNotification("Authentication", "Authentication failed.  Please try again.");
	    }
	});
	ac.start();
    }
}