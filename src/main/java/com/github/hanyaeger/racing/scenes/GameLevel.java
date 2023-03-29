package com.github.hanyaeger.racing.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.Obstakels.Obstakels;
import com.github.hanyaeger.racing.entities.spawner.PowerDownSpawner;
import com.github.hanyaeger.racing.entities.spawner.PowerUpSpawner;
import com.github.hanyaeger.racing.entities.text.HealthText;
import com.github.hanyaeger.racing.entities.text.MuntText;

import com.github.hanyaeger.racing.entities.Obstakels.AutoObstakel;
import com.github.hanyaeger.racing.entities.Obstakels.TonObstakel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private EvadeRacing evadeRacing;
    private Auto auto;

    private Munt munt;
    private Obstakels AutoObstakel;
    private Obstakels TonObstakel;

    private ArrayList<Obstakels> obstakelsArrayList = new ArrayList<Obstakels>();

    public GameLevel(EvadeRacing evadeRacing) {

        this.evadeRacing = evadeRacing;

    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/Achtergrond_Weg (2).png");
    }

    private Coordinate2D randomLocation(){
        double y = new Random().nextInt((int) getHeight());
        return new Coordinate2D(getWidth(), y);
    }


    @Override
    public void setupEntities() {

        HealthText healthText = new HealthText(new Coordinate2D(0, 0));
        addEntity(healthText);

        MuntText muntText = new MuntText(new Coordinate2D(600, 0));
        addEntity(muntText);

        Auto auto = new Auto(new Coordinate2D(0, getHeight() / 2), healthText, evadeRacing);
        addEntity(auto);
        this.auto = auto;

        Munt munt = new Munt(randomLocation(), muntText);
        addEntity(munt);
        this.munt = munt;

        Obstakels eersteTon = new TonObstakel(randomLocation(), healthText, evadeRacing, auto);
        Obstakels eersteAuto = new AutoObstakel(randomLocation(), healthText, evadeRacing, auto);
        obstakelsArrayList.add(eersteTon);
        obstakelsArrayList.add(eersteAuto);
        addObstakels(eersteTon);
        addObstakels(eersteAuto);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Obstakels tweedeTon = new TonObstakel(randomLocation(), healthText, evadeRacing, auto);
                Obstakels tweedeAuto = new AutoObstakel(randomLocation(), healthText, evadeRacing, auto);
                obstakelsArrayList.add(tweedeTon);
                obstakelsArrayList.add(tweedeAuto);
                addObstakels(tweedeTon);
                addObstakels(tweedeAuto);
            }
        };
        timer.schedule(timerTask, 10000);

    }


    public void addObstakels(Obstakels obstakel) {
        addEntity(obstakel);
    }

    @Override
    public void setupEntitySpawners() {

        addEntitySpawner(new PowerUpSpawner(getWidth(), getHeight(), auto, munt, AutoObstakel, TonObstakel, obstakelsArrayList));
        addEntitySpawner(new PowerDownSpawner(getWidth(), getHeight(), auto, munt));
    }

}









