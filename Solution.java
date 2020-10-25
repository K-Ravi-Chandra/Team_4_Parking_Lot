import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int i,n,exitPoint,entryPoint,noOfFloors;
        ParkingLot lot=ParkingLot.getInstance();
        noOfFloors=in.nextInt();
        entryPoint=in.nextInt();
        exitPoint=in.nextInt();
        lot.setNoOfFloors(noOfFloors);
        lot.setEntryPoint(entryPoint);
        lot.setExitPoint(exitPoint);
        ArrayList<Floor> A=lot.getAllFloor();
        /*System.out.println(A);
        A.set(1,A.get(2));
        System.out.println(A);
        System.out.println(lot.floor);*/
        for(i=0;i<noOfFloors;i++){
            A.get(i).setSpots();
        }
        ArrayList<Customer> customerList=new ArrayList<Customer>();

        //define the specifics of the parkinglot... floors and spots..

    }
}
