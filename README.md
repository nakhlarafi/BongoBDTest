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
I have used Facade design pattern for making this video player app methods.
There is an interface method named `Functionalities`. `PlayPause`, `Forward`. `Rewind` classes implements the `action(String s, VideoView videoView)` method from it. The logics are written in the action method from differenct classes. Then there is a method named `ShapeMaker` which is the Facade class. This pattern hides the complexities of the system.

<h1>Pseudocode for the Play/Pause/Rewind/Forward functionalities</h1> 
<h2>Play or Pause</h2>

** Interface Class
```scss
public interface Functionalities {
    void actions(String s, VideoView videoView);
}
```
** Concrete classes and logics
```scss
public class PlayPause implements Functionalities{

    private int seekForwardTime = 3 * 1000; // default 5 second
    private int seekBackwardTime = 3 * 1000; // default 5 second

    @Override
    public void actions(String s, VideoView videoView) {
        if(videoView.isPlaying())
        {
            videoView.pause();
        }
        else{
            videoView.start();
        }
    }
}
```
```scss
public class Rewind implements Functionalities {

    private int seekForwardTime = 3 * 1000; // default 5 second
    private int seekBackwardTime = 3 * 1000; // default 5 second

    @Override
    public void actions(String s, VideoView videoView) {

        if (videoView != null) {
            int currentPosition = videoView.getCurrentPosition();
            if (currentPosition - seekBackwardTime >= 0) {
                videoView.seekTo(currentPosition - seekBackwardTime);
            } else {
                videoView.seekTo(0);
            }
        }

    }
}
```
```scss
public class Forward implements Functionalities {

    private int seekForwardTime = 3 * 1000; // default 5 second
    private int seekBackwardTime = 3 * 1000; // default 5 second

    @Override
    public void actions(String s, VideoView videoView) {

        if (videoView != null) {
            int currentPosition = videoView.getCurrentPosition();
            if (currentPosition + seekForwardTime <= videoView.getDuration()) {
                videoView.seekTo(currentPosition + seekForwardTime);
            } else {
                videoView.seekTo(videoView.getDuration());
            }
        }

    }
}
```
** Facade Class

```scss
public class ShapeMaker {
    private Functionalities playPause;
    private Functionalities forward;
    private Functionalities rewind;

    public ShapeMaker() {
        playPause = new PlayPause();
        forward = new Forward();
        rewind = new Rewind();
    }

    public void setplayPause(String s, VideoView videoView){
        playPause.actions(s, videoView);
    }
    public void setRewind(String s, VideoView videoView){
        rewind.actions(s, videoView);
    }
    public void setForward(String s, VideoView videoView){
        forward.actions(s, videoView);
    }
}
```
I have also added seekbar functionalities. I have completed the app and its in the VideoPlayer folder. The app basically collects all the mp4 files and then sends it to another activity when it is clicked and plays it.

