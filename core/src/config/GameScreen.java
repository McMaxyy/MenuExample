package config;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import menu.Confirm;
import menu.Home;

public class GameScreen implements Screen{
	private Game game;
	private Viewport viewport;
	private Home home;
	private Confirm conf;
	
	private static final int MIN_WIDTH = 600;
	private static final int MIN_HEIGHT = 900;
	private static final int MAX_WIDTH = 1080;
    private static final int MAX_HEIGHT = 1920;
    public static int SELECTED_WIDTH = MIN_WIDTH;
    public static int SELECTED_HEIGHT = MIN_HEIGHT;
    
    private int currentState;
    public static final int HOME = 1;
    public static final int CONFIRM = 2;

	public GameScreen(Game game) {
		this.game = game;
		viewport = new FitViewport(SELECTED_WIDTH, SELECTED_HEIGHT);
		Gdx.graphics.setUndecorated(false);
		Gdx.graphics.setWindowedMode(600, 900);
		setCurrentState(HOME);
	}
	
	public void setCurrentState(int newState) {
		currentState = newState;
		
		switch(currentState) {
		case HOME:
			this.home = new Home(viewport, game, this);
            Gdx.input.setInputProcessor(home.stage);
            break;
		case CONFIRM:
			this.conf = new Confirm(viewport, game, this);
            Gdx.input.setInputProcessor(conf.stage);
            break;
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(55 / 255f, 55 / 255f, 55 / 255f, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    switch(currentState) {
	    case HOME:
	    	home.render(delta);
	    	break;	
	    case CONFIRM:
	    	conf.render(delta);
	    	break;	
	    }	
	}

	@Override
	public void resize(int width, int height) {
		int finalWidth = Math.min(MAX_WIDTH, Math.max(MIN_WIDTH, width));
        int finalHeight = Math.min(MAX_HEIGHT, Math.max(MIN_HEIGHT, height));

        // Update the viewport with the adjusted width and height
        viewport.update(MIN_WIDTH, MIN_HEIGHT, true);
        viewport.apply();
        viewport.getCamera().update(); 
		
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
		home.dispose();
		conf.dispose();
	}
}
