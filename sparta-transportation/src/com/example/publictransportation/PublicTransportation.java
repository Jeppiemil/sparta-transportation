package com.example.publictransportation;
public class PublicTransportation {
    static int count;
    int default_price;
    int uniqueID;
    int cur_gas;
    int cur_speed;
    int max_guest;
    int cur_guest;
    int drive_status; //1 when driving, 0 when normal, -1 going back to garage

    public PublicTransportation(){

        count += 1;
        this.default_price=1000;
        this.max_guest=30;
        this.cur_guest=0;
        this.uniqueID = count;
        this.cur_gas=100;
        this.cur_speed=0;
        this.drive_status=1; //true when driving, false going back to garage
        System.out.printf("교통수단 ID <%s> 가 생성되었습니다.%n", this.uniqueID);
    }
    public void Drive(int status, int gas_consumption){
        this.cur_gas -= gas_consumption;
        this.drive_status = status;
        if (this.drive_status == -1){
            this.cur_guest = 0;
            System.out.printf("%d번 차량이 차고지로 이동합니다. 주유량 %d.%n", this.uniqueID, this.cur_gas);
        } else {
            System.out.printf("%d번 차량 운행합니다. 주유량 %d.%n", this.uniqueID, this.cur_gas);
        }
        if (this.cur_gas < 10 && this.cur_gas > 0){
            System.out.println("주유량 10 미만. 주유가 필요합니다");
        } else if (this.cur_gas <= 0) {
            System.out.println("주유량 0. 주유가 긴급히 필요합니다.");
        };

    }
    public void ChangeSpeed(int speed_delta){
        if (this.drive_status == -1){
            System.out.println("차량이 차고지에 있습니다. 먼저 운행을 시작해주세요.");
        }
        else if (this.cur_gas < 10){
            System.out.println("주유량 10 미만으로 속도 변경이 불가합니다. 주유량을 확인하세요.");
        } else {
            this.cur_speed += speed_delta;
            if (this.cur_speed < 0) {
                this.cur_speed = 0;
                System.out.println("속도를 모두 줄여 차량이 정지합니다.");
            } else {
                System.out.printf("속도 변경을 완료했습니다. 변경된 현재 속도는 %d입니다.%n", this.cur_speed);
            }
        }
    }

    public void ChangeGuest(int count) {
        if (this.drive_status == -1) {
            System.out.println("차량이 차고지에 있습니다. 먼저 운행을 시작해주세요.");
        } else if (this.max_guest < this.cur_guest + count) {
            System.out.printf("최대승객수인 %d명 이상으로 탑승을 시도하여 탑승 불가합니다.%n", this.max_guest);
        } else if (this.cur_guest + count < 0) {
            System.out.printf("현재 승객 수인 %d보다 더 많은 사람을 내리게 했습니다. 모든 승객이 내린 것으로 보아, 현재 승객 수는 0입니다.%n", this.cur_guest);
            this.cur_guest = 0;
        } else {
            this.cur_guest += count;
            if (count >= 0) {
                System.out.printf("%d명 탑승하여 현재 승객 %d명, 잔여 승객 %d명 입니다.", count, this.cur_guest, this.max_guest - this.cur_guest);
                System.out.printf("총 금액은 %d원 입니다.%n", count*this.default_price);
            } else {
                System.out.printf("%d명 하차하여 현재 승객 %d명 입니다%n", count, this.cur_guest);
            }

        }
    }

    public void main(String[] args){

    }
}
