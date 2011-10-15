/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.meschbach.xp.vaadin.sticky.model.StickyApplication;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;
import com.meschbach.xp.vaadin.sticky.model.memory.MemoryStickyApplication;
import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class App extends Application {

    @Override
    public void init() {
	final StickyApplication application = new MemoryStickyApplication();
	/*
	 * Configure our root window
	 */
	final Window mainWindow = new Window("Vaadin Test");
	setMainWindow(mainWindow);
	/*
	 * Assemble the authentication controller
	 */
	final AuthenticationWorkflowController ac = new AuthenticationWorkflowController(application);
	ac.setViewRoot(mainWindow);
	ac.setDelegate(new AuthenticationWorkflowController.Delegate() {

	    public void authenticated(StickyUser su) {
		/*
		 * Spawn the next phase of the application
		 */
		ac.release();
		StickyNotesController snc = new StickyNotesController(su, mainWindow);
		snc.init();
	    }

	    public void failed() {
		mainWindow.showNotification("Authentication", "Authentication failed.  Please try again.");
	    }
	});
	ac.start();
    }
}
