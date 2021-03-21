package mainpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/** Main class */
public class Main
{
    static DataManager dataManager = new DataManager();
    static User user = null;

    /** Oda bilgilerini tutmak icin kullanilan bir statik nested class*/
    static class rsrInput
    {
        String rsrDate,rsrEndDate;
        int roomId,rsrDayNum;

        /** Alinan argumanlari atayan constructor
         * @param rsrDate rezervasyon tarihi
         * @param rsrEndDate rezervasyon bitim tarihi
         * @param roomId oda numarasi
         * @param rsrDayNum rezervasyon edilen gun sayisi*/
        rsrInput(String rsrDate,String rsrEndDate,int roomId,int rsrDayNum)
        {
            this.rsrDate = rsrDate;
            this.rsrEndDate = rsrEndDate;
            this.roomId = roomId;
            this.rsrDayNum = rsrDayNum;
        }
    }

    /** Konuk-Resepsiyonist kullanicilarin sisteme girisini saglayan metod*/
    static void login()
    {
        Scanner scanner = new Scanner(System.in);
        int loginType;

        System.out.print("Konuk girisi için 1, Resepsiyonist girisi için 2:");
        loginType = scanner.nextInt();
        scanner.nextLine();

        while(user == null)
        {
            System.out.print("Kullanici Adi:");
            String username = scanner.nextLine();
            System.out.print("Sifre:");
            String password = scanner.nextLine();

            user = dataManager.getUser(loginType, username, password);

            if (user == null)
            {
                System.out.println("Hatali giris...");
            }
        }
    }

    /** Rezerve edilecek oda ile ilgili bilgileri returnleyen method
     * @return rsrInput*/
    static rsrInput getRsrInput()
    {
        Scanner scanner = new Scanner(System.in);

        String rsrDate,rsrEndDate;
        System.out.println("*******************************************");
        System.out.print("Oda numarasini girin:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Date date = new Date();

        boolean isFormatValid = false;
        while(!isFormatValid)
        {
            try
            {
                System.out.print("Bir tarih girin (dd-MM-yyyy):");
                String dateString = scanner.nextLine();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

                date = sdf.parse(dateString);

                isFormatValid = true;
            }
            catch(Exception ex)
            {
                System.out.println("Yanlis tarih formati");
            }
        }
        rsrDate = date.toString();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        System.out.print("Kalinacak gun sayisi:");
        int rsrDayNum = scanner.nextInt();

        System.out.println("*******************************************");

        cal.add(cal.DAY_OF_MONTH,rsrDayNum);

        rsrEndDate = cal.getTime().toString();

        return new rsrInput(rsrDate,rsrEndDate,id,rsrDayNum);
    }
    /** Tum metodlarin yurutuldugu main metodu
     * @param args .*/
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(dataManager.Guests.size());

        login();
        while(true)
        {
            if (user.getClass().getSimpleName().equals("Guest"))
            {
                Guest guest = (Guest) user;
                System.out.println("*******************************************");
                System.out.print("Rezervasyon yapmak icin 1,\niptal etmek icin 2,\nçıkmak icin 3:");

                int prNum =  scanner.nextInt();
                scanner.nextLine();

                System.out.println("*******************************************");

                if(prNum == 1)
                {
                    rsrInput input = getRsrInput();

                    Room room = dataManager.getRoomByID(input.roomId);
                    if(room != null)
                    {
                        guest.reserve(guest.getName(),room, input.rsrDate, input.rsrDayNum, input.rsrEndDate);
                        dataManager.writeRooms();
                    }
                    else
                    {
                        System.out.println("Oda bulunamadi");
                    }

                }
                else if(prNum == 2)
                {
                    System.out.print("Oda numarasi girin:");
                    int id = scanner.nextInt();

                    Room room = dataManager.getRoomByID(id,guest.getName());
                    if(room != null)
                    {
                        guest.cancelReservation(room);
                        dataManager.writeRooms();
                    }
                    else
                    {
                        System.out.println("Oda bulunamadi");
                    }
                }
                else
                {
                    break;
                }
            }
            else
            {
                Receptionist rcp = (Receptionist) user;

                System.out.println("*******************************************");
                System.out.print("Rezervasyon yapmak icin 1,\niptal etmek icin 2,\n" +
                        "check-in icin 3,\ncheck-out icin 4,\nçıkmak icin 5:");

                int prNum =  scanner.nextInt();
                scanner.nextLine();
                System.out.println("*******************************************");
                if(prNum == 5)
                {
                    break;
                }

                System.out.print("Musteri ismi girin:");
                String name = scanner.nextLine();

                if(prNum == 1)
                {
                    rsrInput input = getRsrInput();

                    Room room = dataManager.getRoomByID(input.roomId);
                    if(room != null)
                    {
                        rcp.reserve(name,room, input.rsrDate, input.rsrDayNum, input.rsrEndDate);
                        dataManager.writeRooms();
                    }
                    else
                    {
                        System.out.println("Oda bulunamadi");
                    }

                }
                else if(prNum == 2)
                {
                    System.out.print("Oda numarasi girin:");
                    int id = scanner.nextInt();

                    Room room = dataManager.getRoomByID(id,name);
                    if(room != null)
                    {
                        rcp.cancelReservation(room);
                        dataManager.writeRooms();
                    }
                    else
                    {
                        System.out.println("Oda bulunamadi");
                    }
                }

                else if(prNum == 3)
                {
                    rsrInput input = getRsrInput();

                    Room room = dataManager.getRoomByID(input.roomId);
                    if(room != null)
                    {
                        rcp.check_in(name,room, input.rsrDate, input.rsrDayNum, input.rsrEndDate);
                        dataManager.writeRooms();
                    }
                    else
                    {
                        System.out.println("Oda bulunamadi");
                    }
                }

                else if(prNum == 4)
                {
                    System.out.print("Oda numarasi girin:");
                    int id = scanner.nextInt();

                    Room room = dataManager.getRoomByID(id,name);
                    if(room != null)
                    {
                        rcp.check_out(room);
                        dataManager.writeRooms();
                    }
                    else
                    {
                        System.out.println("Oda bulunamadi");
                    }
                }


            }
        }

    }
}
