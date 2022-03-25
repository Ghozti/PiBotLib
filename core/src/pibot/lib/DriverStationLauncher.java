package pibot.lib;

import com.badlogic.gdx.Game;
import pibot.lib.graphical.DriverStation;

public class DriverStationLauncher extends Game {

    @Override
    public void create() {
        setScreen(new DriverStation());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        screen.dispose();
    }

    @Override
    public void resize(int width, int height) {
        screen.resize(width, height);
    }
}
