package mainpackage;

/** Konuk bilgilerini tutan class */
public class Guest extends User
{
    /** Verilen name ve password degerlerini atayan constructor
     * @param name Konuk kullanici adi
     * @param password konuk sifresi*/
    public Guest(String name,String password)
    {
        super(name,password);
    }
}
