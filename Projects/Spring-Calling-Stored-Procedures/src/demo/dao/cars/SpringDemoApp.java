package demo.dao.cars;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple example to test our Spring demo app
 * 
 * @author www.luv2code.com
 */
public class SpringDemoApp {


	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		// 1. Get Spring application context
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// 2. Get the DAO bean
		CarsDAO carsDAO = context.getBean("carsDAO", CarsDAO.class);

		// 3. Call methods on the bean
		List carsList = carsDAO.getCars("Nissan", "Altima", 2014, 50000.00);

		// 4. Display the results
		for (Object temp : carsList) {
			System.out.println(temp);
		}
	}

}
