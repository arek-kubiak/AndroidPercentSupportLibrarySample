package pl.akubiak.samples.percentsupportlibrarysample;

import android.os.Bundle;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pl.akubiak.samples.percentsupportlibrarysample.R;

public class CodeBehindSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_behind_sample);

        View view = findViewById(R.id.noSizeBox);
        setPercentSize(view, 0.4f, 0.6f);
        setPercentMargin(view, 0.1f);
    }

    private void setPercentSize(View view, float widthPercent, float heightPercent) {
        PercentRelativeLayout.LayoutParams params = (PercentRelativeLayout.LayoutParams) view.getLayoutParams();

        if(params != null){
            PercentLayoutHelper.PercentLayoutInfo info = params.getPercentLayoutInfo();
            info.heightPercent = heightPercent;
            info.widthPercent = widthPercent;
            view.requestLayout();
        }
    }

    private void setPercentMargin(View view, float marginPercent) {
        PercentRelativeLayout.LayoutParams params = (PercentRelativeLayout.LayoutParams) view.getLayoutParams();

        if(params != null){
            PercentLayoutHelper.PercentLayoutInfo info = params.getPercentLayoutInfo();
            info.bottomMarginPercent = marginPercent;
            info.topMarginPercent = marginPercent;
            info.rightMarginPercent = marginPercent;
            info.leftMarginPercent = marginPercent;
            view.requestLayout();
        }
    }
}
