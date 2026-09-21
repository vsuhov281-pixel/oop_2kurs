package lab3;

public class publication {
    protected String title;
    protected String publisher;
    protected int year;

    public publication(String title, String publisher, int year){
        setTitle(title);
        setPublisher(publisher);
        setYear(year);
    }

    public void setTitle(String title){
        if(title == null || title.isBlank())
            throw new IllegalArgumentException("Название должно быть");
        this.title = title;
    }

    public void setPublisher(String publisher){
        if(publisher == null || publisher.isBlank())
            throw new IllegalArgumentException("Название должно быть");
        this.publisher = publisher;
    }

    public void setYear(int year){
        if(year < 0 || year > 2026)
            throw new IllegalArgumentException("Шо ты пишешь");
        this.year = year;
    }

    public String read(){
        return "Издание: \"" + title + "\", автор: " + publisher + ", год создания: " + year;
    }
}