public class Main {
    public static void main(String[] args) {
        try {
            // AYARLAR
            // AES anahtarı tam 16 karakter olmalıdır (Örn: 1234567812345678)
            String key = "1234567812345678"; 
            String mySecret = "Piksel Kasası'na hoş geldiniz! Verileriniz güvende.";
            
            // Dosya yolları: input.png ana klasörde olmalı
            String originalImage = "input.png";
            String stegoImage = "output.png";

            SteganoEngine engine = new SteganoEngine();

            System.out.println("************************************");
            System.out.println("   PIKSEL KASASI SISTEMI ACILDI     ");
            System.out.println("************************************");

            // Gizleme İşlemi
            System.out.println("\n[+] Veri kilitleniyor (AES-128)...");
            String encrypted = AESCrypto.encrypt(mySecret, key);
            
            System.out.println("[+] Resim piksellerine gömülüyor...");
            engine.encode(originalImage, encrypted, stegoImage);
            System.out.println("[OK] Mesaj başarıyla '" + stegoImage + "' içine saklandı.");

            // Geri Çözme İşlemi (Kontrol Amaçlı)
            System.out.println("\n[+] Kasa açılıyor, veri okunuyor...");
            String extractedEncrypted = engine.decode(stegoImage, encrypted.length());
            String result = AESCrypto.decrypt(extractedEncrypted, key);
            
            System.out.println("\n------------------------------------");
            System.out.println("Kasadaki Gizli Mesaj: " + result);
            System.out.println("------------------------------------");

        } catch (Exception e) {
            System.err.println("\n[!] HATA: " + e.getMessage());
            System.err.println("[?] İpucu: 'input.png' dosyasının ana dizinde olduğundan emin olun.");
        }
    }
}