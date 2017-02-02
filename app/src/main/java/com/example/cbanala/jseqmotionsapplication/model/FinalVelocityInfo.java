package com.example.cbanala.jseqmotionsapplication.model;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by chethanbanala on 2/2/17.
 */

public class FinalVelocityInfo  extends ScriptableObject {

    //v = v0 + at
    private double initialVelocity; //v0
    private double acceleration; //a
    private long time; //t
    private double finalVelocityInfo; //v


    @Override
    public String getClassName() {
        return "FinalVelocityInfo";
    }

    @Override
    public void put(String name, Scriptable start, Object value) {
        if(name.equals("initialVelocity")) {
            this.initialVelocity = ((Double) value).doubleValue();
        } else if (name.equals("acceleration")) {
            this.acceleration = ((Double) value).doubleValue();
        } else if (name.equals("time")) {
            this.time = ((Double) value).intValue();
        } else if (name.equals("finalVelocityInfo")) {
            this.finalVelocityInfo = ((Double) value).doubleValue();
        } else {
            super.put(name, start, value);
        }
    }

    @Override
    public Object get(String name, Scriptable start) {
        if(name.equals("initialVelocity")) {
            return this.initialVelocity;
        } else if(name.equals("acceleration")) {
            return this.acceleration;
        } else if(name.equals("time")) {
            return this.time;
        } else if (name.equals("finalVelocityInfo")) {
            return this.finalVelocityInfo;
        } else {
            return super.get(name, start);
        }
    }


    //Getters and Setters

    public double getInitialVelocity() {
        return initialVelocity;
    }

    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getFinalVelocityInfo() {
        return finalVelocityInfo;
    }

    public void setFinalVelocityInfo(double finalVelocityInfo) {
        this.finalVelocityInfo = finalVelocityInfo;
    }

}
