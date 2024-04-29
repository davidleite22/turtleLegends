package com.turtle.legends;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CharacterSelectionScreen implements Screen {
    private Stage stage;
    private Array<Character> characters;
    private int selectedCharacterIndex = 0;
    private Sound dropSound;

    public CharacterSelectionScreen(final Drop game) {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        characters = new Array<>();
        characters.add(new Character("David", "tony.png"));
        characters.add(new Character("Jeff", "capivara.png"));
        characters.add(new Character("Tigas", "tigas.png"));
        characters.add(new Character("Cesinha", "cesar.png"));
        // Adicione quantos personagens você precisar

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        for (final Character character : characters) {
            Image characterImage = new Image(character.getTexture());
            characterImage.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    selectedCharacterIndex = characters.indexOf(character, true);
                    if(selectedCharacterIndex == 0){
                        dropSound = Gdx.audio.newSound(Gdx.files.internal("vai.mp3"));
                        dropSound.play();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        game.setScreen(new TelaDoJogoPrincipal(game,"ovo.png","tony.png","wow.mp3"));

                    }
                    if(selectedCharacterIndex == 1){
                        dropSound = Gdx.audio.newSound(Gdx.files.internal("desgraca.mp3"));
                        dropSound.play();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        game.setScreen(new TelaDoJogoPrincipal(game,"vinho.png","capivara.png","heheboi.mp3"));

                    }
                    if(selectedCharacterIndex == 2){
                        dropSound = Gdx.audio.newSound(Gdx.files.internal("semzap.mp3"));
                        dropSound.play();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        game.setScreen(new TelaDoJogoPrincipal(game,"canudo.png","tigas.png","glup.mp3"));
                    }
                    if(selectedCharacterIndex == 3){
                        dropSound = Gdx.audio.newSound(Gdx.files.internal("miau.mp3"));
                        dropSound.play();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        game.setScreen(new TelaDoJogoPrincipal(game,"waifu.png","cesar.png","yamete.mp3"));
                    }
                    System.out.println("Personagem selecionado: " + character.getName());
                }
            });
            table.add(characterImage).pad(20);
        }
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
