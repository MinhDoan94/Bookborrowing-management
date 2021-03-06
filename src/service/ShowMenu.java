package service;

import java.util.Scanner;

import static service.BookService.inputBook;
import static service.BookService.showBook;
import static service.BookBorrowService.*;
import static service.ReaderService.inputReader;
import static service.ReaderService.showReader;

public class ShowMenu {
    public static void ShowMenu() {
        while (true) {
            int functionChoice = getFunctionChoice();
            switch (functionChoice) {
                case 1:
                    inputBook();
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    inputReader();
                    break;
                case 4:
                    showReader();
                    break;
                case 5:
                    creatLibrary();
                    showBookBorrow();
                    break;
                case 6:
                    sortLibraryFollowReaderName();
                    showBookBorrow();
                    break;
                case 7:
                    sortLibraryFollowBookQuantity();
                    showBookBorrow();
                    break;
                case 8:
                    searchReaderName();
                    break;
                case 9:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
            }
        }
    }


    private static int getFunctionChoice() {
        System.out.println("__________QUẢN LÝ SÁCH THƯ VIỆN____________");
        System.out.println("1. Nhập danh sách đầu sách mới.");
        System.out.println("2. In ra danh sách đầu sách trong thư viện.");
        System.out.println("3. Nhập danh sách bạn đọc mới.");
        System.out.println("4. In ra danh sách bạn đọc trong thư viện.");
        System.out.println("5. Lập bảng quản lý mượn sách và in danh sách ra màn hình");
        System.out.println("6. Sắp xếp danh sách Quản lý mượn sách theo tên bạn đọc và in danh sách ra màn hình ");
        System.out.println("7. Sắp xếp danh sách Quản lý mượn sách theo Số lượng cuốn sách được mượn giảm dần và in danh sách ra màn hình.");
        System.out.println("8. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc ");
        System.out.println("9. Thoát chương trình.");
        System.out.print("Xin mời bạn lựa chọn giá trị:");
        int functionChoice = 0;
        while (true) {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice > 0 && functionChoice < 10)
                break;
            System.out.print("Bạn nhập sai rồi, xin mời bạn nhập lại: ");
        }
        return functionChoice;
    }
}

