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
Plane Class:

```scss
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
```
* Specify the interface design pattern

```scss
public class Tester{
  public static void main(String []args){
    Car c = new Car(4,4,false);
    System.out.println(c.has_gas());
    
    Plane p = new Plane(100,4,true);
    System.out.println(p.has_gas());
  }
}
```
<h1>Problem 2b</h1>
I have used the Facotory Design Pattern. I have created object without exposing the creation logic and refered to newly created object using a common interface.

* Creating the factory class
```scss
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
```
* Running the factory

```scss
public class Tester{
  public static void main(String []args){
    VehicleFactory vFactory = new VehicleFactory();

    Vehicle v1 = vFactory.getVehicle("Car",4,4,false);
    System.out.println(v1.has_gas());
    
    Vehicle v2 = vFactory.getVehicle("Plane",10,4,true);
    System.out.println(v2.set_num_of_wheels());
    
  }
}
```

<h1>Problem 3</h1>
I will use MVVM model for making this video player app.

* Model Class
There will be a model class which will have get and set methods for each video files. Usally here the locations and the image thumbnails.

* Repository Class
The gathered file path will be sent to the model class.

* Adapter Class
It will have an adapter class for shwoing the video files stored on the entire mobile storage gathered using Repository and Model classes.

* Viewmodel Class
For adding new values.

* Pseudocode for the Play/Pause/Rewind/Forward functionalities
<h2>Play or Pause</h2>

```scss
public void PlayButton(View view){

        if(videoView.isPlaying())
        {
            videoView.pause();
        }
        else{
            videoView.start();
        }

    }

```
