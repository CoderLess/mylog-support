package com.ibn.service;

import com.ibn.annotation.NotNeedLogin;
import com.ibn.entity.ImageBaseDO;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.service
 * @date ：2020/2/7 13:37
 * @description：对图片进行操作
 * @version: 1.0
 */
public interface ImageBaseService {
    /**
     * @author: RenBin
     * @description: 保存图片
     * @date: 2020/2/7 13:38
     */
    Long saveImage(ImageBaseDO imageBaseDO);
    /**
     * @author: RenBin
     * @description: 获取图片
     * @date: 2020/2/7 15:56
     */
    @NotNeedLogin
    ImageBaseDO queryImage(ImageBaseDO imageBaseDO);
}
