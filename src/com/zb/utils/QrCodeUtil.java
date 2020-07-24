package com.zb.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * 二维码
 * 保存二维码到文件系统
 */
public class QrCodeUtil {
    //生成二维码图片输出流
    private static final QRCodeWriter QR_CODE_WRITER = new QRCodeWriter();
    /*
     * text -二维码内容
     * format- 生成图片格式
     * width height-生成二维码的宽高
     * path-生成二维码的存储路径
     * */
    public static void generateQrCodeAndSave
    (String text, String format, int width, int height, String path) throws WriterException, IOException {

        //存储乱码问题
        HashMap map=new HashMap();
        map.put(EncodeHintType.CHARACTER_SET,"UTF-8");
       // text=new String(text.getBytes("UTF-8"),"ISO-8859-1");
        //二维码信息对象
        BitMatrix bitMatrix
                = QR_CODE_WRITER.encode(text, BarcodeFormat.QR_CODE, width, height,map);
        //将二维码转化成图片
        MatrixToImageWriter.writeToPath(bitMatrix,format, Paths.get(path));
    }
}
