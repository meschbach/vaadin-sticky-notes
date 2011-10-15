/*
 * Copyright 2011 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin.sticky.model.memory;

import com.meschbach.xp.vaadin.sticky.model.StickyApplication;
import com.meschbach.xp.vaadin.sticky.model.StickyAuthorizationException;
import com.meschbach.xp.vaadin.sticky.model.StickyException;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public class MemoryStickyApplication implements StickyApplication {

    MemoryStickyUser msu;

    public MemoryStickyApplication() {
	msu = new MemoryStickyUser("test", 20);
    }

    public StickyUser authorizeUser(String userName, String password) throws StickyException {
	/*
	 * Find the user by password
	 */
	if (userName.equals("test") && password.equals("test")) {
	    return msu;
	} else {
	    throw new StickyAuthorizationException();
	}
    }
}
