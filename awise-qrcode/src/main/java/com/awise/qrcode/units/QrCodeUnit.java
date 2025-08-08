package com.awise.qrcode.units;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import javax.imageio.ImageIO;

import com.awise.qrcode.domain.AwQrcode;
import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCodeUnit {



    public QrCodeUnit(){}

    /**
     * 生成指定网址大小及图片格式的二维码
     *  @param url      网址
     * @param size     尺寸
     * @param fileType 二维码图片格式
     * @param qrFile   生成图片保存地址
     */
    public void createQrCode(String url, int size, String fileType, File qrFile) throws WriterException, IOException {

            HashMap<EncodeHintType, Object> hintMap = new HashMap<EncodeHintType, Object>();
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, size, size, hintMap);

            int matrixWidth = bitMatrix.getWidth();
            BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
            image.createGraphics();

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, matrixWidth, matrixWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, qrFile);
    }

    public AwQrcode createQrCode(String url, int size,int multiple, String fileType,String filepath,String productiontasksformID,String productiontasksID,String processingprocessID,String query) {
        AwQrcode awQrcode = new AwQrcode();
        String fileurl = UUID.randomUUID().toString()+".png";
        File file = new File(String.format("%s/%s",filepath,fileurl));
        url = url + query;

        try {
            this.createQrCode(url,size * multiple,fileType,file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        awQrcode.setFileurl(fileurl);
        awQrcode.setEffectiveDuration("10");
        awQrcode.setProductionTasksFormID(Long.valueOf(productiontasksformID));
        awQrcode.setProductionTasksID(Long.valueOf(productiontasksID));
        awQrcode.setProcessingprocessID(Long.valueOf(processingprocessID));
        awQrcode.setCreateTime(new Date());

        return awQrcode;
    }
}
