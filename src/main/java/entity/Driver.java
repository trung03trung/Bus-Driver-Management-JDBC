package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Driver extends Person implements Serializable {
    private static final String A="A";
    private static final String B="B";
    private static final String C="C";
    private static final String D="D";
    private static final String E="E";
    private static final String F="F";

    private static int autoID=10000;
    private String level;

    public Driver() {
    }

    public Driver(int id, String name, String address, String phoneNum, String level) {
        super(id, name, address, phoneNum);
        this.level = level;
    }
    public void setID(){
        this.id=Driver.autoID++;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public void inputInfor() {
        Scanner sc=new Scanner(System.in);
        super.inputInfor();
        System.out.println("Nhập trình độ lái xe là 1 trong các lựa chọn dưới đây: ");
        char[] b=new char[7];
        char a='A';
       for(int i=1;i<=6;i++){
           System.out.println(i+"."+(char)a);
           a+=1;


       }
       int choice;
       do {
           try {
               choice=Integer.parseInt(sc.next());
               if(choice>=1&&choice<=6)
                   break;
               System.out.print("Chỉ nhập từ 1 đến 6 vui lòng nhập lại: ");
           }catch (NumberFormatException e){
               System.out.print("Chỉ nhập số nguyên dương vui lòng nhập lại: ");
           }


       }while (true);
       switch (choice){
           case 1:level=A;
           break;
           case 2:level=B;
           break;
           case 3:level=C;
           break;
           case 4:level=D;
           break;
           case 5:level=E;
           break;
           case 6:level=F;
       }

    }

    @Override
    public String toString() {
        return "Driver{" +
                "level='" + level + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
