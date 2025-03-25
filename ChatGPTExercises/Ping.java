import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ping {
    public static void main(String[] args) {
        // Kullanım: java Ping 127.0.0.1 2
        if (args.length != 2) {
            System.out.println("Kullanım: java Ping <DESTIP> <TIMEOUT>");
            return;
        }

        String inputIP = args[0];  // Kullanıcının girdiği IP adresi
        int inputTimeout = Integer.parseInt(args[1]) * 1000; // Kullanıcının girdiği timeout süresi (saniye)

        try {
            sendPing(inputIP, inputTimeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendPing(String ip, int timeOut) throws IOException, InterruptedException {
        InetAddress destIP = InetAddress.getByName(ip);
        System.out.println("Ping atılıyor: " + ip);

        // ANSI Renk Kodları (Sadece Konsol İçin)
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        // Log dosyası oluştur
        String time = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        BufferedWriter output = new BufferedWriter(new FileWriter(time + ".txt", true));

        try {
            while (true) {
                long startTime = System.currentTimeMillis(); // Süre ölçümü BAŞLANGIÇ
                boolean reachable = destIP.isReachable(2000); // 2 saniye içinde yanıt bekleniyor
                long endTime = System.currentTimeMillis(); // Süre ölçümü BİTİŞ
                long roundTrip = endTime - startTime; // Gidiş-dönüş süresi hesapla

                String timeStamp = new SimpleDateFormat("dd-MM-yyyy | HH:mm:ss").format(new Date());

                // Konsol çıktısı renkli, dosya çıktısı renksiz olmalı
                String consoleOutput;
                String logOutput;

                if (reachable) {
                    consoleOutput = ANSI_BLUE + timeStamp + "| " + ANSI_RESET + roundTrip + " ms " + ip + ANSI_GREEN + " yanıt verdi." + ANSI_RESET;
                    logOutput = timeStamp + "| " + roundTrip + " ms " + ip + " yanıt verdi.";
                } else {
                    consoleOutput = ANSI_BLUE + timeStamp + "| " + ANSI_RESET + ip + ANSI_RED + " erişilemiyor!" + ANSI_RESET;
                    logOutput = timeStamp + "| " + ip + " erişilemiyor!";
                }

                System.out.println(consoleOutput);
                output.append(logOutput);
                output.newLine(); // Yeni satır ekle

                output.flush(); // Buffer'ı dosyaya yaz

                Thread.sleep(timeOut); // Belirtilen süre kadar bekle
            }
        } finally {
            output.close(); // Çıkışta dosyayı kapat
        }
    }
}
