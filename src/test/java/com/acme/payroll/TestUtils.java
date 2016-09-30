package com.acme.payroll;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class TestUtils {

    private static final String DEFAULT_CHARSET = "UTF-8";

    private TestUtils() {
        super();
    }

    static String inputStreamToString(InputStream inputStream) {
        return inputStreamToString(inputStream, DEFAULT_CHARSET);
    }

    static String inputStreamToString(InputStream inputStream, String charset) {
        StringBuilder fileData = new StringBuilder();
        String currentLine;
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream, charset));
            while ((currentLine = bufferedReader.readLine()) != null) {
                fileData.append(currentLine).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileData.toString();
    }
}
