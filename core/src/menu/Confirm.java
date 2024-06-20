package menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import config.GameScreen;
import config.Storage;

public class Confirm implements Screen{
	Skin skin;
	Viewport vp;
	public Stage stage;
	private Game game;
	private GameScreen gameScreen; 	
	private Storage storage;
	private TextButton oddaja, back;
	private MyDialog dialog;

	public Confirm(Viewport viewport, Game game, GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		this.game = game;
		stage = new Stage(viewport);
		vp = viewport;
		Gdx.input.setInputProcessor(stage);
		storage = Storage.getInstance();
		storage.createFont();
		skin = storage.skin;
		dialog = new MyDialog("Komentar", skin, stage);
		
		if(Home.izbiraGlavna == null)
			Home.izbiraGlavna = "/";
		if(Home.izbiraPredjed == null)
			Home.izbiraPredjed = "/";
		if(Home.izbiraPriloga == null)
			Home.izbiraPriloga = "/";
		if(Home.izbiraSolata == null)
			Home.izbiraSolata = "/";
		if(Home.izbiraPijaca == null)
			Home.izbiraPijaca = "/";
		if(Home.izbiraSladica == null)
			Home.izbiraSladica = "/";
		if(Home.komentar == null)
			Home.komentar = "/";
	
		createComponents();
	}

	private void createComponents() {
		float initialY = vp.getWorldHeight() / 1.4f;
        float yIncrement = 100;
		
		Label label = new Label("", storage.labelStyle);
		label.setWrap(true);
		label.setSize(500, 500);
		label.setPosition(vp.getWorldWidth() / 8, vp.getWorldHeight() / 3f);
		label.setText("Predjed: " + Home.izbiraPredjed + "\n\n");	
		label.setText(label.getText() + "Glavna jed: " + Home.izbiraGlavna + "\n\n");
        label.setText(label.getText() + "Priloga: " + Home.izbiraPriloga + "\n\n");
        label.setText(label.getText() + "Solata: " + Home.izbiraSolata + "\n\n");
        label.setText(label.getText() + "Pijaca: " + Home.izbiraPijaca + "\n\n");
        label.setText(label.getText() + "Sladica: " + Home.izbiraSladica + "\n\n");
		stage.addActor(label);
		
		oddaja = new TextButton("Naprej", storage.buttonStyle);
        oddaja.setColor(Color.LIGHT_GRAY);
        oddaja.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {            	
                dialog.show(stage);
            }
        });
        oddaja.setSize(200, 50);
        oddaja.setPosition(vp.getWorldWidth() / 1.85f, initialY - 6 * yIncrement);
        stage.addActor(oddaja);
        
        back = new TextButton("Nazaj", storage.buttonStyle);
        back.setColor(Color.LIGHT_GRAY);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	gameScreen.setCurrentState(GameScreen.HOME);
            }
        });
        back.setSize(200, 50);
        back.setPosition(vp.getWorldWidth() / 8, initialY - 6 * yIncrement);
        stage.addActor(back);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			dialog.hide();
		}
		
		stage.act();
		stage.draw();			
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
