package lab3;

 public class Book extends publication{
        private int pagesCount;
        public Book(String title, String publisher, int year, int pagesCount){
            super(title, publisher, year);
            setPageCount(pagesCount);
        }

    public void setPageCount(int pageCount){
        if(pageCount < 0)
            throw new IllegalArgumentException("Страницы есть всегда!!!");
        this.pagesCount = pageCount;
    }

    @Override 
    public String read(){
        return super.read() + " количество страниц: " + pagesCount  + "- это книга";           
    }
}