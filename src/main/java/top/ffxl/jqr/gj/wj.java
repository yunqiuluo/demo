package top.ffxl.jqr.gj;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.UUID;

@Slf4j
public class wj {

    private static final String UPLOAD_DIR = "/www/wwwroot/img";


    public static String img(String source, String suffix) {
        try {
            String fileName = UUID.randomUUID() +
                    (suffix.startsWith(".") ? suffix : "." + suffix);

            Files.createDirectories(Paths.get(UPLOAD_DIR));

            if (source.startsWith("http://") || source.startsWith("https://")) {
                downloadFromUrl(source, fileName);
            } else {
                copyLocalFile(source, fileName);
            }

            return "https://www.ffxl.top/img/" + fileName;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }


    private static void downloadFromUrl(String url, String fileName) throws Exception {
        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, Paths.get(UPLOAD_DIR, fileName), StandardCopyOption.REPLACE_EXISTING);
        }
    }


    private static void copyLocalFile(String sourcePath, String fileName) throws Exception {
        Files.copy(Paths.get(sourcePath), Paths.get(UPLOAD_DIR, fileName),
                StandardCopyOption.REPLACE_EXISTING);
    }
}