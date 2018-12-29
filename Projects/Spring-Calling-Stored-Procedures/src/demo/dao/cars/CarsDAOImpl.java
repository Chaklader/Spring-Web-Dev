package demo.dao.cars;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;


public class CarsDAOImpl implements CarsDAO {

	private CarsStoredProcedure carsStoredProcedure;
	private JdbcTemplate jdbcTemplate;

	public CarsDAOImpl() {

	}

	@PostConstruct
	public void postConstruct() {
		carsStoredProcedure = new CarsStoredProcedure(jdbcTemplate);
	}

	@SuppressWarnings("rawtypes")
	public List getCars(String make, String model, int year, double maxPrice) {

		List result = null;

		// Call the stored procedure
		Map data = carsStoredProcedure.getCars(make, model, year, maxPrice);

		// retrieve the list of objects
		result = (List) data.get(DAOConstants.RESULT_LIST);

		// retrieve the status info
		Integer code = (Integer) data.get(DAOConstants.RETURN_CODE);
		String message = (String) data.get(DAOConstants.RETURN_MESSAGE);

		// just print the code and message…should log this
		System.out.println("Status Code=" + code);
		System.out.println("Status Messsage=" + message);

		return result;
	}

	public CarsStoredProcedure getCarsStoredProcedure() {
		return carsStoredProcedure;
	}

	public void setCarsStoredProcedure(CarsStoredProcedure carsStoredProcedure) {
		this.carsStoredProcedure = carsStoredProcedure;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}