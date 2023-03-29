package com.github.hanyaeger.racing.entities.Obstakels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.text.HealthText;

public abstract class Obstakels extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher {

    protected EvadeRacing evadeRacing;

    public HealthText healthText;

    private Auto auto;


    public Obstakels(Coordinate2D location, HealthText healthText, String imagePath, EvadeRacing evadeRacing, Size size, Auto auto) {
        super(imagePath, location);
        setMotion(5, 270d);
        this.evadeRacing = evadeRacing;

        this.auto = auto;

        this.healthText = healthText;
        healthText.setHealthText(auto.getHealth());

    }


    @Override
    public abstract void onCollision(Collider collidingObject);

}




