package entity;

public class BookBorrow {
    private Reader reader;
    private BookBorrowDetail[] bookBorrowDetails;

    public BookBorrow(Reader reader, BookBorrowDetail[] bookBorrowDetails) {
        this.reader = reader;
        this.bookBorrowDetails = bookBorrowDetails;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public BookBorrowDetail[] getOrderBookDetails() {
        return bookBorrowDetails;
    }

    public int getBookquantity(){
        int sum = 0;
        for (int i = 0; i < bookBorrowDetails.length; i++) {
            if (bookBorrowDetails[i]!=null)
                sum += bookBorrowDetails[i].getQuantity();
        }
        return sum;
    }
}

