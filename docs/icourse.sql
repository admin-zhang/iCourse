create database icourse;
use icourse;

drop table if exists `sms_admin`;
create table sms_admin
(
    id          varchar(40)                                                                            not null
        primary key,
    user_name   varchar(64)                                                                            null comment '用户账号',
    password    varchar(64)                                                                            null comment '用户密码',
    nick_name   varchar(200)                                                                           null comment '用户昵称',
    email       varchar(100)                                                                           null comment '用户邮箱',
    icon        varchar(500) default 'http://127.0.0.1:9000/ishop/lisi/avatar/20231009/background.jpg' null comment '头像',
    phonenumber varchar(11)                                                                            not null comment '手机号码',
    sex         char         default '0'                                                               null comment '用户性别：0->男;1->女;2->保密',
    status      tinyint      default 0                                                                 null comment '状态：0->正常；1->异常',
    del_flag    tinyint      default 0                                                                 null comment '删除标志：0->存在;1->删除',
    create_by   varchar(64)  default 'system'                                                          null comment '创建者',
    create_time timestamp    default CURRENT_TIMESTAMP                                                 not null comment '创建时间',
    update_by   varchar(64)  default 'system'                                                          null comment '更新者',
    update_time timestamp    default CURRENT_TIMESTAMP                                                 null on update CURRENT_TIMESTAMP comment '更新时间',
    note        varchar(500)                                                                           null comment '备注信息',
    constraint sms_admin_phonenumber_uindex
        unique (phonenumber)
)
    comment '后台管理员表';