package tugas2pbd;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

class menu{
    String nama;
    double harga;
    String kategori; //makanan atau minuman
    
    menu(String nama, double harga, String kategori){
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
}

public class Tugas2PBD {
    // Format double ke Rupiah
    static String formatRupiah(double angka) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(angka);
    }
    
    //method untuk menampilkan daftar menu
    static void tampilkanMenu(ArrayList<menu> daftarMenu){
        System.out.println("\n========== DAFTAR MENU RESTORAN ==========");
        System.out.println("--- MAKANAN ---");
        int nomor = 1;
        for (menu m : daftarMenu){
            if(m.kategori.equals("Makanan")){
                System.out.println(nomor + "." + m.nama + "- Rp " + formatRupiah(m.harga));
                nomor++;
            }
        }
        
        System.out.println("\n--- MINUMAN ---");
        for (menu m : daftarMenu) {
            if (m.kategori.equals("Minuman")) {
                System.out.println(nomor + ". " + m.nama + " - Rp " + formatRupiah(m.harga));
                nomor++;
            }
        }
        System.out.println("===========================================");
    }
    
    // Method untuk menampilkan semua menu dengan nomor urut (untuk manajemen)
    static void tampilkanSemuaMenu(ArrayList<menu> daftarMenu) {
        System.out.println("\n========== DAFTAR MENU LENGKAP ==========");
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMenu.get(i).nama + 
                             " - " + daftarMenu.get(i).kategori + 
                             " - Rp " + formatRupiah(daftarMenu.get(i).harga));
        }
        System.out.println("===========================================");
    }

    
    // Method untuk menambah menu baru
    static void tambahMenu(ArrayList<menu> daftarMenu, Scanner sc) {
        System.out.println("\n--- TAMBAH MENU BARU ---");
        System.out.print("Masukkan nama menu: ");
        sc.nextLine(); // consume newline
        String nama = sc.nextLine();
        
        System.out.print("Masukkan harga: ");
        double harga = sc.nextDouble();
        
        System.out.print("Masukkan kategori (Makanan/Minuman): ");
        String kategori = sc.next();
        
        // Validasi kategori
        if (!kategori.equalsIgnoreCase("Makanan") && !kategori.equalsIgnoreCase("Minuman")) {
            System.out.println("Kategori tidak valid! Menu gagal ditambahkan.");
            return;
        }
        
        daftarMenu.add(new menu(nama, harga, kategori));
        System.out.println("Menu \"" + nama + "\" berhasil ditambahkan!");
    }
    
    // Method untuk mengubah harga menu
    static void ubahHargaMenu(ArrayList<menu> daftarMenu, Scanner sc) {
        if (daftarMenu.isEmpty()) {
            System.out.println("Tidak ada menu yang tersedia!");
            return;
        }
        
        tampilkanSemuaMenu(daftarMenu);
        System.out.print("Pilih nomor menu yang akan diubah harganya: ");
        int pilihan = sc.nextInt();
        
        if (pilihan < 1 || pilihan > daftarMenu.size()) {
            System.out.println("Nomor menu tidak valid!");
            return;
        }
        
        menu selectedMenu = daftarMenu.get(pilihan - 1);
        System.out.println("Menu: " + selectedMenu.nama);
        System.out.println("Harga lama: Rp " + formatRupiah(selectedMenu.harga));
        System.out.print("Masukkan harga baru: ");
        double hargaBaru = sc.nextDouble();
        
        // Konfirmasi
        System.out.print("Apakah Anda yakin ingin mengubah harga? (Ya/Tidak): ");
        String konfirmasi = sc.next();
        
        if (konfirmasi.equalsIgnoreCase("Ya")) {
            selectedMenu.harga = hargaBaru;
            System.out.println("Harga menu \"" + selectedMenu.nama + "\" berhasil diubah menjadi Rp " + formatRupiah(hargaBaru));
        } else {
            System.out.println("Perubahan harga dibatalkan.");
        }
    }
    
    // Method untuk menghapus menu
    static void hapusMenu(ArrayList<menu> daftarMenu, Scanner sc) {
        if (daftarMenu.isEmpty()) {
            System.out.println("Tidak ada menu yang tersedia!");
            return;
        }
        
        tampilkanSemuaMenu(daftarMenu);
        System.out.print("Pilih nomor menu yang akan dihapus: ");
        int pilihan = sc.nextInt();
        
        if (pilihan < 1 || pilihan > daftarMenu.size()) {
            System.out.println("Nomor menu tidak valid!");
            return;
        }
        
        menu selectedMenu = daftarMenu.get(pilihan - 1);
        System.out.println("Menu yang akan dihapus: " + selectedMenu.nama);
        
        // Konfirmasi
        System.out.print("Apakah Anda yakin ingin menghapus menu ini? (Ya/Tidak): ");
        String konfirmasi = sc.next();
        
        if (konfirmasi.equalsIgnoreCase("Ya")) {
            daftarMenu.remove(pilihan - 1);
            System.out.println("Menu \"" + selectedMenu.nama + "\" berhasil dihapus!");
        } else {
            System.out.println("Penghapusan menu dibatalkan.");
        }
    }
    
    // Method untuk melakukan pemesanan (menggunakan perulangan while)
    static void prosesPemesanan(ArrayList<menu> daftarMenu, Scanner sc) {
        System.out.println("\n========== PEMESANAN ==========");
        
        // ArrayList untuk menyimpan pesanan dinamis
        ArrayList<String> namaPesanan = new ArrayList<>();
        ArrayList<Integer> jumlahItem = new ArrayList<>();
        ArrayList<Double> hargaSatuan = new ArrayList<>();
        ArrayList<String> kategoriPesanan = new ArrayList<>();
        ArrayList<Double> subtotalItem = new ArrayList<>();
        
        String input;
        boolean isValid;
        int pilihanMenu;
        int qty;
        
        System.out.println("Masukkan pesanan Anda (ketik 'selesai' untuk mengakhiri):");
        System.out.println("Gunakan format: nomor menu = jumlah");
        System.out.println("Contoh: 1 = 2 (berarti memesan menu nomor 1 sebanyak 2 porsi)");
        System.out.println();
        
        // Looping input pesanan hingga user mengetik "selesai"
        while (true) {
            System.out.print("Pesanan: ");
            input = sc.next();
            
            if (input.equalsIgnoreCase("selesai")) {
                if (namaPesanan.isEmpty()) {
                    System.out.println("Anda belum memesan apapun! Silakan pesan minimal 1 menu.");
                    continue;
                }
                break;
            }
            
            // Validasi input angka
            try {
                pilihanMenu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Silakan masukkan nomor menu atau ketik 'selesai'.");
                continue;
            }
            
            // Cek apakah input adalah "="
            String samaDengan = sc.next();
            if (!samaDengan.equals("=")) {
                System.out.println("Format salah! Gunakan format: nomor = jumlah");
                continue;
            }
            
            // Baca jumlah
            try {
                qty = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Jumlah tidak valid!");
                sc.nextLine(); // clear buffer
                continue;
            }
            
            // Validasi pilihan menu (1 sampai jumlah menu)
            if (pilihanMenu < 1 || pilihanMenu > daftarMenu.size()) {
                System.out.println("Nomor menu tidak valid! Silakan pilih nomor yang tersedia.");
                continue;
            }
            
            menu selectedMenu = daftarMenu.get(pilihanMenu - 1);
            
            // Menambahkan pesanan ke ArrayList
            namaPesanan.add(selectedMenu.nama);
            jumlahItem.add(qty);
            hargaSatuan.add(selectedMenu.harga);
            kategoriPesanan.add(selectedMenu.kategori);
            subtotalItem.add(selectedMenu.harga * qty);
            
            System.out.println("✓ " + selectedMenu.nama + " x " + qty + " ditambahkan ke keranjang!");
        }
        
        // Hitung total awal (menggunakan perulangan for)
        double totalAwal = 0;
        for (double sub : subtotalItem) {
            totalAwal += sub;
        }
        
        // Penawaran beli 1 gratis 1 (Minuman termurah jika total > 50000)
        double potonganGratis = 0;
        boolean dapatPromo = false;
        String minumanGratis = "";
        double hargaMinumanGratis = 0;
        
        if (totalAwal > 50000) {
            double minHarga = Double.MAX_VALUE;
            int idxMinuman = -1;
            
            // Cari minuman termurah (menggunakan perulangan for)
            for (int i = 0; i < kategoriPesanan.size(); i++) {
                if (kategoriPesanan.get(i).equals("Minuman")) {
                    if (hargaSatuan.get(i) < minHarga) {
                        minHarga = hargaSatuan.get(i);
                        idxMinuman = i;
                    }
                }
            }
            
            if (idxMinuman != -1) {
                dapatPromo = true;
                potonganGratis = hargaSatuan.get(idxMinuman);
                minumanGratis = namaPesanan.get(idxMinuman);
                hargaMinumanGratis = hargaSatuan.get(idxMinuman);
            }
        }
        
        double totalSetelahPromo = totalAwal - potonganGratis;
        
        // Diskon 10% jika > 100000
        double diskon = 0;
        boolean dapatDiskon = false;
        if (totalSetelahPromo > 100000) {
            diskon = 0.1 * totalSetelahPromo;
            dapatDiskon = true;
        }
        double totalSetelahDiskon = totalSetelahPromo - diskon;
        
        // Pajak 10% dari total setelah diskon
        double pajak = 0.1 * totalSetelahDiskon;
        double biayaPelayanan = 20000;
        double totalBayar = totalSetelahDiskon + pajak + biayaPelayanan;
        
        // Cetak struk
        System.out.println("\n\n========== STRUK PEMBAYARAN ==========");
        System.out.println("Item yang dipesan:");
        System.out.printf("%-25s %5s %15s %15s\n", "Nama Menu", "Qty", "@Harga", "Subtotal");
        System.out.println("------------------------------------------------------------");
        
        for (int i = 0; i < namaPesanan.size(); i++) {
            System.out.printf("%-25s %5d %15s %15s\n",
                namaPesanan.get(i), jumlahItem.get(i),
                formatRupiah(hargaSatuan.get(i)), formatRupiah(subtotalItem.get(i)));
        }
        
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %25s %15s\n", "Subtotal", "", formatRupiah(totalAwal));
        System.out.println("------------------------------------------------------------");
        
        // Informasi penawaran
        if (dapatPromo) {
            System.out.println("\nPenawaran Beli 1 Gratis 1 (Minuman):");
            System.out.printf("  - Gratis %s (Rp %s)\n", minumanGratis, formatRupiah(hargaMinumanGratis));
            System.out.printf("%-25s %25s %15s\n", "Potongan promo", "", formatRupiah(potonganGratis));
        } else if (totalAwal > 50000) {
            System.out.println("\nPenawaran Beli 1 Gratis 1: Tidak ada minuman yang dipesan.");
        } else {
            System.out.println("\nPenawaran Beli 1 Gratis 1: Total pesanan kurang dari Rp 50.000");
        }
        
        System.out.printf("%-25s %25s %15s\n", "Total setelah promo", "", formatRupiah(totalSetelahPromo));
        
        if (dapatDiskon) {
            System.out.printf("%-25s %25s %15s\n", "Diskon 10% (> Rp100.000)", "", formatRupiah(diskon));
        } else {
            System.out.println("Diskon 10%: Tidak memenuhi (total setelah promo <= Rp 100.000)");
        }
        
        System.out.printf("%-25s %25s %15s\n", "Total setelah diskon", "", formatRupiah(totalSetelahDiskon));
        System.out.printf("%-25s %25s %15s\n", "Pajak 10%", "", formatRupiah(pajak));
        System.out.printf("%-25s %25s %15s\n", "Biaya Pelayanan", "", formatRupiah(biayaPelayanan));
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %25s %15s\n", "TOTAL BAYAR", "", formatRupiah(totalBayar));
        System.out.println("============================================================");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Inisialisasi ArrayList menu (dinamis)
        ArrayList<menu> daftarMenu = new ArrayList<>();
        
        // Menu awal (4 makanan, 4 minuman)
        daftarMenu.add(new menu("Nasi Ayam Bakar", 25000, "Makanan"));
        daftarMenu.add(new menu("Rendang", 30000, "Makanan"));
        daftarMenu.add(new menu("Sate Ayam", 25000, "Makanan"));
        daftarMenu.add(new menu("Mie Ayam", 20000, "Makanan"));
        daftarMenu.add(new menu("Es Teh", 5000, "Minuman"));
        daftarMenu.add(new menu("Jus Jeruk", 10000, "Minuman"));
        daftarMenu.add(new menu("Es Teler", 15000, "Minuman"));
        daftarMenu.add(new menu("Es Kopi", 20000, "Minuman"));
        
        int pilihanUtama;
        
        // Menu utama dengan perulangan do-while
        do {
            System.out.println("\n=========================================");
            System.out.println("       APLIKASI RESTORAN SEDERHANA");
            System.out.println("=========================================");
            System.out.println("1. Pemesanan (Pelanggan)");
            System.out.println("2. Manajemen Menu (Pemilik Restoran)");
            System.out.println("3. Keluar");
            System.out.println("=========================================");
            System.out.print("Pilih menu (1-3): ");
            
            pilihanUtama = sc.nextInt();
            
            switch (pilihanUtama) {
                case 1:
                    // Tampilkan menu terlebih dahulu sebelum pemesanan
                    tampilkanMenu(daftarMenu);
                    prosesPemesanan(daftarMenu, sc);
                    break;
                    
                case 2:
                    // Submenu manajemen menu (dengan perulangan do-while)
                    int pilihanManajemen;
                    do {
                        System.out.println("\n========== MANAJEMEN MENU ==========");
                        System.out.println("1. Tambah Menu Baru");
                        System.out.println("2. Ubah Harga Menu");
                        System.out.println("3. Hapus Menu");
                        System.out.println("4. Kembali ke Menu Utama");
                        System.out.println("=====================================");
                        System.out.print("Pilih menu (1-4): ");
                        
                        pilihanManajemen = sc.nextInt();
                        
                        switch (pilihanManajemen) {
                            case 1:
                                tambahMenu(daftarMenu, sc);
                                break;
                            case 2:
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Belum ada menu! Silakan tambahkan menu terlebih dahulu.");
                                } else {
                                    ubahHargaMenu(daftarMenu, sc);
                                }
                                break;
                            case 3:
                                if (daftarMenu.isEmpty()) {
                                    System.out.println("Belum ada menu! Silakan tambahkan menu terlebih dahulu.");
                                } else {
                                    hapusMenu(daftarMenu, sc);
                                }
                                break;
                            case 4:
                                System.out.println("Kembali ke menu utama...");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
                        }
                    } while (pilihanManajemen != 4);
                    break;
                    
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi restoran!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-3.");
            }
        } while (pilihanUtama != 3);
        
        sc.close();
    }   
}