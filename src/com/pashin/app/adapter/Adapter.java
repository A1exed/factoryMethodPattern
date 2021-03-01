package com.pashin.app.adapter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Adapter {
    public OutputStream stringArrToOutputStream(String[] stringArr) {
        OutputStream outputStream = new ByteArrayOutputStream();
        for (String s : stringArr) {
            try {
                outputStream.write(s.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream;
    }
}
