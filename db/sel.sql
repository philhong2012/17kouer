drop table if exists t_sel_course;

drop table if exists t_sel_student;

drop table if exists t_sel_student_2_course;

/*==============================================================*/
/* Table: t_sel_course                                          */
/*==============================================================*/
create table t_sel_course
(
   courseId             varchar(40) not null,
   courseName           varchar(40),
   courseCode           varchar(40),
   createdTime          bigint not null,
   updateTime           bigint,
   createdBy            varchar(40) not null,
   updatedBy            varchar(40),
   delFlag              bit default 0,
   primary key (courseId)
);

/*==============================================================*/
/* Table: t_sel_student                                         */
/*==============================================================*/
create table t_sel_student
(
   studentId            varchar(40) not null,
   studentName          varchar(40),
   studentNO            varchar(40),
   psw                  varchar(40),
   createdTime          bigint not null,
   updateTime           bigint,
   createdBy            varchar(40) not null,
   updatedBy            varchar(40),
   delFlag              bit default 0,
   primary key (studentId)
);

/*==============================================================*/
/* Table: t_sel_student_2_course                                */
/*==============================================================*/
create table t_sel_student_2_course
(
   studentCourseId      varchar(40) not null,
   studentId            varchar(40),
   courseId             varchar(40),
   createdTime          bigint not null,
   updateTime           bigint,
   createdBy            varchar(40) not null,
   updatedBy            varchar(40),
   delFlag              bit default 0,
   primary key (studentCourseId)
);

alter table t_sel_student_2_course add constraint FK_T_SEL_ST_REFERENCE_T_SEL_ST foreign key (studentId)
      references t_sel_student (studentId) on delete restrict on update restrict;

alter table t_sel_student_2_course add constraint FK_T_SEL_ST_REFERENCE_T_SEL_CO foreign key (courseId)
      references t_sel_course (courseId) on delete restrict on update restrict;


drop table if exists t_sel_attachment;

drop table if exists t_sel_user;

/*==============================================================*/
/* Table: t_sel_attachment                                      */
/*==============================================================*/
create table t_sel_attachment
(
   id                   varchar(50) not null,
   name                 varchar(50) comment '名称',
   original_name        varchar(100) comment '原名',
   type                 tinyint comment '类型',
   description          varchar(500) comment '介绍',
   size                 bigint comment '大小',
   approval_status      tinyint default 0 comment '1：审核通过 ：0 ：不通过  ，默认不通过',
   create_id            varchar(50) comment '创建人',
   create_time          bigint comment '创建时间',
   update_id            varchar(50) comment '修改人',
   update_time          bigint comment '修改时间',
   del_flag             tinyint default 0 comment '删除标志: 1 删除 0 （默认）未删除',
   primary key (id)
);

alter table t_sel_attachment comment '附件';

/*==============================================================*/
/* Table: t_sel_user                                            */
/*==============================================================*/
create table t_sel_user
(
   id                   varchar(50) not null comment 'id',
   name                 varchar(50) comment '用户名',
   sex                  tinyint comment '性别',
   login_name           varchar(50) comment '登录名',
   password             varchar(50),
   email                varchar(100),
   create_id            varchar(50) comment '创建人',
   create_time          bigint comment '创建时间',
   update_id            varchar(50) comment '修改人',
   update_time          bigint comment '修改时间',
   del_flag             tinyint default 0 comment '删除标志: 1 删除 0 （默认）未删除',
   primary key (id)
);

alter table t_sel_user comment '用户';

insert into t_sel_user(id,name,password,login_name) VALUE ('1','admin','c4ca4238a0b923820dcc509a6f75849b','admin');



