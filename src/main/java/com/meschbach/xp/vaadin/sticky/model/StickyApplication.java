/*
 * Copyright 2010 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin.sticky.model;

/**
 * The <code>StickyApplication</code> represents an instance of the sticky notes
 * data model.
 * 
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public interface StickyApplication {

    /**
     * @return the user's data model instance
     * @throws StickyException if the user could not be authenticated
     */
    public StickyUser authorizeUser(String userName, String password) throws StickyException, StickyAuthorizationException;
}
