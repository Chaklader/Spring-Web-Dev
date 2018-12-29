package com.mohsenj.core.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class MiscellaneousUtilsTest {

	@Test
	public void isAdminSideString_startWithSlashAdmin()
	{
		assertTrue(MiscellaneousUtils.isAdminSideString("/admin/blah/blah"));
	}
	
	@Test
	public void isAdminSideString_notStartedWithSlashAdmin()
	{
		assertFalse(MiscellaneousUtils.isAdminSideString("/x/admin/blah/blah"));
		assertFalse(MiscellaneousUtils.isAdminSideString("admin/blah/blah"));
	}
}
