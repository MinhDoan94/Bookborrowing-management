package entity;

import java.util.Scanner;

public class Person implements inputable {
    protected int id;
    protected String name;
    protected String phone;
    protected String address;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfor() {
        System.out.print("Nhập tên bạn đọc: ");
        this. setName(new Scanner(System.in).nextLine());
        System.out.print("Xin mời nhập địa chỉ của bạn đọc: ");
        this. setAddress(new Scanner(System.in).nextLine());
        System.out.print("Xin mời nhập số điện thoại của bạn đọc: ");
        this. setPhone(new Scanner(System.in).nextLine());
    }
}
