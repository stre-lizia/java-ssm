package org.xueyinhu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * CREATE TABLE `news_type`  (
 *   `tid` INT NOT NULL AUTO_INCREMENT COMMENT '新闻类型id',
 *   `tname` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '新闻类型描述',
 *   `version` INT DEFAULT 1 COMMENT '乐观锁',
 *   `is_deleted` INT DEFAULT 0 COMMENT '头条是否被删除 1 删除  0 未删除',
 *   PRIMARY KEY (`tid`) USING BTREE
 * ) ENGINE = INNODB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
 */

@Data
public class Type implements Serializable {
    @TableId
    private Integer tid;
    private String tname;

    @Version
    private Integer version;

    @TableLogic
    private Integer isDeleted;

    @Serial
    private static final long serialVersionUID = 1L;
}
