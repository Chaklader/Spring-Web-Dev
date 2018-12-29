CREATE DATABASE IF NOT EXISTS StoredProcedure;

USE StoredProcedure;

DROP TABLE IF EXISTS cars;

CREATE TABLE `cars` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*
-- Query: SELECT * FROM demo.cars
LIMIT 0, 1000

*/

INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('Ford','Focus',2014,15000.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('Ford','Explorer',2013,30000.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('Nissan','Altima',2010,12000.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('Nissan','Altima',2013,18000.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('Nissan','Altima',1992,1299.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('Nissan','Z',2014,33000.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('BMW','335i',2014,45000.00);
INSERT INTO `cars` (`make`,`model`,`year`,`price`) VALUES ('BMW','M4 Coupe',2014,NULL);

--
-- Create the Stored Procedure: getCars
--

DROP PROCEDURE IF EXISTS getCars;

DELIMITER $$

CREATE DEFINER=`student`@`localhost` 

PROCEDURE `getCars`(
						IN the_make VARCHAR(64), 
						IN the_model VARCHAR(64), 
						IN the_year INT, 
						IN the_max_price DECIMAL(10,2), 
						OUT status_code INT, 
						OUT status_message VARCHAR(128)
					)

BEGIN	

	SELECT make, model, `year`, price FROM cars 
	
	WHERE 
		make = the_make AND
		model = the_model AND
		price <= the_max_price AND
		make = the_make AND
		`year` <= the_year;

	SET status_code = 0;
	SET status_message = 'success';

END$$
DELIMITER ;
