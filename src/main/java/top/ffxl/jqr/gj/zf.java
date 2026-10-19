package top.ffxl.jqr.gj;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class zf {
    public static void fs() {
        String macStr = "E8:9C:25:D0:09:74";
        String publicIp = "43.139.148.221";
        int port = 9;
        try {
            byte[] macBytes = parseMacAddress(macStr);

            // 构建魔术包（同前）
            byte[] magicPacket = new byte[6 + 16 * 6];
            for (int i = 0; i < 6; i++) {
                magicPacket[i] = (byte) 0xFF;
            }
            for (int i = 0; i < 16; i++) {
                System.arraycopy(macBytes, 0, magicPacket, 6 + i * 6, 6);
            }

            // 发送到公网IP（不再需要设置广播标志）
            try (DatagramSocket socket = new DatagramSocket()) {
                InetAddress address = InetAddress.getByName(publicIp);
                DatagramPacket packet = new DatagramPacket(magicPacket, magicPacket.length, address, port);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] parseMacAddress(String macStr) {
        String[] parts = macStr.split("[:\\-]");
        if (parts.length != 6) return null;
        byte[] mac = new byte[6];
        try {
            for (int i = 0; i < 6; i++) {
                mac[i] = (byte) Integer.parseInt(parts[i], 16);
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return mac;
    }
}