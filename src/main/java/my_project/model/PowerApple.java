package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class PowerApple extends Apple {

    public PowerApple(double x, double y) {
        super(x, y);
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,255,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

}
