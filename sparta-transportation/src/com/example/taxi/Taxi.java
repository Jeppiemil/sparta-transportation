package com.example.taxi;

import com.example.publictransportation.PublicTransportation;

public class Taxi extends PublicTransportation {
    static int count;
    int uniqueID;
    int drive_status;
    String destination;
    int destination_km;
    int default_km;
    int default_price;
    int additional_price;
    int total_payment;
    int total_income;
    int max_guest;
    int cur_guest;
    int cur_gas;


    public Taxi(){
        count += 1;
        this.uniqueID = count;
        this.default_km = 1;
        this.default_price = 3000;
        this.additional_price = 1000;
        this.drive_status=1;
        this.max_guest = 4;
        this.cur_guest = 0;
        this.total_income =0;
        this.cur_gas = 100;
        System.out.printf("현재 상태는 %d, 주유량은 %d 입니다.%n", this.drive_status, this.cur_gas);
    }

    public void ChangeGuest(int count, String guest_destination, int guest_km){
        if (drive_status == 0){
            System.out.println("이미 승객이 타고 있습니다.");
        } else if (max_guest < count){
            System.out.println("최대 승객 수 초과로 탑승할 수 없습니다.");
        } else {
            this.drive_status = 0;
            this.cur_guest += count;
            this.destination = guest_destination;
            this.destination_km = guest_km;
            this.total_payment = this.default_price + (this.destination_km - this.default_km) * this.additional_price;
            this.total_income += this.total_payment;
            System.out.printf("%d명 탑승하여 잔여 승객 수는 %d%n", this.cur_guest, this.max_guest - this.cur_guest);
            System.out.printf("목적지는 %s으로 %dkm 떨어져 있어 기본요금 %d에 추가요금이 붙어 %d원을 지불하셔야 합니다.%n", this.destination, this.destination_km, this.default_price, this.total_payment);
            System.out.printf("%d번 차량 운행 시작합니다.%n",this.uniqueID);

        }
    }

    public void LeaveGuest(){
        System.out.printf("목적지에 도달했습니다. 총 요금은 %d원 입니다. ", this.total_payment);
        this.drive_status = 1;
        this.cur_guest = 0;
        this.total_payment = 0;
        this.destination = "";
        this.destination_km = 0;
        System.out.printf("현재까지 벌어들인 누적요금은 총 %d원 입니다.%n", this.total_income);
        Drive(1, 0);
    }

}
