package com.lxl.qq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘晓亮
 * @date 2020/8/18 11:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessResult {
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    private String flag;
    private String msg;
    private Object data;

}
