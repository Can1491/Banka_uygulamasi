package bankaa;

import java.util.Scanner;

public class banka {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Giriş ekranı
        String dogruKullanici = "Can";
        String dogruSifre = "1234";

        if (!girisYap(input, dogruKullanici, dogruSifre)) {
            input.close();
            return;
        }

        // Başlangıç bakiyesi
        double bakiye = 1000;

        int secim;

        do {
            menuGoster();

            System.out.print("Seçiminiz: ");
            secim = input.nextInt();

            switch (secim) {

                case 1:
                    bakiyeGoster(bakiye);
                    break;

                case 2:
                    bakiye = paraYatir(input, bakiye);
                    break;

                case 3:
                    bakiye = paraCek(input, bakiye);
                    break;

                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }

        } while (secim != 4);

        input.close();
    }

    // Kullanıcı giriş işlemi
    public static boolean girisYap(
            Scanner input,
            String dogruKullanici,
            String dogruSifre) {

        String kullaniciAdi;
        String sifre;
        int hak = 3;

        while (hak > 0) {

            System.out.print("Kullanıcı adı: ");
            kullaniciAdi = input.nextLine();

            System.out.print("Şifre: ");
            sifre = input.nextLine();

            if (kullaniciAdi.equals(dogruKullanici)
                    && sifre.equals(dogruSifre)) {

                System.out.println("Giriş başarılı!");
                System.out.println("Hoş geldin " + kullaniciAdi);

                return true;

            } else {

                hak--;

                System.out.println(
                        "Hatalı giriş! Kalan hak: " + hak);
            }
        }

        System.out.println("Hesap bloke edildi!");

        return false;
    }

    // Banka menüsü
    public static void menuGoster() {

        System.out.println("\n--- BANKA MENÜ ---");
        System.out.println("1- Bakiye Görüntüle");
        System.out.println("2- Para Yatır");
        System.out.println("3- Para Çek");
        System.out.println("4- Çıkış");
    }

    // Bakiye görüntüleme
    public static void bakiyeGoster(double bakiye) {

        System.out.println("Bakiyeniz: " + bakiye);
    }

    // Para yatırma
    public static double paraYatir(
            Scanner input,
            double bakiye) {

        System.out.print("Yatırılacak miktar: ");
        double yatir = input.nextDouble();

        if (yatir > 0) {

            bakiye += yatir;

            System.out.println("Para yatırma başarılı.");
            System.out.println("Yeni bakiye: " + bakiye);

        } else {

            System.out.println(
                    "Hata: Yatırılacak miktar 0'dan büyük olmalıdır.");
        }

        return bakiye;
    }

    // Para çekme
    public static double paraCek(
            Scanner input,
            double bakiye) {

        System.out.print("Çekilecek miktar: ");
        double cek = input.nextDouble();

        if (cek <= 0) {

            System.out.println(
                    "Hata: Çekilecek miktar 0'dan büyük olmalıdır.");

        } else if (cek <= bakiye) {

            bakiye -= cek;

            System.out.println("Para çekme başarılı.");
            System.out.println("Yeni bakiye: " + bakiye);

        } else {

            System.out.println("Yetersiz bakiye!");
        }

        return bakiye;
    }
}
