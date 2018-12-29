package com.mohsenj.core.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class StringUtilsTest {

	@Test
	public void emptyStringSlugify()
	{
		assertThat(StringUtils.slugify("")).isEqualTo(new String());
	}
	
	@Test
	public void singleCharStringSlugify()
	{
		assertThat(StringUtils.slugify("a")).isEqualTo(new String("a"));
	}
	
	@Test
	public void whithoneSpaceStringSlugify()
	{
		assertThat(StringUtils.slugify("a b")).isEqualTo(new String("a-b"));
	}
	
	@Test
	public void whithtwoSlashStringSlugify()
	{
		assertThat(StringUtils.slugify("abc/dsef/")).isEqualTo(new String("abc-dsef-"));
	}
	
	@Test
	public void multiSpaceAndSlashStringSlugify()
	{
		assertThat(StringUtils.slugify("abc/dsef/ fgdg gf-/gfd/ w")).isEqualTo(new String("abc-dsef--fgdg-gf--gfd--w"));
	}
	
	@Test 
	public void randomString_checkIfRandomAndUnique() {
		
		String str1 = StringUtils.randomString(15);
		String str2 = StringUtils.randomString(15);
		String str3 = StringUtils.randomString(15);
		String str4 = StringUtils.randomString(15);
		
		assertNotEquals(str1, str2);
		assertNotEquals(str1, str3);
		assertNotEquals(str1, str4);
		assertNotEquals(str2, str4);
	}
	
	@Test 
	public void randomString_returnRequestedLenght() {
		
		String str1 = StringUtils.randomString(15);

		
		assertEquals(str1.length(), 15);
	}
	
	@Test
	public void randomString_returnAlphanumeric() {
		String str1 = StringUtils.randomString(15);
		
		assertTrue(str1.matches("[A-Za-z0-9]+"));
	}
}
