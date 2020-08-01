public class Plane implements Vehicle{
  int numOfWheels, numOfPassenger;
  boolean hasGas;
  
  public Plane(int numOfWheels, int numOfPassenger, boolean hasGas){
    this.numOfPassenger = numOfPassenger;
    this.numOfWheels = numOfWheels;
    this.hasGas = hasGas;
  }
  
  public int set_num_of_wheels(){
    return numOfWheels;
  }
  public int set_num_of_passengers(){
    return numOfPassenger;
  }
  public boolean has_gas(){
    return hasGas;
  }
}