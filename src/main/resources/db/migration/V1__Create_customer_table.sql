CREATE TABLE `customer` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `phone` varchar(10) NOT NULL,
  `created_at` timestamp,
  `updated_at` timestamp,
  `is_deleted` bool
);