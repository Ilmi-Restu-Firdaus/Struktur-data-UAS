package SD;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SD {

    public static void main(String[] args) {
       
    
        Scanner scanner = new Scanner(System.in);
         
        record tambah( String Jenis,String Nama,int Jumlah,int Harga,int total){}
        boolean toko = true;
        ArrayList<String> riwayatBarang = new ArrayList<>();
        LinkedList<tambah> tambahbarang = new LinkedList<>();
        int jumlahKeluar,barang;
        
        
          while (toko) {
            System.out.println("\033[32m┌───────────────────────────────────────┐\033[0m");  
            System.out.println("            TOKO GLOSIR ");
            System.out.println("\033[32m└───────────────────────────────────────┘\033[0m");                                   
            System.out.println("1. Beli/tambah stok barang");
            System.out.println("2. Tampilkan stok barang");
            System.out.println("3. Jual/Keluarkan barang");
            System.out.println("4. Riwayat barang");
            System.out.println("5.keluar");
            System.out.print("\nPilih operasi yang ingin dilakukan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan \n

            switch (pilihan) {
                
            case 1:
                
            System.out.print("Masukan Jumlah barang yang akan di input : ");
            int jumlahinput = scanner.nextInt();
                 for (int i = 0; i < jumlahinput; i++) {
            System.out.println("\nBarang ke-"+(i+1));
            
           System.out.print("Jenis barang (Makanan/Minuman)    : ");
        String jenisbarang = scanner.next();

        if (jenisbarang.equalsIgnoreCase("makanan") || jenisbarang.equalsIgnoreCase("minuman")) {
            System.out.print("Nama Barang                       : ");
            String namabarang = scanner.next();
            
            System.out.print("Jumlah Barang                     : ");
            int jumlahbarang = scanner.nextInt();
            
            System.out.print("Harga Barang                      : ");
            int hargabarang = scanner.nextInt();
            
            int total = jumlahbarang * hargabarang;
            
            System.out.println("Total Belanja                     : " + total);
             String riwayatMasuk = "[+] " +"jenis :" + jenisbarang + ",Nama :" + namabarang + ", Jumlah :" + jumlahbarang+", Harga :"+ hargabarang+", total Pembelian: "+ total+ " ditambahkan ke gudang.";
            riwayatBarang.add(riwayatMasuk);
             tambahbarang.add(new tambah(jenisbarang,namabarang,jumlahbarang,hargabarang,total));              
            System.out.println(riwayatMasuk + " Barang berhasil di tambahkan");       
        } else {
            System.out.println("Hanya masukkan makanan atau minuman");
        }            
            
           
            
           
                 }break;
                 
            case 2:
                
           if(!tambahbarang.isEmpty()){
              System.out.println("Stok Barang");
                     for (tambah item : tambahbarang) {
            if (item.Jumlah() > 0) {
                System.out.println("Jenis: " + item.Jenis() + ", Nama: " + item.Nama() + ", Jumlah: " + item.Jumlah() + ", harga: " + item.Harga() + ", Total Penjualan: " + item.total());
                }
            }
                }else {
                    System.out.println("belum ada barang masuk");
            }
                    System.out.println("1.Cari barang ");
                    System.out.println("2.Urutkan barang (berdasar makanan/minuman)");
                    System.out.println("3.keluar");
                    System.out.print("pilihan: ");
                    barang = scanner.nextInt();
                    
                    if (barang ==1){
                    System.out.print("Masukan jenis: ");
                    String jen = scanner.next();
                    System.out.print("Masukan nama: ");
                    String nam = scanner.next();    
                    
                    boolean found = false;
             for (tambah item : tambahbarang) {
                 if (item.Nama().equalsIgnoreCase(nam)&& item.Jenis().equalsIgnoreCase(jen)) {
                     found = true;
                 System.out.println("Jenis: " + item.Jenis()  + ", Nama: " + item.Nama() + ", Jumlah: " + item.Jumlah() + ", harga: " + item.Harga()  +", Total Harga: "+ item.total());
                    }
                 }
                  if (!found) {
                 System.out.println("Barang tidak di temukan");
                 }break;
                 }
                    
                else if (barang == 2) {  
                tambahbarang.sort((item1, item2) -> item1.Jenis().compareTo(item2.Jenis()));
                System.out.println("Stok Barang setelah diurutkan berdasar makanan/minuman:");
            for (tambah item : tambahbarang) {
                System.out.println("Jenis: " + item.Jenis() + ", Nama: " + item.Nama() + ", Jumlah: " + item.Jumlah() + ", harga: " + item.Harga() + ", Total Harga: " + item.total());
                            }
                        }
                else if (barang ==3 ) {
             }break;       
                    
            case 3:
                
            System.out.print("Masukkan jenis barang yang akan dikeluarkan (Makanan/Minuman): ");
            String jenisKeluar = scanner.next();
            if (jenisKeluar.equalsIgnoreCase("makanan") || jenisKeluar.equalsIgnoreCase("minuman")) {
            System.out.print("Masukkan nama barang yang akan dikeluarkan                   : ");
            String namaKeluar = scanner.next();
            System.out.print("Masukkan jumlah barang yang akan dikeluarkan                 : ");
            jumlahKeluar = scanner.nextInt();
            System.out.print("masukan harga jual satuan                                    : ");
            int hargajual = scanner.nextInt();
            boolean barangDitemukan = false;

        for (tambah item : tambahbarang) {
        if (item.Jenis.equalsIgnoreCase(jenisKeluar) && item.Nama.equalsIgnoreCase(namaKeluar)) {
            
            int totaljual = jumlahKeluar * hargajual;

            if (jumlahKeluar <= item.Jumlah) {
                tambahbarang.remove(item); // Hapus record lama
                tambahbarang.add(new tambah(item.Jenis, item.Nama, item.Jumlah - jumlahKeluar, item.Harga, item.total));

                System.out.println(jumlahKeluar + " " + item.Nama + " berhasil dikeluarkan.");
                String riwayatKeluar = "[-] Jenis: " + jenisKeluar + ", Nama: " + namaKeluar +
                        ", harga satuan: " + hargajual + ", Jumlah: " + jumlahKeluar +
                        ", total penjualan: " + totaljual;
                riwayatBarang.add(riwayatKeluar);
                System.out.println(riwayatKeluar);

                if (item.Jumlah - jumlahKeluar == 0) {
                    System.out.println("Barang " + item.Nama + " telah habis.");
                    // Hapus item jika jumlahnya 0
                    tambahbarang.remove(item);
                }
                
            } else {
                System.out.println("Jumlah barang yang diminta melebihi stok yang ada.");
            } 
        
            barangDitemukan = true;
        }
       }

    if (!barangDitemukan) {
        System.out.println("Barang tidak ditemukan.");
    }} else {
            System.out.println("Hanya masukkan makanan atau minuman");
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
          }    System.out.print("Kembali ke Menu Utama? (y/n): ");
            String jawaban = scanner.next().toLowerCase();
            toko = jawaban.equals("y");
      } 
            scanner.close();
}}
