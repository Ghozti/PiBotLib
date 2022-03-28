package pibot.lib.graphical;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class DriverStation implements Screen {
	SpriteBatch batch;
	Texture img;
	DriverStationButton enableButton, disableButton;

	public DriverStation(){
		batch = new SpriteBatch();
	}

	@Override
	public void show() {
		img = new Texture(Gdx.files.internal("PiBotLib Driver Station.png"));
		enableButton = new DriverStationButton("Enable.png");
		disableButton = new DriverStationButton("disable.png");
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0,0, 1f);
		batch.begin();
		batch.draw(img,0,0,1080,720);
		batch.draw(enableButton.getTexture(),80,50,enableButton.getWidth(), enableButton.getHeight());
		batch.draw(disableButton.getTexture(),230,50,disableButton.getWidth(), disableButton.getHeight());
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
