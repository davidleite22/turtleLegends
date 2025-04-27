package com.turtle.legends;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Character {
    private String name;
    private Texture texture;

    public Character(String name, String texturePath) {
        this.name = name;
        this.texture = new Texture(Gdx.files.internal(texturePath));
    }

    public Texture getTexture() {
        return texture;
    }

    public String getName() {
        return name;
    }


}
