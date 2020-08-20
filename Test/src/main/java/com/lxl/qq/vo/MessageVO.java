package com.lxl.qq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘晓亮
 * @date 2020/8/18 14:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {
    private String message;
    private String destUserName;
}
