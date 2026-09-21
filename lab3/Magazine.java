package lab3;

public class Magazine extends publication{
    private int issueNumber;
    public Magazine(String title, String publisher, int year, int issueNumber){
        super(title, publisher, year);
        setIssueNumber(issueNumber);
    }

    public void setIssueNumber(int issueNumber){
        if(issueNumber < 0)
            throw new IllegalArgumentException("Номер выпуска должен быть больше 0");
        this.issueNumber = issueNumber;
    }

    @Override 
    public String read(){
        return super.read() + " номер выпуска: " +  issueNumber  +  " - это журнал";
    }
}