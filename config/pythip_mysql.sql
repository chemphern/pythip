CREATE TABLE USER (
  id VARCHAR(50) NOT NULL PRIMARY KEY,
  username VARCHAR(50) NOT NULL COMMENT '用户名',
  PASSWORD VARCHAR(50) NOT NULL COMMENT '密码',
  creater VARCHAR(50) DEFAULT NULL COMMENT '创建人',
  STATUS INT(11) NOT NULL DEFAULT '1' COMMENT '状态：1为正常',
  COMMENT VARCHAR(255) NULL COMMENT '备注',
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间'
);
create table user_info (
  id varchar(50) not null primary key,
  user_id varchar(50) not null,
  name varchar(50) not null comment '姓名',
  sex int(11) not null default '0' comment '0未知，1男，2女',
  age int(11) not null default '0' comment '年龄',
  birthday timestamp comment '出生日期',
  job varchar(255) comment '职业',
);
create table user_role (
	id varchar(50) not null primary key,
	user_id varchar(50) not null,
	role_id varchar(50) not null
);
create table role (
	id varchar(50) not null primary key,
	role_name varchar(255) not null,
	role_name_en varchar(255) not null,
	comment varchar(255) null comment '备注',
	create_time timestamp not null
);
create table role_authority (
	id varchar(50) not null primary key,
	role_id varchar(50) not null,
	authority_id varchar(50) not null
);
create table authority (
	id varchar(50) not null primary key,
	authority_name varchar(255) not null,
	url varchar(255) not null,
	last_operator_time timestamp not null default now(),
	parent_id varchar(50) null,
	comment varchar(255) null comment '备注',
	create_time timestamp not null
);