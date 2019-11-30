package com.hoomoomoo.fims.app.util;

import com.hoomoomoo.fims.app.model.common.ResultData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.hoomoomoo.fims.app.consts.BusinessConst.*;

/**
 * @author humm23693
 * @description 命令行执行工具类
 * @package com.hoomoomoo.fims.app.util
 * @date 2019/11/30
 */

public class SysCommandUtils {

    public static ResultData<String> execute(String cmd) {
        BufferedReader inputBufferedReader = null;
        BufferedReader errorBufferedReader = null;
        ResultData<String> resultData = new ResultData();
        String output = STR_EMPTY;

        try {
            // 设置GBK编码 uft8乱码
            Process process = Runtime.getRuntime().exec(cmd);
            inputBufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), GBK));
            errorBufferedReader = new BufferedReader(
                new InputStreamReader(process.getErrorStream(), GBK));

            String line = null;
            while ((line = inputBufferedReader.readLine()) != null) {
                output = output + line + System.lineSeparator();
            }

            while ((line = errorBufferedReader.readLine()) != null) {
                output = output + line + System.lineSeparator();
            }

            resultData.setData(output);
            int waitFor = process.waitFor();
            if (waitFor != 0) {
                resultData.setCode(STATUS_FAIL);
            }
        } catch (Exception var15) {
            throw new RuntimeException(var15);
        } finally {
            if (inputBufferedReader != null) {
                try {
                    inputBufferedReader.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
            }
            if (errorBufferedReader != null) {
                try {
                    errorBufferedReader.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
            }

        }
        return resultData;
    }
}
