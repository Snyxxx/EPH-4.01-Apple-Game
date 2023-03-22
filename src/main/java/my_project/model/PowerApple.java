package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class PowerApple extends Apple {

    public PowerApple(double x, double y) {
        super(x, y);
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
        drawTool.setCurrentColor(200,100,0,255);
        drawTool.drawFilledRectangle(x-4,y-radius*1.5,10,20);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x-4,y-radius*1.5,10,20);
    }

    public void update(double dt) {

        super.update(dt);

    }
}
