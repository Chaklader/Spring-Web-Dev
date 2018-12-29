--
-- Database: `devfactorydb`
--
CREATE DATABASE IF NOT EXISTS `devfactorydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `devfactorydb`;

-- --------------------------------------------------------

--
-- Table structure for table `CUSTOMER`
--

CREATE TABLE `CUSTOMER` (
`customer_id` bigint(20) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `credit_limit` decimal(19,2) NOT NULL,
  `current_credit` decimal(19,2) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone1` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone2` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ORDER_LINE`
--

CREATE TABLE `ORDER_LINE` (
`order_line_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` decimal(19,2) NOT NULL,
  `unit_price` decimal(19,2) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `sales_order_id` bigint(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `PRODUCT`
--

CREATE TABLE `PRODUCT` (
`product_id` bigint(20) NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(19,2) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `SALES_ORDER`
--

CREATE TABLE `SALES_ORDER` (
`sales_order_id` bigint(20) NOT NULL,
  `order_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `total_price` decimal(19,2) NOT NULL,
  `customer_id` bigint(20) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CUSTOMER`
--
ALTER TABLE `CUSTOMER`
 ADD PRIMARY KEY (`customer_id`), ADD UNIQUE KEY `UK_pg3rby55j4a4nrbo68wvjhykg` (`code`);

--
-- Indexes for table `ORDER_LINE`
--
ALTER TABLE `ORDER_LINE`
 ADD PRIMARY KEY (`order_line_id`), ADD KEY `FK_mahmly9lffveqadj65l74e3u1` (`product_id`), ADD KEY `FK_j767d40w5sg17yajfh5qnkuny` (`sales_order_id`);

--
-- Indexes for table `PRODUCT`
--
ALTER TABLE `PRODUCT`
 ADD PRIMARY KEY (`product_id`), ADD UNIQUE KEY `UK_9srjleqmqhwhqln5s61jghyul` (`code`);

--
-- Indexes for table `SALES_ORDER`
--
ALTER TABLE `SALES_ORDER`
 ADD PRIMARY KEY (`sales_order_id`), ADD KEY `FK_86xobpm9rmh05c1wxo6ykaupb` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CUSTOMER`
--
ALTER TABLE `CUSTOMER`
MODIFY `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `ORDER_LINE`
--
ALTER TABLE `ORDER_LINE`
MODIFY `order_line_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `PRODUCT`
--
ALTER TABLE `PRODUCT`
MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT for table `SALES_ORDER`
--
ALTER TABLE `SALES_ORDER`
MODIFY `sales_order_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `ORDER_LINE`
--
ALTER TABLE `ORDER_LINE`
ADD CONSTRAINT `FK_j767d40w5sg17yajfh5qnkuny` FOREIGN KEY (`sales_order_id`) REFERENCES `SALES_ORDER` (`sales_order_id`),
ADD CONSTRAINT `FK_mahmly9lffveqadj65l74e3u1` FOREIGN KEY (`product_id`) REFERENCES `PRODUCT` (`product_id`);

--
-- Constraints for table `SALES_ORDER`
--
ALTER TABLE `SALES_ORDER`
ADD CONSTRAINT `FK_86xobpm9rmh05c1wxo6ykaupb` FOREIGN KEY (`customer_id`) REFERENCES `CUSTOMER` (`customer_id`);

