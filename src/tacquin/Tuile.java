/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tacquin;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Gus
 */
public class Tuile {
    
    private Pane p ; //= new Pane(); // panneau utilisé pour dessiner une tuile
    private Label c;
    private int place = 0;
    private int x; // Place en px
    private int y; // Place en px
    private boolean display;
    
    
    public Tuile(int vx,int vy,String value){
        c = new Label(value);
        this.x= vx;
        this.y = vy;
        this.display = true;
    }

    public Label getC() {
        return c;
    }

    public void setC(Label c) {
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Pane getP() {
        return p;
    }

    public void setP(Pane p) {
        this.p = p;
    }
    
    
    
    
    
    
}
