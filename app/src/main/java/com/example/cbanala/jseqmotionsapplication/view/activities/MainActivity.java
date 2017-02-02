package com.example.cbanala.jseqmotionsapplication.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cbanala.jseqmotionsapplication.R;
import com.example.cbanala.jseqmotionsapplication.base.EQMotionsApplication;
import com.example.cbanala.jseqmotionsapplication.bridge.JSBridge;
import com.example.cbanala.jseqmotionsapplication.model.FinalVelocityInfo;
import com.example.cbanala.jseqmotionsapplication.model.KineticEnergy;
import com.example.cbanala.jseqmotionsapplication.model.Momentum;
import com.example.cbanala.jseqmotionsapplication.model.Weight;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText initialVelET;
    private EditText accelerationET;
    private EditText timeET;
    private Button velSubmitBtn;
    private TextView velocityTV;
    private EditText massET;
    private TextView totalTV;
    private Button massCalcBtn;
    private JSBridge jsBridge;
    private FinalVelocityInfo resultOfFinalVelocityInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsBridge = EQMotionsApplication.getInstance().getJsBridge();

        initUI();
    }

    //Initialize the values
    private void initUI() {
        initialVelET = (EditText) findViewById(R.id.initailVelET);
        accelerationET = (EditText) findViewById(R.id.accelerationET);
        timeET = (EditText) findViewById(R.id.timeET);
        velSubmitBtn = (Button) findViewById(R.id.velBtn);
        velocityTV = (TextView) findViewById(R.id.velocityTextView);
        massET = (EditText) findViewById(R.id.massET);
        totalTV = (TextView) findViewById(R.id.totTV);
        massCalcBtn = (Button) findViewById(R.id.massBtn);

        velSubmitBtn.setOnClickListener(this);
        massCalcBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == velSubmitBtn) {
            findViewById(R.id.container).setVisibility(View.VISIBLE);

            //Getting the values from the edit text fields & setting up to the model
            FinalVelocityInfo finalVelocityInfo = new FinalVelocityInfo();
            finalVelocityInfo.setInitialVelocity(Double.valueOf(initialVelET.getText().toString()));
            finalVelocityInfo.setAcceleration(Double.valueOf(accelerationET.getText().toString()));
            finalVelocityInfo.setTime(Long.parseLong(timeET.getText().toString()));

            //Call the method in "JavaScript" using JSBridge with finalVelocityInfo Values..
            resultOfFinalVelocityInfo = jsBridge.calculateVelocityInfo(finalVelocityInfo);
            velocityTV.setText(String.valueOf(finalVelocityInfo.getFinalVelocityInfo()) +
                    "(Calculation is done on JS)");

        } else if(v == massCalcBtn) {
            //Getting the mass from the EditText Field
            double mass = Double.valueOf(massET.getText().toString());

            //Call the Method in "JavaScript" using JSBridge
            KineticEnergy kineticEnergy = jsBridge.calcualteKineticEnergyInfo(resultOfFinalVelocityInfo, mass);
            Momentum momentum = jsBridge.calculateMomentum(mass, resultOfFinalVelocityInfo);
            Weight weight = jsBridge.calculateWeight(mass);

            totalTV.setText( "These calculations are done on JS Side: " +
                    "\n"+ " Kinetic Energry: " + kineticEnergy.getKineticEnergy() +
                    "\n" + " Momentum: " + momentum.getP() +
                    "\n" + " Weight: " + weight.getWeight());
        }
    }
}
