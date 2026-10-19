package top.ffxl.jqr.gj;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class silk {

    public static byte[] hq(String audioUrl) throws Exception {
        Process process = getProcess(audioUrl);

        // 从标准输出读取纯音频数据
        try (InputStream inputStream = process.getInputStream();
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("FFmpeg 处理失败，退出码: " + exitCode);
            }

            return baos.toByteArray();
        }
    }

    private static Process getProcess(String audioUrl) throws IOException {
        String[] cmd = {
                "ffmpeg",
                "-i", audioUrl,
                "-vn",
                "-acodec", "pcm_s16le",
                "-ar", "16000",
                "-ac", "1",
                "-f", "wav",
                "-"
        };
        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process process = pb.start();

        // 启动线程读取错误流，防止阻塞


        return process;
    }
}