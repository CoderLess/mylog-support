package com.ibn.service.impl;

import com.ibn.dao.ImageBaseDao;
import com.ibn.entity.ImageBaseDO;
import com.ibn.service.ImageBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.service.impl
 * @date ：2020/2/7 13:39
 * @description：图片实现类
 * @version: 1.0
 */
@Service("imageBaseService")
public class ImageBaseServiceImpl implements ImageBaseService {
    @Autowired
    private ImageBaseDao imageBaseDao;
    @Override
    public Long saveImage(ImageBaseDO imageBaseDO) {
        imageBaseDao.saveImage(imageBaseDO);
        return imageBaseDO.getId();
    }

    @Override
    public ImageBaseDO queryImage(ImageBaseDO imageBaseDO) {
        return imageBaseDao.queryImage(imageBaseDO);
    }
}
