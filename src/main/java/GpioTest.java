import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;

public class GpioTest {

    public static void main(String[] args) {
        GpioController controller = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_01,"pin1", PinState.HIGH);
        pin.setMode(PinMode.PWM_OUTPUT);
        Gpio.pwmWrite(pin.getPin().getAddress(), 100);
    }
}
