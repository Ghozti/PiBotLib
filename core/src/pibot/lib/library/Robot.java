package pibot.lib.library;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.pwm.Pwm;
import com.pi4j.io.pwm.PwmConfig;
import com.pi4j.io.pwm.PwmType;
import com.pi4j.library.pigpio.PiGpio;
import pibot.lib.utils.DriverStationState;

import java.util.function.Function;

public class Robot {

    Context context;
    //Pwm pwm;
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
        //pwm = context.create(buildPwmConfig(context,12));
        //System.out.println("pwm init");
    }

    public void runRobot(){
        if (DriverStationState.getState().equals("Enabled")){
            pin.high();
        }
        if (DriverStationState.getState().equals("Disabled")){
            pin.low();
        }else {
            context.shutdown();
        }
        //pwm.on(50,1);
    }

    protected static PwmConfig buildPwmConfig(Context pi4j, int address) {
        return Pwm.newConfigBuilder(pi4j)
                .id("BCM" + address)
                .name("Buzzer")
                .address(address)
                .pwmType(PwmType.HARDWARE)
                .provider("pigpio-pwm")
                .initial(0)
                .shutdown(0)
                .build();
    }
}
