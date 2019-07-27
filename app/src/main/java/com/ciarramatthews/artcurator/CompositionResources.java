package com.ciarramatthews.artcurator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ciarramatthews.splashscreen.Home2Activity;

public class CompositionResources extends AppCompatActivity {

    ListView listview;
    String mTitle[] = {"Understanding Composition", "COMPOSITION 1 - Understanding Shapes", "Pose and Camera Position", "Intro to Storyboarding"};
    String mDescription[] = {"The basics of composition", "Shapes can make your composition better", "Posing a figure in space", "An intro to storyboarding"};
    int images[] = {R.drawable.comp1, R.drawable.comp2, R.drawable.comp3, R.drawable.comp4};

    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatomy_resources);

        listview = findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter(this, mTitle,mDescription, images);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                browser1(i);
            }
        });

        mBackButton = (Button) findViewById(R.id.back_button);
        //mBackButton.setOnClickListener(this);
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.autoTextView, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image1);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }

    public void browser1(int position) {
        if (position == 0) {
            Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=O8i7OKbWmRM"));
            startActivity(browswerIntent);
        }
        else if (position == 1) {
            Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=wg-So3ElA8g"));
            startActivity(browswerIntent);
        }
        else if (position == 2) {
            Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DaG-cBidCBw&t=37s"));
            startActivity(browswerIntent);
        }
        else if (position == 3) {
            Intent browswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RQsvhq28sOI"));
            startActivity(browswerIntent);
        }

    }


    public void onClick(View view) {
        Intent intent = new Intent(this, Home2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

