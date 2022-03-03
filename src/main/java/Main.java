import com.pi4j.io.gpio.*;

public class Main {
    public static void main(String[] args) {

        GpioController controller = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_01,"pin1", PinState.HIGH);
    }
}
