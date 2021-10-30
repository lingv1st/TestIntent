package fire.calculation.testintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonTestIntent;
    TextView textView;
    String text;
    private final static String TEXT = "PARAM-PAM-PAM";
    private final static String SAYHI = "SAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonTestIntent:
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setData(Uri.parse("mailto:"));
                    i.putExtra(TEXT, "hey");
                    startActivity(i);
                    break;
            }
        }
    };

    public void initView() {
        buttonTestIntent = findViewById(R.id.buttonTestIntent);
        textView = findViewById(R.id.textView);

        //        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        textView.setText(bundle.getString(SAYHI));
    }

    public void initListeners() {
        buttonTestIntent.setOnClickListener(onClickListener);
    }
}