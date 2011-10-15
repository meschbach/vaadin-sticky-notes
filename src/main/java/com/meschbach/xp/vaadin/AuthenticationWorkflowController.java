/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.meschbach.xp.vaadin.sticky.model.StickyApplication;
import com.meschbach.xp.vaadin.sticky.model.StickyAuthorizationException;
import com.meschbach.xp.vaadin.sticky.model.StickyException;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import java.io.Serializable;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class AuthenticationWorkflowController implements AuthenticationViewController.AuthenticationListener, Serializable {

    Panel authView;
    Window viewRoot;
    AuthenticationViewController awc;
    Delegate delegate;
    StickyApplication authorizationStrategy;

    public AuthenticationWorkflowController(StickyApplication authorizationStrategy) {
	this.authorizationStrategy = authorizationStrategy;
    }

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
	try {
	    StickyUser user = authorizationStrategy.authorizeUser(userName, password);
	    delegate.authenticated(user);
	} catch (StickyAuthorizationException se) {
	    delegate.failed();
	} catch (StickyException t) {
	    throw new IllegalStateException(t);
	}
    }

    public Delegate getDelegate() {
	return delegate;
    }

    public void setDelegate(Delegate delegate) {
	this.delegate = delegate;
    }

    public interface Delegate {

	public void authenticated(StickyUser user);

	public void failed();
    }
}
