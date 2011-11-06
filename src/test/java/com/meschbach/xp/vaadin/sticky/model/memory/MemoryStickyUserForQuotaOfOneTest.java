package com.meschbach.xp.vaadin.sticky.model.memory;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import com.meschbach.xp.vaadin.sticky.model.StickyException;
import com.meschbach.xp.vaadin.sticky.model.StickyNote;
import com.meschbach.xp.vaadin.sticky.model.StickyQuotaException;
import com.meschbach.xp.vaadin.sticky.model.StickyUser;

public class MemoryStickyUserForQuotaOfOneTest {
	
	StickyUser stickyUser;
	StickyNote stickyNote;
	String testString;	
		
	
	@BeforeClass
	public void setup(){
		stickyUser = null;
	}
	
	/**
	 *  You should be able to create a StickyUser with a quota of one
	 *  create one note.   
	 */
	@Test
	public void creatStickyUserWithQuotaOfOne (){
		stickyUser = new MemoryStickyUser("TestUserName",1);
		try {
			stickyNote = stickyUser.createNote();
		} catch (StickyQuotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StickyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue (stickyUser!= null, "FAIL!  The sticky User is null, but it should not be.");
		assertTrue (stickyNote!= null, "FAIL!  The sticky NOTE is null, but it should not be.");
	}
	
	
}