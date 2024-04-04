package org.xueyinhu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * CREATE TABLE `news_user`  (
 *   `uid` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
 *   `username` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户登录名',
 *   `user_pwd` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户登录密码密文',
 *   `nick_name` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
 *   `version` INT DEFAULT 1 COMMENT '乐观锁',
 *   `is_deleted` INT DEFAULT 0 COMMENT '头条是否被删除 1 删除  0 未删除',
 *   PRIMARY KEY (`uid`) USING BTREE,
 *   UNIQUE INDEX `username_unique`(`username`) USING BTREE
 * ) ENGINE = INNODB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
 */

@Data
public class User implements Serializable {
    @TableId
    private Integer uid;
    private String username;
    private String userPwd;
    private String nickName;

    @Version
    private Integer version;

    @TableLogic
    private Integer isDeleted;

    @Serial
    private static final long serialVersionUID = 1L;
}
