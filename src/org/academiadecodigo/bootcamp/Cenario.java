package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cenario {
    private Rectangle cenario;
    private Rectangle minirect;

    public Cenario() {
        this.cenario = new Rectangle(10,10,1200,800);
        cenario.draw();
        this.minirect = new Rectangle(10,510,1200,300);
        minirect.setColor(Color.BLUE);
        minirect.fill();
    }

    public int getCenarioHeight() {
        return cenario.getHeight();
    }

    public int getCenarioWidth() {
        return cenario.getWidth();
    }
}
