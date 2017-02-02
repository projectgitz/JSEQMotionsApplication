package com.example.cbanala.jseqmotionsapplication.model;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by chethanbanala on 2/2/17.
 */

public class Weight extends ScriptableObject {

    //W= mg;
    private double weight;
    private double mass;
    private double gravity;

    @Override
    public String getClassName() {
        return "Weight";
    }

    @Override
    public void put(String name, Scriptable start, Object value) {
        if(name.equals("weight")) {
            this.weight = ((Double) value).doubleValue();
        } else if(name.equals("mass")) {
            this.mass = ((Double) value).doubleValue();
        } else if(name.equals("gravity")) {
            this.gravity = ((Double) value).doubleValue();
        } else {
            super.put(name, start, value);
        }
    }

    @Override
    public Object get(String name, Scriptable start) {
        if(name.equals("weight")) {
            return  this.weight;
        } else if(name.equals("mass")) {
            return  this.mass;
        } else if(name.equals("gravity")) {
            return  this.gravity;
        } else {
            return super.get(name, start);
        }
    }

    //Getters and Setters

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}
