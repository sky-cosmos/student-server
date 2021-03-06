package com.kaiyu.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.kaiyu.dao.UmsAdminDao;
import com.kaiyu.domain.UmsAdmin;
import com.kaiyu.dto.AdminParam;
import com.kaiyu.dto.UmsAdminQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author likaiyu
 * @date 2020/11/28
 **/
@Component
public class UmsAdminDaoImpl implements UmsAdminDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public UmsAdmin selectOne(AdminParam sysUser) {
        final String sql = "SELECT * FROM ums_admin WHERE username = ? and password=?";
        RowMapper<UmsAdmin> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsAdmin.class);
        return jdbcTemplate.queryForObject(sql,beanPropertyRowMapper,sysUser.getUsername(),sysUser.getPassword());
    }

    @Override
    public int insert(UmsAdmin umsAdmin) {
        final   String sql= "INSERT INTO ums_admin (username,PASSWORD,icon,email,nick_name,note,create_time,STATUS) VALUES(?,?,?,?,?,?,now(),?);";
        return jdbcTemplate.update(sql,umsAdmin.getUsername(),umsAdmin.getPassword(),umsAdmin.getIcon(),umsAdmin.getEmail(),umsAdmin.getNickName(),umsAdmin.getNote(),umsAdmin.getStatus());
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdmin admin) {
        final String sql="UPDATE ums_admin SET username= ?," +
                "password=?,icon=?,email=?,nick_name=?," +
                "note=?,status=? WHERE id=?;";
        return jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword(),admin.getIcon(),admin.getEmail(),admin.getNickName(),
                admin.getNote(),admin.getStatus(),admin.getId());
    }

    @Override
    public int deleteByPrimaryKey(Long adminId) {
        final String sql="delete from ums_admin  where  id= ?";
        return jdbcTemplate.update(sql,adminId);
    }

    @Override
    public List<UmsAdmin> selectAll() {
        final String sql = "SELECT * FROM ums_admin ";
        RowMapper<UmsAdmin> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsAdmin.class);
        return jdbcTemplate.query(sql,beanPropertyRowMapper);
    }

    @Override
    public UmsAdmin selectByPrimaryKey(Long attribute) {
        final String sql = "SELECT * FROM ums_admin where id=?";
        RowMapper<UmsAdmin> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsAdmin.class);
        return jdbcTemplate.queryForObject(sql,beanPropertyRowMapper,attribute);
    }

    @Override
    public List<UmsAdmin> likeQuery(UmsAdminQueryParam loginRq) {
        StringBuilder sbSql =new StringBuilder();
        sbSql.append( "SELECT * FROM ums_admin where 1=1 ");
        if(!StringUtils.isEmpty(loginRq.getNickName())){
            //模糊查询
            sbSql.append( "and nick_name like \'%").append(loginRq.getNickName()).append("%\' ");
        }
        if(!StringUtils.isEmpty(loginRq.getUsername())){
            //模糊查询
            sbSql.append( "and username like \'%").append(loginRq.getUsername()).append("%\' ");
        }
        if(loginRq.getStatus()!=null){
            sbSql.append( "and status = ").append(loginRq.getStatus());
        }
        RowMapper<UmsAdmin> beanPropertyRowMapper = new BeanPropertyRowMapper(UmsAdmin.class);
        return jdbcTemplate.query(sbSql.toString(),beanPropertyRowMapper);
    }

}
