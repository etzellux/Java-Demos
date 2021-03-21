import java.util.Scanner;
public class Login {
    public boolean Login(Account account)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen hesap numaranızı giriniz:");
        String hesapno = scanner.nextLine();
        System.out.print("Lütfen şifrenizi giriniz:");
        String sifre= scanner.nextLine();
        if(account.getHesapno().equals(hesapno) && account.getSifre().equals(sifre))
        {
            return true;
        }
        else 
        {
            return false;
        }
        
    }
    
}
