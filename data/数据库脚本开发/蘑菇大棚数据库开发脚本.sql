#创建数据库
create datebase graduate;

#创建系统用户表
drop table tb_mrgh_users;
create table tb_mrgh_users(
    idno int not null auto_increment primary key,  #编号
    user_id varchar(32),  #用户id
    user_name varchar(32),  #用户姓名
    user_age varchar(32),  #用户年龄
    user_psd varchar(32),  #用户密码
    user_phone varchar(32),  #用户联系方式
    user_add varchar(32),  #用户地址
    status varchar(32),  #用户身份标识.0:开发测试;1:管理员;2:普通用户
    del_flag varchar(32),   #删除标识.初始为0;删除为1.
    memo varchar(32),  #备注
    ctime varchar(32)	#创建时间
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into tb_mrgh_users values(100001,'2017022010001','anke','25','123456','13028698635','河北石家庄众鑫大厦','1','0','开发测试','20170220234220');
insert into tb_mrgh_users values(100002,'2017022010002','sunshine','25','123456','13028698635','河北科技大学','0','0','开发测试','20170221234220');
insert into tb_mrgh_users values(100003,'2017022010003','hehe','25','123456','13028698600','建设大街1103号','2','0','开发测试','20170221234220');



#创建监控点表
drop table tb_mrgh_monitor;
create table tb_mrgh_monitor(
	idno int not null auto_increment primary key,  #编号
	mushroom_pointid varchar(32) not null ,#大棚编号，如001;002
	mushroom_name varchar(32) not null , #蘑菇大棚的名字 如:001号大棚;002号大棚
	user_id varchar(32),  #大棚负责人id
	mushroom_desc varchar(128),#大棚的描述信息
	mushroom_status int,#大棚监控状态，0：非监控；1：监控中
	mushroom_long varchar(32),#大棚的经度
	mushroom_lat varchar(32),#大棚的纬度
	del_flag varchar(32),   #删除标识.初始为0;删除为1.
	memo varchar(32),  #备注
  ctime varchar(32)  #创建时间
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_mrgh_monitor values(1001,'001','1号大棚','2017022010001','我是一个大棚','1','114.2010280000','38.8550600000','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(1002,'002','2号大棚','2017022010002','我是一个大棚','1','114.1999860000','38.8543850000','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(1003,'003','3号大棚','2017022010003','我是一个大棚','1','114.2007760000','38.8508730000','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(1004,'004','4号大棚','2017022010001','我是一个大棚','1','114.2007750000','38.8508730000','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(1005,'005','5号大棚','2017022010002','我是一个大棚','1','114.2001700000','38.8508770000','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(1006,'006','6号大棚','2017022010001','我是一个大棚','1','114.2004760000','38.8502730000','0','我是备注','20170326182636');
insert into tb_mrgh_monitor values(1007,'007','7号大棚','2017022010003','我是一个大棚','1','114.2006760000','38.8506730000','0','我是备注','20170326182636');


#创建大棚数据采集表
drop table tb_mrgh_data_acquisition;
create table tb_mrgh_data_acquisition(
	idno int not null auto_increment primary key,
	mushroom_pointid varchar(32) not null ,#大棚编号，如001;002
	mushroom_airtemp varchar(16) not null,#空气温度
	mushroom_airhumidity varchar(16) not null,#空气湿度，相对湿度，单位%
	mushroom_soiltemp varchar(16) not null,#土壤温度
	mushroom_soilmoisture varchar(16) not null,#土壤湿度，相对湿度，单位%
	mushroom_ightintensity varchar(16) not null ,#光照强度，单位LUX
	mushroom_co2densuty varchar(16) not null,#二氧化碳浓度，单位：ppm
	memo varchar(32),  #备注
  ctime varchar(32)  #时间
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建大棚
