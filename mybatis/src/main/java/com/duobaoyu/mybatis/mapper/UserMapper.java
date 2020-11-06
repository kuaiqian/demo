package com.duobaoyu.mybatis.mapper;

import com.duobaoyu.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author FS001338
 * @date 2020/11/2
 */
@Mapper
public interface UserMapper {

    List<User> selectAll();
}
