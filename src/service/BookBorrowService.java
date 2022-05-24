package service;

import entity.Book;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Reader;

import java.util.Scanner;

import static service.BookService.creatBookOfOrderDetail;
import static service.ReaderService.creatReaderOfOrder;

public class BookBorrowService {
    public static BookBorrow[] ORDERS = new BookBorrow[100];

    public static void creatLibrary() {
        System.out.print("Xin mời nhập số lượng bạn đọc muốn mượn sách: ");
        int readerBorrowBookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerBorrowBookNumber; i++) {
            System.out.println("Xin mời nhập thông tin mượn sách của bạn đọc thứ " + (i + 1));
            saveOrderToLibrary(creatOneOrder());
        }
    }

    public static BookBorrow creatOneOrder() {
        Reader reader = creatReaderOfOrder();
        BookBorrowDetail[] ORDER_BOOK_DETAILS = new BookBorrowDetail[100];
        System.out.print("Nhập số lượng đầu sách mà bạn đọc muốn mượn: ");
        int number = 0;
        while (true) {
            number = new Scanner(System.in).nextInt();
            if (number < 6 && number > 0)
                break;
            System.out.print("Mỗi bạn đọc chỉ được mượn tối đa 5 đầu sách, xin mời nhập lại: ");
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Xin mời nhập thông tin của đầu sách thứ " + (i + 1));
            creatAndSaveOneOrderDetail(ORDER_BOOK_DETAILS);
        }
        return new BookBorrow(reader, ORDER_BOOK_DETAILS);
    }

    public static void saveOrderToLibrary(BookBorrow bookBorrow) {
        for (int j = 0; j < ORDERS.length; j++) {
            if (ORDERS[j] == null) {
                ORDERS[j] = bookBorrow;
                break;
            }
        }
    }

    public static void creatAndSaveOneOrderDetail(BookBorrowDetail[] ORDER_BOOK_DETAILS) {
        Book book = creatBookOfOrderDetail();
        System.out.print("Xin mời nhập số quyển sách muốn mượn: ");
        int bookQuantity = 0;
        while (true) {
            bookQuantity = new Scanner(System.in).nextInt();
            if (bookQuantity < 4 && bookQuantity > 0)
                break;
            System.out.print("Mỗi đầu sách chỉ được mượn tối đa 3 quyển, xin mời nhập lại: ");
        }
        BookBorrowDetail bookBorrowDetail = new BookBorrowDetail(book, bookQuantity);
        for (int k = 0; k < ORDER_BOOK_DETAILS.length; k++) {
            if (ORDER_BOOK_DETAILS[k] == null) {
                ORDER_BOOK_DETAILS[k] = bookBorrowDetail;
                break;
            }
        }
    }

    public static void showBookBorrow() {
        System.out.println("--------------------------------------");
        System.out.println("Danh sách mượn sách của hệ thống là:");
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null) {
                System.out.println("Bạn đọc " + ORDERS[i].getReader().getName() + " mượn các đầu sách: ");
                for (int j = 0; j < ORDERS[i].getOrderBookDetails().length; j++) {
                    if (ORDERS[i].getOrderBookDetails()[j] != null)
                        System.out.println(ORDERS[i].getOrderBookDetails()[j]);
                }
            }
        }
    }

    public static void sortLibraryFollowReaderName() {
        for (int i = 0; i < ORDERS.length; i++) {
            for (int j = i + 1; j < ORDERS.length; j++) {
                if (ORDERS[i] != null && ORDERS[j] != null && ORDERS[i].getReader().getName().compareTo(ORDERS[j].getReader().getName()) > 0) {
                    BookBorrow temp;
                    temp = ORDERS[i];
                    ORDERS[i] = ORDERS[j];
                    ORDERS[j] = temp;
                }
            }
        }
    }

    public static void sortLibraryFollowBookQuantity() {
        for (int i = 0; i < ORDERS.length; i++) {
            for (int j = i + 1; j < ORDERS.length; j++) {
                if (ORDERS[i] != null && ORDERS[j] != null && ORDERS[i].getBookquantity() > ORDERS[j].getBookquantity()) {
                    BookBorrow temp;
                    temp = ORDERS[i];
                    ORDERS[i] = ORDERS[j];
                    ORDERS[j] = temp;
                }
            }
        }
    }

    public static void searchReaderName() {
        System.out.print("Xin mời nhập tên bạn đọc muốn tìm kiếm : ");
        String name = new Scanner(System.in).nextLine();
        int count = 0;
        for (int i = 0; i < ORDERS.length; i++) {
            if (ORDERS[i] != null & ORDERS[i].getReader().getName().compareTo(name) == 0) {
                System.out.println("Kết quả là");
                System.out.println("Bạn đọc " + ORDERS[i].getReader().getName() + " mượn các đầu sách: ");
                for (int j = 0; j < ORDERS[i].getOrderBookDetails().length; j++) {
                    if (ORDERS[i].getOrderBookDetails()[j] != null)
                        System.out.println(ORDERS[i].getOrderBookDetails()[j]);
                }
                count = 1;
                break;
            }
        }
        if (count == 0)
            System.out.println("Tên vừa nhập không tồn tại trong danh sách thư viện Quản lý mượn sách");
    }
}
