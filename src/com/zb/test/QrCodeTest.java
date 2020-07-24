package com.zb.test;

import com.google.zxing.WriterException;
import com.zb.utils.QrCodeUtil;

import java.io.IOException;

//用于测试二维码
public class QrCodeTest {
    //定义图片存储地址
    private static  final  String QR_CODE_IMAGE_PATH="D:/firefoxDownload/MyQrCode.png";
    private static final String text="我错了，别问爱过，都是过去式，拜拜";
    private static final String format="png";
    private static final int width=300;
    private static final int height=300;

    public static void main(String[] args) throws IOException, WriterException {
        QrCodeUtil.generateQrCodeAndSave(text,format,width,height,QR_CODE_IMAGE_PATH);
    }
}
