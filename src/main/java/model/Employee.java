package model;

public class Employee {


    private int id;

    private String name;

    private String email;

    private String password;

    private String receipt_type;

    private  String status ;

    private int amount ;



    private int request_id;





    public Employee(){}



    public Employee(int id, String email, String name, String password, String receipt_type, String status, int amount,int request_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
        this.receipt_type= receipt_type;
        this.status= status;
        this.amount=amount;
        this.request_id=request_id;
    }





    public Employee(int id, String email, String name, String password, String receipt_type, String status, int amount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
        this.receipt_type= receipt_type;
        this.status= status;
        this.amount=amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReceipt_type() {
        return receipt_type;
    }

    public void setReceipt_type(String receipt_type) {
        this.receipt_type = receipt_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }
}
