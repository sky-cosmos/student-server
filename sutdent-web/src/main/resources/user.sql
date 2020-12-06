
create table ums_student(
                            student_id varchar (255) primary key  comment '学号',
                            student_name varchar(255) not null comment '姓名',
                            student_years varchar (255) not null comment '入学年份',
                            student_academy varchar (20) not null comment '学院',
                            student_class varchar(255) not null comment '班级',
                            student_department varchar(255)  comment '部门',
                            student_position varchar(255) not null comment '职位',
                            student_phone varchar (255)  comment '手机号',
                            student_born timestamp default 0 comment '出生年月',
                            create_at DATETIME default current_timestamp () comment '新增时间',
                            update_at DATETIME default null on update current_timestamp() comment '更新时间'
) comment '学生表';