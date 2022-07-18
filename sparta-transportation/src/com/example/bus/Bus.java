package com.example.bus;
import java.util.UUID;
public class Bus {
    int max_guest;
    int cur_guest;
    int price;
    UUID bus_uniqueID;
    int cur_gas;
    int cur_speed;
    boolean bus_status; //true when driving, false going back to garage

    public Bus(){
        max_guest=10;
        cur_guest=0;
        price=2000;
        bus_uniqueID = UUID.randomUUID();
        cur_gas=100;
        cur_speed=0;
        bus_status=true; //true when driving, false going back to garage
        System.out.printf("버스 ID <%s> 가 생성되었습니다.%n", bus_uniqueID);
    }
    public void Drive(boolean status){
        bus_status = status;
        if (bus_status==false){
            cur_gas = 100;
            cur_guest = 0;
            cur_speed = 0;
            System.out.println("차량이 차고지로 이동하여 주유량이 100, 현재 승객 수가 0, 현재 속도가 0이 되었습니다.");
        } else {
            cur_gas -= 46;
            if (cur_gas < 10 && cur_gas > 0){
                System.out.println("주유량 10 미만. 주유가 필요합니다.");
            } else if (cur_gas <= 0) {
                System.out.print("주유량 0. 차고지로 이동합니다. ");
                Drive(false);
            } else {
                System.out.println("운행을 시작합니다.");
            }
        }
    }
    public void ChangeSpeed(int speed_delta){
        if (bus_status==false){
            System.out.println("차량이 차고지에 있습니다. 먼저 Drive로 운행을 시작해주세요.");
        }
        else if (cur_gas < 10){
            System.out.println("주유량 10 미만으로 속도 변경이 불가합니다. 주유량을 확인하세요.");
        } else {
            cur_speed += speed_delta;
            if (cur_speed < 0) {
                cur_speed = 0;
                System.out.println("속도를 모두 줄여 차량이 정지합니다.");
            } else {
                System.out.printf("속도 변경을 완료했습니다. 변경된 현재 속도는 %d입니다.%n", cur_speed);
            }
        }
    }

    public void ChangeGuest(int count) {
        if (bus_status == false) {
            System.out.println("차량이 차고지에 있습니다. 먼저 Drive로 운행을 시작해주세요.");
        } else if (max_guest < cur_guest + count) {
            System.out.printf("최대승객수인 %d명 이상으로 탑승을 시도하여 %d명만 탑승 가능합니다.%n", max_guest, max_guest - cur_guest);
            cur_guest += max_guest - cur_guest;
        } else if (cur_guest + count < 0) {
            System.out.printf("현재 승객 수인 %d보다 더 많은 사람을 내리게 했습니다. 모든 승객이 내린 것으로 간주, 현재 승객 수를 0로 만듭니다.%n", cur_guest);
            cur_guest = 0;
        } else {
            cur_guest += count;
            if (count >= 0) {
                System.out.printf("%d명 탑승하여 현재 승객 %d명 입니다.%n", count, cur_guest);
            } else {
                System.out.printf("%d명 하차하여 현재 승객 %d명 입니다%n", count, cur_guest);
            }

        }
    }

    public void main(String[] args){
        Bus bus = new Bus();
        System.out.println(bus.bus_uniqueID);
    }
}
