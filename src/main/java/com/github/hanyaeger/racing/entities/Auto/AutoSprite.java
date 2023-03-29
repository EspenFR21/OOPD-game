package com.github.hanyaeger.racing.entities.Auto;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class AutoSprite extends SpriteEntity {

    public AutoSprite (Coordinate2D location) {
        super("sprites/Auto.png", location);
    }
}
