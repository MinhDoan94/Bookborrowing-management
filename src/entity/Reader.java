package entity;

import constant.Type_Reader;

import java.util.Scanner;

public class Reader extends Person {

    public static int AUTO_ID = 10000;


    public Type_Reader typeReader;

    public Reader() {
        this.id = AUTO_ID++;
    }

    public Reader(String name, String phone, String address, Type_Reader typeReader) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.typeReader = typeReader;
    }



    public Type_Reader getTypeReader() {
        return typeReader;
    }

    public void setTypeReader(Type_Reader typeReader) {
        this.typeReader = typeReader;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", typeReader=" + typeReader +
                '}';
    }
    public void inputInfor(){
        super.inputInfor();
        this.inputReaderType();
    }
    public void inputReaderType() {

        System.out.print("Xin mời nhập loại bạn đọc, chọn một trong các lựa chọn dưới đây : ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giáo viên");
        int number = 0;
        while (true) {
            number = new Scanner(System.in).nextInt();
            if (number > 0 && number < 4)
                break;
            System.out.print("Bạn nhập sai rồi, xin mời bạn nhập lại: ");
        }
        switch (number) {
            case 1:
                this.setTypeReader(Type_Reader.SINH_VIEN);
                break;
            case 2:
                this.setTypeReader(Type_Reader.HOC_VIEN_CAO_HOC);
                break;
            case 3:
                this.setTypeReader(Type_Reader.GIAO_VIEN);
                break;
        }
    }
}
