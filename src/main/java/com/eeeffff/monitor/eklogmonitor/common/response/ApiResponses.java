/*
 * Copyright (c) 2018-2022 Caratacus, (caratacus@qq.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.eeeffff.monitor.eklogmonitor.common.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;


@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponses<T> implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 表示接口调用成功
     */
    public static final int SUCCESS = 1;
    /**
     * 表示接口调用失败
     */
    public static final int FAIL = -1;
    /**
     * 表示没有权限调用该接口
     */
    public static final int NO_PERMISSION = -2;
    /**
     * 表示未登录或者登录过期
     */
    public static final int NO_LOGIN = -3;
    /**
     * 含义:表示token错误导致解析失败<br>
     */
    public static final int TOKEN_ERROR = -4;

    public static final String NO_LOGIN_MSG = "未登录";
    public static final String NO_PERMISSION_MSG = "没有权限";
    public static final String SUCC_MSG = "成功";
    public static final String FAIL_MSG = "失败";
    

    private String msg = SUCC_MSG;

    /**
     * 当数据请求成功但需要额外提示用户的一些信息.
     */
    private String extMsg = null;

    /**
     * result 1 是成功 不等于1的情况下 有 isloginOut就是登录失败 ,其他情况统一弹窗提示msg
     */
    private int result = SUCCESS;

    /**
     * 结果集返回
     */
    private T data;


    /**
     * 返回成功
     *
     */
    public static ApiResponses<Void> success() {
        return ApiResponses.<Void>builder().result(SUCCESS).msg(SUCC_MSG).build();

    }


    /**
     * 成功返回
     *
     * @param object
     */
    public static <T> ApiResponses<T> success(T object) {
        return ApiResponses.<T>builder().result(SUCCESS).msg(SUCC_MSG).data(object).build();
    }

    /**
     * 成功返回
     *
     * @param object
     */
    public static <T> ApiResponses<T> success(T object, String extMsg) {
        return ApiResponses.<T>builder().result(SUCCESS).msg(SUCC_MSG).extMsg(extMsg).data(object).build();
    }

    /**
     * 返回失败
     */
    public static ApiResponses<Void> failure() {
        return ApiResponses.<Void>builder().result(FAIL).msg(FAIL_MSG).build();

    }

    /**
     * 返回失败
     *
     */
    public static ApiResponses<Void> failure(int result,String msg) {
        return ApiResponses.<Void>builder().result(result).msg(msg).build();

    }

    @JsonIgnore
    public boolean isSuccess() {
        return result == SUCCESS;
    }

    @JsonIgnore
    public boolean isFailed() {
        return !isSuccess();
    }

}
