package lab2;

public class MainCW {
    public static void main(String[] args){
        BookCW book1 = new BookCW("Гарри Поттер", 1999);
        System.out.println("Книга в коротком формате, без счетчика: " + book1.getDescription(true));
        BookCW book2 = new BookCW(0, "фнаф", "я");
        System.out.println("Книга в полном формате: " + book2.getDescription());
        BookCW book3 = new BookCW(0);
        System.out.println("Книга без параметров: " + book3.getDescription());
        BookCW book4 =  BookCW.createBook("Гранатовый браслет","Куприн", 1890);
        System.out.println(book4.getDescription(true));
        BookCW book5 = new BookCW();
        System.out.println(book5.getDescription());
        System.out.println("Книг со счетчиком: " + BookCW.getCounter());
    }
}
