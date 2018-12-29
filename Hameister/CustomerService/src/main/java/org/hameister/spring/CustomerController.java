package org.hameister.spring;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/customers")
public class CustomerController {


	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private Map<String, Customer> customers = new HashMap<String, Customer>();
	private long customerIdCounter = 1;

	
	// curl -i http://localhost:2001/spring/customers
	@RequestMapping(method=RequestMethod.GET, value="", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> allCustomers() {
		return new ResponseEntity<List<Customer>>(new ArrayList<Customer>(customers.values()), HttpStatus.OK);
	}
	
	// curl -i -X POST -H "Content-Type: application/json" http://localhost:2001/spring/customers/
	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<Void> createCustomer() {
		Customer customer = new Customer();
		customer.setId(String.valueOf(customerIdCounter++));

		customers.put(customer.getId(), customer);

		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setLocation(new URI("/customers/" + customer.getId()));
		} catch (URISyntaxException e) {
			logger.error("Invalid URI. Customer id is not valid.", e);
		}

		logger.info("Created customer:" + customer.getId());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// curl -i http://localhost:2001/spring/customers/1
	@RequestMapping(method = RequestMethod.GET, value = "{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) throws CustomerNotFoundException {
		logger.info("Requested customer with id " + customerId);

		return new ResponseEntity<Customer>(findCustomer(customerId), HttpStatus.OK);
	}


	// curl -i -X PUT -d '{"Name":"Max"}' -H "Content-Type: application/json" http://localhost:2001/spring/customers/1
	@RequestMapping(method = RequestMethod.PUT, value = "{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateCustomer(@PathVariable String customerId, @RequestBody Map<String, String> customerData) throws CustomerNotFoundException, MandatoryArgumentMissingException {

		logger.info("Try to update the Customer: " + customerId);
		Customer customer = findCustomer(customerId);

		if (customerData.containsKey("Name")) {
			customer.setName(customerData.get("Name"));
		} else {
			throw new MandatoryArgumentMissingException("Name");
		}

		customer.setCreated(new Date());

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// curl -i -X DELETE -H "Content-Type: application/json" http://localhost:2001/spring/customers/1
	@RequestMapping(method = RequestMethod.DELETE, value = "{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) throws CustomerNotFoundException {
		logger.info("Try to delete the Customer: " + customerId);
		customers.remove(findCustomer(customerId).getId());
		logger.info("Deleted Customer:" + customerId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private Customer findCustomer(String customerId) throws CustomerNotFoundException {
		if (customers.containsKey(customerId)) {
			return customers.get(customerId);
		}
		throw new CustomerNotFoundException(customerId);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(Exception e) {
		return new ResponseEntity<String>("{\"reason\":\"" + e.getMessage() + "\"}", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ MandatoryArgumentMissingException.class, IllegalArgumentException.class })
	public ResponseEntity<String> handleBadRequest(Exception e) {
		return new ResponseEntity<String>("{\"reason\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
	}
}
