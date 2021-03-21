package Test;

import mainpackage.*;

/** Main metod icerisinde mainpackage paketinin siniflari test edilmistir */
public class Test
{
    public static void main(String args[])
    {
        /* DATAMANAGER */

        DataManager dataManager = new DataManager();

        dataManager.createEmptyRooms(10);

        dataManager.readGuests();

        dataManager.readReceptionists();

        dataManager.readRooms();

        System.out.println(dataManager.getUser(1,"Abs","123123").toString());

        System.out.println(dataManager.getRoomByID(3).getClass().getSimpleName());

        System.out.println(dataManager.getRoomByID(5,"0").getClass().getSimpleName());

        /* ROOM */

        Room room1 = dataManager.Rooms.get(5);

        Room room2 = new Room(122,0,"0","0",0,"0");

        Room room3 = new Room(789);

        System.out.println(room1.getReservationDate());

        System.out.println(room1.getReservedDayNum());

        System.out.println(room1.getRsrEndDate());

        System.out.println(room1.getState());

        System.out.println(room1.getRsrName());

        System.out.println();

        /* USER & GUEST- Guest ve Receptionist siniflarinin super sinifi*/

        User user1 = dataManager.Guests.get(0);

        System.out.println(user1.getName());

        System.out.println(user1.getPassword());

        user1.reserve("test",room1,"0",0,"0");

        user1.cancelReservation(room1);

        /* Receptionist - user sinifindan kalitimi var*/

        Receptionist rcp = dataManager.Receptionists.get(0);

        Receptionist rcp2 = new Receptionist("test","123123");

        System.out.println(rcp.getName());

        System.out.println(rcp.getPassword());

        rcp.check_in("test",room1,"0",0,"0");

        rcp.check_out(room1);















    }
}
