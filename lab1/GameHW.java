public class GameHW {
    private long id;
    private String title;
    private String genre;
    private double rating;
    private double price;
    
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
}
