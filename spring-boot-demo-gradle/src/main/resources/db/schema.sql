drop table if exists grade;

create table grade
(
    id         BIGINT(20) not null comment '主键ID',
    student_id BIGINT(20) not null comment '学生ID',
    grade      int        not null comment '学生成绩'
);

drop table if exists student_info;

create table student_info
(
    id       BIGINT(20)  not null comment '主键ID',
    name     varchar(20) not null comment '学生姓名',
    class_id int         not null comment '学生班级'
)