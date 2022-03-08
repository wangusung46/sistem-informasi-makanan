-- --------------------------------------------------------
-- Host:                         46.17.172.1
-- Server version:               10.5.12-MariaDB-cll-lve - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table u900802584_delivery.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table u900802584_delivery.hibernate_sequence: ~2 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(141),
	(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table u900802584_delivery.item
CREATE TABLE IF NOT EXISTS `item` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table u900802584_delivery.item: ~10 rows (approximately)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`, `active`, `name`, `price`, `stock`) VALUES
	(11, b'1', 'Item 1', 10, 100),
	(12, b'1', 'Item 2', 10, 500),
	(13, b'1', 'Item 3', 10, 160),
	(14, b'1', 'Item 4', 10, 130),
	(15, b'1', 'Item 5', 10, 106),
	(16, b'1', 'Item 6', 10, 120),
	(17, b'1', 'Item 7', 10, 700),
	(18, b'1', 'Item 8', 10, 170),
	(19, b'1', 'Item 9', 10, 130),
	(20, b'1', 'Item 10', 10, 106);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping structure for table u900802584_delivery.rating
CREATE TABLE IF NOT EXISTS `rating` (
  `id` bigint(20) NOT NULL,
  `id_transaction` bigint(20) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `review` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table u900802584_delivery.rating: ~0 rows (approximately)
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` (`id`, `id_transaction`, `rate`, `review`) VALUES
	(139, 137, 3, 'Delicious Lezatos');
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;

-- Dumping structure for table u900802584_delivery.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` bigint(20) NOT NULL,
  `count_item` int(11) DEFAULT NULL,
  `id_item` bigint(20) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table u900802584_delivery.transaction: ~2 rows (approximately)
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` (`id`, `count_item`, `id_item`, `id_user`, `status`) VALUES
	(137, 7, 11, 136, 'COMPLETE'),
	(140, 7, 18, 136, 'DELIVERY');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

-- Dumping structure for table u900802584_delivery.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ic` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `roles` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table u900802584_delivery.user: ~3 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `active`, `address`, `email`, `gender`, `ic`, `name`, `password`, `phone`, `roles`) VALUES
	(2, b'1', 'DERPO', 'admin', 'Famale', '42372', 'UGNKK', '$2a$12$nlB1mjDqzxeWkvP4wWKvJOSWexaO6Fg.p3zwC/0KyotVcCBY3NzzG', '65106', 'ROLE_ADMIN'),
	(136, b'1', 'Trans Seram Address', 'c1', 'male', '001', 'Customer 1', '$2a$12$nlB1mjDqzxeWkvP4wWKvJOSWexaO6Fg.p3zwC/0KyotVcCBY3NzzG', '001', 'ROLE_CUSTOMER'),
	(138, b'1', 'Air Pepaya Address', 's1', 'Male', '002', 'Staff 1', '$2a$10$mK.mqDZWd.WUGibB5wiVUefZ7LWLF7LPwV9Z1ybIOGIu7aFCScuPG', '002', 'ROLE_STAFF'),
	(139, b'1', 'Air Pepaya Address', 's2', 'Male', '002', 'Staff 2', '$2a$10$mK.mqDZWd.WUGibB5wiVUefZ7LWLF7LPwV9Z1ybIOGIu7aFCScuPG', '002', 'ROLE_STAFF');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
