package pibot.lib.graphical;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import pibot.lib.utils.Constants;

public class DriverStationButton {

    private Texture texture;
    private String path;
    private float width, height;

    public DriverStationButton(String defaultPath){
        this.path = defaultPath;
        this.texture = new Texture(Gdx.files.internal(defaultPath));
        this.width = Constants.Graphical.DriverStation.buttonWidth;
        this.height = Constants.Graphical.DriverStation.buttonHeight;
    }

    public void changePath(String path) {
        texture = new Texture(Gdx.files.internal(path));
    }

    public Texture getTexture(){
        return texture;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
