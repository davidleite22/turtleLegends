package com.turtle.legends;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    final Drop game;

    OrthographicCamera camera;

    public MainMenuScreen(final Drop game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    public void render(float delta){
        ScreenUtils.clear(0,0,0.3f,1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.draw(game.batch,"Bem vindo ao jogo ",500,650);
        game.font.draw(game.batch, "PRESSIONE ENTER ",500,100);
        game.batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            game.setScreen(new CharacterSelectionScreen(game));
            dispose();
        }
    }

    @Override
    public void show() {

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
    public void dispose() {

    }


}
