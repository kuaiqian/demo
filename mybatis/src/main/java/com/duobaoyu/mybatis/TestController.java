package com.duobaoyu.mybatis;

import com.duobaoyu.mybatis.entity.User;
import com.duobaoyu.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author FS001338
 * @date 2020/11/9
 */
@RestController
@RequestMapping("/mybatis")
public class TestController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private Map<String, User> applicationList;

    @GetMapping("/selectAll")
    @ResponseBody
    public List<User> selectAllUser() {
        System.out.println(applicationList);
        return userMapper.selectAll();
    }
}
