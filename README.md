# TEAM MEMBERS
-Githin 
-Gautam
-Pavan Kalyan
-Yethin
-Ravi Chandra

# INSTRUCTIONS TO RUN CODE

  First step is Describing initial state of parkingLot.After that we can independently change attributes of parking lot and manage customers using the operation class
  (switch statements with descriptions are given)
  In most cases the input is checked for any abnormalities but in some cases it is not.
  For example -Input date should not be the last date of month.
  Customer is not removed from the arraylist -customerlist and hence this object may invoke some unwanted methods.
  Most of the methods in systems class is coupled along with methods of other modules, so they are not used in main function directly.
  
  
  
  
# DESCRIPCTION OF THIS CODE
   
  This code is divided into 4 files namely Systems,Customer,ParkingLot and Solution (main class) 
  Customer class:
       This includes the classes like customerInfoPortal , Ticket ,PaymentSystems ,Customer and some methods to implement them using OOPS concepts
       
  Systems class:
       This class includes the system classe and the following methods availableFloor,findNearestSpot,AssignSpot,releaseSpot,giveTicket,openExitGate.
       
  ParkingLot class:
       this class includes floor class and ParkingLot class along with many methods 
       namely displayBoard,EntryDisplay,getInstance,setNoOfFloors,setEntryPoint,setExitPoint,getAllFloor,getNoOfFloors and all methods of each type of availability and the display methods
       
  Solution class:
       This will be our main class which will give all inputs like the number of floors and spot types ,entry points and exit points... utilising other classes of other 
       files as discussed above.
