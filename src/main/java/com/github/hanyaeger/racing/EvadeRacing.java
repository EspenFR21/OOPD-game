package com.github.hanyaeger.racing;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.racing.scenes.End;
import com.github.hanyaeger.racing.scenes.GameBeschrijving;
import com.github.hanyaeger.racing.scenes.GameLevel;
import com.github.hanyaeger.racing.scenes.TitleScene;

public class EvadeRacing extends YaegerGame {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("EvadeRacing");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(1, new TitleScene(this));
        addScene(2, new GameLevel(this));
        addScene(3, new GameBeschrijving(this));
        addScene(4, new End(this));
    }

}
