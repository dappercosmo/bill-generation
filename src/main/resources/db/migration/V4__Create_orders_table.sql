CREATE TABLE `orders` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `customer_id` bigint,
  `product_id` bigint,
  `quantity` int,
  `total_price` bigint,
  `created_at` timestamp,
   `updated_at` timestamp,
   `is_deleted` bool
);