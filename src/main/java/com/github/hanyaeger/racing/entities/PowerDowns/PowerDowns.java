package com.github.hanyaeger.racing.entities.PowerDowns;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.racing.entities.Auto.Auto;
import com.github.hanyaeger.racing.entities.Auto.HitBox;
import com.github.hanyaeger.racing.entities.Munt;

    public abstract class PowerDowns extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided {
        public PowerDowns (Coordinate2D location, String imagePath, Size size, Auto auto, Munt munt) {
            super(imagePath, location);
            setMotion(3, 270d);
        }

        @Override
        public void onCollision(Collider collidingObject) {
            if (collidingObject instanceof HitBox) {
                doePowerDown();
            }
        }

        public abstract void doePowerDown();
    }

