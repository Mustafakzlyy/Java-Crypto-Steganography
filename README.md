**🛡️ Piksel Kasası (Java-Crypto-Steganography)**
--------------------------------------------------
Piksel Kasası, dijital dünyada mesajlarınızı görünmez kılan bir siber güvenlik aracıdır. Bu proje, gizli verileri önce AES-128 bit ile şifreler, ardından LSB (Least Significant Bit) yöntemini kullanarak bir PNG resminin piksellerine gömer.

**✨ Öne Çıkan Özellikler**
-----------------------------
Çift Katmanlı Koruma: Veriler sadece gizlenmekle kalmaz, aynı zamanda askeri düzeyde AES şifreleme ile korunur.

Görsel Kusursuzluk: 1000x1000 piksellik bir resimde yapılan değişiklikler insan gözüyle fark edilemez.

Siber Güvenlik Odaklı: GitHub portfolyonuz için hem kriptografi hem de steganografi bilgisini bir arada sunan teknik bir örnektir.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**📁 Proje Yapısı**
----------------------
Java-Crypto-Steganography/
├── src/                # Kaynak kodlar
│   ├── AESCrypto.java      # Şifreleme motoru
│   ├── SteganoEngine.java  # Piksel manipülasyon motoru
│   └── Main.java           # Uygulama giriş noktası (Piksel Kasası Arayüzü)
├── input.png           # Gizleme yapılacak orijinal resim (1000x1000 önerilir)
└── README.md           # Proje tanıtımı ve kullanım kılavuzu
 
**🚀 Başlangıç**
---------------------
**Gereksinimler**
Bilgisayarınızda JDK 17 veya üzeri bir sürümün yüklü olması gerekir.

Ana dizinde input.png isimli bir resim dosyası bulunmalıdır.

**Çalıştırma Adımları**
------------------------
1-Proje klasöründe bir terminal açın.

2-Kodları derleyin

3-Piksel Kasası'nı çalıştırın
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**🧠 Nasıl Çalışır?**
----------------------------
Şifreleme: Girdiğiniz metin, belirlediğiniz 16 karakterlik anahtar ile AES algoritması kullanılarak okunamaz hale getirilir.

Gizleme: Şifreli metnin her bir biti, resimdeki piksellerin en önemsiz bitine (LSB) sırasıyla yerleştirilir.

Çözme: output.png dosyası okunur, bitler toplanır ve anahtar ile şifre çözülerek orijinal mesaj geri getirilir.
