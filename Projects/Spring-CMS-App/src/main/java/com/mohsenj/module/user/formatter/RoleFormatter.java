package com.mohsenj.module.user.formatter;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

import com.mohsenj.module.user.model.Permission;
import com.mohsenj.module.user.model.Role;

public class RoleFormatter implements Formatter<Role> {

	@Override
	public String print(Role role, Locale locale) {
		return role.getId().toString();
	}

	@Override
	public Role parse(String id, Locale locale) throws ParseException {
		Role role = new Role();
		role.setId(Integer.parseInt(id));
		return role;
	}
}