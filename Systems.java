import java.util.ArrayList;
import java.util.Scanner;
public class Systems{
    Scanner in=new Scanner(System.in);
    ParkingLot lot=ParkingLot.getInstance();
    int availableFloor(ArrayList<Floor> a,vehicletype vehicle){//spotType parameter must be given(probably use an object from floor class)
        int k=0,l=0;
        int flag=0;
        int total = a.size();
        for(int i=0;i<total;i++){
            int totalspotsinthatfloor= a.get(i).spots.size();
            for(int j=0;j<totalspotsinthatfloor;j++){
                if(vehicle.equals(a.get(i).spots.get(j).getspottype()) && a.get(i).spots.get(j).isAvailable){
                    return i;
                }
            }
        }
        return -1;
    }
    int findNearestSpot(ArrayList<Floor> a,int i,vehicletype vehicle){//spotType parameter must be given(probably use an object from floor class)
        //find spot and invoke AssignSpot method.
        int totalspotsinthatfloor= a.get(i).spots.size();
        for(int j=0;j<totalspotsinthatfloor;j++){
            if(vehicle.equals(a.get(i).spots.get(j).getspottype()) && a.get(i).spots.get(j).isAvailable){
                return j;
            }
        }
        return -1;
    }
    void AssignSpot(Spot e){ //Give the corresponding spotNo as parameter
        e.isAvailable=false;
    }
    void releaseSpot(Spot e){
        e.isAvailable=true;
    }
    Ticket giveTicket(vehicletype x){
        int y=availableFloor(lot.getAllFloor(),x),z=findNearestSpot(lot.getAllFloor(),y,x);
        String EntryTime;
        System.out.print("Enter Time in Format hh:mm ");
        EntryTime=in.next();
        if(y==-1 || z==-1){
            System.out.println("No Spots are Available!!");
            return null;
        }
        Ticket a=new Ticket(y,z,EntryTime,0);
        AssignSpot(lot.floor.get(y).spots.get(z));
        //call method to change availabilty of that spot
        return a;
    }
    void openExitGate(){


    }
}