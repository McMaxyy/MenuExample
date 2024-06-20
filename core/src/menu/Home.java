package menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import config.GameScreen;
import config.Storage;

	public class Home implements Screen {
	    Skin skin;
	    Viewport vp;
	    public Stage stage;
	    private Game game;
	    private GameScreen gameScreen;
	    private Storage storage;
	    private TextButton predjed, glavneJedi, priloga, sladica, pijaca, solata, back, oddaja;
	    private TextButton test, mJed, rJed, sol;
	    private TextButton[] testenine = new TextButton[4];
	    private TextButton[] mesneJedi = new TextButton[5];
	    private TextButton losos;
	    private TextButton[] gSolate = new TextButton[3];
	    private TextButton[] priloge = new TextButton[6];
	    private TextButton[] predjedi = new TextButton[3];
	    private TextButton[] sladice = new TextButton[2];
	    private TextButton[] pijace = new TextButton[11];
	    private TextButton[] solate = new TextButton[13];
	    public static String komentar, izbiraPredjed, izbiraGlavna, izbiraPriloga, izbiraSladica,
	            izbiraPijaca, izbiraSolata;

	    public Home(Viewport viewport, Game game, GameScreen gameScreen) {
	        this.gameScreen = gameScreen;
	        this.game = game;
	        stage = new Stage(viewport);
	        vp = viewport;
	        Gdx.input.setInputProcessor(stage);
	        storage = Storage.getInstance();
	        storage.createFont();
	        skin = storage.skin;

	        createComponents();
	    }

	    private void createComponents() {
	        float initialY = vp.getWorldHeight() / 1.4f;
	        float initialY2 = vp.getWorldHeight() / 1.2f;
	        float yIncrement = 100;
	        float yIncrement2 = 60;
	        String izbira;
	        
	        back = new TextButton("Nazaj", storage.buttonStyle);
	        back.setColor(Color.LIGHT_GRAY);
	        back.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	                if(test.isVisible() || priloge[0].isVisible() || predjedi[0].isVisible() ||
	                		sladice[0].isVisible() || pijace[0].isVisible()) {
	                	showHideButtons(3, 1);
	                    showHideButtons(1, 2);
	                    showHideButtons(8, 1);
	                    showHideButtons(9, 1);
	                    showHideButtons(10, 1);
	                    showHideButtons(11, 1);
	                }
	                else if(testenine[0].isVisible() || mesneJedi[0].isVisible() || losos.isVisible()
	                		|| gSolate[0].isVisible()) {
	                	showHideButtons(3, 2);
	                    showHideButtons(2, 1);
	                    showHideButtons(4, 1);
	                	showHideButtons(5, 1);
	                	showHideButtons(6, 1);
	                }
	                else if(solate[0].isVisible()) {
	                	showHideButtons(7, 1);
	                	showHideButtons(1, 2);
	                }
	            }
	        });
	        back.setSize(100, 50);
	        back.setPosition(vp.getWorldWidth() / 15, vp.getWorldHeight() / 1.1f);
	        stage.addActor(back);

	        // Predjedi button
	        predjed = new TextButton("Predjedi", storage.buttonStyle);
	        predjed.setColor(Color.LIGHT_GRAY);
	        predjed.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(1, 1);
	                showHideButtons(9, 2);
	            }
	        });
	        predjed.setSize(450, 50);
	        predjed.setPosition(vp.getWorldWidth() / 8, initialY);
	        stage.addActor(predjed);

	        // Glavne Jedi button
	        glavneJedi = new TextButton("Glavne jedi", storage.buttonStyle);
	        glavneJedi.setColor(Color.LIGHT_GRAY);
	        glavneJedi.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	                showHideButtons(1, 1);
	                showHideButtons(3, 2);
	            }
	        });
	        glavneJedi.setSize(450, 50);
	        glavneJedi.setPosition(vp.getWorldWidth() / 8, initialY - yIncrement);
	        stage.addActor(glavneJedi);

	        // Priloga button
	        priloga = new TextButton("Priloga", storage.buttonStyle);
	        priloga.setColor(Color.LIGHT_GRAY);
	        priloga.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(1, 1);
	                showHideButtons(8, 2);
	            }
	        });
	        priloga.setSize(450, 50);
	        priloga.setPosition(vp.getWorldWidth() / 8, initialY - 2 * yIncrement);
	        stage.addActor(priloga);

	        // Sladica button
	        sladica = new TextButton("Sladica", storage.buttonStyle);
	        sladica.setColor(Color.LIGHT_GRAY);
	        sladica.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(1, 1);
	                showHideButtons(10, 2);
	            }
	        });
	        sladica.setSize(450, 50);
	        sladica.setPosition(vp.getWorldWidth() / 8, initialY - 3 * yIncrement);
	        stage.addActor(sladica);

	        // Pijaca button
	        pijaca = new TextButton("Pijaca", storage.buttonStyle);
	        pijaca.setColor(Color.LIGHT_GRAY);
	        pijaca.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(1, 1);
	                showHideButtons(11, 2);
	            }
	        });
	        pijaca.setSize(450, 50);
	        pijaca.setPosition(vp.getWorldWidth() / 8, initialY - 4 * yIncrement);
	        stage.addActor(pijaca);

	        // Solata button
	        solata = new TextButton("Solata", storage.buttonStyle);
	        solata.setColor(Color.LIGHT_GRAY);
	        solata.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(1, 1);
	                showHideButtons(7, 2);
	            }
	        });
	        solata.setSize(450, 50);
	        solata.setPosition(vp.getWorldWidth() / 8, initialY - 5 * yIncrement);
	        stage.addActor(solata);
	        
	        oddaja = new TextButton("Naprej", storage.buttonStyle);
	        oddaja.setColor(Color.LIGHT_GRAY);
	        oddaja.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	gameScreen.setCurrentState(GameScreen.CONFIRM);
	            }
	        });
	        oddaja.setSize(200, 50);
	        oddaja.setPosition(vp.getWorldWidth() / 1.85f, initialY - 6 * yIncrement);
	        stage.addActor(oddaja);
	        
	        test = new TextButton("Testenine", storage.buttonStyle);
	        test.setColor(Color.LIGHT_GRAY);
	        test.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(3, 1);
	                showHideButtons(2, 2);
	            }
	        });
	        test.setSize(450, 50);
	        test.setPosition(vp.getWorldWidth() / 8, initialY);
	        test.setVisible(false);
	        stage.addActor(test);

	        // Glavne Jedi button
	        mJed = new TextButton("Mesne jedi", storage.buttonStyle);
	        mJed.setColor(Color.LIGHT_GRAY);
	        mJed.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(3, 1);
	                showHideButtons(4, 2);
	            }
	        });
	        mJed.setSize(450, 50);
	        mJed.setPosition(vp.getWorldWidth() / 8, initialY - yIncrement);
	        mJed.setVisible(false);
	        stage.addActor(mJed);

	        // Priloga button
	        rJed = new TextButton("Ribje jedi", storage.buttonStyle);
	        rJed.setColor(Color.LIGHT_GRAY);
	        rJed.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(3, 1);
	                showHideButtons(5, 2);
	            }
	        });
	        rJed.setSize(450, 50);
	        rJed.setPosition(vp.getWorldWidth() / 8, initialY - 2 * yIncrement);
	        rJed.setVisible(false);
	        stage.addActor(rJed);

	        // Sladica button
	        sol = new TextButton("Solate", storage.buttonStyle);
	        sol.setColor(Color.LIGHT_GRAY);
	        sol.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	showHideButtons(3, 1);
	                showHideButtons(6, 2);
	            }
	        });
	        sol.setSize(450, 50);
	        sol.setPosition(vp.getWorldWidth() / 8, initialY - 3 * yIncrement);
	        sol.setVisible(false);
	        stage.addActor(sol);

	        for (int i = 0; i < testenine.length; i++) {
	            testenine[i] = new TextButton("", storage.buttonStyle);
	        }
	        testenine[0].setText("Bolognese");
	        testenine[1].setText("Dimljen losos");
	        testenine[2].setText("Smetanova omaka");
	        testenine[3].setText("Carbonara");
	        for (int i = 0; i < testenine.length; i++) {
	        	testenine[i].setVisible(false);
	            izbira = testenine[i].getText().toString();
	            final String finalIzbira = izbira;
	            testenine[i].setColor(Color.LIGHT_GRAY);
	            testenine[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraGlavna = finalIzbira;
	                    showHideButtons(2, 1);
	                    showHideButtons(1, 2);
	                }
	            });
	            testenine[i].setSize(450, 50);
	            testenine[i].setPosition(vp.getWorldWidth() / 8, initialY - i * yIncrement);
	            stage.addActor(testenine[i]);
	        }
	        
	        for (int i = 0; i < mesneJedi.length; i++) {
	            mesneJedi[i] = new TextButton("", storage.buttonStyle);
	        }
	        mesneJedi[0].setText("Puranji zrezek");
	        mesneJedi[1].setText("Piscancji zrezek");
	        mesneJedi[2].setText("Goveji zrezek");
	        mesneJedi[3].setText("Svinjski zrezek");
	        mesneJedi[4].setText("Klobasa");
	        for (int i = 0; i < mesneJedi.length; i++) {
	        	mesneJedi[i].setVisible(false);
	            izbira = mesneJedi[i].getText().toString();
	            final String finalIzbira = izbira;
	            mesneJedi[i].setColor(Color.LIGHT_GRAY);
	            mesneJedi[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraGlavna = finalIzbira;
	                    showHideButtons(4, 1);
	                    showHideButtons(1, 2);
	                }
	            });
	            mesneJedi[i].setSize(450, 50);
	            mesneJedi[i].setPosition(vp.getWorldWidth() / 8, initialY - i * yIncrement);
	            stage.addActor(mesneJedi[i]);
	        }
	        
	        losos = new TextButton("Losos", storage.buttonStyle);
	        losos.setColor(Color.LIGHT_GRAY);
	        final String finalIzbira = "Losos";
	        losos.addListener(new ClickListener() {
	            @Override
	            public void clicked(InputEvent event, float x, float y) {
	            	izbiraGlavna = finalIzbira;
	            	showHideButtons(1, 2);
	                showHideButtons(5, 1);
	            }
	        });
	        losos.setSize(450, 50);
	        losos.setPosition(vp.getWorldWidth() / 8, initialY);
	        losos.setVisible(false);
	        stage.addActor(losos);
	        
	        for (int i = 0; i < gSolate.length; i++) {
	        	gSolate[i] = new TextButton("", storage.buttonStyle);
	        }
	        gSolate[0].setText("Cezarjeva solata");
	        gSolate[1].setText("Solata z gamberi");
	        gSolate[2].setText("Solata s puranom");
	        for (int i = 0; i < gSolate.length; i++) {
	        	gSolate[i].setVisible(false);
	            izbira = gSolate[i].getText().toString();
	            final String finalIzbira1 = izbira;
	            gSolate[i].setColor(Color.LIGHT_GRAY);
	            gSolate[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraGlavna = finalIzbira1;
	                    showHideButtons(6, 1);
	                    showHideButtons(7, 2);
	                }
	            });
	            gSolate[i].setSize(450, 50);
	            gSolate[i].setPosition(vp.getWorldWidth() / 8, initialY - i * yIncrement);
	            stage.addActor(gSolate[i]);
	        }
	        
	        for (int i = 0; i < solate.length; i++) {
	        	solate[i] = new TextButton("", storage.buttonStyle);
	        }
	        solate[0].setText("Paradiznik");
	        solate[1].setText("Zelena solata");
	        solate[2].setText("Zelje");
	        solate[3].setText("Kumara");
	        solate[4].setText("Cicerika");
	        solate[5].setText("Fizol");
	        solate[6].setText("Koruza");
	        solate[7].setText("Motovilec");
	        solate[8].setText("Rukola");
	        solate[9].setText("Korenje");
	        solate[10].setText("Vinski kis");
	        solate[11].setText("Jogurtov preliv");
	        solate[12].setText("Cesnov preliv");
	        for (int i = 0; i < solate.length; i++) {
	        	solate[i].setVisible(false);
	            izbira = solate[i].getText().toString();
	            final String finalIzbira1 = izbira;
	            final int t = i;
	            solate[i].setColor(Color.LIGHT_GRAY);
	            solate[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                	solate[t].setTouchable(Touchable.disabled);
	                	solate[t].setDisabled(true);
	                	if(izbiraSolata == null)
	                		izbiraSolata = finalIzbira1;
	                	else
	                		izbiraSolata += ", " + finalIzbira1;
	                }
	            });
	            solate[i].setSize(450, 50);
	            solate[i].setPosition(vp.getWorldWidth() / 8, initialY2 - i * yIncrement2);
	            stage.addActor(solate[i]);
	        }
	        
	        for (int i = 0; i < priloge.length; i++) {
	            priloge[i] = new TextButton("", storage.buttonStyle);
	        }
	        priloge[0].setText("Prazen krompir");
	        priloge[1].setText("Pire krompir");
	        priloge[2].setText("Pomfri");
	        priloge[3].setText("Pecen krompir");
	        priloge[4].setText("Pecena zelenjava");
	        priloge[5].setText("Kislo zelje");
	        for (int i = 0; i < priloge.length; i++) {
	        	priloge[i].setVisible(false);
	            izbira = priloge[i].getText().toString();
	            final String finalIzbira1 = izbira;
	            priloge[i].setColor(Color.LIGHT_GRAY);
	            priloge[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraPriloga = finalIzbira1;
	                    showHideButtons(8, 1);
	                    showHideButtons(1, 2);
	                }
	            });
	            priloge[i].setSize(450, 50);
	            priloge[i].setPosition(vp.getWorldWidth() / 8, initialY - i * yIncrement);
	            stage.addActor(priloge[i]);
	        }
	        
	        for (int i = 0; i < predjedi.length; i++) {
	            predjedi[i] = new TextButton("", storage.buttonStyle);
	        }
	        predjedi[0].setText("Narezek");
	        predjedi[1].setText("Gobova juha");
	        predjedi[2].setText("Goveja juha");
	        for (int i = 0; i < predjedi.length; i++) {
	        	predjedi[i].setVisible(false);
	            izbira = predjedi[i].getText().toString();
	            final String finalIzbira1 = izbira;
	            predjedi[i].setColor(Color.LIGHT_GRAY);
	            predjedi[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraPredjed = finalIzbira1;
	                    showHideButtons(9, 1);
	                    showHideButtons(1, 2);
	                }
	            });
	            predjedi[i].setSize(450, 50);
	            predjedi[i].setPosition(vp.getWorldWidth() / 8, initialY - i * yIncrement);
	            stage.addActor(predjedi[i]);
	        }
	        
	        for (int i = 0; i < sladice.length; i++) {
	            sladice[i] = new TextButton("", storage.buttonStyle);
	        }
	        sladice[0].setText("Tiramisu");
	        sladice[1].setText("Palacinke");
	        for (int i = 0; i < sladice.length; i++) {
	        	sladice[i].setVisible(false);
	            izbira = sladice[i].getText().toString();
	            final String finalIzbira1 = izbira;
	            sladice[i].setColor(Color.LIGHT_GRAY);
	            sladice[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraSladica = finalIzbira1;
	                    showHideButtons(10, 1);
	                    showHideButtons(1, 2);
	                }
	            });
	            sladice[i].setSize(450, 50);
	            sladice[i].setPosition(vp.getWorldWidth() / 8, initialY - i * yIncrement);
	            stage.addActor(sladice[i]);	            
	        }
	        
	        for (int i = 0; i < pijace.length; i++) {
	            pijace[i] = new TextButton("", storage.buttonStyle);
	        }
	        pijace[0].setText("Lasko");
	        pijace[1].setText("Union");
	        pijace[2].setText("Budweiser");
	        pijace[3].setText("Radler");
	        pijace[4].setText("Vino (napisi izbiro v komentar)");
	        pijace[5].setText("Coca-cola");
	        pijace[6].setText("Sprite");
	        pijace[7].setText("Schweppes Bitter Lemon");
	        pijace[8].setText("Schweppes Tonic");
	        pijace[9].setText("Ledeni caj");
	        pijace[10].setText("Jabolcni sok");
	        for (int i = 0; i < pijace.length; i++) {
	        	pijace[i].setVisible(false);
	            izbira = pijace[i].getText().toString();
	            final String finalIzbira1 = izbira;
	            pijace[i].setColor(Color.LIGHT_GRAY);
	            pijace[i].addListener(new ClickListener() {
	                @Override
	                public void clicked(InputEvent event, float x, float y) {
	                    izbiraPijaca = finalIzbira1;
	                    showHideButtons(11, 1);
	                    showHideButtons(1, 2);
	                }
	            });
	            pijace[i].setSize(450, 50);
	            pijace[i].setPosition(vp.getWorldWidth() / 8, initialY2 - i * yIncrement2);
	            stage.addActor(pijace[i]);	            
	        }
	    }
	
	private void showHideButtons(int x, int y) {
		switch(x) {
		case 1:
			if(y == 1) {
				predjed.setVisible(false);
				glavneJedi.setVisible(false);
				priloga.setVisible(false);
				sladica.setVisible(false);
				pijaca.setVisible(false);
				solata.setVisible(false);
			}
			else if(y == 2) {
				predjed.setVisible(true);
				glavneJedi.setVisible(true);
				priloga.setVisible(true);
				sladica.setVisible(true);
				pijaca.setVisible(true);
				solata.setVisible(true);
			}
			break;
		case 2:
			if(y == 1) {
				for(int i = 0; i < testenine.length; i++) {
					testenine[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < testenine.length; i++) {
					testenine[i].setVisible(true);
				}
			}
			break;
		case 3:
			if(y == 1) {
				test.setVisible(false);
				mJed.setVisible(false);
				rJed.setVisible(false);
				sol.setVisible(false);
			}
			else if(y == 2) {
				test.setVisible(true);
				mJed.setVisible(true);
				rJed.setVisible(true);
				sol.setVisible(true);
			}
			break;
		case 4:
			if(y == 1) {
				for(int i = 0; i < mesneJedi.length; i++) {
					mesneJedi[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < mesneJedi.length; i++) {
					mesneJedi[i].setVisible(true);
				}
			}
			break;
		case 5:
			if(y == 1)
				losos.setVisible(false);
			else if(y == 2)
				losos.setVisible(true);
			break;
		case 6:
			if(y == 1) {
				for(int i = 0; i < gSolate.length; i++) {
					gSolate[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < gSolate.length; i++) {
					gSolate[i].setVisible(true);
				}
			}
			break;
		case 7:
			if(y == 1) {
				for(int i = 0; i < solate.length; i++) {
					solate[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < solate.length; i++) {
					solate[i].setTouchable(Touchable.enabled);
					solate[i].setDisabled(false);
					izbiraSolata = null;
					solate[i].setVisible(true);
				}
			}
			break;
		case 8:
			if(y == 1) {
				for(int i = 0; i < priloge.length; i++) {
					priloge[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < priloge.length; i++) {
					priloge[i].setVisible(true);
				}
			}
			break;
		case 9:
			if(y == 1) {
				for(int i = 0; i < predjedi.length; i++) {
					predjedi[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < predjedi.length; i++) {
					predjedi[i].setVisible(true);
				}
			}
			break;	
		case 10:
			if(y == 1) {
				for(int i = 0; i < sladice.length; i++) {
					sladice[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < sladice.length; i++) {
					sladice[i].setVisible(true);
				}
			}
			break;
		case 11:
			if(y == 1) {
				for(int i = 0; i < pijace.length; i++) {
					pijace[i].setVisible(false);
				}
			}
			else if(y == 2) {
				for(int i = 0; i < pijace.length; i++) {
					pijace[i].setVisible(true);
				}
			}
			break;
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		if(Gdx.input.isKeyPressed(Keys.F5)) {
			stage.clear();
			createComponents();
		}
		
		if(predjed.isVisible() && back != null)
			back.setVisible(false);
		else if(izbiraSolata == null && solate[0].isVisible())
			back.setVisible(false);
		else
			back.setVisible(true);	
		
		if(predjed.isVisible())
			oddaja.setVisible(true);
		else
			oddaja.setVisible(false);
		
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