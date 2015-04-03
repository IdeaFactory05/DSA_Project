package realestate;

public class ListHouse implements Listable{
    // House information

    private String lastName;
    private String firstName;
    private String lotNumber;
    private String price;
    private String squareFeet;
    private String bedRooms;
    
    public ListHouse(){}
    public ListHouse(String lastName, String firstName, String lotNumber,
            String price, String squareFeet, String bedRooms) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.lotNumber = lotNumber;
        this.price = price;
        this.squareFeet = squareFeet;
        this.bedRooms = bedRooms;
    }

    @Override
    public Listable copy() // Returns a copy of this ListHouse
    {
        ListHouse result = new ListHouse(lastName, firstName, lotNumber, price,
                squareFeet, bedRooms);
        return result;
    }

    @Override
    public int compareTo(Listable otherListHouse) // Houses are compared based on their lot numbers
    {
        ListHouse other = (ListHouse) otherListHouse;
        Integer.parseInt(this.lotNumber);
        return (Integer.parseInt(this.lotNumber) - Integer.parseInt(other.lotNumber));
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

    public Listable copy();

    public int compareTo(Listable otherListHouse);

}

