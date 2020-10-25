import java.util.Scanner;

enum vehicletype{
    COMPACTTYPE,MOTORBIKETYPE,ELECTRICTYPE,HANDICAPPEDTYPE,TRUCKTYPE
}
abstract class PaymentSystem {
    int calculateFee(){
        //we need to calculate time here only i guess.
        return 0;
    }
    abstract void pay();

}
abstract class customerInfoPortal extends PaymentSystem{
    int fee=calculateFee();
    abstract void seeDetails();
}

class Ticket{
    int floor;
    int spotNo;
    String entryTime;//try giving a specific input pattern and repeat process until valid input;
    int ticketNo; //Helps to track customer no, and gives an idea abt Tickets sold
    public Ticket(int Floor,int SpotNo,String EntryTime,int TicketNo) {
        this.floor=Floor;
        this.spotNo=SpotNo;
        this.entryTime=EntryTime;
        this.ticketNo=TicketNo;
    }

}
public class Customer extends customerInfoPortal{
    Scanner in=new Scanner(System.in);
    boolean paid=false;
    String name,address;
    int age;
    private vehicletype v;
    String LicensePlate;
    Systems obj=new Systems();
    private void inputVehicleType(){
        int x;
        System.out.println("Please choose your vehicleType: " +
                "enter 1 for compacttype,2 for motorbike,3 for electric,4 for handicapped,5 for truck");
        x=in.nextInt();
        switch (x){
            case 1:{
                v=vehicletype.COMPACTTYPE;
                break;
            }
            case 2:{
                v=vehicletype.MOTORBIKETYPE;
                break;
            }
            case 3:{
                v=vehicletype.ELECTRICTYPE;
                break;
            }
            case 4:{
                v=vehicletype.HANDICAPPEDTYPE;
                break;
            }
            case 5:{
                v=vehicletype.TRUCKTYPE;
                break;
            }
            default:{
                System.out.println("Please Enter a Valid Input!!");
            }
        }
    }
    public void inputCustomerDetails(){
        System.out.println("Enter Name, Age, Address and License Plate");
        name=in.nextLine();
        in.nextLine();
        age=in.nextInt();
        address=in.nextLine();
        LicensePlate=in.nextLine();
        inputVehicleType();
    }

    @Override
    void seeDetails() {
        System.out.println("Customer Name: "+name+" Age: "+age+ " Address: "+ address+" VehicleType: "+v
                +" License Plate: "+LicensePlate);
    }

    Ticket getTicket(){//probably spotType as a parameter.
        return obj.giveTicket(v);
    }
    vehicletype getvehicletype(){
        return this.v;
    }
    void park(Ticket a){ //We obtain ticket probably from systems class only.
        System.out.println("Car Parked in Floor "+ a.floor+" in spotNo "+ a.spotNo+ " ");

    }
    void unPark(Ticket a){
        System.out.println("Vehicle Parked in Floor "+ a.floor+" in spotNo "+ a.spotNo+ " is removed.");
    }
    @Override
    void pay() {
        int a;
        int fees=calculateFee();
        System.out.print("The following Options are Available: \n" +
                "1)Pay Using Customer info Portal via credit card \n" +
                "2)Pay To the parking Attendant\n" +
                "3)Pay at exitGate via Credit Card\n" +
                "Please choose your option: ");
        a=in.nextInt();
        switch (a){
            case 1:{
                System.out.println("Pay amount "+fees+" via credit Card using customer portal");
                break;
            }
            case 2:{
                System.out.println("Pay amount "+fees+" via cash to parking attendant");
                break;
            }
            case 3:{
                System.out.println("Pay amount "+fees+" via credit Card at exit Gate");
                break;
            }
            default:{
                System.out.println("Please Give a valid Input!");
            }
        }
    }


}