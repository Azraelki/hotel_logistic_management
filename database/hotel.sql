-- init database

DROP DATABASE IF EXISTS hotel;

CREATE DATABASE hotel;

USE hotel;

GRANT SELECT, INSERT, UPDATE, DELETE ON hotel.* TO 'hoteluser'@'localhost' IDENTIFIED BY 'hoteluser';

CREATE TABLE jobs(
	`j_id` INT,
	`j_name` VARCHAR(20),
	`j_task` VARCHAR(20),
	PRIMARY KEY(`j_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE employee(
    `e_id` VARCHAR(32),
    `j_id` INT,
    `e_name` VARCHAR(20),
    `e_gender` BOOL,
    `e_age` INT,
    `e_phone_num` VARCHAR(20),
    `e_arrived_at` REAL,
    KEY `idx_e_arrived_at` (`e_arrived_at`),
    CONSTRAINT `fk_e_j_id` FOREIGN KEY(`j_id`) REFERENCES jobs(`j_id`),
    PRIMARY KEY(`e_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE users(
    `u_id` VARCHAR(32),
    `e_id` VARCHAR(32) UNIQUE,
    `u_type` INT,
    `u_password` VARCHAR(32),
    CONSTRAINT `fk_u_e_id` FOREIGN KEY(`e_id`) REFERENCES employee(`e_id`),
    PRIMARY KEY(`u_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE facilities(
    `f_id` VARCHAR(32),
    `f_name` VARCHAR(20),
    `f_type` INT,
    `f_n_num` INT,
    `f_b_num` INT,
    PRIMARY KEY(`f_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE food(
    `fo_id` VARCHAR(32),
    `fo_name` VARCHAR(20),
    `fo_type` INT,
    `fo_style` VARCHAR(20),
    `fo_status` BOOL,
    `fo_price` double,
    KEY `idx_fo_style` (`fo_style`),
    KEY `idx_fo_type` (`fo_type`),
    PRIMARY KEY(`fo_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE linens(
    `l_id` VARCHAR(32),
    `e_id` VARCHAR(32),
    `l_date` REAL,
    KEY `idx_l_date` (`l_date`),
    CONSTRAINT `fk_e_id` FOREIGN KEY(`e_id`) REFERENCES employee(`e_id`),
    PRIMARY KEY(`l_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE linens_info(
    `li_id` VARCHAR(32),
    `l_id` VARCHAR(32),
    `f_id` VARCHAR(32),
    `li_rec_num` INT,
    `li_sen_num` INT,
    `li_back_wash_num` INT,
    `li_owe_num` INT,
    CONSTRAINT `fk_li_f_id` FOREIGN KEY(`f_id`) REFERENCES facilities(`f_id`),
    CONSTRAINT `fk_li_l_id` FOREIGN KEY(`l_id`) REFERENCES linens(`l_id`),
    PRIMARY KEY(`li_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE facilitie_fix(
    `ff_id` VARCHAR(32),
    `e_id` VARCHAR(32),
    `f_id` VARCHAR(32),
    `ff_status` INT,
    `ff_content` VARCHAR(200),
     `ff_date_begin` REAL,
    `ff_date_end` REAL,
     KEY `idx_ff_status` (`ff_status`),
    CONSTRAINT `fk_ff_e_id` FOREIGN KEY(`e_id`) REFERENCES employee(`e_id`),
    CONSTRAINT `fk_ff_f_id` FOREIGN KEY(`f_id`) REFERENCES facilities(`f_id`),
    KEY `idx_ff_date_begin` (`ff_date_begin`),
    KEY `idx_ff_date_end` (`ff_date_end`),
    PRIMARY KEY(`ff_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE purchase_order(
    `po_id` VARCHAR(32),
    `e_id` VARCHAR(32),
    `po_date` REAL,
    `po_deal_date` REAL,
    `po_status` BOOL,
    KEY `idx_po_po_status` (`po_status`),
    CONSTRAINT `fk_po_e_id` FOREIGN KEY(`e_id`) REFERENCES employee(`e_id`),
    PRIMARY KEY(`po_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE purchase_info(
    `pi_id` VARCHAR(32),
    `po_id` VARCHAR(32),
    `f_id` VARCHAR(32),
	`pi_price` double,
    `pi_num` INT,
	`pi_total` double,
    CONSTRAINT `fk_pi_po_id` FOREIGN KEY(`po_id`) REFERENCES purchase_order(`po_id`),
    CONSTRAINT `fk_pi_f_id` FOREIGN KEY(`f_id`) REFERENCES facilities(`f_id`),
    PRIMARY KEY(`pi_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE employee_works(
    `ew_id` VARCHAR(32),
    `e_id` VARCHAR(32),
    `ew_leave` INT,
    `ew_clean` INT,
    `ew_date` REAL,
    CONSTRAINT `fk_ew_e_id` FOREIGN KEY(`e_id`) REFERENCES employee(`e_id`),
    KEY `idx_ew_date` (`ew_date`),
    PRIMARY KEY(`ew_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE clean_plan(
	`cp_id` VARCHAR(32),
	`e_id` VARCHAR(32),
	`cp_content` VARCHAR(30),
	`cp_begin` REAL,
	`cp_end` REAL,
	CONSTRAINT `fk_cp_e_id` FOREIGN KEY(`e_id`) REFERENCES employee(`e_id`),
	KEY `idx_cp_begin` (`cp_begin`),
	KEY `idx_cp_flag` (`cp_flag`),
	PRIMARY KEY(`cp_id`)
)ENGINE=INNODB CHARSET=utf8;

CREATE TABLE food_show(
    `fs_id` VARCHAR(32),
    `fo_id` VARCHAR(32),
    `fs_date` REAL,
    KEY `idx_fs_date` (`fs_date`),
    CONSTRAINT `fk_fs_fo_id`FOREIGN KEY(`fo_id`) REFERENCES food(`fo_id`),
    PRIMARY KEY(`fs_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE test(
	id VARCHAR(32),
	t_name VARCHAR(20),
	PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE role(
	r_id VARCHAR(32),
	r_type INT,
	privilege VARCHAR(10),
	PRIMARY KEY(`r_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE facilitie_use(
	fu_id VARCHAR(32),
	f_id VARCHAR(32),
	fu_num INT,
	fu_date REAL,
	KEY `idx_fu_f_id` (`f_id`),
	KEY `idx_fu_fu_date` (`fu_date`),
	PRIMARY KEY(`fu_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE sys_log(
	`sl_id` VARCHAR(32),
	`sl_classname` VARCHAR(200),
	`sl_methodname` VARCHAR(200),
	`sl_params` VARCHAR(200),
	`sl_username` VARCHAR(10),
	`sl_flag` INT,
	`sl_desc` VARCHAR(20),
	`sl_err` VARCHAR(4000),
	`sl_date` REAL,
	KEY `idx_sl_flag` (`sl_flag`),
	PRIMARY KEY(`sl_id`)
)ENGINE=INNODB CHARSET=utf8;
-- admin
INSERT INTO jobs(`j_id`,`j_name`) VALUES(1,'店长');
INSERT INTO employee(`e_id`,`j_id`,`e_name`,`e_gender`,`e_age`,`e_phone_num`,`e_arrived_at`) VALUES('0987fff4508f43fbaed718e263442526','1','admin',FALSE,32,'13523453421',1402909113.628);
INSERT INTO users(`u_id`,`e_id`,`u_type`,`u_password`) VALUES('0987fff4708f43fbaed718e263442526','0987fff4508f43fbaed718e263442526',0,'123456');
