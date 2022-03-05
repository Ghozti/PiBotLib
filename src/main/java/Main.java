import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class Main {
    public static void main(String[] args) {

        GpioController controller = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_01,"pin1", PinState.HIGH);
        Gpio.pwmWrite(pin.getPin().getAddress(), 100);
    }
}
