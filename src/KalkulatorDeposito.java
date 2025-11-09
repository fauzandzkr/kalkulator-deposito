/**
 * Mewakili entitas deposito dan memegang semua logika 
 * untuk perhitungan bunga, pajak, dan total akhir.
 * Kelas ini tidak berinteraksi langsung dengan pengguna.
 *
 * @author Fauzan
 * @version 1.0
 */
public class KalkulatorDeposito {

    private static final double TARIF_PAJAK = 0.20;

    private double pokokSimpanan;
    private double sukuBungaTahunan;
    private int jangkaWaktuBulan;

    private double bungaKotor;
    private double pajak;
    private double bungaBersih;
    private double totalAkhir;

    /**
     * Constructor untuk membuat objek KalkulatorDeposito.
     * Data input dimasukkan saat objek dibuat.
     *
     * @param pokokSimpanan     Jumlah uang pokok yang disimpan.
     * @param sukuBungaTahunan  Suku bunga tahunan (misal: 5.0).
     * @param jangkaWaktuBulan  Lama simpanan dalam bulan.
     */
    public KalkulatorDeposito(double pokokSimpanan, double sukuBungaTahunan, int jangkaWaktuBulan) {
        this.pokokSimpanan = pokokSimpanan;
        this.sukuBungaTahunan = sukuBungaTahunan;
        this.jangkaWaktuBulan = jangkaWaktuBulan;
    }

    /**
     * Menjalankan semua proses kalkulasi secara internal.
     * Metode ini mengubah state internal objek.
     */
    public void hitung() {
        this.bungaKotor = hitungBungaKotor();
        this.pajak = hitungPajak();
        this.bungaBersih = hitungBungaBersih();
        this.totalAkhir = hitungTotalAkhir();
    }

    // --- METODE KALKULASI (sekarang PRIVATE) ---
    // Metode ini sekarang private karena hanya perlu dipanggil
    // dari dalam kelas ini (via metode public 'hitung()').
    // Mereka juga tidak butuh parameter lagi, karena sudah
    // mengakses dari atribut kelas (this.pokokSimpanan, dll).

    /**
     * Menghitung total bunga kotor.
     * @return jumlah bunga kotor.
     */
    private double hitungBungaKotor() {
        return (this.pokokSimpanan * (this.sukuBungaTahunan / 100)) * ((double) this.jangkaWaktuBulan / 12);
    }

    /**
     * Menghitung jumlah pajak dari bunga kotor.
     * @return jumlah pajak.
     */
    private double hitungPajak() {
        return this.bungaKotor * TARIF_PAJAK;
    }

    /**
     * Menghitung bunga bersih setelah dipotong pajak.
     * @return jumlah bunga bersih.
     */
    private double hitungBungaBersih() {
        return this.bungaKotor - this.pajak;
    }

    /**
     * Menghitung total uang di akhir jangka waktu.
     * @return total uang akhir.
     */
    private double hitungTotalAkhir() {
        return this.pokokSimpanan + this.bungaBersih;
    }


    public double getPokokSimpanan() { return this.pokokSimpanan; }
    public double getBungaKotor() { return this.bungaKotor; }
    public double getPajak() { return this.pajak; }
    public double getBungaBersih() { return this.bungaBersih; }
    public double getTotalAkhir() { return this.totalAkhir; }
}