package realEstate;

public class ListHouse implements Listable {
// House information

    private String lastName;
    private String firstName;
    private String lotNumber;
    private String price;
    private String squareFeet;
    private String bedRooms;
    
    public ListHouse(){}
    public void init(String lastName, String firstName, String lotNumber,
            String price, String squareFeet, String bedRooms) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.lotNumber = lotNumber;
        this.price = price;
        this.squareFeet = squareFeet;
        this.bedRooms = bedRooms;
    }

    @Override
    public void copy() // Returns a copy of this ListHouse
    {
      
    }

    @Override
    public void compareTo() // Houses are compared based on their lot numbers
    {
      
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getSquareFeet() {
        return squareFeet;
    }

    public String getBedRooms() {
        return bedRooms;
    }
}

interface Listable {

    public void copy();

    public void compareTo();

}
