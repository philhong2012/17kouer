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
