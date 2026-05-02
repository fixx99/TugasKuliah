package tugas1pbd;
import java.util.Scanner;
import java.text.DecimalFormat;

//kelas menu untuk mempresentasikan item menu
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

public class Tugas1PBD {
   // Format double ke Rupiah
    static String formatRupiah(double angka) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(angka);
    }
    
   //method untuk memilih menu berdasarkan nomor pilihan
    static menu pilihMenu(int nomor, menu[] daftarMenu){
        switch(nomor){
            case 1: return daftarMenu[0];
            case 2: return daftarMenu[1];
            case 3: return daftarMenu[2];
            case 4: return daftarMenu[3];
            case 5: return daftarMenu[4];
            case 6: return daftarMenu[5];
            case 7: return daftarMenu[6];
            case 8: return daftarMenu[7];
            default: return null;
        }
    }
    
   //method untuk menampilkan daftar menu
    static void tampilkanMenu(menu[]daftarMenu){
        System.out.println("==== DAFTAR MENU RESTORAN ====");
        System.out.println("--- MAKANAN ---");
        System.out.println("1. " + daftarMenu[0].nama + " - Rp " + formatRupiah(daftarMenu[0].harga));
        System.out.println("2. " + daftarMenu[1].nama + " - Rp " + formatRupiah(daftarMenu[1].harga));
        System.out.println("3. " + daftarMenu[2].nama + " - Rp " + formatRupiah(daftarMenu[2].harga));
        System.out.println("4. " + daftarMenu[3].nama + " - Rp " + formatRupiah(daftarMenu[3].harga));
        
        System.out.println("\n--- MINUMAN ---");
        System.out.println("5. " + daftarMenu[4].nama + " - Rp " + formatRupiah(daftarMenu[4].harga));
        System.out.println("6. " + daftarMenu[5].nama + " - Rp " + formatRupiah(daftarMenu[5].harga));
        System.out.println("7. " + daftarMenu[6].nama + " - Rp " + formatRupiah(daftarMenu[6].harga));
        System.out.println("8. " + daftarMenu[7].nama + " - Rp " + formatRupiah(daftarMenu[7].harga));
        System.out.println("==========================================");
    }
    
    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        
       //inisiasasi array menu
       menu[] daftarMenu = {
           new menu("Nasi Ayam Bakar", 25000, "Makanan"),
           new menu("Rendang", 30000, "Makanan"),
           new menu("Sate Ayam", 25000, "Makanan"),
           new menu("Mie Ayam", 20000, "Makanan"),
           new menu("Es Teh", 5000, "Minuman"),
           new menu("Jus Jeruk", 10000, "Minuman"),
           new menu("Es Teler", 15000, "Minuman"),
           new menu("Es Kopi", 20000, "Minuman")
       };
       
       tampilkanMenu(daftarMenu);
       
       //memasukan jumlah yang dipesan
        System.out.print("Berapa banyak menu yang ingin dipesan? ");
        int jumlahPesanan = masuk.nextInt();
        
       //validasi jumlah pesanan
       if(jumlahPesanan < 1){
           System.out.println("Jumlah Pesanan Harus Minimal 1");
           masuk.close();
       }
       
      //array untuk menyimpan data pesanan
        String[] namaPesanan = new String[4];
        int[] jumlahItem = new int[4];
        double[] hargaSatuan = new double[4];
        String[] kategoriPesanan = new String[4];
        double[] subtotalItem = new double[4];
        
       // Proses input setiap pesanan tanpa perulangan
       // Pesanan ke-1
        System.out.print("\nPesanan ke-1 (nomor menu 1-8): ");
        int nomorMenu = masuk.nextInt();
        System.out.print("Jumlah: ");
        int qty = masuk.nextInt();
        menu menu = pilihMenu(nomorMenu, daftarMenu);
        if (menu == null) {
            System.out.println("Nomor menu tidak valid! Pesanan dibatalkan.");
            masuk.close();
            return;
        }
        namaPesanan[0] = menu.nama;
        jumlahItem[0] = qty;
        hargaSatuan[0] = menu.harga;
        kategoriPesanan[0] = menu.kategori;
        subtotalItem[0] = menu.harga * qty;

       // Pesanan ke-2
        if (jumlahPesanan >= 2) {
            System.out.print("\nPesanan ke-2 (nomor menu 1-8): ");
            nomorMenu = masuk.nextInt();
            System.out.print("Jumlah: ");
            qty = masuk.nextInt();
            menu = pilihMenu(nomorMenu, daftarMenu);
            if (menu == null) {
                System.out.println("Nomor menu tidak valid! Pesanan dibatalkan.");
                masuk.close();
                return;
            }
            namaPesanan[1] = menu.nama;
            jumlahItem[1] = qty;
            hargaSatuan[1] = menu.harga;
            kategoriPesanan[1] = menu.kategori;
            subtotalItem[1] = menu.harga * qty;
        }

       // Pesanan ke-3 
        if (jumlahPesanan >= 3) {
            System.out.print("\nPesanan ke-3 (nomor menu 1-8): ");
            nomorMenu = masuk.nextInt();
            System.out.print("Jumlah: ");
            qty = masuk.nextInt();
            menu = pilihMenu(nomorMenu, daftarMenu);
            if (menu == null) {
                System.out.println("Nomor menu tidak valid! Pesanan dibatalkan.");
                masuk.close();
                return;
            }
            namaPesanan[2] = menu.nama;
            jumlahItem[2] = qty;
            hargaSatuan[2] = menu.harga;
            kategoriPesanan[2] = menu.kategori;
            subtotalItem[2] = menu.harga * qty;
        }

       // Pesanan ke-4
        if (jumlahPesanan >= 4) {
            System.out.print("\nPesanan ke-4 (nomor menu 1-8): ");
            nomorMenu = masuk.nextInt();
            System.out.print("Jumlah: ");
            qty = masuk.nextInt();
            menu = pilihMenu(nomorMenu, daftarMenu);
            if (menu == null) {
                System.out.println("Nomor menu tidak valid! Pesanan dibatalkan.");
                masuk.close();
                return;
            }
            namaPesanan[3] = menu.nama;
            jumlahItem[3] = qty;
            hargaSatuan[3] = menu.harga;
            kategoriPesanan[3] = menu.kategori;
            subtotalItem[3] = menu.harga * qty;
        }
        
       // hitung total awal
        double totalAwal = 0;
        if (jumlahPesanan >= 1) totalAwal += subtotalItem[0];
        if (jumlahPesanan >= 2) totalAwal += subtotalItem[1];
        if (jumlahPesanan >= 3) totalAwal += subtotalItem[2];
        if (jumlahPesanan >= 4) totalAwal += subtotalItem[3];

       // penawaran beli 1 gratis 1
        double potonganGratis = 0;
        boolean dapatPromo = false;
        String minumanGratis = "";
        double hargaMinumanGratis = 0;
        
       // Cek apakah totalAwal > 50000
        if (totalAwal > 50000) {
            // Cari minuman termurah di antara pesanan
            double minHarga = Double.MAX_VALUE;
            int idxMinuman = -1;
            // Cek pesanan ke-1
            if (jumlahPesanan >= 1 && kategoriPesanan[0].equals("Minuman")) {
                minHarga = hargaSatuan[0];
                idxMinuman = 0;
            }
            // Cek pesanan ke-2
            if (jumlahPesanan >= 2 && kategoriPesanan[1].equals("Minuman")) {
                if (hargaSatuan[1] < minHarga) {
                    minHarga = hargaSatuan[1];
                    idxMinuman = 1;
                }
            }
            // Cek pesanan ke-3
            if (jumlahPesanan >= 3 && kategoriPesanan[2].equals("Minuman")) {
                if (hargaSatuan[2] < minHarga) {
                    minHarga = hargaSatuan[2];
                    idxMinuman = 2;
                }
            }
            // Cek pesanan ke-4
            if (jumlahPesanan >= 4 && kategoriPesanan[3].equals("Minuman")) {
                if (hargaSatuan[3] < minHarga) {
                    minHarga = hargaSatuan[3];
                    idxMinuman = 3;
                }
            }
            if (idxMinuman != -1) {
                dapatPromo = true;
                potonganGratis = hargaSatuan[idxMinuman];
                minumanGratis = namaPesanan[idxMinuman];
                hargaMinumanGratis = hargaSatuan[idxMinuman];
            }
        }

        double totalSetelahPromo = totalAwal - potonganGratis;
        
       // diskon 10% jika > 100000
        double diskon = 0;
        boolean dapatDiskon = false;
        if (totalSetelahPromo > 100000) {
            diskon = 0.1 * totalSetelahPromo;
            dapatDiskon = true;
        }
        double totalSetelahDiskon = totalSetelahPromo - diskon;

       // pajak 10% dari total harga
        double pajak = 0.1 * totalSetelahDiskon;
        double biayaPelayanan = 20000;
        double totalBayar = totalSetelahDiskon + pajak + biayaPelayanan;

       // Cetak struk
        System.out.println("\n\n========== STRUK PEMBAYARAN ==========");
        System.out.println("Item yang dipesan:");
        // Header tabel
        System.out.printf("%-25s %5s %15s Rp%10s\n", "Nama Menu", "Qty", "@Harga", "Subtotal");
        System.out.println("------------------------------------------------------------");
        
        if (jumlahPesanan >= 1) {
            System.out.printf("%-25s %5d %15s Rp%10s\n", 
                namaPesanan[0], jumlahItem[0], 
                formatRupiah(hargaSatuan[0]), formatRupiah(subtotalItem[0]));
        }
        if (jumlahPesanan >= 2) {
            System.out.printf("%-25s %5d %15s RP%10s\n", 
                namaPesanan[1], jumlahItem[1], 
                formatRupiah(hargaSatuan[1]), formatRupiah(subtotalItem[1]));
        }
        if (jumlahPesanan >= 3) {
            System.out.printf("%-25s %5d %15s Rp%10s\n", 
                namaPesanan[2], jumlahItem[2], 
                formatRupiah(hargaSatuan[2]), formatRupiah(subtotalItem[2]));
        }
        if (jumlahPesanan >= 4) {
            System.out.printf("%-25s %5d %15s Rp%10s\n", 
                namaPesanan[3], jumlahItem[3], 
                formatRupiah(hargaSatuan[3]), formatRupiah(subtotalItem[3]));
        }
        
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %25s RP%15s\n", "Subtotal", "", formatRupiah(totalAwal));
        System.out.println("------------------------------------------------------------");
        
        // Informasi penawaran
        if (dapatPromo) {
            System.out.println("\nPenawaran Beli 1 Gratis 1 (Minuman):");
            System.out.printf("  - Gratis %s (Rp %s)\n", minumanGratis, formatRupiah(hargaMinumanGratis));
            System.out.printf("%-25s %25s Rp%10s\n", "Potongan promo", "", formatRupiah(potonganGratis));
        } else if (totalAwal > 50000) {
            System.out.println("\nPenawaran Beli 1 Gratis 1: Tidak ada minuman yang dipesan.");
        } else {
            System.out.println("\nPenawaran Beli 1 Gratis 1: Total pesanan kurang dari Rp 50.000");
        }
        
        System.out.printf("%-25s %25s %10s\n", "Total setelah promo", "", formatRupiah(totalSetelahPromo));
        
        if (dapatDiskon) {
            System.out.printf("%-25s %25s Rp%10s\n", "Diskon 10% (> Rp100.000)", "", formatRupiah(diskon));
        } else {
            System.out.println("Diskon 10%: Tidak memenuhi (total setelah promo <= Rp 100.000)");
        }
        
        System.out.printf("%-25s %25s RP%10s\n", "Total setelah diskon", "", formatRupiah(totalSetelahDiskon));
        System.out.printf("%-25s %25s Rp%10s\n", "Pajak 10%", "", formatRupiah(pajak));
        System.out.printf("%-25s %25s Rp%10s\n", "Biaya Pelayanan", "", formatRupiah(biayaPelayanan));
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %25s Rp%10s\n", "TOTAL BAYAR", "", formatRupiah(totalBayar));
        System.out.println("============================================================");
        masuk.close();

    }

}
