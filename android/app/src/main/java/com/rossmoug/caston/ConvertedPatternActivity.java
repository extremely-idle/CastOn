package com.rossmoug.caston;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rossmoug.cast_on.CastOnActivity;
import com.rossmoug.cast_on.R;
import com.rossmoug.caston.core.state.pattern.Pattern;

/**
 *
 */
public class ConvertedPatternActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converted_pattern);

        final Intent intent = getIntent();
        final Pattern convertedPattern = (Pattern) intent.getSerializableExtra(CastOnActivity.CONVERTED_PATTERN);

        final TextView convertedNumberOfRowsField = (TextView) findViewById(R.id.numberOfRowsData);
        convertedNumberOfRowsField.setText(String.valueOf(convertedPattern.getGauge().getRowCount()));

        final TextView convertedNumberOfStichesField = (TextView) findViewById(R.id.numberOfStitchesData);
        convertedNumberOfStichesField.setText(String.valueOf(convertedPattern.getGauge().getStitchCount()));
    }
}