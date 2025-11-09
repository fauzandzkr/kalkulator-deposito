import java.util.Scanner;

/**
 * Kelas utama untuk menjalankan aplikasi (entry point).
 * Bertanggung jawab HANYA untuk interaksi dengan pengguna
 * (input dan output konsol).
 */
public class AplikasiDeposito {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("--- KALKULATOR DEPOSITO SEDERHANA ---");

            double pokok = ambilInputDouble(scanner, "Masukkan Jumlah Pokok Simpanan (Rp): ");
            double bunga = ambilInputDouble(scanner, "Masukkan Suku Bunga Tahunan (%): ");
            int bulan = ambilInputInt(scanner, "Masukkan Jangka Waktu (bulan): ");

            KalkulatorDeposito kalkulator = new KalkulatorDeposito(pokok, bunga, bulan);
            
            kalkulator.hitung();

            tampilkanHasil(kalkulator);

        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }
    }

    /**
     * Metode bantu untuk mengambil input double dari pengguna.
     * @param scanner Objek scanner yang digunakan.
     * @param pesan   Pesan yang ditampilkan ke pengguna.
     * @return Nilai double yang dimasukkan pengguna.
     */
    private static double ambilInputDouble(Scanner scanner, String pesan) {
        System.out.print(pesan);

        while (!scanner.hasNextDouble()) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            System.out.print(pesan);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Metode bantu untuk mengambil input integer dari pengguna.
     * @param scanner Objek scanner yang digunakan.
     * @param pesan   Pesan yang ditampilkan ke pengguna.
     * @return Nilai integer yang dimasukkan pengguna.
     */
    private static int ambilInputInt(Scanner scanner, String pesan) {
        System.out.print(pesan);
        while (!scanner.hasNextInt()) {
            System.out.println("Input tidak valid. Harap masukkan angka bulat.");
            System.out.print(pesan);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Metode bantu untuk menampilkan hasil perhitungan ke konsol.
     * @param kalkulator Objek kalkulator yang sudah berisi data hasil.
     */
    private static void tampilkanHasil(KalkulatorDeposito kalkulator) {
        System.out.println("\n--- HASIL PERHITUNGAN ---");

        System.out.printf("Pokok Simpanan:       Rp %,.0f%n", kalkulator.getPokokSimpanan());
        System.out.printf("Bunga Kotor:          Rp %,.0f%n", kalkulator.getBungaKotor());
        System.out.printf("Pajak (20%%):         Rp %,.0f%n", kalkulator.getPajak());
        System.out.printf("Bunga Bersih:         Rp %,.0f%n", kalkulator.getBungaBersih());
        System.out.println("---------------------------------");
        System.out.printf("Total Uang Jatuh Tempo: Rp %,.0f%n", kalkulator.getTotalAkhir());
    }
}