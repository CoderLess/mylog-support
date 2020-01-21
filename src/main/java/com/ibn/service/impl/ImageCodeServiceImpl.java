package com.ibn.service.impl;

import com.ibn.service.ImageCodeService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.service.impl
 * @author： RenBin
 * @createTime：2020/1/20 15:39
 */
@Service(value = "imageCodeService")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ImageCodeServiceImpl implements ImageCodeService {
    private int width = 70;
    private int high = 35;
    private Random random = new Random();
    private String[] fontNameArr = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    /**
     * @description: 可选字符
     * @author：RenBin
     * @createTime：2019/12/13 14:34
     */
    private String codes = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    /**
     * @description: 背景色
     * @author：RenBin
     * @createTime：2020/1/20 15:40
     */
    private Color bgColor = new Color(255, 255, 255);
    /**
     * @description: 验证码上的文本
     * @author：RenBin
     * @createTime：2020/1/20 15:40
     */
    private String text;

    /**
     * @description: 生成随机的颜色
     * @author：RenBin
     * @createTime：2020/1/20 15:40
     */
    private Color randomColor() {
        int bound = 150;
        int red = random.nextInt(bound);
        int green = random.nextInt(bound);
        int blue = random.nextInt(bound);
        return new Color(red, green, blue);
    }

    /**
     * @description: 生成随机的字体
     * @author：RenBin
     * @createTime：2020/1/20 15:40
     */
    private Font randomFont() {
        int index = random.nextInt(fontNameArr.length);
        //生成随机的字体名称
        String fontName = fontNameArr[index];
        //生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int style = random.nextInt(4);
        //生成随机字号, 24 ~ 28
        int size = random.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    /**
     * @description: 画干扰线
     * @author：RenBin
     * @createTime：2020/1/20 15:40
     */
    private void drawLine(BufferedImage image) {
        //一共画3条
        int num = 3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        //生成两个点的坐标，即4个值
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(high);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(high);
            g2.setStroke(new BasicStroke(1.5F));
            //干扰线是蓝色
            g2.setColor(Color.BLUE);
            //画线
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * @description: 随机生成一个字符
     * @author：RenBin
     * @createTime：2020/1/20 15:41
     */
    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * @description: 创建BufferedImage
     * @author：RenBin
     * @createTime：2020/1/20 15:41
     */
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, high, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, high);
        return image;
    }

    /**
     * @description: 调用这个方法得到验证码
     * @author：RenBin
     * @createTime：2020/1/20 15:41
     */
    @Override
    public BufferedImage getImage() {
        //创建图片缓冲区
        BufferedImage image = createImage();
        //得到绘制环境
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        //用来装载生成的验证码文本
        StringBuilder sb = new StringBuilder();
        // 向图片中画4个字符
        //循环四次，每次生成一个字符
        for (int i = 0; i < 4; i++) {
            //随机生成一个字母
            String s = randomChar() + "";
            //把字母添加到sb中
            sb.append(s);
            //设置当前字符的x轴坐标
            float x = i * 1.0F * width / 4;
            //设置随机字体
            g2.setFont(randomFont());
            //设置随机颜色
            g2.setColor(randomColor());
            //画图
            g2.drawString(s, x, high - 5);
        }
        //把生成的字符串赋给了this.text
        this.text = sb.toString();
        //添加干扰线
        drawLine(image);
        return image;
    }

    /**
     * @description: 返回验证码图片上的文本
     * @author：RenBin
     * @createTime：2020/1/20 15:41
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * @description: 保存图片到指定的输出流
     * @author：RenBin
     * @createTime：2020/1/20 15:41
     */
    @Override
    public void output(BufferedImage bufferedImage, OutputStream outputStream)
            throws IOException {
        if (null == outputStream) {
            return;
        }
        ImageIO.write(bufferedImage, "JPEG", outputStream);
    }

    /**
     * @description: 输出图片
     * @author：RenBin
     * @createTime：2020/1/20 15:42
     */
    @Override
    public void outputImage(BufferedImage bi, String imageName) {
        String path = imageName + ".jpg";
        try {
            ImageIO.write(bi, "JPEG", new FileOutputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
