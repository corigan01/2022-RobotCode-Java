# 2022-RobotCode-Java
Robot code for the 2022 robot game! Designed to be modular from the beginning!


## This robot code is designed to be modular
There are several sections that help the user program the robot. The `layer` class included from the package `frc.robot.Layer` is used in assisting the user in trasfering information from one `InputDevice` to an `OutputDevice` without including the specific `InputDevice` in the `OutputDevice`. 

**Ok let's know to use it**
```java
/* Robot code defined above */

public class Robot {
  public layer Layer; // Defined the layer class as public to be used by every other class
  
  public xbox x_controller; // This is an example of an InputDevice
  
  public void init() {
    Layer = new layer(); // This will init the layer class
    
    x_controller = new xbox(0 /* This is the port the controller is on in the driver station */, Layer /* this is the layer class for xbox controller */);
  }
  
  /* ... Other Functions we dont care about :) */
  
  public void teleopPeriodic() {
    x_controller.OutputIntoLayer(); // This will populate layer with all the inputs that x_controller supports
    
    Layer.DisplayVar(); // This will display all vars to SmartDashboard
    
  }
  
  /* ... Other code we dont care about :) */

}
```

## Why use layer?
The `layer` class allows us to not care about how `xbox` or anything else. All we care about are the variables defined in `layer`, and an `InputDevice`/`OutputDevice` will do their own thing. 

# Other Documentation
## Lib's Used
* Phoenix.json            -- Included from the (install offline package) after installing the firmware utill
* REVLib.json             -- Included from ` https://software-metadata.revrobotics.com/REVLib.json `
* WPILibNewCommands.json  -- included from (install offline package) 
* WPILibOldCommands.json  -- Included the same as `WIPLibNewCommands.json`

## Port Order
```
* 0 = XBOX CONTROLLER
* 1 = STICK CONTROLLER / XBOX CONTROLLER
* 2 = OTHER
* 3 = OTHER
* 4 = OTHER
* 5 = OTHER
```

## How to use driver station
### https://github.com/wpilibsuite/frc-docs/blob/stable/source/docs/software/driverstation/driver-station.rst
