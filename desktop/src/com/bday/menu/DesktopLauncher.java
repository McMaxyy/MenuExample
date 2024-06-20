package com.bday.menu;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import config.Menu;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Menu");
		
		config.setWindowedMode(600, 900);
		config.setDecorated(true);
		config.setResizable(false);
		
		int samples = 32;
        config.setBackBufferConfig(8, 8, 8, 8, 16, 0, samples);
		
		new Lwjgl3Application(new Menu(), config);
	}
}
