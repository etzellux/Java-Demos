package mainpackage;

import java.util.Scanner;

/** Resepsiyonist bilgilerini tutan class */
public class Receptionist extends User
{
    Scanner scanner = new Scanner(System.in);

    /** Verilen name name ve password degerleri ile Receptionist objesi olustutan constructor
     * @param name kullanici adi
     * @param password sifre*/
    public Receptionist(String name,String password)
    {
        super(name,password);
    }
    /** name degeri verilen kullanıcının room objesinde check-in yapan metod
     * @param name musteri adi
     * @param room oda objesi
     * @param rsrDate rezervasyon tarihi
     * @param rsrDayNum rezervasyon edilen gun sayisi
     * @param rsrEndDate rezervasyon bitim tarihi */
    public void check_in(String name,Room room,String rsrDate,int rsrDayNum,String rsrEndDate)
    {
        reserve(name,room,rsrDate,rsrDayNum,rsrEndDate);
        room.setState(2);
    }
    /** Verilen Room objesinde check-out yapan metod
     * @param room oda objesi*/
    public void check_out(Room room)
    {
        System.out.println("Ucret: " + room.getReservedDayNum()*50 + "tl");
        cancelReservation(room);
    }
}
