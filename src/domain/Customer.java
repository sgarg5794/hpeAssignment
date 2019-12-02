package domain;

public class Customer {

    private String name;
    private String emailId;
    private String phoneNumber;

    public Customer(String name, String emailId, String phoneNumber) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void printCustomerDetails(){
        System.out.println("\tCustomerName:"+this.name);
        System.out.println("\tCustomerEmail:"+this.emailId);
        System.out.println("\tCustomerPhoneNumber:"+this.phoneNumber);


    }

}
