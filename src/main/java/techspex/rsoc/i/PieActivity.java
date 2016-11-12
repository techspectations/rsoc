package techspex.rsoc.i;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.animation.Easing.EasingOption;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class PieActivity extends AppCompatActivity {
    ImageButton noti;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int col= Color.rgb(70,130,180);
    private static final int col1=Color.rgb(0,0,0);
    //Typeface typ = Typeface.createFromAsset(getAssets(),"goodfisb.ttf");


    PieChart mChart;
    // we're going to display pie chart for school attendance
    private int[] yValues = {50, 50, 50, 50, 50};
    private String[] xValues = {"POLITICS", "SPORTS", "ENTERTAINMENT","AROUND YOU","OTHERS"};

    // colors for different sections in pieChart
    public static  final int[] MY_COLORS = {
            Color.rgb(255,165,0), Color.rgb(83,235,83), Color.rgb(186,85,211),
            Color.rgb(219,112,147), Color.rgb(0,206,209)
    };
    private SpannableString generateCenterSpannableText()
    {
        SpannableString localSpannableString = new SpannableString("REPORTER");
        localSpannableString.setSpan(new RelativeSizeSpan(1.7F), 0, 13, 0);
        localSpannableString.setSpan(new StyleSpan(0), 0, 13, 0);

        //localSpannableString.setSpan(new BackgroundColorSpan(0xFFCCCCCC),0,9,0);
        //localSpannableString.setSpan(new ForegroundColorSpan(1),0,20,10);
        //localSpannableString.setSpan(new ForegroundColorSpan(-7829368), 15, 17, 0);
        // localSpannableString.setSpan(new RelativeSizeSpan(0.8F), 18, 28, 0);
        //localSpannableString.setSpan(new StyleSpan(2), 18, 28, 0);
        //localSpannableString.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 18, 28, 0);
        return localSpannableString;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        // noti=(ImageButton)findViewById(R.id.button2) ;

        mChart = (PieChart) findViewById(R.id.chart);

        mChart.setUsePercentValues(true);
        mChart.setDescription("");

        mChart.setRotationEnabled(true);


        this.mChart.setExtraOffsets(5.0F, 10.0F, 5.0F, 5.0F);
        this.mChart.setDrawHoleEnabled(true);
        this.mChart.setHoleColor(-1);
        this.mChart.setTransparentCircleColor(-1);
        this.mChart.setTransparentCircleAlpha(110);
        this.mChart.setHoleRadius(58.0F);
        this.mChart.setTransparentCircleRadius(61.0F);
        this.mChart.setDrawCenterText(true);
        this.mChart.setCenterTextColor(col);
        this.mChart.setCenterText(generateCenterSpannableText());
        //this.mChart.setHoleColor(0xFF9933);
        //  this.mChart.setCenterTextTypeface(typ);
        this.mChart.setHighlightPerTapEnabled(true);
        this.mChart.setRotationAngle(0.0F);
        this.mChart.setRotationEnabled(true);
        this.mChart.setHighlightPerTapEnabled(true);
        this.mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                // display msg when value selected
                if (e == null)
                    return;
                if (xValues[e.getXIndex()].equals("AROUND YOU")){
                    Intent i = new Intent(PieActivity.this,Main2Activity.class);

                    startActivity(i);
                }
                if (xValues[e.getXIndex()].equals("FOOD & STAY")){
                    Intent i = new Intent(PieActivity.this,MainActivity.class);
                    startActivity(i);
                }
                if (xValues[e.getXIndex()].equals("TIME & VENUE")){
                    Intent i = new Intent(PieActivity.this,MainActivity.class);
                    startActivity(i);
                }


                //Toast.makeText(MenuActivity.this,
                // xValues[e.getXIndex()] + " is " + e.getVal() + "", Toast.LENGTH_SHORT).show();
              /* noti.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i =new Intent(MenuActivity.this,NotifyActivity.class);
                        startActivity( i);
                    }
                });*/
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // setting sample Data for Pie Chart
        setDataForPieChart();


    }


    public void setDataForPieChart() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yValues.length; i++)
            yVals1.add(new Entry(yValues[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xValues.length; i++)
            xVals.add(xValues[i]);

        // create pieDataSet
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        // adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added My Own colors
        for (int c : MY_COLORS)
            colors.add(c);


        dataSet.setColors(colors);


        //  create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(xVals, dataSet);
        //   data.setValueFormatter(new DefaultValueFormatter());
        //   data.setValueFormatter(new PercentFormatter());

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(10f);
        data.setDrawValues(false);
        //  data.setValueTypeface(this.goo);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        // refresh/update pie chart
        mChart.invalidate();

        // animate piechart
        mChart.animateXY(1400, 1400);



        // Legends to show on bottom of the graph
        mChart.getLegend().setEnabled(false);

    }


    public class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal if needed
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value) + ""; // e.g. append a dollar-sign
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PieActivity.this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }




}
