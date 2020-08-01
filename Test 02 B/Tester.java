public class Tester{
  public static void main(String []args){
    VehicleFactory vFactory = new VehicleFactory();

    Vehicle v1 = vFactory.getVehicle("Car",4,4,false);
    System.out.println(v1.has_gas());
    
    Vehicle v2 = vFactory.getVehicle("Plane",10,4,true);
    System.out.println(v2.set_num_of_wheels());
    
  }
}