# BongoBDTest

<h1>Problem 1</h1>

I have solved the problem and wrote two test cases using Junit.

<h1>Problem 2a</h1>

I have implemented the `Vehicle` class in `Car` and `Plane` class. Then wrote the methods that were declared in the Interface class. I created a tester class and passed the necessary variables in the constructor. 

* Car Class:

```scss

public class Car implements Vehicle{
  int numOfWheels, numOfPassenger;
  boolean hasGas;
  
  public Car(int numOfWheels, int numOfPassenger, boolean hasGas){
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

```
