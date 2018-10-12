package com.jstudio.bookstore.util;

import com.jstudio.bookstore.config.AppConfig;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@Component
public final class FileUtil {
    private static FileUtil instance;

    public static FileUtil getInstance() {
        return instance;
    }

    @Autowired
    AppConfig appConfig;

    @PostConstruct
    private void init() {
        instance = this;
        this.getRootFolder(appConfig.getUploadRootPath());
    }


    private File getRootFolder(String rootPath) {
        File rootFolder = new File(rootPath);
        if (!rootFolder.exists()) {
            rootFolder.mkdirs();
        }
        return rootFolder;
    }

    public String saveFile(InputStream inStream, String rootPath) throws IOException {
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
