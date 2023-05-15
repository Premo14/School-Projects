public class Contact {

    private String firstName, lastName, address, phoneNum, uniqueID = "";

    public Contact() {}


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString(){
        String contactCard;

        contactCard = uniqueID + "\n" +
                firstName +  " " + lastName + "\n" +
                address + "\n" +
                phoneNum + "\n";

        return contactCard;
    }
}