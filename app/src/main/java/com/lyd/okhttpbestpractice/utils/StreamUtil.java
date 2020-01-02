package com.lyd.okhttpbestpractice.utils;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 描述: 字符串和输入流互转类
 * 作者: LYD
 * 创建日期: 2020/1/2 16:06
 */
public class StreamUtil {

    /**
     * 将一个字符串转化为输入流
     *
     * @param string
     * @return
     */
    public static InputStream strToStream(String string) {
        if (!TextUtils.isEmpty(string)) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
                return byteArrayInputStream;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 将一个输入流转化为字符串
     *
     * @param inputStream
     * @return
     */
    public static String streamToStr(InputStream inputStream) {
        if (inputStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String sTempOneLine;
                while ((sTempOneLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append(sTempOneLine);
                }
                return stringBuffer.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
