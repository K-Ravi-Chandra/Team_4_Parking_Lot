import java.util.Scanner;

enum vehicletype{
    COMPACTTYPE,MOTORBIKETYPE,ELECTRICTYPE,HANDICAPPEDTYPE,TRUCKTYPE
}
//Payment System deals with customer paying the Cash and calculating the amount...
//calculateFee method is not done for all cases (due to time constraint)...
abstract class PaymentSystem {
    int calculateFee(String time,String date){
        Scanner in=new Scanner(System.in);
        String date1=date;
        String time1=time;

        System.out.println("Enter date dd/mm/yy   and   time hh/mm  of exiting");
        String date2=in.next();
        String time2=in.next();


        //Calculating total time spent in parkingLot

        int dateDiff=(  date2.charAt(0)*10 + date2.charAt(1)  ) - (  date1.charAt(0)*10 + date1.charAt(1)  );

        int h1= (  time1.charAt(0)*10 + time1.charAt(1)  );
        int h2= (  time2.charAt(0)*10 + time2.charAt(1)  );

        int m1= (  time1.charAt(3)*10 + time1.charAt(4)  );
        int m2= (  time2.charAt(3)*10 + time2.charAt(4)  );

        if(m1>0) h1++;

        int minDiff=(m1>0?((60-m1)+(m2)):m2);

        int timeDiff= h2-h1;
        int hourDiff= (24*dateDiff)+(timeDiff) ;
        int totalMin=hourDiff*60+minDiff;

        if(minDiff==60)
        {
            minDiff=0;
            hourDiff++;
        }
        System.out.println("Total time spent:"+hourDiff+" hours "+minDiff+" minutes = "+totalMin+" minutes effectively ");

        //Calculating money 20Rs for 1st 1 hr, 10Rs for hours 2 and 3,Rs 5 for the remaining hours.
        if(minDiff>0)
            hourDiff++;

        int totalMoney=20;
        for(int hr=2;hr<=3 && hr<=hourDiff;hr++)
            totalMoney+=10;
        for(int hr=4;hr<=hourDiff;hr++)
            totalMoney+=5;
        return totalMoney;
    }
    abstract void pay();

}
//the customerInfoPortal can also be used to Pay hence it extends paymentSystem...
abstract class customerInfoPortal extends PaymentSystem{
    abstract void seeDetails();
}
//This class Stores Ticket Details of the customer....
class Ticket{
    int floor;
    int spotNo;
    String entryTime;
    String entryDate;
    int ticketNo;
    public Ticket(int Floor,int SpotNo,String EntryTime,int TicketNo,String EntryDate) {
        this.floor=Floor;
        this.spotNo=SpotNo;
        this.entryTime=EntryTime;
        this.ticketNo=TicketNo;
        this.entryDate=EntryDate;
    }

}
//Customer is an integral part of our parkingLot System...
public class Customer extends customerInfoPortal{
    Scanner in=new Scanner(System.in);
    private boolean paid=false;
    private String name,address;
    private int age;
    private int customerNo;
    private vehicletype v;
    private String LicensePlate;
    Systems obj=new Systems();
    Ticket t;
    //a separate method to input the vehicleType since it is enum
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
    //inputting all the customer details
    public void inputCustomerDetails(int customerNo){
        System.out.println("Enter Name, Age, Address and License Plate");
        this.customerNo=customerNo;
        name=in.nextLine();
        age=in.nextInt();
        in.nextLine();
        address=in.nextLine();
        LicensePlate=in.nextLine();
        inputVehicleType();

    }
    //implementing abstract class method
    @Override
    void seeDetails() {
        System.out.println("Customer Name: "+name+" Age: "+age+ " Address: "+ address+" VehicleType: "+v
                +" License Plate: "+LicensePlate);
    }
    //method to get a new Ticket....returns a ticket Object which is also stored
    Ticket getTicket(int Number){//probably spotType as a parameter.
        t=obj.giveTicket(v,this.customerNo);
        return t;
    }
    vehicletype getvehicletype(){
        return this.v;
    }
    //park and unPark functions....
    void park(Ticket a){ //We obtain ticket probably from systems class only.
        System.out.println("Car Parked in Floor "+ a.floor+" in spotNo "+ a.spotNo+ " ");

    }
    void unPark(Ticket a){
        if(paid){
            System.out.println("Vehicle Parked in Floor "+ a.floor+", spotNo "+ a.spotNo+ " is removed.");
            obj.openExitGate(a.floor,a.spotNo);
        }
        else
            System.out.println("Please Pay to Exit!!");
    }
    //Function to pay...3 methods are included
    @Override
    void pay() {
        int a;
        int fees=calculateFee(t.entryTime,t.entryDate);
        System.out.print("The following Options are Available: \n" +
                "1)Pay Using Customer info Portal via credit card \n" +
                "2)Pay To the parking Attendant\n" +
                "3)Pay at exitGate via Credit Card\n" +
                "Please choose your option: ");
        a=in.nextInt();
        switch (a){
            case 1:{
                System.out.println("Pay amount "+fees+" via credit Card using customer portal");
                paid=true;
                break;
            }
            case 2:{
                System.out.println("Pay amount "+fees+" via cash to parking attendant");
                paid=true;
                break;
            }
            case 3:{
                System.out.println("Pay amount "+fees+" via credit Card at exit Gate");
                paid=true;
                break;
            }
            default:{
                System.out.println("Please Give a valid Input!");
            }
        }
    }
}
