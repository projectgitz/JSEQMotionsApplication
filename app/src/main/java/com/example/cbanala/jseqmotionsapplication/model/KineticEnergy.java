package com.example.cbanala.jseqmotionsapplication.model;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by chethanbanala on 2/2/17.
 */

public class KineticEnergy extends ScriptableObject {

    //K = (1/2)mv2
    private double kineticEnergy;
    private double mass;
    private double velocity;

    @Override
    public String getClassName() {
        return "KineticEnergy";
    }

    @Override
    public void put(String name, Scriptable start, Object value) {
        if(name.equals("kineticEnergy")) {
            this.kineticEnergy = ((Double) value).doubleValue();
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
        if(name.equals("kineticEnergy")) {
            return  this.kineticEnergy;
        } else if(name.equals("mass")) {
            return  this.mass;
        } else if(name.equals("velocity")) {
            return  this.velocity;
        } else {
            return super.get(name, start);
        }
    }

    //Generate Getters and Setters

    public double getKineticEnergy() {
        return kineticEnergy;
    }

    public void setKineticEnergy(double kineticEnergy) {
        this.kineticEnergy = kineticEnergy;
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
