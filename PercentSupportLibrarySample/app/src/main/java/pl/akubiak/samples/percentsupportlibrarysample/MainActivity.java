package pl.akubiak.samples.percentsupportlibrarysample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pl.akubiak.samples.common.Sample;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int BASIC_USAGE_SAMPLE_LINEAR_LAYOUT = 1;
    private static final int BASIC_USAGE_SAMPLE_PERCENT_RELATIVE_LAYOUT = 2;
    private static final int CODE_BEHIND_SAMPLE = 3;

    private static final int MAIN_SAMPLE_LINEAR_LAYOUT = 4;
    private static final int MAIN_SAMPLE_PERCENT_FRAME_LAYOUT = 5;
    private static final int MAIN_SAMPLE_PERCENT_RELATIVE_LAYOUT = 6;

    private static final int ASPECT_RATIO_SAMPLE = 7;

    private final List<Sample> samples;

    {
        samples = new ArrayList<>();
        samples.add(new Sample(BASIC_USAGE_SAMPLE_LINEAR_LAYOUT, "Basic usage sample - LinearLayout"));
        samples.add(new Sample(BASIC_USAGE_SAMPLE_PERCENT_RELATIVE_LAYOUT, "Basic usage sample - PercentRelativeLayout"));
        samples.add(new Sample(CODE_BEHIND_SAMPLE, "Code-behind - setting attributes"));
        samples.add(new Sample(MAIN_SAMPLE_LINEAR_LAYOUT, "Main sample - LinearLayout"));
        samples.add(new Sample(MAIN_SAMPLE_PERCENT_FRAME_LAYOUT, "Main sample - PercentFrameLayout"));
        samples.add(new Sample(MAIN_SAMPLE_PERCENT_RELATIVE_LAYOUT, "Main sample - PercentRelativeLayout"));
        samples.add(new Sample(ASPECT_RATIO_SAMPLE, "layout_aspectRatio Sample"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView samplesListView = (ListView) findViewById(R.id.main_listView_samples);
        ArrayAdapter<Sample> adapter = new ArrayAdapter<Sample>(this,
                android.R.layout.simple_list_item_2, android.R.id.text2, samples);

        samplesListView.setOnItemClickListener(this);
        samplesListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        runSample(samples.get(position).getId());
    }

    private void runSample(int sampleId) {
        Intent intent;

        switch (sampleId) {
            case BASIC_USAGE_SAMPLE_LINEAR_LAYOUT:
                intent = new Intent(this, BasicUsageSampleLinearLayoutActivity.class);
                break;
            case BASIC_USAGE_SAMPLE_PERCENT_RELATIVE_LAYOUT:
                intent = new Intent(this, BasicUsageSamplePercentRelativeLayoutActivity.class);
                break;
            case CODE_BEHIND_SAMPLE:
                intent = new Intent(this, CodeBehindSampleActivity.class);
                break;
            case MAIN_SAMPLE_LINEAR_LAYOUT:
                intent = new Intent(this, MainSampleLinearLayoutActivity.class);
                break;
            case MAIN_SAMPLE_PERCENT_FRAME_LAYOUT:
                intent = new Intent(this, MainSamplePercentFrameLayoutActivity.class);
                break;
            case MAIN_SAMPLE_PERCENT_RELATIVE_LAYOUT:
                intent = new Intent(this, MainSamplePercentRelativeLayoutActivity.class);
                break;
            case ASPECT_RATIO_SAMPLE:
                intent = new Intent(this, LayoutAspectRatioSampleActivity.class);
                break;
            default:
                return;
        }

        startActivity(intent);
    }
}
