import java.util.Date;

public class loanHistoryModel {
    private int loan_id;
    private int book_id;
    private int visitor_id;
    private String visitorName;
    private String visitorReference;
    private Date borrowed_date;
    private Date returned_date;
    private Boolean is_available;

    public int getLoan_id() {
        return loan_id;
    }
    public int getBook_id(){
        return book_id;
    }
    public int getVisitor_id(){
        return visitor_id;
    }
    public String getVisitorName() {
        return visitorName;
    }
    public String getVisitorReference() {
        return visitorReference;
    }
    public Date getBorrowed_date() {
        return borrowed_date;
    }
    public Date getReturned_date() {
        return returned_date;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public loanHistoryModel(int loan_id, int book_id, int visitor_id, String visitorName, String visitorReference, Date borrowed_date, Date returned_date, Boolean is_available) {
        this.loan_id = loan_id;
        this.book_id = book_id;
        this.visitor_id = visitor_id;
        this.visitorName = visitorName;
        this.visitorReference = visitorReference;
        this.borrowed_date = borrowed_date;
        this.returned_date = returned_date;
        this.is_available = is_available;
    }
}

