package demo.dao.cars;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class is used to convert ResultSet records to Domain Objects The class
 * is invoked for each Row in the ResultSet. It implements the Spring RowMapper
 * interface
 */
@SuppressWarnings("rawtypes")
public class CarRowMapper implements RowMapper {

	/**
	 * Maps the result set rows to a Claim object
	 */
	public Object mapRow(ResultSet rs, int index) throws SQLException {

		Car theCar = new Car();

		String make = StringUtils.trimToEmpty(rs.getString(1));
		theCar.setMake(make);

		String model = StringUtils.trimToEmpty(rs.getString(2));
		theCar.setModel(model);

		int year = rs.getInt(3);
		theCar.setYear(year);

		double price = rs.getDouble(4);
		theCar.setPrice(price);

		return theCar;
	}
}