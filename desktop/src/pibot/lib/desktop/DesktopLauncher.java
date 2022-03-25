package pibot.lib.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pibot.lib.DriverStationLauncher;
import pibot.lib.graphical.DriverStation;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PiBotLib Driver Station";
		config.width = 1080;
		config.height = 720;
		config.resizable = false;
		new LwjglApplication(new DriverStationLauncher(),config);
	}
}
