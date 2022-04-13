package pibot.lib.library;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.library.pigpio.PiGpio;
import pibot.lib.utils.DriverStationState;

import java.util.function.Function;

public class Robot {

    Context context;
    DigitalOutputConfigBuilder pinConfig;
    DigitalOutput pin;

    public Robot(){
        context = Pi4J.newAutoContext();
        pinConfig = DigitalOutput.newConfigBuilder(context)
                .id("led")
                .name("LED Flasher")
                .address(4)
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .provider("pigpio-digital-output");
        pin = context.create(pinConfig);
    }

    public void runRobot(){
        if (DriverStationState.getState().equals("Enabled")){
            pin.initialize(context);
            pin.high();
        }
        if (DriverStationState.getState().equals("Disabled")){
            pin.initialize(context);
            pin.low();
        }else {
            context.shutdown();
        }
    }
}
