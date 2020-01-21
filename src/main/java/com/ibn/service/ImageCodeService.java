package com.ibn.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.service
 * @author： RenBin
 * @createTime：2020/1/20 15:38
 */
public interface ImageCodeService {
    /**
     * @description: 获取图片
     * @author：RenBin
     * @createTime：2020/1/20 15:38
     */
    BufferedImage getImage();
    /**
     * @description: 获取验证码的值
     * @author：RenBin
     * @createTime：2020/1/20 15:38
     */
    String getText();
    /**
     * @description: 输出到指定的流中
     * @author：RenBin
     * @createTime：2020/1/20 15:39
     */
    void output(BufferedImage image, OutputStream out) throws IOException;
    /**
     * @description: 输出到指定文件
     * @author：RenBin
     * @createTime：2020/1/20 15:39
     */
    void outputImage(BufferedImage bi,String imageName);
}
