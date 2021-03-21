package mainpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/** Room ve Receptionist classlarinin ortak ozelliklerini bulunduran superclass */
public class User
{
    String name;
    String password;

    /** Verilen name ve password degerleri ile kullanici olusturan constructor
     * @param name kullanici adi
     * @param password sifre */
    public User(String name,String password)
    {
        this.name = name;
        this.password = password;
    }

    /** Verilen oda ve kullanici bilgileri ile oda reserve eden metod
     * @param name kullanici adi
     * @param room oda objesi
     * @param rsrDate rezervasyon tarihi
     * @param rsrDayNum rezerve edilen gun sayisi
     * @param rsrEndDate rezervasyon bitim tarihi*/
    public void reserve(String name,Room room,String rsrDate,int rsrDayNum,String rsrEndDate)
    {
        room.setState(1);
        room.setReservationDate(rsrDate);
        room.setReservedDayNum(rsrDayNum);
        room.setRsrEndDate(rsrEndDate);
        room.setRsrName(name);
    }
    /** Verilen Room objesi ile rezervasyon iptali yapan metod
     * @param room oda objesi*/
    public void cancelReservation(Room room)
    {
            room.setState(0);
            room.setReservationDate("0");
            room.setReservedDayNum(0);
            room.setRsrEndDate("0");
            room.setRsrName("0");
    }
    /** Kullanici objesinin name degerini returnleyen metod
     * @return name kullanici adi*/
    public String getName()
    {
        return name;
    }
    /** Kullanici objesinin name degerini verilen deger olarak degistiren metod
     * @param name kullanici adi*/
    public void setName(String name)
    {
        this.name = name;
    }
    /** Kullanici objesinin password degerini returnleyen metod
     * @return password sifre*/
    public String getPassword()
    {
        return password;
    }
    /** Kullanici objesinin password degerini verilen deger olarak degistiren metod
     * @param password sifre*/
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String toString()
    {
        return name + "," + password;
    }
}
