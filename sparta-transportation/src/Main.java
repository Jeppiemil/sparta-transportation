import com.example.bus.*;
public class Main {
    public static void main(String[] args) {
        Bus a_bus = new Bus();
        Bus.Drive(true);
        Bus.ChangeSpeed(30);
        Bus.ChangeGuest(15);
        Bus.Drive(true);
        Bus.Drive(true);
        Bus.ChangeGuest(5);

    }
}
