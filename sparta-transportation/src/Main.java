import com.example.bus.*;
import com.example.taxi.*;

import com.example.publictransportation.*;
public class Main {
    public static void main(String[] args) {
//        Bus bus1 = new Bus();
//        Bus bus2 = new Bus();
//
//        bus1.ChangeGuest(2);
//        bus1.Drive(1, 50);
//        bus1.Drive(-1,-10);
//        bus1.Drive(1, 0);
//        bus1.ChangeGuest(45);
//        bus1.ChangeGuest(5);
//        bus1.Drive(-1, 55);
//
//
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        taxi1.ChangeGuest(2, "서울역",2);
        taxi1.Drive(0, 80);
        taxi1.LeaveGuest();

        taxi1.ChangeGuest(5, "서울역", 2);
        taxi1.ChangeGuest(3, "구로디지털단지역", 12);

        taxi1.Drive(0, 20);
        taxi1.LeaveGuest();

    }
}
