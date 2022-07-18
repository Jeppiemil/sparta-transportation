package com.example.bus;
import java.util.UUID;
public class Bus {
    static int max_guest;
    static int cur_guest;
    static int price;
    UUID bus_uniqueID;
    static int cur_gas;
    static int cur_speed;
    static boolean bus_status; //true when driving, false going back to garage
    public Bus(){
        max_guest=10;
        cur_guest=0;
        price=2000;
        bus_uniqueID = UUID.randomUUID();
        cur_gas=100;
        cur_speed=0;
        bus_status=true; //true when driving, false going back to garage
    }
    public static void Drive(boolean status){
        Bus.bus_status = status;
        if (Bus.bus_status==false){
            Bus.cur_gas = 100;
            Bus.cur_guest = 0;
            Bus.cur_speed = 0;
            System.out.println("차량이 차고지로 이동하여 주유량이 100, 현재 승객 수가 0, 현재 속도가 0이 되었습니다.");
        } else {
            Bus.cur_gas -= 46;
            if (Bus.cur_gas < 10 && Bus.cur_gas > 0){
                System.out.println("주유량 10 미만. 주유가 필요합니다.");
            } else if (Bus.cur_gas <= 0) {
                System.out.print("주유량 0. 차고지로 이동합니다. ");
                Drive(false);
            } else {
                System.out.println("운행을 시작합니다.");
            }
        }
    }
    public static void ChangeSpeed(int speed_delta){
        if (Bus.bus_status==false){
            System.out.println("차량이 차고지에 있습니다. 먼저 Drive로 운행을 시작해주세요.");
        }
        else if (Bus.cur_gas < 10){
            System.out.println("주유량 10 미만으로 속도 변경이 불가합니다. 주유량을 확인하세요.");
        } else {
            Bus.cur_speed += speed_delta;
            if (Bus.cur_speed < 0) {
                Bus.cur_speed = 0;
                System.out.println("속도를 모두 줄여 차량이 정지합니다.");
            } else {
                System.out.printf("속도 변경을 완료했습니다. 변경된 현재 속도는 %d입니다.%n", Bus.cur_speed);
            }
        }
    }

    public static void ChangeGuest(int count) {
        if (Bus.bus_status == false) {
            System.out.println("차량이 차고지에 있습니다. 먼저 Drive로 운행을 시작해주세요.");
        } else if (Bus.max_guest < Bus.cur_guest + count) {
            System.out.printf("최대승객수인 %d명 이상으로 탑승을 시도하여 %d명만 탑승 가능합니다.%n", Bus.max_guest, Bus.max_guest - Bus.cur_guest);
            Bus.cur_guest += Bus.max_guest - Bus.cur_guest;
        } else if (cur_guest + count < 0) {
            System.out.printf("현재 승객 수인 %d보다 더 많은 사람을 내리게 했습니다. 모든 승객이 내린 것으로 간주, 현재 승객 수를 0로 만듭니다.%n", Bus.cur_guest);
            Bus.cur_guest = 0;
        } else {
            Bus.cur_guest += count;
            if (count >= 0) {
                System.out.printf("%d명 탑승하여 현재 승객 %d명 입니다.%n", count, Bus.cur_guest);
            } else {
                System.out.printf("%d명 하차하여 현재 승객 %d명 입니다%n", count, Bus.cur_guest);
            }

        }
    }

    public static void main(String[] args){
    }
}
