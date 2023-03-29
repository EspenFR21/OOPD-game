package com.github.hanyaeger.racing.entities.Auto;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HitBox extends RectangleEntity implements Collider {
    protected HitBox(Coordinate2D location) {
        super(location);
        setWidth(40);
        setHeight(15);
        setFill(Color.BLACK);

    }
}
