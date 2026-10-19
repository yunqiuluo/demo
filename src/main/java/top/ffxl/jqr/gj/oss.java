package top.ffxl.jqr.gj;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

public class oss {
    private static final S3Client s3 = S3Client.builder()
//            .endpointOverride(URI.create("https://s3.ffxl.top"))
            .endpointOverride(URI.create("http://127.0.0.1:9000"))
            .region(Region.US_EAST_1)
            .credentialsProvider(
                    StaticCredentialsProvider.create(
                            AwsBasicCredentials.create("","")
                    )
            )
            .forcePathStyle(true)
            .build();
    public static void set(String name, String path){
        s3.putObject(
                PutObjectRequest.builder().bucket("ces").key(name).build(),
                Paths.get(path)
        );
    }
    public static void seturl(String name,String contentType, String path) throws IOException {
        URL uri = new URL(path);
        try (InputStream inputStream = uri.openStream()) {
            byte[] data = inputStream.readAllBytes();
            s3.putObject(
                    PutObjectRequest.builder()
                            .bucket("ces")
                            .key(name)
                            .contentType(contentType)
                            .build(),
                    RequestBody.fromBytes(data)
            );
        }
    }
    public static void putBytes(String name, String contentType, byte[] data) {
        s3.putObject(
                PutObjectRequest.builder()
                        .bucket("ces")
                        .key(name)
                        .contentType(contentType)
                        .build(),
                RequestBody.fromBytes(data)
        );
    }
    public static void del(String name){
        s3.deleteObject(DeleteObjectRequest.builder().bucket("ces").key(name).build());
    }

}
