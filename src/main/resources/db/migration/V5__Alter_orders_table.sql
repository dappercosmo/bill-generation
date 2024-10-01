ALTER TABLE `orders` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);