import java.util.Scanner;
public class ATM {
    public void runn(Account account)
    {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        System.out.println("Hoşgeldiniz...");
        int sayac=0;
        while(true)
        {
            if(login.Login(account))
            {
                System.out.println("Giriş başarılı");
                break;
            }
            else
            {
                System.out.println("Başarısız giriş");
                sayac++;
            }
            if(sayac==3)
            {
                System.out.println("3 başarısız giriş denediniz...");
                return;
            }
        }
        String islemler = "1. Bakiye Öğrenme\n"
                        + "2. Para Çekme\n"
                        + "3. Para Yatırma\n"
                        + "4. Çıkış\n";
        String islem;
        System.out.println(islemler);
        while(true)
        {
            System.out.println("*************************");
            System.out.print("İşlem seçiniz:");
            islem = scanner.nextLine();
            switch(islem)
            {
                case "1":
                    System.out.println("Bakiye:"+ account.getBakiye());
                    break;
                case "2":
                    account.paracek();
                    break;
                case "3":
                    account.parayatir();
                    break;
                case "4":
                    return;
                    
            }
            
        }
    }
    
}
