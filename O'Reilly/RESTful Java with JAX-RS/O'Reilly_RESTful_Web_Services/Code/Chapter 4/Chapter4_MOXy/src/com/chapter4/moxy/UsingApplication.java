package com.chapter4.moxy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

public class UsingApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UserResource.class);
		return s;
	}
	
	@Override
	public Set<Object> getSingletons() {
		MOXyJsonProvider moxyJsonProvider = new MOXyJsonProvider();
		moxyJsonProvider.setWrapperAsArrayName(true);
		HashSet<Object> set = new HashSet<Object>(1);
		set.add(moxyJsonProvider);
		return set;
	}
}