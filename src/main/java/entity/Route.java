package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Route implements Inputable, Serializable {
    private int id;
    private long distance;
    private int stopPoint;

    public Route() {
    }

    public Route(int id, long distance, int stopPoint) {
        this.id = id;
        this.distance = distance;
        this.stopPoint = stopPoint;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public int getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(int stopPoint) {
        this.stopPoint = stopPoint;
    }

    @Override
    public void inputInfor() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập khoảng cách: ");
        do{
            try {
                distance=Integer.parseInt(sc.next());
                if(distance>0)
                    break;
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }

        }while (true);
        System.out.print("Nhập số điểm dừng: ");
        do{
            try {
                stopPoint=Integer.parseInt(sc.next());
                if(stopPoint>0)
                    break;
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }catch (NumberFormatException e){
                System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
            }

        }while (true);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", distance=" + distance +
                ", stopPoint=" + stopPoint +
                '}';
    }
}
