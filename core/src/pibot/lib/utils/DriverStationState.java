package pibot.lib.utils;

public class DriverStationState {

    private static String state = "Disabled";

    public static void switchState(){
        if (state.equals("Disabled")){
            state = "Enabled";
        }else if (state.equals("Enabled")){
            state = "Disabled";
        }
    }

    public static String getState() {
        return state;
    }
}
