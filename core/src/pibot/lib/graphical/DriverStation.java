package pibot.lib.graphical;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import pibot.lib.utils.Constants;

import java.awt.*;

public class DriverStation implements Screen {
	SpriteBatch batch;
	Texture img;
	DriverStationButton enableButton, disableButton;
	Rectangle mouseHitbox;

	public DriverStation(){
		batch = new SpriteBatch();
	}

	@Override
	public void show() {
		img = new Texture(Gdx.files.internal("PiBotLib Driver Station.png"));
		enableButton = new DriverStationButton("Enable(1).png",80,50);
		disableButton = new DriverStationButton("disable.png",280,50);
		mouseHitbox = new Rectangle(Gdx.input.getX(),-Gdx.input.getY(),15,15);
	}

	private void update(){
		mouseHitbox.x = Gdx.input.getX();
		mouseHitbox.y = Math.abs(Gdx.input.getY() - (int) Constants.Graphical.Screen.height);
		System.out.println(mouseHitbox.x + " " + mouseHitbox.y);
	}

	@Override
	public void render(float delta) {
		update();
		ScreenUtils.clear(0, 0,0, 1f);
		batch.begin();
		batch.draw(img,0,0,1080,720);
		batch.draw(enableButton.getTexture(),enableButton.getX(),enableButton.getY(),enableButton.getWidth(), enableButton.getHeight());
		batch.draw(disableButton.getTexture(),disableButton.getX(),disableButton.getY(),disableButton.getWidth(), disableButton.getHeight());
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
