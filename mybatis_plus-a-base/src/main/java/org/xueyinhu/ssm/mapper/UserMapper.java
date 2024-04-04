package org.xueyinhu.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.xueyinhu.ssm.pojo.User;

/** mybatis-plus
 *
 */

public interface UserMapper extends BaseMapper<User> {

    // 定义一个根据年龄参数查询，并且分页的方法
    IPage<User> queryByAge(IPage<User> page, @Param("age") Integer age);
}
