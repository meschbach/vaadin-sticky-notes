/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin;

import com.meschbach.xp.vaadin.AuthenticationViewController.AuthenticationListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class AuthenticationViewController  implements Button.ClickListener {

    AuthenticationListener delegate;
    TextField userName;
    PasswordField secret;
    Button loginButton;

    public Panel assemble() {
	userName = new TextField("User Name");
	userName.setRequired(true);
	secret = new PasswordField("Password");
	secret.setRequired(true);
	loginButton = new Button("Authenticate");
	loginButton.addListener(this);
	loginButton.setClickShortcut(KeyCode.ENTER);
	/*
	 * Assemble our panel
	 */
	Panel p = new Panel("Authentication");
	p.addComponent(userName);
	p.addComponent(secret);
	p.addComponent(loginButton);
	return p;
    }

    public AuthenticationListener getDelegate() {
	return delegate;
    }

    public void setDelegate(AuthenticationListener delegate) {
	this.delegate = delegate;
    }

    public void buttonClick(ClickEvent event) {
	delegate.authenticated(userName.getValue().toString(), secret.getValue().toString());
    }

    interface AuthenticationListener {

	public void authenticated(String userName, String password);
    }
}
