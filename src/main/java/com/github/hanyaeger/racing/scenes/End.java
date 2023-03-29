package com.github.hanyaeger.racing.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.buttons.HomeButton;
import com.github.hanyaeger.racing.entities.text.MuntText;

public class End extends StaticScene {

    private EvadeRacing evadeRacing;


    public End (EvadeRacing evadeRacing) {

        this.evadeRacing = evadeRacing;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/End_Scherm.png");
    }

    @Override
    public void setupEntities() {

        HomeButton homeButton = new HomeButton(new Coordinate2D(getWidth() / 2.4, getHeight() / 2), evadeRacing);
        addEntity(homeButton);

    }
}
