package pibot.lib.graphical;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import pibot.lib.graphical.tools.Font;
import pibot.lib.utils.Constants;

public class DriverStation implements Screen {

	SpriteBatch batch;
	Texture img;
	DriverStationButton enableButton, disableButton;
	com.badlogic.gdx.math.Rectangle mouseHitbox;
	Font font;

	public DriverStation(){
		batch = new SpriteBatch();
	}

	@Override
	public void show() {
		img = new Texture(Gdx.files.internal("PiBotLib Driver Station.png"));
		enableButton = new DriverStationButton("Enable (1).png",80,50);
		disableButton = new DriverStationButton("disable.png",280,50);
		mouseHitbox = new com.badlogic.gdx.math.Rectangle(Gdx.input.getX(),-Gdx.input.getY(),15,15);
		font = new Font(100);
	}

	private void update(){
		mouseHitbox.x = Gdx.input.getX();
		mouseHitbox.y = Math.abs(Gdx.input.getY() - (int) Constants.Graphical.Screen.height);
		updateEnableButton();
		updateDisableButton();
	}

	@Override
	public void render(float delta) {
		update();
		ScreenUtils.clear(0, 0,0, 1f);
		batch.begin();
		batch.draw(img,0,0,1080,720);
		batch.draw(enableButton.getTexture(),enableButton.getX(),enableButton.getY(),enableButton.getWidth(), enableButton.getHeight());
		batch.draw(disableButton.getTexture(),disableButton.getX(),disableButton.getY(),disableButton.getWidth(), disableButton.getHeight());
		font.draw(batch,"Robot State: ",480,200,0,false);
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

	private void updateEnableButton(){
		if (enableButton.getHitbox().overlaps(mouseHitbox)){
			enableButton.changePath("Enable.png");
		}else {
			enableButton.changePath("Enable (1).png");
		}
	}

	private void updateDisableButton(){
		if (disableButton.getHitbox().overlaps(mouseHitbox)){
			disableButton.changePath("disable(1).png");
		}else {
			disableButton.changePath("disable.png");
		}
	}
}
