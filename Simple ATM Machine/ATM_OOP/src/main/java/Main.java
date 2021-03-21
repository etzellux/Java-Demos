
public class Main {
    public static void main(String[] args)
    {
        ATM atm = new ATM();
        Account account = new Account("0001-0002","12345","ABS",1500.0);
        atm.runn(account);
        System.out.println("İyi günler...");
        
    }
}
