package com.etl.rum.rumtestapp.mpChart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class DateValueFormatter implements IAxisValueFormatter {
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        // Simple version. You should use a DateFormatter to specify how you want to textually represent your date.
//            return new Date(Float.valueOf(value).longValue()).toString();
        return "my value";
    }
}