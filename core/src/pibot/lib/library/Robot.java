package pibot.lib.library;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import pibot.lib.utils.DriverStationState;

import java.util.Scanner;

public class Robot {

    public static void runRobot(){
        Thread thread = new Thread();
        thread.start();
        Context context = Pi4J.newAutoContext();
        DigitalOutputConfigBuilder pinConfig = DigitalOutput.newConfigBuilder(context)
                .id("led pin")
                .name("pin 7")
                .address(7)
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .provider("pigpio-digital-output");

        DigitalOutput pin = context.create(pinConfig);

        boolean exit = false;

        while(!exit){
            System.out.println("running");
            if (DriverStationState.getState().equals("Enabled")){
                pin.high();
            }else if (DriverStationState.getState().equals("Disabled")){
                pin.low();
            }else {
                exit = true;
            }
        }
        context.shutdown();
    }
}
