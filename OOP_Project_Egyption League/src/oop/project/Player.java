/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

/**
 *
 * @author LEGION R
 */


enum Position{
   GK,CB,LB,RB,DMF,CMF,AMF,SS,RW,LW,FC
}

public class Player extends Person {
    Position position;
    
    
    
    public Player(String name, float height, float weight, Position position) {
        super(name, height, weight);
        this.position = position;
    }


    @Override
    public String toString() {
        return getName()+" "+getHeight()+" "+getWeight()+" "+position;
    }
    
}
