package top.ffxl.jqr.gj;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class img {
    private final ImageReader image;
    private img(String URL) throws IOException {
        InputStream in = new URL(URL).openStream();
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
        this.image = readers.next();
        this.image.setInput(iis, true);
    }
    public static img build(String URL) throws IOException {
        return new img(URL);
    }
    public int getWidth() throws IOException {
        return image.getWidth(0);
    }
    public int getHeight() throws IOException {
        return image.getHeight(0);
    }
    public String getFormat() throws IOException {
        return image.getFormatName();
    }
}
