package Class.KBs.KB1;

import java.util.ArrayList;
import java.util.Scanner;

public class First {

    static Scanner in = new Scanner(System.in);
    static String[] product = {"Indomie Rasa Kari Ayam", "Kecap Manis Bango", "Kopi Kapal Kapi", "Gula Pasir Gulaku",
            "Telor Ayam Sinar Mas"};
    static int[] price = {2500,10500,15000,9000,22500};

    public static void main(String[] args) {
        ArrayList<String> transaction = new ArrayList<>();
        System.out.println("Masukan barang Anda dengan format ['indicator(-/+)' 'kode_barang(0-4)' 'jumlah_barang']");
        System.out.println("Contoh: Tambah kecap manis 20 buah -> input:+ 1 20");
        String input = "";

        while (true){
            input = in.nextLine();
            if (input.equals("-1"))
                break;

            char indicator = input.charAt(0);
            int code_product = Character.getNumericValue(input.charAt(2));

            if (input.length() > 4){
                String s_quantity = input.substring(4);
                if (code_product < 6){
                    try{
                        int quantity = Integer.parseInt(s_quantity);
                        if (quantity != 0){
                            if (indicator == '+') {
                                boolean existed = false;
                                int i;
                                for (i = 0; i < transaction.size(); i++) {
                                    if (Character.getNumericValue(transaction.get(i).charAt(0)) == code_product) {
                                        existed = true;
                                        break;
                                    }
                                }
                                if (existed){
                                    int total = Integer.parseInt(transaction.get(i).substring(1));
                                    total += quantity;
                                    transaction.set(i, code_product+String.valueOf(total));
                                    System.out.println("Penambahan barang yang sudah ada berhasil dilakukan");
                                } else {
                                    transaction.add(code_product+String.valueOf(quantity));
                                    System.out.println("Penambahan barang berhasil dilakukan");
                                }
                            } else if (indicator == '-'){
                                boolean existed = false;
                                int i;
                                for (i = 0; i < transaction.size(); i++) {
                                    if (Character.getNumericValue(transaction.get(i).charAt(0)) == code_product) {
                                        existed = true;
                                        break;
                                    }
                                }
                                if (existed){
                                    int total = Integer.parseInt(transaction.get(i).substring(1));
                                    if (total > quantity){
                                        total-=quantity;
                                        transaction.set(i, code_product+String.valueOf(total));
                                        System.out.println("Pengurangan barang yang sudah ada berhasil dilakukan");
                                    } else if (total == quantity) {
                                        transaction.remove(i);
                                        System.out.println("Pengurangan barang berhasil dilakukan");
                                    } else
                                        System.out.println("Maaf jumlah pengurangan invalid");
                                }else
                                    System.out.println("Maaf barang yang akan dikurangi, tidak ditemukan");
                            } else
                                System.out.println("Maaf indicator invalid, hanya bisa - atau +");
                        } else
                            System.out.println("Tidak ada yang perlu ditambahkan atau dikurangi");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Maaf, tidak bisa membaca banyak/quantity barang");
                    }
                } else
                    System.out.println("Maaf, kode_barang tidak ditemukan");
            }else
                System.out.println("Format inputan invalid");
        }

        System.out.println("Keranjang Anda:");
        int total = 0;
        for (int i = 0; i < transaction.size(); i++) {
            int get_index_product = Character.getNumericValue(transaction.get(i).charAt(0));
            int get_quantity = Integer.parseInt(transaction.get(i).substring(1));
            System.out.println(product[get_index_product] + " " + get_quantity + "x " + price[get_index_product]);
            total += get_quantity * price[get_index_product];
        }
        if (total == 0)
            System.out.println("KOSONG");
        System.out.println("Total yang harus Anda bayar adalah Rp."+total);
    }
}
