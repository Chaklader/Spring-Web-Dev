package com.mohsenj.module.user.formatter;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

import com.mohsenj.module.user.model.Permission;

public class PermissionFormatter implements Formatter<Permission> {

	@Override
	public String print(Permission hobby, Locale locale) {
		return hobby.getId().toString();
	}

	@Override
	public Permission parse(String id, Locale locale) throws ParseException {
		Permission hobby = new Permission();
		hobby.setId(Integer.parseInt(id));
		return hobby;
	}
}