package com.kaiyu.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.kaiyu.dao.UmsStudentDao;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.domain.UmsStudent;
import com.kaiyu.dto.UmsStudentParam;
import com.kaiyu.dto.UmsStudentQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author likiayu
 * @date 2020/11/28
 **/
@Component
public class UmsStudentDaoImpl implements UmsStudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int insert(UmsStudent umsStudent) {
        final   String sql= "INSERT INTO ums_student (student_id," +
                "student_name,student_years,student_academy,student_class," +
                "student_department,student_position,student_phone,student_born," +
                "create_at)  VALUES(?,?,?,?,?,?,?,?,?,now());";
        return jdbcTemplate.update(sql,umsStudent.getStudentId(),
                umsStudent.getStudentName(),umsStudent.getStudentYears(),
                umsStudent.getStudentAcademy(),
                umsStudent.getStudentClass(),umsStudent.getStudentDepartment(),
                umsStudent.getStudentPosition(),umsStudent.getStudentPhone(),
                umsStudent.getStudentBorn());
    }

    @Override
    public int updateByPrimaryKey(UmsStudentParam umsStudent) {
        final String sql="UPDATE ums_student SET student_name=?,student_years=?," +
                "student_academy=?,student_class=?,student_department=?," +
                "student_position=?,student_phone=?,student_born=? WHERE student_id=?";
        return jdbcTemplate.update(sql,umsStudent.getStudentName(),umsStudent.getStudentYears(),
                umsStudent.getStudentAcademy(),umsStudent.getStudentClass(),umsStudent.getStudentDepartment()
        ,umsStudent.getStudentPosition(),umsStudent.getStudentPhone(),umsStudent.getStudentBorn(),umsStudent.getStudentId());

    }

    @Override
    public UmsStudent selectByPrimaryKey(Integer umsStudentId) {
        final String sql ="SELECT * from ums_student where student_id=?";
        RowMapper<UmsStudent> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsStudent.class);

        return jdbcTemplate.queryForObject(sql,beanPropertyRowMapper,umsStudentId);
    }

    @Override
    public int deleteByPrimaryKey(Integer sutudenId) {
        final String sql="delete from ums_student where student_id=?";
        return jdbcTemplate.update(sql,sutudenId);
    }

    @Override
    public List<UmsStudent> selectAll() {
        final String sql="select * from ums_student";
        RowMapper<UmsStudent> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsStudent.class);
        return jdbcTemplate.query(sql,beanPropertyRowMapper);
    }

    @Override
    public List<UmsStudent> likeQuery(UmsStudentQueryParam loginRq) {
        StringBuilder sbSql =new StringBuilder();
        sbSql.append( "SELECT * FROM ums_student where 1=1 ");
        if(!StringUtils.isEmpty(loginRq.getStudentName())){
            //模糊查询
            sbSql.append( "and student_name like \'%").append(loginRq.getStudentName()).append("%\' ");
        }
        if(!StringUtils.isEmpty(loginRq.getStudentPosition())){
            //模糊查询
            sbSql.append( "and student_position like \'%").append(loginRq.getStudentPosition()).append("%\' ");
        }
        if(loginRq.getStudentDepartment()!=null){
            sbSql.append( "and student_department like \'%").append(loginRq.getStudentDepartment()).append("%\' ");
        }
        RowMapper<UmsStudent> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsStudent.class);
        return jdbcTemplate.query(sbSql.toString(),beanPropertyRowMapper);
    }

    public UmsStudent selectByPrimaryKey(Long attribute) {
        final String sql = "SELECT * FROM ums_student where id=?";
        RowMapper<UmsStudent> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsStudent.class);
        return jdbcTemplate.queryForObject(sql,beanPropertyRowMapper,attribute);
    }





}
