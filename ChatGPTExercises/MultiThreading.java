public class MultiThreading {
    public static void main(String[] args) {

        long[] numbers = new long[100_000_000]; // RAM kullanımını düşürmek için 1 milyon eleman
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        
        System.out.println("Available Cores: " + Runtime.getRuntime().availableProcessors());
        // Available Cores: 18

        fastSum(10, numbers); // Örnek olarak 4 thread ile çalıştır
        noThreadResult(numbers);
    }    

    public static void fastSum(int threadNumber, long[] numbers){

        long startTime = System.currentTimeMillis();

        // if thread is 5, borders is 200 000
        int borders = numbers.length / threadNumber;
        long result = 0;
        SummaryThread[] threads = new SummaryThread[threadNumber];
        
        for (int i = 0; i < threadNumber; i++) {
            int start = i * borders;
            int end = (i == threadNumber - 1) ? numbers.length : (i + 1) * borders;
            threads[i] = new SummaryThread(start, end, numbers);
            threads[i].start();  // 🔥 Thread'i başlat
        }

        // Tüm thread'lerin bitmesini bekle
        for (SummaryThread thread : threads) {
            try {
                thread.join();  // 🔥 Thread bitene kadar bekle
                result += thread.getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Summary process duration is : " + estimatedTime + "ms with " + threadNumber + " threads.");
        System.out.println("Total sum: " + result);
    }

    public static void noThreadResult(long[] numbers){
        long startTime = System.currentTimeMillis();
        long result = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];  // Toplam hesaplama
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Summary process duration is : " + estimatedTime + "ms with no thread.");
        System.out.println("Total sum: " + result);
    }
}

class SummaryThread extends Thread {
    private int start, end;
    private long[] array;
    private long sum = 0;

    public SummaryThread(int start, int end, long[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];  // Toplama işlemi
        }
    }

    public long getSum() {
        return sum;  // Thread tamamlandıktan sonra sonucu alacağız
    }
}
