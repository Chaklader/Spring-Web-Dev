package com.chapter4.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.chapter4.shared.User;
import com.chapter4.shared.UserWithoutAnnotation;

@Path("jaxbResource")
@Produces("application/xml")
@Consumes("application/xml")
public class UserResource {

	@GET
	public User[] getUserArray() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "John"));
		userList.add(new User(2, "Williams"));
		userList.add(new User(3, "Suzanne"));
		return userList.toArray(new User[userList.size()]);
	}
	
	@GET
	@Path("withoutAnnotation")
    public JAXBElement<UserWithoutAnnotation> getuser() {
		UserWithoutAnnotation user = new UserWithoutAnnotation(1,"John");
        return new JAXBElement<UserWithoutAnnotation>(new QName("user"), UserWithoutAnnotation.class, user);
    }
}
