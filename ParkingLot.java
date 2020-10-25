import java.util.Scanner;
import java.util.*;
enum spotType{
    COMPACTTYPE,MOTORBIKETYPE,ELECTRICTYPE,HANDICAPPEDTYPE,TRUCKTYPE
}
//Display board for each Floor...
interface displayBoard{
    void displayAllInFloor();
    boolean compactTypeIsAvailable(int f);
    boolean motorBikeTypeIsAvailable(int f);
    boolean electricTypeIsAvailable(int f);
    boolean handicappedTypeIsAvailable(int f);
    boolean truckTypeIsAvailable(int f);
}
//Display board for The entire Parking Lot...Set At entryPoints
interface EntryDisplay{
    boolean compactTypeIsAvailable();
    boolean motorBikeTypeIsAvailable();
    boolean electricTypeIsAvailable();
    boolean handicappedTypeIsAvailable();
    boolean truckTypeIsAvailable();
}
//One of the main Component of out ParkingLot System...This class can only be instantiated once(Singleton Approach) so that
//it can clearly a single ParkingLot...
public class ParkingLot implements EntryDisplay{
    //Making this a singleton class
    private static ParkingLot single_instance=null;
    //private constructor(its left empty)
    private ParkingLot(){

    }
    //method to get instance of this class(whenever we try to create an object for this class this method makes sure all of
    // those objects are the same)...
    public static ParkingLot getInstance(){
        if(single_instance==null)
            single_instance=new ParkingLot();
        return single_instance;
    }
    Scanner scan = new Scanner(System.in);
    private int noOfFloors;
    private int entryPoint;
    private int exitPoint;
    //
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
    //Arraylist to keep the objects of Floor class(the various Floors available in the parking lot)
    ArrayList<Floor> getAllFloor(){
        for(int i=0;i<noOfFloors;i++) {
            Floor a = new Floor();
            floor.add(a);
        }
        return floor;
    }
    //adding a new floor
    void addFloor(){
        this.noOfFloors++;
        Floor a=new Floor();
        floor.add(a);
    }
    //removing a new floor
    void removeFloor(){
        floor.remove(floor.size()-1);
        noOfFloors--;
    }
    int getNoOfFloors(){
        return this.noOfFloors;
    }
    //implementing methods of the DisplayBoard Interface
    @Override
    public boolean compactTypeIsAvailable() {
        //overriding the compact type is available method i.e,to check the availability of compact type spot
        for(int i=0;i<this.noOfFloors;i++){
            if(floor.get(i).compactTypeIsAvailable(i)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean motorBikeTypeIsAvailable() {
        //overriding the motorbike type is available method i.e,to check the availability of motor bike type spot
        for(int i=0;i<this.noOfFloors;i++){
            if(floor.get(i).motorBikeTypeIsAvailable(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean electricTypeIsAvailable() {
        //overriding the electricType isAvailable method i.e,to check the availability of electric type spot
        for(int i=0;i<this.noOfFloors;i++){
            if(floor.get(i).electricTypeIsAvailable(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean handicappedTypeIsAvailable() {
        //overriding the handicappedType isAvailable method i.e,to check the availability of handicapped type spot
        for(int i=0;i<this.noOfFloors;i++){
            if(floor.get(i).handicappedTypeIsAvailable(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean truckTypeIsAvailable() {
        //overriding the trucktypeisavailable method i.e,to check the availability of truck tyoe spot
        for(int i=0;i<this.noOfFloors;i++){
            if(floor.get(i).truckTypeIsAvailable(i)) {
                return true;
            }
        }
        return false;
    }
}
class Floor implements displayBoard{
    Scanner in = new Scanner(System.in);
    ParkingLot lot=ParkingLot.getInstance();

    private int noOfSpots;
    //Arraylist to keep the objects of spot class(the various spots available in each floor)
    ArrayList<Spot> spots = new ArrayList<Spot>();
    void initialSetSpots(int k)
    {
        System.out.print("Enter no of Spots in floor "+k+": ");
        this.noOfSpots=in.nextInt();
        System.out.println("enter 1 for compacttype,2 for motorbike,3 for electric,4 for handicapped,5 for truck");
        for(int i=0;i<this.noOfSpots;i++){
            Spot b=new Spot();
            spots.add(b);
            int x=in.nextInt();
            switch(x){
                case 1:
                    spots.get(i).setSpot(spotType.COMPACTTYPE,i);
                    System.out.println("Compact Spot added");
                    break;
                case 2:
                    spots.get(i).setSpot(spotType.MOTORBIKETYPE,i);
                    System.out.println("MotorBike Spot added");
                    break;
                case 3:
                    spots.get(i).setSpot(spotType.ELECTRICTYPE,i);
                    System.out.println("Electric Spot added");
                    break;
                case 4:
                    spots.get(i).setSpot(spotType.HANDICAPPEDTYPE,i);
                    System.out.println("Electric Spot added");
                    break;
                case 5:
                    spots.get(i).setSpot(spotType.TRUCKTYPE,i);
                    System.out.println("Truck Spot added");
                    break;
                default:
                    System.out.println("Enter a Valid Input");
                    i--;
            }
        }
    }
    int getTotalNoOfSpots() {
        return this.noOfSpots;
    }

    void addSpot(){
        noOfSpots++;
        Spot x=new Spot();
        spots.add(x);
    }
    void removeSpot(){
        noOfSpots--;
        spots.remove(noOfSpots);
    }

    //implementing Methods of displayBoard interface(for each floor)...
    @Override
    public void displayAllInFloor() {
        String s;
        System.out.println("Please see the board for Reference");
        for(int i=0;i<noOfSpots;i++){
            if(spots.get(i).isAvailable){
                s="Available";
            }
            else
                s="Not Available";
            System.out.println("SpotNo is: " + spots.get(i).number+ " spotType is: " + spots.get(i).a+ " " + s);

        }
    }
    @Override
    public boolean compactTypeIsAvailable(int f) {
        for(int i=0;i<noOfSpots;i++){
            if(lot.floor.get(f).spots.get(i).isAvailable && lot.floor.get(f).spots.get(i).a==spotType.COMPACTTYPE){
                System.out.println("Compact Spot is Available");
                return true;
            }
        }
        System.out.println("Compact Spot is not Available");
        return false;
    }

    @Override
    public boolean motorBikeTypeIsAvailable(int f) {
        for(int i=0;i<noOfSpots;i++){
            if(lot.floor.get(f).spots.get(i).isAvailable && lot.floor.get(f).spots.get(i).a==spotType.MOTORBIKETYPE){
                System.out.println("MotorBike Spot is Available");
                return true;
            }
        }
        System.out.println("MotorBike Spot is not Available");
        return false;
    }

    @Override
    public boolean electricTypeIsAvailable(int f) {
        for(int i=0;i<noOfSpots;i++){
            if(lot.floor.get(f).spots.get(i).isAvailable && lot.floor.get(f).spots.get(i).a==spotType.ELECTRICTYPE){
                System.out.println("Electric Spot is Available");
                return true;
            }
        }
        System.out.println("Electric Spot is not Available");
        return false;
    }

    @Override
    public boolean handicappedTypeIsAvailable(int f) {
        for(int i=0;i<noOfSpots;i++){
            if(lot.floor.get(f).spots.get(i).isAvailable && lot.floor.get(f).spots.get(i).a==spotType.HANDICAPPEDTYPE){
                System.out.println("Handicapped Spot is Available");
                return true;
            }
        }
        System.out.println("Handicapped Spot is not Available");
        return false;
    }

    @Override
    public boolean truckTypeIsAvailable(int f) {
        for(int i=0;i<noOfSpots;i++){
            if(lot.floor.get(f).spots.get(i).isAvailable && lot.floor.get(f).spots.get(i).a==spotType.TRUCKTYPE){
                System.out.println("Truck Spot is Available");
                return true;
            }
        }
        System.out.println("Truck Spot is not Available");
        return false;
    }
}
//This class allows the admin to change spot type, set the spotType and change availability of various spots
class Spot extends Floor{
    boolean isAvailable;
    spotType a;
    int number;
    //when a spot is occupied it changes its availavilty, when a spot is emptied the same must happen...
    void changeAvailability(){
        isAvailable=!isAvailable;
    }
    //to initialize values of a new Spot(it is set to available by default)...
    void setSpot(spotType s,int no){
        isAvailable=true;
        this.number=no;
        a=s;
    }
    spotType getSpotType(){
        return a;
    }
    void ChargeElectricCar(){
        System.out.println("Pay Fee to charge Your Vehicle");
    }
}
