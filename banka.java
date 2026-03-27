package bankaa;
import java.util.Scanner;


public class banka {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Giriş ekranı
        String dogruKullanici = "Can";
        String dogruSifre = "1234";

        String kullaniciAdi, sifre;
        int hak = 3;

        while (hak > 0) {
            System.out.print("Kullanıcı adı: ");
            kullaniciAdi = input.nextLine();

            System.out.print("Şifre: ");
            sifre = input.nextLine();

            if (kullaniciAdi.equals(dogruKullanici) && sifre.equals(dogruSifre)) {
                System.out.println("Giriş başarılı!");
                System.out.println("Hoş geldin " + kullaniciAdi);
                break;
            } else {
                hak--;
                System.out.println("Hatalı giriş! Kalan hak: " + hak);
            }
        }

        if (hak == 0) {
            System.out.println("Hesap bloke edildi!");
            return;
        }

        //Banka ekranı
        double bakiye = 1000;
        int secim;

        do {
            System.out.println("\n--- BANKA MENÜ ---");
            System.out.println("1- Bakiye Görüntüle");
            System.out.println("2- Para Yatır");
            System.out.println("3- Para Çek");
            System.out.println("4- Çıkış");
            System.out.print("Seçiminiz: ");

            secim = input.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Bakiyeniz: " + bakiye);
                    break;

                case 2:
                    System.out.print("Yatırılacak miktar: ");
                    double yatir = input.nextDouble();
                    bakiye += yatir;
                    System.out.println("Yeni bakiye: " + bakiye);
                    break;

                case 3:
                    System.out.print("Çekilecek miktar: ");
                    double cek = input.nextDouble();

                    if (cek <= bakiye) {
                        bakiye -= cek;
                        System.out.println("Yeni bakiye: " + bakiye);
                    } else {
                        System.out.println("Yetersiz bakiye!");
                    }
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
}
