import java.util.Scanner;
import java.util.*;
interface displayBoard{
    void displayAll();
    boolean compactTypeIsAvailable();
    boolean motorBikeTypeIsAvailable();
    boolean electricTypeIsAvailable();
    boolean handicappedTypeIsAvailable();
    boolean truckTypeIsAvailable();
}
interface EntryDisplay{
    boolean compactTypeIsAvailable();
    boolean motorBikeTypeIsAvailable();
    boolean electricTypeIsAvailable();
    boolean handicappedTypeIsAvailable();
    boolean truckTypeIsAvailable();
}
public class ParkingLot{
    //Making this a singleton class
    private static ParkingLot single_instance=null;
    //private constructor(its left empty)
    private ParkingLot(){

    }
    //method to get instance of this class
    public static ParkingLot getInstance(){
        if(single_instance==null)
            single_instance=new ParkingLot();
        return single_instance;
    }
    Scanner scan = new Scanner(System.in);
    private int noOfFloors;
    private int entryPoint;
    private int exitPoint;
    ArrayList<Floor> floor=new ArrayList<Floor>();
    void setNoOfFloors(int noOfFloors){
        this.noOfFloors=noOfFloors;
    }
    void setEntryPoint(int EntryPoint){
        this.entryPoint=EntryPoint;
    }
    void setExitPoint(int a){
        this.exitPoint=a;
    }
    ArrayList<Floor> getAllFloor(){
        Floor[] a=new Floor[noOfFloors];
        for(int i=0;i<noOfFloors;i++){
            a[i]=new Floor();
        }
        floor.addAll(Arrays.asList(a).subList(0, noOfFloors));
        return floor;
    }
    /*void addFloor(){
        a[++noOfFloors]=new Floor();
        noOfFloors++;
        floor.add(a[noOfFloors-1]);
    }
    void removeFloor(){
        floor.remove(a[noOfFloors-1]);
        noOfFloors--;
    }*/
    int getNoOfFloors(){
        return this.noOfFloors;
    }

}
class Floor implements displayBoard{
    Scanner scan=new Scanner(System.in);

    enum spotType{
        COMPACTTYPE,MOTORBIKETYPE,ELECTRICTYPE,HANDICAPPEDTYPE,TRUCKTYPE
    }
    int compactTypeSpots,n;
    int motorbikeTypeSpots;
    int electricTypeSpots;
    int handicappedTypeSpots;
    int truckTypeSpots;
    Scanner in = new Scanner(System.in);
    ArrayList<Spot> spots = new ArrayList<Spot>();
    Spot[] b=new Spot[n];
    void setSpots()
    {

        System.out.print("Enter no of Spots in floor :");
        this.n=in.nextInt();
        System.out.println("enter 1 for compacttype,2 for motorbike,3 for electric,4 for handicapped,5 for truck");
        for(int i=0;i<this.n;i++){
            b[i]=new Spot();
            spots.add(b[i]);
            int x=scan.nextInt();
            switch(x){
                case 1:
                    spots.get(i).setType(spotType.COMPACTTYPE);
                    break;
                case 2:
                    spots.get(i).setType(spotType.MOTORBIKETYPE);
                    break;
                case 3:
                    spots.get(i).setType(spotType.ELECTRICTYPE);
                    break;
                case 4:
                    spots.get(i).setType(spotType.HANDICAPPEDTYPE);
                    break;
                case 5:
                    spots.get(i).setType(spotType.TRUCKTYPE);
                    break;
                default:
                    System.out.println("Enter a Valid Input");
            }
        }
    }
    int totalnoofspots=spots.size();
    int getTotalnoofspots() {
        return this.totalnoofspots;
    }

    void addSpot(){

    }
    void removeSpot(){

    }


    @Override
    public void displayAll() {
        String s;
        System.out.println("Please see the board for Reference");
        for(int i=0;i<n;i++){
            if(spots.get(i).isAvailable){
                s="Available";
            }
            else
                s="Not Available";
            System.out.println("SpotNo is: " + spots.get(i)+ " spotType is: " + spots.get(i).a+ " " + s);

        }
    }
    @Override
    public boolean compactTypeIsAvailable() {
        for(int i=0;i<n;i++){
            if(spots.get(i).isAvailable && spots.get(i).a==spotType.COMPACTTYPE){
                System.out.println("Compact Spot is Available");
                return true;
            }
        }
        System.out.println("Compact Spot is not Available");
        return false;
    }

    @Override
    public boolean motorBikeTypeIsAvailable() {
        for(int i=0;i<n;i++){
            if(spots.get(i).isAvailable && spots.get(i).a==spotType.MOTORBIKETYPE){
                System.out.println("MotorBike Spot is Available");
                return true;
            }
        }
        System.out.println("MotorBike Spot is not Available");
        return false;
    }

    @Override
    public boolean electricTypeIsAvailable() {
        for(int i=0;i<n;i++){
            if(spots.get(i).isAvailable && spots.get(i).a==spotType.ELECTRICTYPE){
                System.out.println("Electric Spot is Available");
                return true;
            }
        }
        System.out.println("Electric Spot is not Available");
        return false;
    }

    @Override
    public boolean handicappedTypeIsAvailable() {
        for(int i=0;i<n;i++){
            if(spots.get(i).isAvailable && spots.get(i).a==spotType.HANDICAPPEDTYPE){
                System.out.println("Handicapped Spot is Available");
                return true;
            }
        }
        System.out.println("Handicapped Spot is not Available");
        return false;
    }

    @Override
    public boolean truckTypeIsAvailable() {
        for(int i=0;i<n;i++){
            if(spots.get(i).isAvailable && spots.get(i).a==spotType.TRUCKTYPE){
                System.out.println("Truck Spot is Available");
                return true;
            }
        }
        System.out.println("Truck Spot is not Available");
        return false;
    }
}

class Spot extends Floor{
    boolean isAvailable;
    spotType a;
    int number;
    void changeAvailability(){
        isAvailable=!isAvailable;
    }
    void setType(spotType s){
        isAvailable=true;
        a=s;
    }
    spotType getspottype(){
        return a;
    }
    void ChargeElectricCar(){
        System.out.println("Pay Fee to charge Your Vehicle");
    }
}
