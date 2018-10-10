package com.jstudio.bookstore.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class FileUtil {

    public static File getRootFolder(String rootPath) {
        File rootFolder = new File(rootPath);
        if (!rootFolder.exists()) {
            rootFolder.mkdirs();
        }
        return rootFolder;
    }

    public static String saveFile(InputStream inStream, String rootPath) throws IOException {
        File file = File.createTempFile("upload_", "_new.jpg", getRootFolder(rootPath));
        FileOutputStream fos = new FileOutputStream(file);
        final int len = 64 * 1024;
        byte[] buffer = new byte[len];
        while (true) {
            int readLen = inStream.read(buffer, 0, len);
            if (readLen > 0) {
                fos.write(buffer, 0, readLen);
            } else {
                break;
            }
        }
        inStream.close();
        fos.close();
        return file.getAbsolutePath();
    }
}
