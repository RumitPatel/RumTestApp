package com.etl.rum.rumtestapp.mpChart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.etl.rum.rumtestapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MPChartActivity extends AppCompatActivity {

    private final int[] colors = new int[]{
            ColorTemplate.MATERIAL_COLORS[0],
            ColorTemplate.MATERIAL_COLORS[1],
            ColorTemplate.MATERIAL_COLORS[2]
    };
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpchart_lib);

        chart = findViewById(R.id.chart1);
//        chart.setOnChartValueSelectedListener(this);

        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.setDrawBorders(false);

        chart.getAxisRight().setEnabled(false);
        chart.getAxisRight().setDrawAxisLine(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getXAxis().setDrawAxisLine(false);
        chart.getXAxis().setDrawGridLines(false);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(true);
        chart.setDoubleTapToZoomEnabled(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new DateValueFormatter());

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        setStaticData();
    }

    private void setStaticData() {
        chart.resetTracking();

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        dataSets.add(getTempData1());
        dataSets.add(getTempData2());

        LineData data = new LineData(dataSets);
        chart.setData(data);
        chart.invalidate();
    }

    private LineDataSet getTempData1() {
        ArrayList<Entry> values = new ArrayList<>();
        double val = 11.5;
        Entry entry = new Entry(10, (float) val);
        values.add(entry);

        val = 59.3;
        entry = new Entry(20, (float) val);
        values.add(entry);

        val = 97.4;
        entry = new Entry(30, (float) val);
        values.add(entry);

        val = 85.7;
        entry = new Entry(40, (float) val);
        values.add(entry);

        val = 98.1;
        entry = new Entry(50, (float) val);
        values.add(entry);

        LineDataSet lineDataSet = new LineDataSet(values, "Systolic");
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setCircleRadius(4f);

        int color = colors[0];
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);

        return lineDataSet;
    }

    private LineDataSet getTempData2() {
        ArrayList<Entry> values = new ArrayList<>();
        double val = 15.7;
        Entry entry = new Entry(10, (float) val);
        values.add(entry);

        val = 65.2;
        entry = new Entry(20, (float) val);
        values.add(entry);

        val = 96.9;
        entry = new Entry(30, (float) val);
        values.add(entry);

        val = 86.4;
        entry = new Entry(40, (float) val);
        values.add(entry);

        val = 97.1;
        entry = new Entry(50, (float) val);

        values.add(entry);

        LineDataSet lineDataSet = new LineDataSet(values, "Diastolic");
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setCircleRadius(4f);

        int color = colors[1];
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);

        return lineDataSet;
    }
}