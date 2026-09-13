public class BookCW{
    private long id;
    private String title;
    private String author;
    private int year;

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

    public String getDeScription(){
        return "\"" + title + "\" - " + author + " (" + year + ")";
    }
}