package mainpackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** Txt dosyalarindan veri okuyup yazabilmeyi saglayan class */
public class DataManager
{
    /** Oda, Konuk ve Resepsiyonistleri tutan ArrayList objeleri */
    public ArrayList<Room> Rooms = new ArrayList<>();
    public ArrayList<Receptionist> Receptionists = new ArrayList<>();
    public ArrayList<Guest> Guests = new ArrayList<>();

    /** Dosyalarda yazan verileri bellege alan constructor*/
    public DataManager()
    {
        try
        {
            setUp();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Verilen sayıda bos oda olusturan metod
     * @param num istenen oda sayisi*/
    public void createEmptyRooms(int num)
    {
        for(int i=0;i<num;i++)
        {
            Room room = new Room(i + 1);
            Rooms.add(room);
        }
    }

    /** Oda bilgilerini dosyaya yazan metod */
    public void writeRooms()
    {
        try
        {
            FileWriter file = new FileWriter("C:\\Users\\emrem\\DS_HW1\\src\\Data\\Rooms.txt");
            BufferedWriter br = new BufferedWriter(file);
            for(int i=0;i<Rooms.size(); i++)
            {
                Room room = Rooms.get(i);
                br.write(room.getId() + "," + room.getState() + "," + room.getReservationDate() + ","
                        + room.getRsrEndDate() + "," + room.getReservedDayNum() + "," + room.getRsrName());
                br.newLine();
                //System.out.println(room.getId() + "," + room.getState() + "," + room.getReservationDate() + "," + room.getRsrEndDate() + "," + room.getReservedDayNum());
            }
            br.close();
            file.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Rooms.txt dosyasindan oda bilgilerini okuyan metod */
    public void readRooms()
    {
        try
        {
            FileReader in = new FileReader("C:\\Users\\emrem\\DS_HW1\\src\\Data\\Rooms.txt");
            Scanner scanner = new Scanner(in);
            while(scanner.hasNextLine())
            {
                String roomString = scanner.nextLine();
                String[] roomData = roomString.split(",");
                Room room = new Room(Integer.parseInt(roomData[0]),Integer.parseInt(roomData[1]),roomData[2],roomData[3],Integer.parseInt(roomData[4]),roomData[5]);
                Rooms.add(room);
            }
            scanner.close();
            in.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Receptionists.txt dosyasindan resepsiyonist bilgilerini okuyan metod */
    public void readReceptionists()
    {
        try
        {
            FileReader in = new FileReader("C:\\Users\\emrem\\DS_HW1\\src\\Data\\Receptionists.txt");
            Scanner scanner = new Scanner(in);
            while(scanner.hasNextLine())
            {
                String rcpString = scanner.nextLine();
                String[] rcpData = rcpString.split(",");
                Receptionist rcp = new Receptionist(rcpData[0],rcpData[1]);
                Receptionists.add(rcp);
            }
            scanner.close();
            in.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Guests.txt dosyasindan konuk bilgilerini okuyan metod */
    public void readGuests()
    {
        try
        {
            FileReader in = new FileReader("C:\\Users\\emrem\\DS_HW1\\src\\Data\\Guests.txt");
            Scanner scanner = new Scanner(in);
            while(scanner.hasNextLine())
            {
                String guestString = scanner.nextLine();
                String[] guestData = guestString.split(",");
                Guest guest = new Guest(guestData[0],guestData[1]);
                Guests.add(guest);
            }
            scanner.close();
            in.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /** Txt dosyalarindaki tum bilgileri okuyup bellege alan metod */
    public void setUp()
    {
        readRooms();
        readReceptionists();
        readGuests();
    }

    /** Giris turu, kullanici adi ve sifreye gore User objesi returnleyen metod
     * @param loginType giris turu
     * @param username  kullanici adi
     * @param password  sifre
     * @return guest konuk objesi*/
    public User getUser(int loginType,String username,String password)
    {
        if(loginType == 1)
        {
            for(int i=0;i<Guests.size();i++)
            {
                Guest guest = Guests.get(i);

                if(guest.getName().equals(username))
                {
                    if(guest.getPassword().equals(password))
                    {
                        return guest;
                    }
                    else
                    {
                        return null;
                    }
                }
            }
        }

        else if(loginType == 2)
        {
            for(int i=0;i<Receptionists.size();i++)
            {
                Receptionist rcp = Receptionists.get(i);

                if(rcp.getName().equals(username))
                {
                    if(rcp.getPassword().equals(password))
                    {
                        return rcp;
                    }
                    else
                    {
                        return null;
                    }
                }
            }
        }
        return null;
    }
    /** Verilen id degerine gore boş oda returnleyen metod
     * @param id oda numarasi
     * @return room objesi*/
    public Room getRoomByID(int id)
    {
        for(int i=0;i<Rooms.size();i++)
        {
            if(Rooms.get(i).getId() == id && Rooms.get(i).getState() == 0)
            {
                return Rooms.get(i);
            }
        }
        return null;
    }

    /** Verilen id ve name degerine gore oda returnleyen metod
     * @param id oda numarasi
     * @param name kullanici adi
     * @return room objesi*/
    public Room getRoomByID(int id,String name)
    {
        for(int i=0;i<Rooms.size();i++)
        {
            if(Rooms.get(i).getId() == id && Rooms.get(i).getRsrName().equals(name))
            {
                return Rooms.get(i);
            }
        }
        return null;
    }
}
