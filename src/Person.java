public class Person {
    //Information of the paying guest
    private String firstName;
    private String lastName;
    private String creditCardNo;

    public Person(String firstName, String lastName, String creditCardNo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardNo = creditCardNo;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }


    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }
}
