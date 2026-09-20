package lab2;

public class GameHW {
    private long id;
    private String title;
    private String genre;
    private double rating;
    private double price;

    private static int counter = 0;  // счётчик созданных объектов

    public GameHW(){
        this(0, "Без названия", "Неизвестен", 0 , 0);

    }

    public GameHW(long id, String title,  String genre, double rating, double price){
        this.id = ++counter;
        setTitle(title);
        setGenre(genre);
        setRating(rating);
        setPrice(price);
    }

    public GameHW( String title,  String genre, double rating, double price){
        setTitle(title);
        setGenre(genre);
        setRating(rating);
        setPrice(price);
    }

    public GameHW(String title,  String genre, double rating){
        setTitle(title);
        setGenre(genre);
        setRating(rating);
    }
    
    public GameHW(long id, String title, String genre){
        this(0, title, genre, 10.0, 21);
    }

    public GameHW(long id){
        this(0, "Неизестно", "Неизвестен");
    }

    public GameHW(String title, String genre){
        this(title, genre, 10.0);
    }
    
    public static int getCounter(){
        return counter;
    }

    public static GameHW createGame(String title, String genre, int price){
        System.out.println("Фабрика создала новую игру: " + title); 
        return new GameHW(0, title, genre, 8.7, price);
    }

    
    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.title = title;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Жанр есть всегда");
        }
        this.genre = genre;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0.0 || rating > 10.0) {
            throw new IllegalArgumentException("Рейтинг введи");
        }
        this.rating = rating;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Бесплатный сыр только в мышеловке");
        }
       this.price = price;
    }

    public String getDescription(){
        return "Игра " + "\"" + title + "\"" + "(" + "жанр:" + genre + " ," + "рейтинг " + rating + ") " + "- " + price + " руб";  
    }

    public String getDescription(boolean smallname){
        if(smallname)
            return "Игра " + "\"" + title + "\"" + " жанр: " + genre;
        else
            return getDescription(); 
    }

    public double calculateDiscount() {
        return this.price * 0.9; 
    }

    public double calculateDiscount(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100%");
        }
        double multiplier = 1 - (discountPercent / 100.0);
        return this.price * multiplier;
    }
}
