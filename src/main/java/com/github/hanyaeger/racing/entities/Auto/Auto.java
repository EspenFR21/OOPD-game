package com.github.hanyaeger.racing.entities.Auto;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.racing.EvadeRacing;
import com.github.hanyaeger.racing.entities.PowerUps.MushroomPW;
import com.github.hanyaeger.racing.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Auto extends DynamicCompositeEntity implements KeyListener, SceneBorderCrossingWatcher{

    private EvadeRacing evadeRacing;
    private int health = 5;

    private double autoSpeed = 3;

    KeyCode keyUp = KeyCode.UP;
    KeyCode keyDown = KeyCode.DOWN;

    public Auto(Coordinate2D location, HealthText healthText, EvadeRacing evadeRacing) {
        super(location);

        this.evadeRacing = evadeRacing;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setAutoSpeed(double autoSpeed) {
        this.autoSpeed = autoSpeed;
    }

    public void setKeyUp(KeyCode keyUp) {
        this.keyUp = keyUp;
    }
    public void setKeyDown(KeyCode keyDown) {
        this.keyDown = keyDown;
    }



    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(keyUp)){
            setMotion(autoSpeed,180d);
        } else if(pressedKeys.contains(keyDown)){
            setMotion(autoSpeed,0d);
        } else {
            setMotion(0,0);
        }

    }

    @Override
    protected void setupEntities() {
        var AutoSprite = new AutoSprite(new Coordinate2D(0, getHeight()/2));
        addEntity(AutoSprite);

        var HitBox = new HitBox(new Coordinate2D(25, (getHeight()/2) + 21));
        addEntity(HitBox);
    }
}
