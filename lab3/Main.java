package lab3;

public class Main {
    public static void main(String[] args){
        publication izdanie1 = new publication("Спортивные новости", "BBC", 2017);
        System.out.println("Вывод суперкласса: " + izdanie1.read());
        Book book = new Book("Преступление и наказание", "Достоевский", 1879, 359);
        System.out.println("Вывод подкласса: " + book.read());
        Magazine jurnal = new Magazine("О политике", "Первый канал", 2000, 54);
        System.out.println("Вывод подкласса: " + jurnal.read());
    }
}
