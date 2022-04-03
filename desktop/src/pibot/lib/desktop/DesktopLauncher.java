package pibot.lib.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import pibot.lib.DriverStationLauncher;
import pibot.lib.graphical.DriverStation;
import pibot.lib.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("PiBotLib Driver Station");
		config.setWindowSizeLimits((int) Constants.Graphical.Screen.width,(int) Constants.Graphical.Screen.height,(int) Constants.Graphical.Screen.width,(int) Constants.Graphical.Screen.height);
		new Lwjgl3Application(new DriverStationLauncher(),config);
	}
}
