import java.util.ArrayList;
import java.util.Scanner;

// Kelas Induk - Abstract Base Class
abstract class Pengguna {
    private String nama;
    private String kontak;

    // Constructor overloading
    public Pengguna() {
        this.nama = "Nama Tidak Diketahui";
        this.kontak = "Kontak Tidak Diketahui";
    }

    public Pengguna(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    // Abstract method untuk ditimpa oleh kelas anak
    public abstract void tampilkanInfoPengguna();
}

// Kelas Induk untuk Kamar
abstract class Kamar {
    private String nomorKamar;
    private double hargaPerMalam;
    private boolean terisi;

    // Constructor overloading
    public Kamar() {
        this.nomorKamar = "Belum Ditentukan";
        this.hargaPerMalam = 0;
        this.terisi = false;
    }

    public Kamar(String nomorKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.terisi = false;
    }

    // Getter dan Setter
    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }

    public boolean isTerisi() {
        return terisi;
    }

    public void setTerisi(boolean terisi) {
        this.terisi = terisi;
    }

    // Abstract method untuk perhitungan harga
    public abstract double hitungTotalHarga(int lamaMenginap);
}

// Kelas Induk untuk Reservasi
abstract class Reservasi {
    private Tamu tamu;
    private Kamar kamar;
    private int lamaMenginap;
    private String tanggalReservasi;

    // Constructor
    public Reservasi(Tamu tamu, Kamar kamar, int lamaMenginap, String tanggalReservasi) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.lamaMenginap = lamaMenginap;
        this.tanggalReservasi = tanggalReservasi;
    }

    // Getter dan Setter
    public Tamu getTamu() {
        return tamu;
    }

    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public int getLamaMenginap() {
        return lamaMenginap;
    }

    public void setLamaMenginap(int lamaMenginap) {
        this.lamaMenginap = lamaMenginap;
    }

    public String getTanggalReservasi() {
        return tanggalReservasi;
    }

    public void setTanggalReservasi(String tanggalReservasi) {
        this.tanggalReservasi = tanggalReservasi;
    }

    // Abstract method untuk status reservasi
    public abstract void tampilkanStatusReservasi();
}

// Kelas Induk Tamu - Inheritance dari Pengguna
class Tamu extends Pengguna {
    private String email;
    private String jenisIdentitas;

    // Constructor
    public Tamu(String nama, String kontak, String email, String jenisIdentitas) {
        super(nama, kontak);
        this.email = email;
        this.jenisIdentitas = jenisIdentitas;
    }

    // Getter dan Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenisIdentitas() {
        return jenisIdentitas;
    }

    public void setJenisIdentitas(String jenisIdentitas) {
        this.jenisIdentitas = jenisIdentitas;
    }

    // Overriding method dari kelas induk
    @Override
    public void tampilkanInfoPengguna() {
        System.out.println("Nama Tamu: " + getNama());
        System.out.println("Kontak: " + getKontak());
        System.out.println("Email: " + email);
        System.out.println("Jenis Identitas: " + jenisIdentitas);
    }
}

// Kelas Anak - Kamar Standar (Inheritance dari Kamar)
class KamarStandar extends Kamar {
    private boolean pemandangan;

    // Constructor
    public KamarStandar(String nomorKamar, double hargaPerMalam, boolean pemandangan) {
        super(nomorKamar, hargaPerMalam);
        this.pemandangan = pemandangan;
    }

    // Getter dan Setter
    public boolean isPemandangan() {
        return pemandangan;
    }

    public void setPemandangan(boolean pemandangan) {
        this.pemandangan = pemandangan;
    }

    // Overriding method perhitungan harga
    @Override
    public double hitungTotalHarga(int lamaMenginap) {
        double totalHarga = getHargaPerMalam() * lamaMenginap;
        return pemandangan ? totalHarga * 1.1 : totalHarga;
    }
}

// Kelas Anak - Kamar Suite (Inheritance dari Kamar)
class KamarSuite extends Kamar {
    private boolean sarapanGratis;

    // Constructor
    public KamarSuite(String nomorKamar, double hargaPerMalam, boolean sarapanGratis) {
        super(nomorKamar, hargaPerMalam);
        this.sarapanGratis = sarapanGratis;
    }

    // Getter dan Setter
    public boolean isSarapanGratis() {
        return sarapanGratis;
    }

    public void setSarapanGratis(boolean sarapanGratis) {
        this.sarapanGratis = sarapanGratis;
    }

    // Overriding method perhitungan harga
    @Override
    public double hitungTotalHarga(int lamaMenginap) {
        double totalHarga = getHargaPerMalam() * lamaMenginap;
        return sarapanGratis ? totalHarga * 0.9 : totalHarga;
    }
} 

// Kelas ReservasiKamar - Inheritance dari Reservasi
class ReservasiKamar extends Reservasi {
    private double totalHarga;
    private String statusReservasi;

