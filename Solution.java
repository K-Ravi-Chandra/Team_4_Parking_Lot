import java.util.*;
class Operation{
    Scanner in=new Scanner(System.in);
    int choice,x,i,y,z,j;
    int customerNo=0;
    ParkingLot lot=ParkingLot.getInstance();
    //overriding method of parent class to execute a method from this class.
    Systems obj1=new Systems();
    ArrayList<Ticket> ticketList=new ArrayList<Ticket>();
    ArrayList<Customer> customerList=new ArrayList<Customer>();
    int ClassCall() {
        System.out.println("Choose One of the Following: \n" +
                "press 1 for Operation on ParkingLot\n" +
                "press 2 for Operation on Customer");
        choice=in.nextInt();
        OpCall();
        return choice;
    }

    void OpCall() {
        //nested switch case
        switch (choice){
            case 1:{
                System.out.println("Choose One of the Following: \n" +
                        "press 1 to add a floor\n" +
                        "press 2 to remove a floor\n" +
                        "press 3 to get number of floors \n" +
                        "press 4 to get number of spots in the corresponding floor\n" +
                        "press 5 to see display board for the corresponding floor\n" +
                        "press 6 to add a spot to the corresponding floor\n" +
                        "press 7 to remove a spot from the corresponding floor\n" +
                        "press 8 to getSpotType for the corresponding floor\n" +
                        "press 9 to charge electric car\n" +
                        "press 10 to see EntryGate DisplayBoard");
                x=in.nextInt();
                switch (x){
                    case 1:
                        lot.addFloor();
                        lot.floor.get(lot.floor.size()-1).initialSetSpots(lot.floor.size());
                        break;
                    case 2:
                        lot.removeFloor();
                        break;
                    case 3:
                        System.out.println("No of Floors is: " + lot.getNoOfFloors());
                        break;
                    case 4:
                        //here i is the floor no
                        System.out.print("Enter FloorNo to see Number of spots:");
                        i=in.nextInt();
                        if(i<=lot.floor.size() && i>0 )
                            System.out.println(lot.floor.get(i-1).getTotalNoOfSpots());
                        else
                            System.out.println("Enter a valid floorNo!!");
                        break;
                    case 5:
                        //display board..
                        System.out.print("Enter FloorNo to see DisplayBoard:");
                        i=in.nextInt();
                        if(i<=lot.floor.size() && i>0)
                        {
                            lot.floor.get(i-1).displayAllInFloor();
                            //the bool functions in display board
                            lot.floor.get(i-1).compactTypeIsAvailable(i);
                            lot.floor.get(i-1).motorBikeTypeIsAvailable(i);
                            lot.floor.get(i-1).electricTypeIsAvailable(i);
                            lot.floor.get(i-1).handicappedTypeIsAvailable(i);
                            lot.floor.get(i-1).truckTypeIsAvailable(i);
                        }
                        else
                            System.out.println("Enter a valid floorNo!!");
                        break;
                    case 6:
                        System.out.print("Enter FloorNo to addSpot:");
                        i=in.nextInt();
                        if(i<=lot.floor.size() && i>0) {
                            lot.floor.get(i-1).addSpot();
                            lot.floor.get(i-1).spots.get(lot.floor.get(i-1).spots.size() - 1).setSpot(spotType.COMPACTTYPE,
                                    lot.floor.get(i-1).spots.size() - 1);
                        }
                        else
                            System.out.println("Enter Valid floorNo!!");
                        break;
                    case 7:
                        System.out.print("Enter FloorNo to removeSpot:");
                        i=in.nextInt();
                        if(i<=lot.floor.size() && i>0)
                            lot.floor.get(i-1).removeSpot();
                        else
                            System.out.println("Enter Valid floorNo!!");
                        break;
                    case 8:
                        System.out.print("Enter FloorNo and spotNo to get spotType:");
                        i=in.nextInt();
                        if(i<=lot.floor.size() && i>0) {
                            j = in.nextInt();
                            if(j<=lot.floor.get(i-1).spots.size() && j>0)
                                System.out.println(lot.floor.get(i-1).spots.get(j-1).getSpotType());
                            else
                                System.out.println("Enter Valid SpotNo!!");
                        }
                        else
                            System.out.println("Enter Valid floorNo!!");
                        break;
                    case 9:
                        System.out.print("Enter FloorNo and spotNo to charge Electric Car:");
                        i=in.nextInt();
                        if(i<=lot.floor.size() && i>0) {
                            j = in.nextInt();
                            if(j<=lot.floor.get(i-1).spots.size() && j>0)
                                lot.floor.get(i-1).spots.get(j-1).ChargeElectricCar();
                            else
                                System.out.println("Enter Valid SpotNo!!");
                        }
                        else
                            System.out.println("Enter Valid floorNo!!");
                        break;
                    case 10:
                        lot.compactTypeIsAvailable();
                        lot.motorBikeTypeIsAvailable();
                        lot.electricTypeIsAvailable();
                        lot.handicappedTypeIsAvailable();
                        lot.truckTypeIsAvailable();
                    default:
                        System.out.println("Enter a valid input!!");
                        break;
                }
                break;
            }
            case 2:{
                System.out.println("Choose One of the Following: \n" +
                        "press 1 to add new customer and getTicket\n" +
                        "press 2 to see details using customer info portal\n" +
                        "press 3 to pay cash and exit ParkingLot");
                x=in.nextInt();
                switch (x) {
                    case 1:
                        this.customerNo++;
                        Customer a=new Customer();
                        customerList.add(a);
                        customerList.get(customerNo-1).inputCustomerDetails(customerNo);
                        Ticket t;
                        t=customerList.get(customerNo-1).getTicket(customerNo);
                        if(t.floor!=0 && t.spotNo!=0) {
                            ticketList.add(t);
                            customerList.get(customerNo - 1).park(ticketList.get(customerNo - 1));
                        }
                        break;
                    case 2:
                        System.out.print("Enter Ticket No: ");
                        int z=in.nextInt();
                        if(z<=customerList.size() && z>0 && ticketList.get(z-1).floor!=0){
                            customerList.get(z-1).seeDetails();
                        }
                        else{
                            System.out.println("Invalid Ticket no!!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Ticket No: ");
                        int w=in.nextInt();
                        if(w<=customerList.size() && w>0){
                            customerList.get(w-1).pay();
                            customerList.get(w-1).unPark(ticketList.get(w-1));
                        }
                        else{
                            System.out.println("Invalid Ticket no!!");
                        }
                        break;
                }
                break;
            }
            default:{
                System.out.println("Enter Valid Option!!");
                break;
            }
        }
    }
}

public class Solution extends Operation {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int i,exitPoint,entryPoint,noOfFloors;
        //singleton approach
        ParkingLot lot=ParkingLot.getInstance();
        System.out.print("Enter No Of Floors: ");
        noOfFloors=in.nextInt();
        lot.setNoOfFloors(noOfFloors);
        System.out.print("Enter No Of EntryPoints: ");
        entryPoint=in.nextInt();
        lot.setEntryPoint(entryPoint);
        System.out.print("Enter No Of ExitPoints: ");
        exitPoint=in.nextInt();
        lot.setExitPoint(exitPoint);
        Operation obj=new Operation();
        //Setting Up the initial State of the parking lot.....
        ArrayList<Floor> A=lot.getAllFloor();
        for(i=1;i<=noOfFloors;i++){
            A.get(i-1).initialSetSpots(i);
        }
        //once the state is set...The solution class(representing admin) can be used to change the parkingLot state as well
        //manage the customers with the help of the "Operation" class
        String conformation;
        do{
            obj.ClassCall();
            System.out.println("Do you want to perform anyMore Operations: Press (y/n)");
            conformation=in.next();
        }while(conformation.equals("y"));
    }
}
