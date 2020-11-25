package tk.mapper.ky;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *通用的工具类，主要是用了这个东西，你几乎不用写一行sql语句
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
