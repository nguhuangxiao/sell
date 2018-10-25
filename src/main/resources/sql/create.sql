create table tb_product_category (
  `category_id` INT NOT NULL  AUTO_INCREMENT ,
  `category_name` varchar(100) NOT NULL ,
  `category_type` tinyint(3) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`category_id`) USING BTREE
)CHARACTER SET = utf8mb4