package com.example.cbanala.jseqmotionsapplication.bridge;

import android.content.Context;

import com.example.cbanala.jseqmotionsapplication.base.EQMotionsApplication;
import com.example.cbanala.jseqmotionsapplication.model.FinalVelocityInfo;
import com.example.cbanala.jseqmotionsapplication.model.KineticEnergy;
import com.example.cbanala.jseqmotionsapplication.model.Momentum;
import com.example.cbanala.jseqmotionsapplication.model.Weight;

import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptableObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chethanbanala on 2/2/17.
 */

public class JSBridge {


    private final Context mContext;
    private org.mozilla.javascript.Context rhino;
    private ScriptableObject scope;

    public JSBridge(Context context) {
        this.mContext = context;
    }

    //Start the Rhino Engine...
    public void startEngine() throws IOException {
        //Get the Rhino Context
        rhino = org.mozilla.javascript.Context.enter();
        //Set it to Android Compatible Level
        rhino.setOptimizationLevel(-1);
        scope = rhino.initStandardObjects();
        //Load the script from the asset folder
        rhino.evaluateReader(scope, new BufferedReader(
                new InputStreamReader(mContext.getAssets().open("script.js"))),"JavaScript",1,null);
    }

    public FinalVelocityInfo calculateVelocityInfo(FinalVelocityInfo finalVelocityInfo) {
        Object[] params = new Object[]{finalVelocityInfo};
        Object obj = scope.get("getVelocityInfo", scope);
        Function jsFunction = (Function) obj;
        return (FinalVelocityInfo) jsFunction.call(rhino,scope,scope, params);
    }

    public KineticEnergy calcualteKineticEnergyInfo(FinalVelocityInfo resultOfFinalVelocityInfo, double mass) {
        Object[] params = new Object[]{new KineticEnergy(), resultOfFinalVelocityInfo, mass};
        Object obj = scope.get("getKineticEnergyInfo", scope);
        Function jsFunction = (Function) obj;
        return (KineticEnergy) jsFunction.call(rhino,scope,scope,params);
    }

    public Momentum calculateMomentum(double mass, FinalVelocityInfo resultOfFinalVelocityInfo) {
        Object[] params = new Object[]{new Momentum(),mass, resultOfFinalVelocityInfo};
        Object obj = scope.get("getMomentum", scope);
        Function jsFunction = (Function) obj;
        return (Momentum) jsFunction.call(rhino, scope, scope, params);
    }

    public Weight calculateWeight(double mass) {
        Object[] params = new Object[]{new Weight(), mass};
        Object obj = scope.get("getWeight", scope);
        Function jsFunction = (Function) obj;
        return (Weight) jsFunction.call(rhino,scope,scope,params);
    }
}
