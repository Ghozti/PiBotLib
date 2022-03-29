package pibot.lib.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pibot.lib.DriverStationLauncher;
import pibot.lib.graphical.DriverStation;
import pibot.lib.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PiBotLib Driver Station";
		config.width = (int) Constants.Graphical.Screen.width;
		config.height = (int) Constants.Graphical.Screen.height;
		config.resizable = false;
		new LwjglApplication(new DriverStationLauncher(),config);
	}
}
