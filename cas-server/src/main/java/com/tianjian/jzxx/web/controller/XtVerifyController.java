package com.tianjian.jzxx.web.controller;

import com.tianjian.jzxx.constant.SessionConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 *
 * @author 邓纯杰
 */
@RestController
public class XtVerifyController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final int WIDTH = 200;// 生成的图片的宽度
    private static final int HEIGHT = 30;// 生成的图片的高度

    @RequestMapping(value = "/verify")
    public void verify(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        // 设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");// 等同于response.setHeader("Content-Type",
        // 设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        // 1.在内存中创建一张图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 2.虚拟画笔得到图片
        Graphics g = image.getGraphics();
        // 3.设置图片的背影色
        setBackGround(g);
        // 4.设置图片的边框
        setBorder(g);
        // 5.在图片上画干扰线
//		drawRandomLine(g);
        // 6.写在图片上随机数
        String random = drawRandomNum((Graphics2D) g);// 生成数字和字母组合的验证码图片

        session.setAttribute(SessionConstant.VALIDATECODE, random);
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
            logger.info("生成验证码结束");
        } catch (IOException e) {
            logger.error("生成验证码出现异常");
        }
    }

    /**
     * 设置图片的背景色
     *
     * @param g
     */
    private void setBackGround(Graphics g) {
        // 设置颜色
        g.setColor(Color.WHITE);
        // 填充区域
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    /**
     * 设置图片的边框
     *
     * @param g
     */
    private void setBorder(Graphics g) {
        // 设置边框颜色
        g.setColor(Color.WHITE);
        // 边框区域
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    /**
     * 在图片上画随机线条
     *
     * @param g
     */
    @SuppressWarnings("unused")
    private void drawRandomLine(Graphics g) {
        // 设置颜色
//		g.setColor(Color.GREEN);
        Random r = new Random();
        // 设置线条个数并画线
        for (int i = 0; i < 10; i++) {
            int x1 = r.nextInt(WIDTH);
            int y1 = r.nextInt(HEIGHT);
            int x2 = r.nextInt(WIDTH);
            int y2 = r.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
            //设置干扰线颜色
            Color color = new Color(20 + r.nextInt(210), 20 + r.nextInt(210), 20 + r.nextInt(210));
            g.setColor(color);
        }

    }

    /**
     * 画随机字符
     *
     * @param g
     */
    private String drawRandomNum(Graphics2D g) {
        // 设置颜色
        g.setColor(Color.RED);
        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 30));

        // 数字和字母的组合
//		String baseNumLetter = "Aa0Bb1CcDd3EeFf5Gg6HhJjKkLl7MmN9nOoPp8QqRrSs2TtUuVv4WwXxYyZz";
        String baseNumLetter = "0123456789";
        return createRandomChar(g, baseNumLetter);
    }

    /**
     * 创建随机字符
     *
     * @param g
     * @param baseChar
     * @return 随机字符
     */
    private String createRandomChar(Graphics2D g, String baseChar) {
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int x = 5;
        String ch = "";
        // 控制字数
        for (int i = 0; i < 6; i++) {
            // 设置字体旋转角度
            int degree = r.nextInt() % 30;
            ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
            //设置随机数的颜色
            Color color = new Color(20 + r.nextInt(210), 20 + r.nextInt(210), 20 + r.nextInt(210));
            g.setColor(color);
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 30);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 30);
            x += 30;
        }
        return sb.toString();
    }
}
