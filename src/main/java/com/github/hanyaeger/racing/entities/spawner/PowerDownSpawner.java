package com.github.hanyaeger.racing.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.PowerDowns.MuntenPD;
import com.github.hanyaeger.racing.entities.PowerDowns.MushroomPD;
import com.github.hanyaeger.racing.entities.PowerDowns.PoisonPD;

import java.util.Random;

public class PowerDownSpawner extends EntitySpawner {

    private boolean spawnPowerDown = true;
    private final double sceneHeight;
    private final double sceneWidth;
    private Auto auto;
    private Munt munt;

    public PowerDownSpawner(double sceneWidth, double sceneHeight, Auto auto, Munt munt) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.auto = auto;
        this.munt = munt;
    }

    public void setSpawnPowerDown(boolean spawnPowerUp){
        this.spawnPowerDown = spawnPowerUp;
    }
    @Override
    protected void spawnEntities() {
        int random = new Random().nextInt(100);
        if (spawnPowerDown == true) {
            if (random < 4) {
                spawn(new MushroomPD(randomLocation(), auto, this, munt));
                spawnPowerDown = false;
            } else if (random < 8) {
                spawn(new MuntenPD(randomLocation(), auto, this, munt));
                spawnPowerDown = false;
            } else if(random < 12) {
                spawn(new PoisonPD(randomLocation(), auto, this, munt));
                spawnPowerDown = false;
            }
        }
    }

    private Coordinate2D randomLocation(){
        double y = new Random().nextInt((int) sceneHeight);
        return new Coordinate2D(sceneWidth, y);
    }
}
