package my_project.model;

import KAGO_framework.model.GraphicalObject;

public class Fruit extends GraphicalObject {

    protected double speed;

    public Fruit(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
    }

    public void update(double dt){
        y += speed*dt;

        if(y > 1000){
            jumpBack();
        }
    }
    public void jumpBack(){}
}
