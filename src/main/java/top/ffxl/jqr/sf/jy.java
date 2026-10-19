package top.ffxl.jqr.sf;

import top.ffxl.jqr.jqrpzxx.jcsj;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

public class jy {

    public static String js(String plain_token, String event_ts) {
        try {
            StringBuilder seed = new StringBuilder(jcsj.AppSecret);
            while (seed.length() < 32) {
                seed.append(seed);
            }
            byte[] seedBytes = seed.substring(0, 32).getBytes(StandardCharsets.UTF_8);

            Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(seedBytes, 0);

            String message = event_ts + plain_token;
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

            Signer signer = new Ed25519Signer();
            signer.init(true, privateKey);
            signer.update(messageBytes, 0, messageBytes.length);
            byte[] signature = signer.generateSignature();

            return Hex.toHexString(signature);

        } catch (Exception e) {
            throw new RuntimeException("生成签名失败: " + e.getMessage(), e);
        }
    }
}