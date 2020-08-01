public class Tester{
  public static void main(String []args){
    Car c = new Car(4,4,false);
    System.out.println(c.has_gas());
    
    Plane p = new Plane(100,4,true);
    System.out.println(p.has_gas());
  }
}