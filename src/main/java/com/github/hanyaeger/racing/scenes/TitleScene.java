package com.github.hanyaeger.racing.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.buttons.GameBeschrijvingButton;
import com.github.hanyaeger.racing.entities.buttons.StartButton;


public class TitleScene extends StaticScene {

    private EvadeRacing evadeRacing;

    public TitleScene(EvadeRacing evadeRacing){
        this.evadeRacing = evadeRacing;
    }

    public TitleScene() {
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Start_Pagina.png");
    }

    @Override
    public void setupEntities() {

        StartButton startButton = new StartButton(new Coordinate2D(getWidth() / 2.7, getHeight() / 1.7), evadeRacing);
        addEntity(startButton);

        GameBeschrijvingButton gameBeschrijvingButton = new GameBeschrijvingButton(new Coordinate2D(getWidth() / 3.2, getHeight() / 1.45), evadeRacing);
        addEntity(gameBeschrijvingButton);
    }
}
