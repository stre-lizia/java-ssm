package org.xueyinhu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * CREATE TABLE `news_headline`  (
 *   `hid` INT NOT NULL AUTO_INCREMENT COMMENT '头条id',
 *   `title` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头条标题',
 *   `article` VARCHAR(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头条新闻内容',
 *   `type` INT NOT NULL COMMENT '头条类型id',
 *   `publisher` INT NOT NULL COMMENT '头条发布用户id',
 *   `page_views` INT NOT NULL COMMENT '头条浏览量',
 *   `create_time` DATETIME(0) NULL DEFAULT NULL COMMENT '头条发布时间',
 *   `update_time` DATETIME(0) NULL DEFAULT NULL COMMENT '头条最后的修改时间',
 *   `version` INT DEFAULT 1 COMMENT '乐观锁',
 *   `is_deleted` INT DEFAULT 0 COMMENT '头条是否被删除 1 删除  0 未删除',
 *   PRIMARY KEY (`hid`) USING BTREE
 * ) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
 */

@Data
public class Headline implements Serializable {
    @TableId
    private Integer hid;
    private String title;
    private String article;
    private Integer type;
    private Integer publisher;
    private Integer pageViews;
    private Date createTime;
    private Date updateTime;

    @Version
    private Integer version;

    @TableLogic
    private Integer isDeleted;

    @Serial
    private static final long serialVersionUID = 1L;
}
