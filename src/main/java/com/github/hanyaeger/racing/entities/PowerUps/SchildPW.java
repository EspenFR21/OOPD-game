package com.github.hanyaeger.racing.entities.PowerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Auto.HitBox;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.Obstakels.Obstakels;
import com.github.hanyaeger.racing.entities.spawner.PowerUpSpawner;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SchildPW extends PowerUps {

    private Auto auto;
    private Munt munt;

    private PowerUpSpawner powerUpSpawner;

    private Obstakels AutoObstakel;
    private Obstakels TonObstakel;

    private ArrayList<Obstakels> obstakels;


    public SchildPW(Coordinate2D location, Auto auto, PowerUpSpawner powerUpSpawner, Munt munt, Obstakels AutoObstakel, Obstakels TonObstakel, ArrayList<Obstakels> obstakels) {
        super(location, "PowerUp/Schild_PowerUp.png", new Size(15, 15), auto, munt, AutoObstakel, TonObstakel);

        this.powerUpSpawner = powerUpSpawner;
        this.auto = auto;
        this.munt = munt;
        this.AutoObstakel = AutoObstakel;
        this.TonObstakel = TonObstakel;
        this.obstakels = obstakels;
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.LEFT) {
            remove();
            powerUpSpawner.setSpawnPowerUp(true);
        }
    }


    public void doePowerup() {
        remove();
        pauzeerObstakels();
        powerUpSpawner.setSpawnPowerUp(true);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("test3");
                activeerObstakels();
                timer.cancel();}
        };
        timer.schedule(timerTask, 5000);
    }

    public void pauzeerObstakels() {
        for (Obstakels obstakel : obstakels) {
            obstakel.setMotion(0, 0);
        }
    }

    public void activeerObstakels() {
        for (Obstakels obstakel : obstakels) {
            obstakel.setMotion(5, 270d);
        }
    }
}
