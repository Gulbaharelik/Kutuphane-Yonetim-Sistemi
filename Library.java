import java.util.ArrayList;

public class Library {
    private static final ArrayList<Book> books = new ArrayList<>();
    static final ArrayList<Member> members = new ArrayList<>();
    private static final ArrayList<Officer> officers = new ArrayList<>();
    private static final ArrayList<BorrowedBook> borrowedBooks = new ArrayList<>();

    public static void bookAdd(String name){
        Book newBook = new Book(name);
        books.add(newBook);
    }
    public static boolean bookRemove(String name){
        for (Book book : books){
            if (book.getName().equals(name)){
                books.remove(book);
                break;
            }
        }
        return false;
    }
    public static void bookList() {
        System.out.println("Books found in the library:");
        for (Book book : books) {
            System.out.println("Book Name: " + book.getName() + ", Borrowing Status: " + book.isBorrowingStatus());
        }
    }
    public static void memberAdd(String name){
        Member newMember = new Member(name);
        members.add(newMember);
    }
    public static boolean memberRemove(String name){
        for (Member member : members){
            if(member.getName().equals(name)){
                members.remove(member);
                break;
            }
        }
        return false;
    }
    public static void memberList() {
        System.out.println("Registered members of the library:");
        for (Member member : members) {
            System.out.println("Member Name: " + member.getName());
        }
    }
    public static void officerAdd(String name){
        Officer newOfficer = new Officer(name);
        officers.add(newOfficer);
    }
    public static boolean officerRemove(String name){
        for (Officer officer : officers){
            if (officer.getName().equals(name)){
                officers.remove(officer);
                break;
            }
        }
        return false;
    }
    public static void officerList() {
        System.out.println("The people in charge at the library:");
        for (Officer officer : officers) {
            System.out.println("Officer Name: " + officer.getName());
        }
    }
    public static void borrowedBookAdd(String bookName,String memberName){
        Book book = null;
        Member member = null;

        for (Book b: books){
            if(b.getName().equals(bookName)){
                book = b;
                break;
            }
        }
        for (Member m: members){
            if (m.getName().equals(memberName)){
                member = m;
                break;
            }
        }
        if (book != null && member != null){
            BorrowedBook borrow = new BorrowedBook(book,member);
            borrowedBooks.add(borrow);
            book.setBorrowingStatus(true);
            System.out.println(bookName + " book was loaned to " +memberName +" member.");
        }else{
            System.out.println("No books or members found.");
        }
    }
    public static void borrowedBookTakeItBack(String bookName ,String memberName){
        for (BorrowedBook borrow: borrowedBooks){
            Book book = borrow.getBook();
            Member member= borrow.getMember();

            if (book.getName().equals(bookName) && member.getName().equals(memberName)){
                borrowedBooks.remove(borrow);
                book.setBorrowingStatus(false);
                System.out.println(bookName +" book was taken from " + memberName +" member.");
                return;
            }
        }
    }
    public static void listBorrowedBooks() {
        System.out.println("Borrowed books:");
        for (BorrowedBook borrowedBook : borrowedBooks) {
            Book book = borrowedBook.getBook();
            Member member = borrowedBook.getMember();
            System.out.println("Book: " + book.getName() + ", Borrowing member: " + member.getName());
        }
    }
    public static void viewTheBorrowedOnes(){
        System.out.println("Books currently on loan:");

        for (BorrowedBook borrow : borrowedBooks){
            System.out.println("Book : "+borrow.getBook().getName() +",Member: "+borrow.getMember().getName());
        }
    }
}
