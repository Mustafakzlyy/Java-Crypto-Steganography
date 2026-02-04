import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SteganoEngine {

    // Veriyi Gizleme (Encode)
    public void encode(String sourcePath, String message, String outputPath) throws Exception {
        BufferedImage image = ImageIO.read(new File(sourcePath));
        byte[] msgBytes = message.getBytes();
        int bitIndex = 0;

        for (int y = 0; y < image.getHeight() && bitIndex < msgBytes.length * 8; y++) {
            for (int x = 0; x < image.getWidth() && bitIndex < msgBytes.length * 8; x++) {
                int pixel = image.getRGB(x, y);
                int currentBit = (msgBytes[bitIndex / 8] >> (7 - (bitIndex % 8))) & 1;
                pixel = (pixel & 0xFFFFFFFE) | currentBit;
                image.setRGB(x, y, pixel);
                bitIndex++;
            }
        }
        ImageIO.write(image, "png", new File(outputPath));
    }

    // Veriyi Geri Çıkarma (Decode)
    public String decode(String stegoPath, int messageLength) throws Exception {
        BufferedImage image = ImageIO.read(new File(stegoPath));
        byte[] decodedBytes = new byte[messageLength];
        int bitIndex = 0;

        for (int y = 0; y < image.getHeight() && bitIndex < messageLength * 8; y++) {
            for (int x = 0; x < image.getWidth() && bitIndex < messageLength * 8; x++) {
                int pixel = image.getRGB(x, y);
                int bit = pixel & 1;
                decodedBytes[bitIndex / 8] = (byte) ((decodedBytes[bitIndex / 8] << 1) | bit);
                bitIndex++;
            }
        }
        return new String(decodedBytes);
    }
}