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
    DigitalOutputConfigBuilder pinConfig;
    DigitalOutput pin;

    public Robot(){
        context = Pi4J.newAutoContext();
        PwmConfig pwmConfig = Pwm.newConfigBuilder(context)
                .id("BCM" + 0)
                .name("Buzzer")
                .address(0)
                .pwmType(PwmType.HARDWARE)
                .provider("pigpio-pwm")
                .initial(0)
                .shutdown(0)
                .build();
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
