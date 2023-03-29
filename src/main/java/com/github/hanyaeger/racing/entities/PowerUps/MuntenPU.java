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

import java.util.Timer;
import java.util.TimerTask;

public class MuntenPU extends PowerUps{

    private Auto auto;
    private PowerUpSpawner powerUpSpawner;
    private Munt munt;
    private Obstakels AutoObstakel;
    private Obstakels TonObstakel;


    public MuntenPU(Coordinate2D location, Auto auto, PowerUpSpawner powerUpSpawner, Munt munt, Obstakels AutoObstakel, Obstakels TonObstakel) {
        super(location, "PowerUp/Munten_PowerUp.png", new Size(15, 15), auto, munt, AutoObstakel, TonObstakel);

        this.powerUpSpawner = powerUpSpawner;
        this.auto = auto;
        this.munt = munt;
        this.AutoObstakel = AutoObstakel;
        this.TonObstakel = TonObstakel;

    }
    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof HitBox) {
            remove();
            munt.setMuntX(2);
            powerUpSpawner.setSpawnPowerUp(true);

            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    munt.setMuntX(1);
                    timer.cancel();}
            };
            timer.schedule(timerTask, 10000);

        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.LEFT) {
            remove();
            powerUpSpawner.setSpawnPowerUp(true);
        }
    }
}
