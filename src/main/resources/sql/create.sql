# 微信点餐数据库


```sql
create table `seller_info` (
  `sell_id` bigint not null auto_increment,
  `sell_name` varchar(64) not null comment '名称',
  `sell_avatar` varchar(512) comment '卖家小图',
  `sell_notice` varchar(255) not null comment '卖家公告',
  `sell_description` varchar(64) not null comment '描述',
  `delivery_price` decimal(8,2) not null comment '配送费',
  `packing_price` decimal(8,2) not null comment ''包装费'',
  `min_price` decimal(8,2) not null comment '最低价格',
  `sell_score` decimal(8,2) not null comment '商家评分',
  `delivery_time` int not null comment '送达时间',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`sell_id`)
)



-- 类目
create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment '类目名字',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`category_id`)
);

-- 商品
create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '单价',
    `product_stock` int not null comment '库存',
    `product_description` varchar(64) comment '描述',
    `product_icon` varchar(512) comment '小图',
    `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    `category_type` int not null comment '类目编号',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`product_id`)
);

-- 订单
create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment '买家名字',
    `buyer_phone` varchar(32) not null comment '买家电话',
    `buyer_address` varchar(128) not null comment '买家地址',
    `buyer_openid` varchar(64) not null comment '买家微信openid',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态, 默认未支付',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
);

-- 订单商品
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '当前价格,单位分',
    `product_quantity` int not null comment '数量',
    `product_icon` varchar(512) comment '小图',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);

--买家地址库
create table `buyer_address_book` (
    `id` bigint(20) not null auto_increment,
    `user_id` bigint(20) not null comment '信息所属用户',
    `buyer_name` varchar(32) comment '买家信息',
    `buyer_phone` varchar(32) comment '买家手机号',
    `country` varchar(32) comment '国家',
    `province` varchar(32) comment '省份',
    `city` varchar(32) comment '城市',
    `buyer_address` varchar(128) comment '详细地址',
    `x` double(9, 6) comment '经度',
    `y` double(9, 6) comment '纬度',
	primary key (`id`)
)
--用户表
create table `user` (
    `id` bigint(20) not null auto_increment,
    `name` varchar(32) comment '姓名',
    `phone` varchar(20) comment '用户注册手机号',
    `sex` tinyint(2) comment '性别',
    `open_id` varchar(64) not null comment 'openid',
    `icon` varchar(64) comment '用户头像',
	primary key (`id`)
)



-- 卖家(登录后台使用, 卖家登录之后可能直接采用微信扫码登录，不使用账号密码)
create table `seller_info` (
    `id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment '微信openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '卖家信息表';

```
