public class Book extends Library {
    private final String name;
    private boolean borrowingStatus;
    public Book(String name){
        this.name= name;
        this.borrowingStatus = false;
    }
    public String getName() {
        return name;
    }
    public boolean isBorrowingStatus(){
        return borrowingStatus;
    }
    public void setBorrowingStatus(boolean status){
        this.borrowingStatus=status;
    }
}
