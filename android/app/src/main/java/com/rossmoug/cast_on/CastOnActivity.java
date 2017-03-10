package com.rossmoug.cast_on;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rossmoug.caston.ConvertedPatternActivity;
import com.rossmoug.caston.core.command.impl.ConvertPatternCommand;
import com.rossmoug.caston.core.command.impl.builder.ConvertPatternCommandBuilder;
import com.rossmoug.caston.core.state.Unit;
import com.rossmoug.caston.core.state.gauge.Gauge;
import com.rossmoug.caston.core.state.gauge.builder.GaugeBuilder;
import com.rossmoug.caston.core.state.pattern.Pattern;
import com.rossmoug.caston.core.state.pattern.builder.PatternBuilder;

/**
 *
 */
public class CastOnActivity extends AppCompatActivity {

    public static final String CONVERTED_PATTERN = "convertedPattern";

    /**
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_on);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
    }

    /**
     *
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cast_on, menu);
        return true;
    }

    /**
     *
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param view
     */
    public void convertPattern(View view) {
        final ConvertPatternCommand convertPatternCommand = createConvertPatternCommand(view);

        final Pattern convertedPattern = convertPatternCommand.execute();

        final Intent intent = new Intent(this, ConvertedPatternActivity.class);
        intent.putExtra(CONVERTED_PATTERN, convertedPattern);
        startActivity(intent);
    }

    /**
     *
     * @param view
     * @return
     */
    private ConvertPatternCommand createConvertPatternCommand(View view) {
        final ConvertPatternCommandBuilder builder = new ConvertPatternCommandBuilder();
        final Pattern pattern = createPatternFromView(view);
        final Gauge gauge = createGaugeFromView(view);
        return builder.withPattern(pattern).withGauge(gauge).build();
    }

    /**
     *
     * @param view
     * @return
     */
    private Pattern createPatternFromView(View view) {
        final EditText patternDimensionField = (EditText) findViewById(R.id.patternGaugeDimensionData);
        final double patternDimension = Double.valueOf(patternDimensionField.getText().toString());

        final Gauge gauge = createGaugeFromView(R.id.patternGaugeNumberOfRowsData, R.id.patternGaugeNumberOfStitchesData, R.id.patternGaugeRadioGroup);

        final PatternBuilder patternBuilder = new PatternBuilder();
        return patternBuilder.withGauge(gauge).withDimension(patternDimension).build();
    }

    /**
     *
     * @param view
     * @return
     */
    private Gauge createGaugeFromView(View view) {
        return createGaugeFromView(R.id.gaugeNumberOfRowsData, R.id.gaugeNumberOfStitchesData, R.id.gaugeUnitRadioGroup);
    }

    /**
     *
     * @param numberOfRowsId
     * @param numberOfStitchesId
     * @param unitRadioGroupId
     * @return
     */
    private Gauge createGaugeFromView(int numberOfRowsId, int numberOfStitchesId, int unitRadioGroupId) {
        final EditText numberOfRowsField = (EditText) findViewById(numberOfRowsId);
        final long numberOfRows = Long.valueOf(numberOfRowsField.getText().toString());

        final EditText numberOfStitchesField = (EditText) findViewById(numberOfStitchesId);
        final long numberOfStitches = Long.valueOf(numberOfStitchesField.getText().toString());

        final RadioGroup unitRadioGroup = (RadioGroup) findViewById(unitRadioGroupId);
        final RadioButton unitRadioButton = (RadioButton) findViewById(unitRadioGroup.getCheckedRadioButtonId());
        final Unit unit = Unit.parseUnitLongName(unitRadioButton.getText().toString());

        return createGauge(numberOfRows, numberOfStitches, unit);
    }

    /**
     *
     * @param numberOfRows
     * @param numberOfStitches
     * @param unit
     * @return
     */
    private Gauge createGauge(long numberOfRows, long numberOfStitches, Unit unit) {
        final GaugeBuilder gaugeBuilder = new GaugeBuilder();

        return gaugeBuilder.withRowCount(numberOfRows).withStitchCount(numberOfStitches).withUnit(unit).build();
    }
}