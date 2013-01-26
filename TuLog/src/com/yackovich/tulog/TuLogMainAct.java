package com.yackovich.tulog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

public class TuLogMainAct extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Spinner workoutSelect = (Spinner) findViewById(R.id.spnWorkoutSelect);
        workoutSelect.setAdapter(null);
        
        
    }
}