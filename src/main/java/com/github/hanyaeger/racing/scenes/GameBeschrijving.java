package com.github.hanyaeger.racing.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.buttons.HomeButton;
import com.github.hanyaeger.racing.entities.buttons.StartButton;

public class GameBeschrijving extends TitleScene{

    private EvadeRacing evadeRacing;
    public GameBeschrijving(EvadeRacing evadeRacing) {

        this.evadeRacing = evadeRacing;
    }

    public void setupScene() {
        setBackgroundImage("backgrounds/Scherm_GameBeschrijving.png");
    }

    @Override
    public void setupEntities() {

        HomeButton homeButton = new HomeButton(new Coordinate2D(getWidth() / 1.3, getHeight() / 1.4), evadeRacing);
        addEntity(homeButton);
    }
}
