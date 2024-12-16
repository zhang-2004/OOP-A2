public class Visitor extends Person{    //主题公园游客

    private String id;
    private String ticketType;  //票类型
    private String ticketDate;//票日期  格式：2024-12-10
    private String item;
    private String Phone;


    public Visitor() {
    }

    public Visitor(String name, String gender, int age, String ticketType, String ticketDate,String item,String id,String Phone) {
        super(name, gender, age);
        this.ticketType = ticketType;
        this.ticketDate = ticketDate;
        this.item = item;
        this.id = id;
        this.Phone = Phone;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getIdem() {
        return item;
    }

    public void setIdem(String idem) {
        this.item = idem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Visitor:"+ super.toString() + "\t" + ticketType + "\t" + ticketDate+"\t" + item+"\t" + id+"\t" + Phone;
    }
}
