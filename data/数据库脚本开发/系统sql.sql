#[个人中心]大棚关联用户岗位
select t2.idno,t2.user_id,t2.user_name,t2.user_age,t2.user_phone,t2.user_add,
  case when t2.status='0'then '开发测试' when t2.status='1' then '管理员' when t2.status='2' then'普通用户' end as station,
  t2.memo,t2.ctime as user_ctime,
  t1.idno,t1.mushroom_pointid,t1.mushroom_name,t1.mushroom_desc,t1.mushroom_status,t1.mushroom_long,t1.mushroom_lat,
  t1.memo,t1.ctime as mrgh_ctime
from tb_mrgh_monitor t1
left join tb_mrgh_users t2 on t1.user_id=t2.user_id;
