package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Cenario {
    private Rectangle cenario;
    private Rectangle minirect;
    private Text score;

    public Cenario() {
        this.cenario = new Rectangle(10,10,1200,800);
        cenario.draw();
        this.minirect = new Rectangle(10,510,1200,300);
        minirect.setColor(Color.BLUE);
        minirect.fill();
        score = new Text( 1120,40, "0/10");
        score.draw();
        score.grow(50,50);
    }

    public int getCenarioHeight() {
        return cenario.getHeight();
    }

    public int getCenarioWidth() {
        return cenario.getWidth();
    }

    public void setScore(String s) {
        score.setText(s);
    }
}
