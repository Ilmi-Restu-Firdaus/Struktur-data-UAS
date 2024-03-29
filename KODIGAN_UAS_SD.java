package SD;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class SD2 {
        record Barang(String Jenis, String Nama, int Jumlah, int Harga, int Total) {}

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        boolean toko = true;
        ArrayList<String> riwayatBarang = new ArrayList<>();
        LinkedList<Barang> tambahbarang = new LinkedList<>();
        int jumlahKeluar, barang, hargabarang;
        
        Queue<Barang> preorder = new LinkedList<>();
        
        
        while (toko) {
            System.out.println("\033[32m┌───────────────────────────────────────┐\033[0m");
            System.out.println("            TOKO GLOSIR ");
            System.out.println("\033[32m└───────────────────────────────────────┘\033[0m");
            System.out.println("1. Beli/tambah stok barang");
            System.out.println("2. Tampilkan stok barang");
            System.out.println("3. Jual/Keluarkan barang");
            System.out.println("4. Riwayat barang");
            System.out.println("5. PreOrder");
            System.out.println("6. Konfirmasi");

            System.out.print("\nPilih operasi yang ingin dilakukan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan \n

            switch (pilihan) {

                case 1:
    System.out.print("Masukan Jumlah barang yang akan di input : ");
    int jumlahinput = scanner.nextInt();
    for (int i = 0; i < jumlahinput; i++) {
        System.out.println("\nBarang ke-" + (i + 1));

        System.out.print("Jenis barang (Makanan/Minuman)    : ");
        String jenisbarang = scanner.next();

        if (jenisbarang.equalsIgnoreCase("makanan") || jenisbarang.equalsIgnoreCase("minuman")) {
            System.out.print("Nama Barang                       : ");
            String namabarang = scanner.next();

            System.out.print("Jumlah Barang                     : ");
            int jumlahbarang = scanner.nextInt();

            System.out.print("Harga Barang                      : ");
            hargabarang = scanner.nextInt();

            int total = jumlahbarang * hargabarang;

            System.out.println("Total Belanja                     : " + total);
            String riwayatMasuk = "[+] " + "jenis :" + jenisbarang + ",Nama :" + namabarang
                    + ", Jumlah :" + jumlahbarang + ", Harga :" + hargabarang
                    + ", total Pembelian: " + total + " ditambahkan ke gudang.";
            riwayatBarang.add(riwayatMasuk);
            tambahbarang.add(new Barang(jenisbarang, namabarang, jumlahbarang, hargabarang, total));
            System.out.println(riwayatMasuk + " Barang berhasil di tambahkan");
        } else {
            System.out.println("Hanya masukkan makanan atau minuman");
        }

    }
    break;

                case 2:
            boolean isRunning = true;
                    while (isRunning) {
                        if (!tambahbarang.isEmpty()) {
                            System.out.println("Stok Barang");
                            for (Barang item : tambahbarang) {
                                
                                    System.out.println("Jenis: " + item.Jenis() + ", Nama: " + item.Nama()
                                            + ", Jumlah: " + item.Jumlah() + ", harga: " + item.Harga()
                                            + ", Total pembelian: " + item.Total());
                                
                            }
                        } else {
                            System.out.println("belum ada barang masuk");
                        }
                        System.out.println("1.Cari barang ");
                        System.out.println("2.Urutkan barang (berdasar makanan/minuman) ");
                        System.out.println("3.keluar");
                        System.out.print("pilihan: ");
                        barang = scanner.nextInt();

                        if (barang == 1) {
                            System.out.print("Masukan jenis: ");
                            String jen = scanner.next();
                            System.out.print("Masukan nama: ");
                            String nam = scanner.next();

                            boolean found = false;
                            for (Barang item : tambahbarang) {
                                if (item.Nama().equalsIgnoreCase(nam) && item.Jenis().equalsIgnoreCase(jen)) {
                                    found = true;
                                    System.out.println("Jenis: " + item.Jenis() + ", Nama: " + item.Nama()
                                            + ", Jumlah: " + item.Jumlah() + ", harga beli: " + item.Harga()
                                            + ", Total Harga: " + item.Total());
                                }
                            }
                            if (!found) {
                                System.out.println("Barang tidak di temukan");
                            }
                            break;
                        }

                        else if (barang == 2) {
                            tambahbarang.sort((item1, item2) -> item1.Jenis().compareTo(item2.Jenis()));
                            System.out.println("Stok Barang setelah diurutkan berdasar makanan/minuman:");
                            for (Barang item : tambahbarang) {
                                System.out.println("Jenis: " + item.Jenis() + ", Nama: " + item.Nama()
                                        + ", Jumlah: " + item.Jumlah() + ", harga: " + item.Harga()
                                        + ", Total Harga: " + item.Total());
                            }
                        }

                        else if (barang == 3) {
                            break;
                        }
                    }
                    break;

case 3:
    // Your code for selling/issuing stock
    System.out.print("Masukkan jenis barang yang akan dikeluarkan (Makanan/Minuman): ");
    String jenisKeluar = scanner.next();
    System.out.print("Masukkan nama barang yang akan dikeluarkan: ");
    String namaKeluar = scanner.next();
    System.out.print("Masukkan jumlah barang yang akan dikeluarkan: ");
    jumlahKeluar = scanner.nextInt();
    System.out.print("masukan harga jual satuan: ");
    int hargajual = scanner.nextInt();
    int totaljual = jumlahKeluar * hargajual;

    boolean barangDitemukan = false;

    for (Barang item : tambahbarang) {
        if (item.Jenis().equalsIgnoreCase(jenisKeluar) && item.Nama().equalsIgnoreCase(namaKeluar)) {
            if (jumlahKeluar <= item.Jumlah()) {
                // Remove item from tambahbarang
                tambahbarang.remove(item);

                // Update the stock
                Barang barangBaru = new Barang(item.Jenis(), item.Nama(), item.Jumlah() - jumlahKeluar, item.Harga(), item.Total());

                System.out.println(jumlahKeluar + " " + item.Nama() + " berhasil dikeluarkan.");
                String riwayatKeluar = "[-] " + "Jenis : " + jenisKeluar + ", Nama: " + namaKeluar
                        + ", harga satuan: " + hargajual + ", Jumlah: " + jumlahKeluar
                        + ", total penjualan: " + totaljual;
                riwayatBarang.add(riwayatKeluar);
                System.out.println(riwayatKeluar);
                if (item.Jumlah() - jumlahKeluar == 0) {
                    System.out.println("Barang " + item.Nama() + " telah habis.");
                }
                barangDitemukan = true;

                // Add the updated item back to tambahbarang
                tambahbarang.add(barangBaru);
                break;
            } else {
                System.out.println("Jumlah barang yang diminta melebihi stok yang ada.");
                barangDitemukan = true;
                break;
            }
        }
    }
    if (!barangDitemukan) {
        System.out.println("Barang tidak ditemukan.");
    }
    break;

case 4:
    if (riwayatBarang.isEmpty()) {
        System.out.println("Riwayat barang kosong.");
    } else {
        System.out.println("Riwayat Barang:");
        for (String riwayat : riwayatBarang) {
            System.out.println(riwayat);
        }
    }
    break;

case 5:
                    System.out.println("PreOrder");
                    System.out.print("Masukkan Jumlah barang yang akan di PreOrder : ");
                    int jumlahPreOrder = scanner.nextInt();
                    for (int i = 0; i < jumlahPreOrder; i++) {
                        System.out.println("\nPreOrder ke-" + (i + 1));

                        System.out.print("Jenis barang (Makanan/Minuman)    : ");
                        String jenisPreOrder = scanner.next();

                        if (jenisPreOrder.equalsIgnoreCase("makanan") || jenisPreOrder.equalsIgnoreCase("minuman")) {
                            System.out.print("Nama Barang                       : ");
                            String namaPreOrder = scanner.next();

                            System.out.print("Jumlah Barang                     : ");
                            int jumlahbarang = scanner.nextInt();

                            for (Barang item : tambahbarang) {
                                if (item.Nama.equalsIgnoreCase(namaPreOrder) && item.Jenis.equalsIgnoreCase(jenisPreOrder)) {
                                    System.out.print("Harga Barang                      : ");
                                    hargabarang = scanner.nextInt();
                                    int total = jumlahbarang * hargabarang;

                                    System.out.println("Total Belanja                     : " + total);
                                    String riwayatMasuk = "[+] " + "jenis :" + jenisPreOrder + ",Nama :" + namaPreOrder
                                            + ", Jumlah :" + jumlahbarang + ", Harga :" + hargabarang
                                            + ", total Pembelian: " + total + " PreOrder.";
                                    riwayatBarang.add(riwayatMasuk);
                                    System.out.println(riwayatMasuk + " Barang berhasil di tambahkan");

                                    preorder.add(new Barang(jenisPreOrder, namaPreOrder, jumlahbarang, hargabarang, total));
                                    tambahbarang.add(new Barang(jenisPreOrder, namaPreOrder, jumlahbarang, hargabarang, total));
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Hanya masukkan makanan atau minuman");
                        }
                    }
                    break;
case 6:
    // Proceed to PreOrder confirmation
    System.out.println("\nMelakukan konfirmasi PreOrder...");
    while (!preorder.isEmpty()) {
        Barang preOrderItem = preorder.peek();
        System.out.println("Jenis: " + preOrderItem.Jenis + ", Nama: " + preOrderItem.Nama
                + ", Jumlah: " + preOrderItem.Jumlah + ", Harga: " + preOrderItem.Harga
                + ", Total pembelian: " + preOrderItem.Total);

        System.out.print("Konfirmasi PreOrder (y/n): ");
        String konfirmasi = scanner.next();
        if (konfirmasi.equalsIgnoreCase("y")) {
            // Update stock quantity in tambahbarang list
            for (Barang stockItem : tambahbarang) {
                if (stockItem.Nama.equalsIgnoreCase(preOrderItem.Nama) && stockItem.Jenis.equalsIgnoreCase(preOrderItem.Jenis)) {
                    int updatedStock = stockItem.Jumlah + preOrderItem.Jumlah;
                    stockItem = new Barang(stockItem.Jenis, stockItem.Nama, updatedStock, stockItem.Harga, stockItem.Total);
                    System.out.println("PreOrder confirmed. Stock updated.");
                    break;
                }
            }
            preorder.remove();
        } else {
            System.out.println("PreOrder dibatalkan.");
            preorder.remove();
        }
    }

    // Display updated stock after confirming PreOrders
    for (Barang item : tambahbarang) {
        tambahbarang.remove();
    }
    break;
    
            }
            System.out.print("Kembali ke Menu Utama? (y/n): ");
            String jawaban = scanner.next().toLowerCase();
            toko = jawaban.equals("y");
        }
        scanner.close();
    }
}
