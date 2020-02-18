package com.ibn.vo;

import com.ibn.base.entity.BaseVO;
import lombok.Data;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.vo
 * @date ：2020/1/30 16:01
 * @description：存放用户基本信息（用户登入后将用户相关信息存在前台)
 * @version: 1.0
 */
@Data
public class UserInfoVO extends BaseVO {
    /**
     * @author: RenBin
     * @description: 用户id
     * @date: 2020/1/30 16:03
     */
    private Long id;
    /**
     * @author: RenBin
     * @description: 用户名
     * @date: 2020/1/30 16:03
     */
    private String userName;
    /**
     * @author: RenBin
     * @description: 用户对应的token信息
     * @date: 2020/1/30 18:15
     */
    private String token;
}
