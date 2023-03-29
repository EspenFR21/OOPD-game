package com.github.hanyaeger.racing.entities.PowerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Munt;
import com.github.hanyaeger.racing.entities.Obstakels.Obstakels;

public abstract class PowerUps extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided {
    public PowerUps(Coordinate2D location, String imagePath, Size size, Auto auto, Munt munt, Obstakels AutoObstakel, Obstakels TonObstakel) {
        super(imagePath, location);
        setMotion(3, 270d);
    }
}
