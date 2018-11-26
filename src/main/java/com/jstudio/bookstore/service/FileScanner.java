package com.jstudio.bookstore.service;

import com.jstudio.bookstore.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileScanner {
    @Autowired
    @Qualifier("appConfig")
    AppConfig config;

    public List<File> getFiles() {
        return getFiles(config.getUploadRootPath());
    }

    public List<File> getFiles(String filePath) {
        List<File> result = new ArrayList<>();
        File file = new File(filePath);
        if (file.isDirectory()) {

            File[] files = file.listFiles((pathName) -> {
                String fullName = pathName.getPath();
                String ext = fullName.substring(fullName.lastIndexOf(".") + 1);
                return pathName.isFile() && (ext.equals("JPG") || ext.equals("PNG"));
            });
            for (File subFile : files) {
                if (subFile.isFile()) {
                    result.add(subFile);
                } else {
                    List<File> subResults = getFiles(file.getPath());
                    result.addAll(subResults);
                }
            }

        } else {
            result.add(file);
        }
        return result;
    }
}