    // Constructor
    public ReservasiKamar(Tamu tamu, Kamar kamar, int lamaMenginap, String tanggalReservasi) {
        super(tamu, kamar, lamaMenginap, tanggalReservasi);
        this.totalHarga = kamar.hitungTotalHarga(lamaMenginap);
        this.statusReservasi = "Menunggu Konfirmasi";
    }

    // Getter dan Setter
    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getStatusReservasi() {
        return statusReservasi;
    }

    public void setStatusReservasi(String statusReservasi) {
        this.statusReservasi = statusReservasi;
    }

    // Overriding method status reservasi
    @Override
    public void tampilkanStatusReservasi() {
        System.out.println("Status Reservasi: " + statusReservasi);
        System.out.println("Total Harga: Rp " + totalHarga);
    }
}

// Kelas Utama untuk Sistem Manajemen Reservasi Hotel
public class SistemManajemenReservasiHotel {
    private static ArrayList<Tamu> daftarTamu = new ArrayList<>();
    private static ArrayList<Kamar> daftarKamar = new ArrayList<>();
    private static ArrayList<ReservasiKamar> daftarReservasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inisialisasi beberapa kamar contoh
        daftarKamar.add(new KamarStandar("101", 500000, true));
        daftarKamar.add(new KamarStandar("102", 450000, false));
        daftarKamar.add(new KamarSuite("201", 1000000, true));
        daftarKamar.add(new KamarSuite("202", 900000, false));

        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    tambahTamu();
                    break;
                case 2:
                    lihatDaftarTamu();
                    break;
                case 3:
                    buatReservasi();
                    break;
                case 4:
                    lihatDaftarReservasi();
                    break;
                case 5:
                    System.out.println("Terima kasih. Keluar dari sistem.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\n--- Sistem Manajemen Reservasi Hotel ---");
        System.out.println("1. Tambah Tamu Baru");
        System.out.println("2. Lihat Daftar Tamu");
        System.out.println("3. Buat Reservasi");
        System.out.println("4. Lihat Daftar Reservasi");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void tambahTamu() {
        System.out.print("Masukkan Nama Tamu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Nomor Kontak: ");
        String kontak = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan Jenis Identitas: ");
        String jenisIdentitas = scanner.nextLine();

        Tamu tamu = new Tamu(nama, kontak, email, jenisIdentitas);
        daftarTamu.add(tamu);
        System.out.println("Tamu berhasil ditambahkan!");
    }

    private static void lihatDaftarTamu() {
        System.out.println("\n--- Daftar Tamu ---");
        for (Tamu tamu : daftarTamu) {
            tamu.tampilkanInfoPengguna();
            System.out.println("-------------------");
        }
    }

    private static void buatReservasi() {
        // Menampilkan daftar tamu
        System.out.println("\n--- Pilih Tamu ---");
        for (int i = 0; i < daftarTamu.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTamu.get(i).getNama());
        }
        System.out.print("Pilih nomor tamu: ");
        int indeksTamu = scanner.nextInt() - 1;
        scanner.nextLine(); // Membersihkan newline

        // Menampilkan daftar kamar
        System.out.println("\n--- Pilih Kamar ---");
        for (int i = 0; i < daftarKamar.size(); i++) {
            Kamar kamar = daftarKamar.get(i);
            String tipeKamar = kamar instanceof KamarStandar ? "Standar" : "Suite";
            System.out.println((i + 1) + ". Kamar " + tipeKamar + " - " + kamar.getNomorKamar() + 
                               " (Rp " + kamar.getHargaPerMalam() + ")");
        }
        System.out.print("Pilih nomor kamar: ");
        int indeksKamar = scanner.nextInt() - 1;
        scanner.nextLine(); // Membersihkan newline

        System.out.print("Masukkan Lama Menginap (malam): ");
        int lamaMenginap = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        System.out.print("Masukkan Tanggal Reservasi (DD/MM/YYYY): ");
        String tanggalReservasi = scanner.nextLine();

        Tamu tamu = daftarTamu.get(indeksTamu);
        Kamar kamar = daftarKamar.get(indeksKamar);

        ReservasiKamar reservasi = new ReservasiKamar(tamu, kamar, lamaMenginap, tanggalReservasi);
        daftarReservasi.add(reservasi);

        System.out.println("Reservasi berhasil dibuat!");
        reservasi.tampilkanStatusReservasi();
    }

    private static void lihatDaftarReservasi() {
        System.out.println("\n--- Daftar Reservasi ---");
        for (ReservasiKamar reservasi : daftarReservasi) {
            System.out.println("Tamu: " + reservasi.getTamu().getNama());
            System.out.println("Kamar: " + reservasi.getKamar().getNomorKamar());
            reservasi.tampilkanStatusReservasi();
            System.out.println("-------------------");
        }
    }
}