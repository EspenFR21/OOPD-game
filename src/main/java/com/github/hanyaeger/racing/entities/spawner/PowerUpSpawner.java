package com.github.hanyaeger.racing.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.Obstakels.Obstakels;
import com.github.hanyaeger.racing.entities.PowerUps.MuntenPU;
import com.github.hanyaeger.racing.entities.PowerUps.MushroomPW;
import com.github.hanyaeger.racing.entities.PowerUps.SchildPW;

import java.util.ArrayList;
import java.util.Random;

public class PowerUpSpawner extends EntitySpawner {

    private boolean spawnPowerUp = true;
    private final double sceneHeight;
    private final double sceneWidth;
    private Auto auto;
    private Munt munt;

    private Obstakels AutoObstakel;
    private Obstakels TonObstakel;

    private ArrayList<Obstakels> obstakels;

    public PowerUpSpawner(double sceneWidth, double sceneHeight, Auto auto, Munt munt, Obstakels AutoObstakel, Obstakels TonObstakel, ArrayList<Obstakels> obstakels) {
        super(100);

        this.AutoObstakel = AutoObstakel;
        this.TonObstakel = TonObstakel;
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.auto = auto;
        this.munt = munt;
        this.obstakels = obstakels;
    }

    public void setSpawnPowerUp(boolean spawnPowerUp){
        this.spawnPowerUp = spawnPowerUp;
    }
    @Override
    protected void spawnEntities() {
        int random = new Random().nextInt(100);
        if (spawnPowerUp == true) {
            if (random < 2) {
                spawn(new MushroomPW(randomLocation(), auto, this, munt, AutoObstakel, TonObstakel));
                spawnPowerUp = false;
            } else if (random < 4) {
                spawn(new MuntenPU(randomLocation(), auto, this, munt, AutoObstakel, TonObstakel));
                spawnPowerUp = false;
            } else if (random < 10) {
                spawn(new SchildPW(randomLocation(), auto, this, munt, AutoObstakel, TonObstakel, obstakels));
                spawnPowerUp = false;
            }
        }
    }

    private Coordinate2D randomLocation(){
        double y = new Random().nextInt((int) sceneHeight);
        return new Coordinate2D(sceneWidth, y);
    }
}
