package mainpackage;

import java.util.Date;
/** Oda bilgilerini tutmak icin kullanilan class */
public class Room
{
    int id;
    int state;
    String rsrDate;
    String rsrEndDate;
    int rsrDayNum;
    String rsrName;

    /** Verilen id degeri ile bos oda olusturan constructor
     * @param id oda numarasi*/
    public Room(int id)
    {
        this.id = id;
        state = 0;
        rsrDate = "0";
        rsrEndDate = "0";
        rsrDayNum = 0;
        rsrName = "0";
    }

    /** Verilen degerler ile oda objesi olusturan constructor
     * @param id oda numarasi
     * @param state odanin durumu
     * @param rsrDate odanin rezervasyon tarihi
     * @param rsrEndDate odanin rezervasyon bitim tarihi
     * @param rsrDayNum odanin rezerve edilen gun sayisi
     * @param rsrName odayi rezerve eden kullanicinin ismi*/
    public Room(int id,int state,String rsrDate,String rsrEndDate,int rsrDayNum ,String rsrName)
    {
        this.id = id;
        this.state = state;
        this.rsrDate = rsrDate;
        this.rsrEndDate = rsrEndDate;
        this.rsrDayNum = rsrDayNum;
        this.rsrName = rsrName;
    }
    /** Room objesinin rezervasyon bitim tarihini returnleyen metod
     * @return rsrEndDate rezervasyon bitim tarihi*/
    public String getRsrEndDate()
    {
        return rsrEndDate;
    }

    /** Room objesinin rezervasyon bitim tarihini verilen deger ile degistiren metod
     * @param rsrEndDate rezervasyon bitim tarihi*/
    public void setRsrEndDate(String rsrEndDate)
    {
        this.rsrEndDate = rsrEndDate;
    }

    /** Room objesinin id degerini returnleyen metod
     * @return id oda numarasi*/
    public int getId()
    {
        return id;
    }

    /** Room objesinin id degerini verilen deger ile degistiren metod
     * @param id oda numarasi*/
    public void setId(int id)
    {
        this.id = id;
    }

    /** Room objesinin rezervasyon tarihini returnleyen metod
     * @return rsrDate rezervasyon tarihi*/
    public String getReservationDate()
    {
        return rsrDate;
    }

    /** Room objesinin rezervasyon tarihini verilen deger ile degistiren metod
     * @param reservationDate rezervasyon tarihi*/
    public void setReservationDate(String reservationDate)
    {
        this.rsrDate = reservationDate;
    }

    /** Room objesinin rezerve edilen gun sayisini returnleyen metod
     * @return rsrDayNum rezerve edilen gun sayisi*/
    public int getReservedDayNum()
    {
        return rsrDayNum;
    }

    /** Room objesinin rezerve edilen gun sayisini verilen deger ile degistiren metod
     * @param reservedDayNum rezerve edilen gun sayisi*/
    public void setReservedDayNum(int reservedDayNum)
    {
        this.rsrDayNum = reservedDayNum;
    }

    /** Room objesinin durum degerini returnleyen metod
     * @return state odanin durumu*/
    public int getState()
    {
        return state;
    }
    /** Room objesinin durum degerini verilen deger ile degistiren metod
     * @param state odanin durumu*/
    public void setState(int state)
    {
        this.state = state;
    }

    /** Room objesini rezerve eden kullanicinin adini returnlayan metod
     * @return rsrName rezerve eden kullanicinin adi*/
    public String getRsrName() {
        return rsrName;
    }

    /** Room objesini rezerve eden kullanicinin adini verilen deger ile degistiren metod
     * @param rsrName rezerve eden kullanicinin adi*/
    public void setRsrName(String rsrName) {
        this.rsrName = rsrName;
    }
}
