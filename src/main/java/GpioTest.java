import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;

public class GpioTest {

    public static void main(String[] args) throws InterruptedException {
        GpioController controller = GpioFactory.getInstance();
        GpioPinDigitalOutput pin17 = controller.provisionDigitalOutputPin(RaspiPin.GPIO_17, "pin17", PinState.HIGH);
        GpioPinDigitalOutput pin22 = controller.provisionDigitalOutputPin(RaspiPin.GPIO_22, "pin22", PinState.HIGH);
        GpioPinDigitalOutput pin23 = controller.provisionDigitalOutputPin(RaspiPin.GPIO_23, "pin23", PinState.HIGH);
        GpioPinDigitalOutput pin24 = controller.provisionDigitalOutputPin(RaspiPin.GPIO_24, "pin24", PinState.HIGH);
        pin17.setMode(PinMode.DIGITAL_OUTPUT);
        pin22.setMode(PinMode.DIGITAL_OUTPUT);
        pin23.setMode(PinMode.DIGITAL_OUTPUT);
        pin24.setMode(PinMode.DIGITAL_OUTPUT);
        //Gpio.pwmWrite(pin.getPin().getAddress(), 100);
        Gpio.pwmWrite(pin17.getPin().getAddress(), 100);
        Gpio.pwmWrite(pin22.getPin().getAddress(), 100);
        Gpio.pwmWrite(pin23.getPin().getAddress(), 100);
        Gpio.pwmWrite(pin24.getPin().getAddress(), 100);
        Thread.sleep(10000);
        controller.shutdown();
    }
}
