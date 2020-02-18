package com.ibn.dao;

import com.ibn.annotation.NotNeedLogin;
import com.ibn.entity.ImageBaseDO;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.dao
 * @date ：2020/2/6 09:18
 * @description：图片的处理相关
 * @version: 1.0
 */
public interface ImageBaseDao {
    /**
     * @author: RenBin
     * @description: 保存图片
     * @date: 2020/2/6 09:22
     */
    Long saveImage(ImageBaseDO imageBaseDO);
    /**
     * @author: RenBin
     * @description: 查询图片
     * @date: 2020/2/7 15:57
     */
    @NotNeedLogin
    ImageBaseDO queryImage(ImageBaseDO imageBaseDO);
}
