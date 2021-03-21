import java.util.Scanner;
public class Account {
    Scanner scanner = new Scanner(System.in);
    private String hesapno; //:account id
    private String ad;          //:id
    private String sifre;      //:password
    private double bakiye; //balance
public Account(String hesapno,String sifre,String ad,double bakiye)
{
    this.hesapno= hesapno;
    this.sifre = sifre;
    this.ad = ad;
    this.bakiye = bakiye;
}
    public void parayatir()
    {
        System.out.print("Yatırmak istediğiniz miktar:");
        double miktar = scanner.nextDouble();
        this.bakiye+=miktar;
        System.out.println("Yeni bakiye:"+ this.bakiye);
    }
    public void paracek()
    {
        /* miktar: amount */
        System.out.print("Çekmek istediğiniz miktar:");
        double miktar = scanner.nextDouble(); 
        if(miktar>1500)
        {
            System.out.println("En fazla 1500tl çekebilirsiniz");
        }
        else
        {
            if(bakiye-miktar<0)
            {
                System.out.println("Yetersiz bakiye");
            }
            else
            {
                this.bakiye-=miktar;
                System.out.println("Hesabınızda kalan miktar:"+ this.bakiye);
            }
        }
    }

    
    public String getHesapno() {
        return hesapno;
    }

   
    public void setHesapno(String hesapno) {
        this.hesapno = hesapno;
    }

   
    public String getAd() {
        return ad;
    }

    
    public void setAd(String ad) {
        this.ad = ad;
    }

   
    public double getBakiye() {
        return bakiye;
    }

    
    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    
    public String getSifre() {
        return sifre;
    }

    
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    
}
