package com.github.hanyaeger.racing.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Auto.HitBox;
import com.github.hanyaeger.racing.entities.text.MuntText;

import java.util.Random;

public class Munt extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided {

    private MuntText muntText;

    private double muntX = 1;
    private double Munt = 0;


    public Munt(Coordinate2D location, MuntText muntText) {
        super("sprites/Munt.png", location);
        setMotion(3, 270d);

        this.muntText = muntText;
        muntText.setMuntText(Munt);

    }

    public void setMuntX(double muntX) {
        this.muntX = muntX;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }

    @Override
    public synchronized void onCollision(Collider collidingObject) {
        if (collidingObject instanceof HitBox) {
            Munt += muntX;
            muntText.setMuntText(Munt);

            setAnchorLocationX(getSceneWidth());
            setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
        }

    }
}
