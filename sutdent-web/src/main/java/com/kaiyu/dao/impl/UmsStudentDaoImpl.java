package com.kaiyu.dao.impl;

import com.kaiyu.dao.UmsStudentDao;
import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.UmsStudentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author riversky
 * @date 2020/11/28
 **/
@Component
public class UmsStudentDaoImpl implements UmsStudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insert(UmsStudent umsStudent) {
        final   String sql= "INSERT INTO studentmanager.ums_student (student_id,student_name,student_years,student_academy,student_class,student_department,student_position,student_phone,student_born,create_at) " +
                "  VALUES(:studentId,:studentName,:studentYears,:studentAcademy,:studentClass,:studentDepartment,:studentPosition,:studentPhone,:studentBorn,now());";
        return jdbcTemplate.update(sql,new BeanPropertySqlParameterSource(umsStudent));
    }

    @Override
    public int updateByPrimaryKey(UmsStudentParam umsStudent) {
        final String sql="UPDATE studentmanager.ums_student SET student_name= :studentName,student_years=:studentYears,student_academy=:studentAcademy,student_class=:studentClass,student_department=:studentDepartment," +
                "student_position=:studentPosition,student_phone=:studentPhone,student_born=:studentBorn WHERE student_id=:studentId;";
        return jdbcTemplate.update(sql,new BeanPropertySqlParameterSource(umsStudent) );

    }

    @Override
    public UmsStudent selectByPrimaryKey(Integer umsStudentId) {
        final String sql ="SELECT * from studentmanager.ums_student where student_id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UmsStudent>(),umsStudentId);
    }

    @Override
    public int deleteByPrimaryKey(Integer sutudenId) {
        final String sql="delete from studentmanager.ums_student where student_id=?";
        return jdbcTemplate.update(sql,sutudenId);
    }

    @Override
    public List<UmsStudent> selectAll() {
        final String sql="select * from studentmanager.ums_student";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<UmsStudent>());
    }
}
