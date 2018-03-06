#创建数据库
create datebase graduate;

use graduate;
#创建系统用户表
drop table tb_mrgh_users;
create table tb_mrgh_users(
    user_id int not null primary key auto_increment comment'用户id',
    user_name varchar(32) comment'用户姓名',
    user_age varchar(32) comment'用户年龄',
    user_psd varchar(32) comment'用户密码',
    user_phone varchar(32) comment'用户联系方式',
    user_add varchar(32) comment'用户地址',
    status varchar(32) comment'用户身份标识.0:开发测试;1:普通用户;2:管理员',
    del_flag varchar(32) DEFAULT '0' comment'删除标识.初始为0;删除为1',
    memo varchar(32) comment'备注',
    ctime varchar(32) comment'创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into tb_mrgh_users values(22010001,'test0','25','e10adc3949ba59abbe56e057f20f883e','13028698635','河北石家庄众鑫大厦','0','0','开发测试-测试岗','20170220234220');
insert into tb_mrgh_users values(22010002,'test1','25','e10adc3949ba59abbe56e057f20f883e','13028698635','河北科技大学','1','0','开发测试-普通用户','20170221234220');
insert into tb_mrgh_users values(22010003,'test2','25','e10adc3949ba59abbe56e057f20f883e','13028698600','建设大街1103号','2','0','开发测试-管理员','20170221234220');
insert into tb_mrgh_users values(22010004,'test3','25','e10adc3949ba59abbe56e057f20f883e','13028698635','河北科技大学','1','0','开发测试-普通用户','20170221234220');

select * from tb_mrgh_users;

#创建监控点表
drop table tb_mrgh_monitor;
create table tb_mrgh_monitor(
	mushroom_pointid int not null auto_increment primary key comment'大棚编号,如001;002',
	mushroom_name varchar(32) not null comment'蘑菇大棚的名字 如:001号大棚;002号大棚',
	user_id varchar(32) comment'大棚负责人id',
	mushroom_desc varchar(128) comment'大棚的描述信息',
	mushroom_status int comment'大棚监控状态,0：非监控;1:监控中',
	mushroom_long varchar(32) comment'大棚的经度',
	mushroom_lat varchar(32) comment'大棚的纬度',
	mushroom_length varchar(32) comment'大棚的长度',
	mushroom_width varchar(32) comment'大棚的宽度',
	mushroom_area varchar(32) comment'大棚的面积',
	del_flag varchar(32) comment'删除标识.初始为0;删除为1',
	memo varchar(32) comment'备注',
  ctime varchar(32) comment'创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_mrgh_monitor values(21001,'1号大棚','22010001','我是一个大棚','1','114.2010280000','38.8550600000','30','5','150','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(21002,'2号大棚','22010001','我是一个大棚','1','114.1999860000','38.8543850000','30','5','150','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(21003,'3号大棚','22010001','我是一个大棚','1','114.2007760000','38.8508730000','30','5','150','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(21004,'4号大棚','22010002','我是一个大棚','1','114.2007750000','38.8508730000','30','5','150','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(21005,'5号大棚','22010002','我是一个大棚','1','114.2001700000','38.8508770000','30','5','150','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(21006,'6号大棚','22010003','我是一个大棚','1','114.2004760000','38.8502730000','30','5','150','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(21007,'7号大棚','22010003','我是一个大棚','1','114.2006760000','38.8506730000','30','5','150','0','我是备注','20170326182636');

select * from tb_mrgh_monitor;

#创建大棚数据采集表
drop table tb_mrgh_data_acquisition;
create table tb_mrgh_data_acquisition(
	idno int not null auto_increment primary key,
	mushroom_pointid varchar(32) not null comment'大棚编号，如001;002',
	mushroom_airtemp varchar(16) not null comment'空气温度 30',
	mushroom_airhumidity varchar(16) not null comment'空气湿度，相对湿度，单位%',
	mushroom_soiltemp varchar(16) not null comment'土壤温度',
	mushroom_soilmoisture varchar(16) not null comment'土壤湿度，相对湿度，单位%',
	mushroom_ightintensity varchar(16) not null comment'光照强度，单位LUX',
	mushroom_co2densuty varchar(16) not null comment'二氧化碳浓度，单位：ppm',
	memo varchar(32) comment'备注',
  ctime varchar(32) comment'时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#大棚作物表
drop table tb_mrgh_crop;
create table tb_mrgh_crop(
	idno int not null auto_increment primary key,
	mushroom_pointid varchar(32) not null comment'大棚编号，如001;002',
	mushroom_crop_no varchar(16) not null comment'作物编号',
	mushroom_crop_name varchar(16) not null comment'作物名称',
	mushroom_plant_time varchar(16) not null comment'种植时间',
	mushroom_plant_cnt varchar(16) not null comment'种植数量',
	del_flag varchar(16) not null comment'删除标识.初始为0;删除为1',
	memo varchar(32) comment'备注',
  ctime varchar(32) comment'时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
