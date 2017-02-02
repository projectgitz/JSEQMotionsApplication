package com.example.cbanala.jseqmotionsapplication.model;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by chethanbanala on 2/2/17.
 */

public class Momentum extends ScriptableObject {

    //p = mv
    private double p;
    private double mass;
    private double velocity;


    @Override
    public String getClassName() {
        return "Momentum";
    }

    @Override
    public void put(String name, Scriptable start, Object value) {
        if(name.equals("p")) {
            this.p = ((Double) value).doubleValue();
        } else if(name.equals("mass")) {
            this.mass = ((Double) value).doubleValue();
        } else if(name.equals("velocity")) {
            this.velocity = ((Double) value).doubleValue();
        } else {
            super.put(name, start, value);
        }
    }


    @Override
    public Object get(String name, Scriptable start) {
        if(name.equals("p")) {
            return  this.p;
        } else if(name.equals("mass")) {
            return  this.mass;
        } else if(name.equals("velocity")) {
            return  this.velocity;
        } else {
            return super.get(name, start);
        }
    }

    //Generate Getters and Setters
    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}
