package org.xueyinhu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/** SQL
 * use studb;
 * #
 * DROP TABLE IF EXISTS user;
 * #
 * CREATE TABLE user
 * (
 *     id BIGINT(20) NOT NULL COMMENT '主键ID',
 *     name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
 *     age INT(11) NULL DEFAULT NULL COMMENT '年龄',
 *     email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
 *     PRIMARY KEY (id)
 * );
 * #
 * INSERT INTO user (id, name, age, email) VALUES
 * (1, 'Jone', 18, 'test1@t.com'),
 * (2, 'Jack', 20, 'test2@t.com'),
 * (3, 'Tom', 28, 'test3@t.com'),
 * (4, 'Sandy', 21, 'test4@t.com'),
 * (5, 'Billie', 24, 'test5@t.com');
 */

@TableName // 默认可以不加（使用实体类的名字作为表名，忽略大小写）
@Data
public class User {
    // 当表主键名称和属性名称不同时候，可以使用 value 指定
    // IdType.ASSIGN_ID 雪花算法，生成不重复的 bigInt / varchar(64)，即实体的 Long 类型
    // IdType.AUTO 需要主键字段设置自增
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    // @TableField 字段，可以当主键名称和属性名称不同时候设置 value 映射
    private String name;
    private Integer age;
    private String email;

    // @TableLogic 设置逻辑删除字段
    // 当删除数据的时候，自动变成修改此列的属性值，默认为 0，删除为 1
    @TableLogic
    private Integer deleted;

    // 版本号字段
    @Version
    private Integer version;
}
