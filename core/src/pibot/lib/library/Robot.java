package pibot.lib.library;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalOutputProvider;
import com.pi4j.io.gpio.digital.DigitalState;
import pibot.lib.utils.DriverStationState;

import java.util.Scanner;

public class Robot {

    Context context;
    DigitalOutputConfigBuilder pinConfig;
    DigitalOutput pin;
    DigitalOutput a;

    public Robot(){
        context = Pi4J.newAutoContext();
        a = context.dout().create(4);
        a.config().shutdownState(DigitalState.LOW);
        //pinConfig = DigitalOutput.newConfigBuilder(context)
        //        .id("led pin")
        //        .name("pin 4")
        //        .address(4)
        //        .shutdown(DigitalState.LOW)
        //        .initial(DigitalState.LOW)
        //        .provider("pigpio-digital-output");
        //pin = context.create(pinConfig);
    }

    public void runRobot(){
        if (DriverStationState.getState().equals("Enabled")){
            a.high();
        }
        if (DriverStationState.getState().equals("Disabled")){
            a.low();
        }else {
            context.shutdown();
        }
    }
}
