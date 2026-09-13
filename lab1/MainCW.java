
public class MainCW {
    public static void main(String[] args){
        BookCW book1 = new BookCW();
        book1.setTitle("Преступление и наказание");
        book1.setAuthor("Достоевский");
        book1.setYear(1854);
        System.out.println(book1.getDeScription());
        
        BookCW book2 = new BookCW();
        book2.setTitle("Война и мир");
        book2.setAuthor("Толстой");
        book2.setYear(1821);
        System.out.println(book2.getDeScription());

        BookCW book3 = new BookCW();
        book3.setTitle("Капитанская дочка");
        book3.setAuthor("Пушкин");
        book3.setYear(1721);
        System.out.println(book3.getDeScription());
    }
}