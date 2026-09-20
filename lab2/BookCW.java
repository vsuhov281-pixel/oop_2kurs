package lab2;

public class BookCW{
    private long id;
    private String title;
    private String author;
    private int year;
    private static int counter = 0;  // счётчик созданных объектов

    public BookCW(){
        this(0, "Без названия", "Неизвестен", 0);

    }

    public BookCW(long id, String title,  String author, int year){
        this.id = ++counter;
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public BookCW(String title,  String author, int year){
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public BookCW(String title,  String author){
        setTitle(title);
        setAuthor(author);
    }
    
    public BookCW(long id, String title, String author){
        this(0, title, author, 2001);
    }

    public BookCW(long id){
        this(id, "Неизвестен", "НОУНЕЙМ");
    }

    public BookCW(String title, int year){
        this( title, "Без автора", year);
    }
    
    public static int getCounter(){
        return counter;
    }

    public static BookCW createBook(String title, String author, int year){
        System.out.println("Фабрика создала новую книгу: " + title); 
        return new BookCW(0, title,author,year);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.title = title;
    }

    public String getAuthor(){
        return author;
    } 

    public void setAuthor(String author){
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("Атора не может не быть");
        }
        this.author = author;
    }

    public Integer getYear(){
        return year;
    }

    public void setYear(Integer year){
        if(year < 0 || year > 2026)
            throw new IllegalArgumentException("Шо ты пишешь");
        this.year = year;
    }

    public String getDescription(){
        return "\"" + title + "\" - " + author + " (" + year + ")";
    }

    public String getDescription(boolean shortFormat) {
        if (shortFormat) {
        return title + " (" + year + ")";
        }
        return getDescription();
    }
}