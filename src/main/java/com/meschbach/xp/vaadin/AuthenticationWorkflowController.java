/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class AuthenticationWorkflowController implements AuthenticationViewController.AuthenticationListener {

    Panel authView;
    Window viewRoot;
    AuthenticationViewController awc;
    Delegate delegate;

    public Window getViewRoot() {
	return viewRoot;
    }

    public void setViewRoot(Window viewRoot) {
	this.viewRoot = viewRoot;
    }

    public void start() {
	/*
	 * Build the label to be attached to the window
	 */
	awc = new AuthenticationViewController();
	awc.setDelegate(this);
	authView = awc.assemble();
	viewRoot.addComponent(authView);
    }

    public void release() {
	viewRoot.removeComponent(authView);
    }

    public void authenticated(String userName, String password) {
	if (userName.equals("test") && password.equals("test")) {
	    delegate.authenticated();
	} else {
	    delegate.failed();
	}
    }

    public Delegate getDelegate() {
	return delegate;
    }

    public void setDelegate(Delegate delegate) {
	this.delegate = delegate;
    }

    interface Delegate {

	public void authenticated();

	public void failed();
    }
}
