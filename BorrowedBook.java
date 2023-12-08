public class BorrowedBook extends Library{
    private final Book book;
    private final Member member;
    public BorrowedBook(Book book,Member member){
        this.book=book;
        this.member=member;
    }
    public Book getBook() {
        return book;
    }
    public Member getMember() {
        return member;
    }
}
