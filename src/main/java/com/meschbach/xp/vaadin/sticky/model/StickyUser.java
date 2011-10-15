/*
 * Copyright 2010 Mark Eschbach.
 *
 * $HeadURL$
 * $Id$
 */
package com.meschbach.xp.vaadin.sticky.model;

import java.util.List;

/**
 *
 * @author "Mark Eschbach" (meschbach@gmail.com)
 */
public interface StickyUser {

    public String getUserName() throws StickyException;

    public List<StickyNote> getNotes() throws StickyException;

    /**
     *
     * @return
     * @throws StickyException if a problem occurs creating notes
     */
    public StickyNote createNote() throws StickyException, StickyQuotaException;
}
