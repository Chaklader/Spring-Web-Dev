package com.chapter4.lowLevelXML;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

@Path("/userResource")
public class UserResource {

	@POST
	@Path("usingStreamSource")
	public StreamSource getStreamSource(StreamSource streamSource) {
		System.out.println("StreamSource Request: " + streamSource.getInputStream());
		System.out.println(streamSource.getInputStream().getClass());
	    return streamSource;
	}
	
	@POST
	@Path("usingSAXSource")
	public SAXSource getSAXSource(SAXSource saxSource) {
		System.out.println("SAXSource Request: " + saxSource.getXMLReader().toString());
	    return saxSource;
	}
	 
	@POST
	@Path("usingDOMSource")
	public DOMSource getDOMSource(DOMSource domSource) {
		System.out.println("DOMSource Request: " + domSource.getNode());
	    return domSource;
	}
	 
	@POST
	@Path("usingDocument")
	public Document getDocument(Document document) {
		System.out.println("Document Request: " + document.getDocumentURI());
	    return document;
	}
}