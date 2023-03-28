package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private int points;
    private int pears;
    private int apples;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    private boolean speedboost;
    private boolean urTooSlow;
    private double timer;
    private double timer2;
    private boolean pPlus;
    private boolean pMinus;
    private boolean applesC;
    private boolean pearsC;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;
        speedboost = false;
        urTooSlow = false;
        timer = 0;
        timer2 = 0;

        this.keyToGoLeft = KeyEvent.VK_A;
        this.keyToGoRight = KeyEvent.VK_D;
        this.direction = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157, 152, 3, 255);
        drawTool.drawFilledRectangle(x, y, width, height);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawRectangle(x, y, width, height);

        drawTool.drawText(10,10,"Speed: " + speed);
        drawTool.drawText(10,25,"Buffed: " + speedboost);
        drawTool.drawText(10,40,"Debuffed: " + urTooSlow);

        drawTool.drawText(450,30,"Points: " + points);

        drawTool.drawText(390,30,"Pears: " + pears);
        drawTool.drawText(520,30,"Apples: " + apples);
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if (direction == 0 && x + width < Config.WINDOW_WIDTH - 15) {
            x = x + speed * dt;
        }
        if (direction == 2 && x > 0) {
            x = x - speed * dt;
        }

        if (x < 0) {
            x = 0;
        }

        if (speedboost){
            timer += dt;
            urTooSlow = false;
            timer2 = 0;

            if (timer<=5){
                speed = Math.random() + 200;
            }else{
                speed = 150;
                timer = 0;
                speedboost = false;
            }
        }

        if (urTooSlow){
            timer2 += dt;
            speedboost = false;
            timer = 0;

            if (timer2<=5){
                speed = Math.random() + 50;
            }else{
                speed = 150;
                timer2 = 0;
                urTooSlow = false;
            }
        }

        if (pMinus){
            points -= 1;
            pMinus = false;
        }

        if (pPlus){
            points += 1;
            pPlus = false;
        }

        if (pearsC){
            pears += 1;
            pearsC = false;
        }

        if (applesC){
            apples += 1;
            applesC = false;
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    public void speedboost(){ speedboost = true; }
    public void urTooSlow(){ urTooSlow = true; }

    public void setPointsPlus(){ pPlus = true; }
    public void setPointsMinus(){ pMinus = true; }

    public void pearsCollected(){ pearsC = true; }
    public void applesCollected(){ applesC = true; }
}
