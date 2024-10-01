CREATE TABLE `product` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `price` bigint NOT NULL,
  `description` text NOT NULL,
  `customer_id` bigint,
  `created_at` timestamp,
  `updated_at` timestamp,
  `is_deleted` bool
);