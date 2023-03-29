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

public class MushroomPD extends PowerDowns {

    private Auto auto;
    private Munt munt;

    private PowerDownSpawner powerDownSpawner;

    public MushroomPD(Coordinate2D location, Auto auto, PowerDownSpawner powerDownSpawner, Munt munt) {
        super(location, "PowerDowns/Mushroom_PowerDown.png", new Size(15, 15), auto, munt);

        this.powerDownSpawner = powerDownSpawner;
        this.auto = auto;
        this.munt = munt;
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border == SceneBorder.LEFT) {
            remove();
            powerDownSpawner.setSpawnPowerDown(true);
        }
    }

    @Override
    public void doePowerDown() {
        remove();
        auto.setAutoSpeed(1);
        powerDownSpawner.setSpawnPowerDown(true);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                auto.setAutoSpeed(3);
                timer.cancel();}
        };
        timer.schedule(timerTask, 5000);
    }
}
