package com.github.hanyaeger.racing.entities.PowerDowns;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Auto.HitBox;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.spawner.PowerDownSpawner;
import javafx.scene.input.KeyCode;

import java.util.Timer;
import java.util.TimerTask;

public class PoisonPD extends PowerDowns {

    private Auto auto;
    private Munt munt;

    private PowerDownSpawner powerDownSpawner;

    public PoisonPD(Coordinate2D location, Auto auto, PowerDownSpawner powerDownSpawner, Munt munt) {
        super(location, "PowerDowns/Poison_PowerDown.png", new Size(15, 15), auto, munt);

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

    public void doePowerDown() {
        remove();
        auto.setKeyUp(KeyCode.DOWN);
        auto.setKeyDown(KeyCode.UP);

        powerDownSpawner.setSpawnPowerDown(true);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                auto.setKeyUp(KeyCode.UP);
                auto.setKeyDown(KeyCode.DOWN);
                timer.cancel();}
        };
        timer.schedule(timerTask, 10000);
    }

}
