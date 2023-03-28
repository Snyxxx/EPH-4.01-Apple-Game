package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ChinesePear extends Pear {

    double timer = 0;
    double speedX = Math.random()*100+100;


    public ChinesePear(double x, double y){
        super(x,y);
        width = 25;
        height = 35;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);

        drawTool.setCurrentColor(200,100,0,255);
        drawTool.drawFilledRectangle(x+7.5,y-10,10,15);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x+7.5,y-10,10,15);
    }

    @Override
    public void update(double dt) {
        //TODO 03 Eine Birne soll von oben herab fallen. Sobald sie unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 04).
        super.update(dt);
        timer = timer+dt;
        if (timer > 1.5) {
            timer = 0;
        }
        if(timer < 0.75){
            x = x - speedX*dt;
        }else{
            x = x + speedX*dt;
        }
    }
    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
    public void jumpBack(){
        y = 0;
        x = Math.random()*1000;


    }
}
