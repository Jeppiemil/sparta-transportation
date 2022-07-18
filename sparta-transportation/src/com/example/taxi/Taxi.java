package com.example.taxi;

import java.util.UUID;


public class Taxi {
    boolean cur_guest; //true when with customer, false without

    int price;
    int additional_price_perKM;
    UUID taxi_uniqueID;
    int cur_gas;
    int cur_speed;
    boolean taxi_status; //true when driving, false going back to garage

    String destination;
    int destination_KM;

    public Taxi(){
        cur_guest=false;
        price=2000;
        taxi_uniqueID = UUID.randomUUID();
        cur_gas=100;
        cur_speed=0;
        taxi_status = true; //true when driving, false going back to garage
        System.out.printf("버스 ID <%s> 가 생성되었습니다.%n", taxi_uniqueID);
    }
    public void Drive(boolean status){
        taxi_status = status;
        if (taxi_status ==false){
            cur_gas = 100;
            cur_guest = false;
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
        if (taxi_status ==false){
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

    public void AddGuest(String customer_destination, int customer_destination_KM) {
        if (taxi_status == false) {
            System.out.println("차량이 차고지에 있습니다. 먼저 Drive로 운행을 시작해주세요.");
        } else if (cur_guest = true) {
            System.out.println("이미 승객이 탑승하고 있어 다른 승객 탑승이 어렵습니다.");
        } else {
            cur_guest = true;
            destination = customer_destination;
            destination_KM = customer_destination_KM;
        }
    }

    public static void main(String[] args){
        com.example.taxi.Taxi taxi = new Taxi();
        System.out.println(taxi.taxi_uniqueID);
    }
}
