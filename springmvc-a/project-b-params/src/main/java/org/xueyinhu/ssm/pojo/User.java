package org.xueyinhu.ssm.pojo;

import lombok.Data;

@Data
public class User {
    private String name; // 属性名称必须等于请求名称
    private int age = 19; // 可以直接设置默认值
}
