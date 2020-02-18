package com.zhifa.erweima.controller;

import com.zhifa.erweima.util.QRCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author lzf
 * @version 1.0
 * @date 2020-02-17 13:46
 */
@RestController
public class QRCodeController {

    @GetMapping("/getImg")
    public void getImg(HttpServletResponse response) {
        String logoImg = "C:\\Users\\tecsun\\Desktop\\微信图片_20200217142612.jpg";
        String text = "https://space.bilibili.com/184865921/favlist?fid=354333421&ftype=create";
        try {
            BufferedImage image = QRCodeUtil.createImage(text, logoImg, true);
            // 写入返回
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byte[] QRJPG = baos.toByteArray();
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            ServletOutputStream os = response.getOutputStream();
            os.write(QRJPG); // 自此完成一套，图片读入，写入流，转为字节数组，写入输出流
            os.flush();
            os.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
