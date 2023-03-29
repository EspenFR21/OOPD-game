package com.github.hanyaeger.racing.entities.Obstakels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.text.HealthText;

import java.util.Random;

public class AutoObstakel extends Obstakels {
    private Auto auto;

    public AutoObstakel(Coordinate2D location, HealthText healthText, EvadeRacing evadeRacing, Auto auto) {
        super(location, healthText, "Obstakels/Auto_Obstakel.png", evadeRacing, new Size(5, 5), auto);
        this.auto = auto;
        this.evadeRacing = evadeRacing;
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
            setAnchorLocationX(getSceneWidth());
            setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 81));
    }


    @Override
    public void onCollision(Collider collidingObject) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 81));

        auto.setHealth(auto.getHealth() - 2);
        System.out.println(auto.getHealth());
        if (auto.getHealth() < 1) {
            System.out.println("test");
            evadeRacing.setActiveScene(4);
        }
        healthText.setHealthText(auto.getHealth());

    }
    }

