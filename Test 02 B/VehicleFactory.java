public class VehicleFactory {
 
   //use getVehicle method to get object of type vehicle 
   public Vehicle getVehicle(String vehiType, int numOfWheels, int numOfPassenger, boolean hasGas){
      if(vehiType == null){
         return null;
      }  
      if(vehiType.equalsIgnoreCase("Car")){
         return new Car(numOfWheels, numOfPassenger, hasGas);
         
      } else if(vehiType.equalsIgnoreCase("Plane")){
         return new Plane(numOfWheels, numOfPassenger, hasGas);
         
      }
      
      return null;
   }
}