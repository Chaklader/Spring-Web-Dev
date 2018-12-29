-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`student`@`localhost` PROCEDURE `test_getCars`()
BEGIN
	DECLARE statusCode INT;
	DECLARE statusMessage VARCHAR(128);

	CALL `demo`.`getCars`('Nissan', 'Altima', '2010', 50000.00, statusCode, statusMessage);

	select statusCode, statusMessage;

END