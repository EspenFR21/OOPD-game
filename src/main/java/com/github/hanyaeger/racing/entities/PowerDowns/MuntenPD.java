package com.github.hanyaeger.racing.entities.PowerDowns;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Auto.HitBox;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.spawner.PowerDownSpawner;

import java.util.Timer;
import java.util.TimerTask;

public class MuntenPD extends PowerDowns {

    private Auto auto;
    private PowerDownSpawner powerDownSpawner;
    private Munt munt;

    public MuntenPD(Coordinate2D location, Auto auto, PowerDownSpawner powerDownSpawner, Munt munt) {
        super(location, "PowerDowns/Munten_PowerDown.png", new Size(15, 15), auto, munt);

        this.powerDownSpawner = powerDownSpawner;
        this.auto = auto;
        this.munt = munt;
    }
    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof HitBox) {
            remove();
            munt.setMuntX(0.5);
            powerDownSpawner.setSpawnPowerDown(true);

            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    munt.setMuntX(1);
                    timer.cancel();
                }
            };
            timer.schedule(timerTask, 10000);

        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.LEFT) {
            remove();
            powerDownSpawner.setSpawnPowerDown(true);
        }
    }
}
