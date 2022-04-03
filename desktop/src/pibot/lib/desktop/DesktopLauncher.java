package pibot.lib.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import pibot.lib.DriverStationLauncher;
import pibot.lib.graphical.DriverStation;
import pibot.lib.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("PiBot lib driver station");
		config.setWindowSizeLimits(1080,720,1080,720);
		config.setWindowedMode(1080,720);
		new Lwjgl3Application(new DriverStationLauncher(),config);
	}
}
