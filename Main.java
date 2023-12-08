import java.util.Scanner;

// Gülbahar Elik
// 1220505035

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continues = true;

        while (continues){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Please,select the operation you want to perform: ");
            System.out.println("");
            System.out.println("1.Adding books to the library");
            System.out.println("2.Don't take a book out of the library");
            System.out.println("3.Adding a new member to the library");
            System.out.println("4.Do not remove a member from the library");
            System.out.println("5.Adding a new staff member to the library");
            System.out.println("6.Don't take an attendant out of the library");
            System.out.println("7.Lending a book to a member");
            System.out.println("8.Do not return a compromised book from a member to the library");
            System.out.println("9.View the books that are currently being borrowed");
            System.out.println("10.List of added books");
            System.out.println("11.List of added members");
            System.out.println("12.List of added officers");
            System.out.println("13.Exit");
            System.out.println("");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter the name of the book you want to add: ");
                    String bookName = scanner.nextLine();
                    Library.bookAdd(bookName);
                    System.out.println(bookName + " added to the library.");
                    System.out.println("");
                    Library.bookList();
                    break;
                case 2:
                    System.out.print("Enter the name of the book you want to delete: ");
                    String theBookYouWantToRemove = scanner.nextLine();
                    boolean isBookRemoved=Library.bookRemove(theBookYouWantToRemove);
                    if(!Library.bookRemove(theBookYouWantToRemove)){
                        System.out.println(theBookYouWantToRemove + " was taken out of the library.");
                    }else{
                        System.out.println("This book could not be found in the library.");
                    }
                    System.out.println("");
                    Library.bookList();
                    break;
                case 3:
                    System.out.print("Enter the name of the member you want to be added: ");
                    String memberName= scanner.nextLine();
                    Library.memberAdd(memberName);
                    System.out.println(memberName + " added to the library.");
                    System.out.println("");
                    Library.memberList();
                    break;
                case 4:
                    System.out.print("Enter the name of the member you want to remove: ");
                    String memberYouWantToRemove = scanner.nextLine();
                    boolean isMemberRemoved=Library.memberRemove(memberYouWantToRemove);
                        if (!Library.memberRemove(memberYouWantToRemove)) {
                            System.out.println(memberYouWantToRemove + " was taken out of the library.");
                        } else {
                        System.out.println("There is no such member in the library.");
                    }
                    System.out.println("");
                    Library.memberList();
                    break;
                case 5:
                    System.out.print("Enter the name of the employee you want to add: ");
                    String officerName= scanner.nextLine();
                    Library.officerAdd(officerName);
                    System.out.println(officerName + " was added to the library as an employee.");
                    System.out.println("");
                    Library.officerList();
                    break;
                case 6:
                    System.out.print("Enter the name of the official you want to remove: ");
                    String staffYouWanTToRemove = scanner.nextLine();
                    boolean isOfficerRemove=Library.officerRemove(staffYouWanTToRemove);
                    if(!Library.officerRemove(staffYouWanTToRemove)){
                        System.out.println(staffYouWanTToRemove + " was removed from the library as an officer.");
                    }else{
                        System.out.println("This officer cannot be found in the library");
                    }
                    System.out.println("");
                    Library.officerList();
                    break;
                case 7:
                    System.out.print("Enter the name of the book you want to lend: ");
                    String borrowBookName = scanner.nextLine();
                    System.out.print("Enter the name of the member you want to lend to: ");
                    String borrowMemberName = scanner.nextLine();
                    Library.borrowedBookAdd(borrowBookName,borrowMemberName);
                    System.out.println("");
                    Library.listBorrowedBooks();
                    break;
                case 8:
                    System.out.print("Enter the name of the book you want to get back: ");
                    String takeBackBookName= scanner.nextLine();
                    System.out.print("Enter the name of the member you want to take back: ");
                    String takeBackMemberName = scanner.nextLine();
                    Library.borrowedBookTakeItBack(takeBackBookName,takeBackMemberName);
                    System.out.println("");
                    break;
                case 9:
                    Library.viewTheBorrowedOnes();
                    System.out.println("");
                    break;
                case 10:
                    Library.bookList();
                    break;
                case 11:
                    Library.memberList();
                    break;
                case 12:
                    Library.officerList();
                    break;
                case 13:
                    continues = false;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}