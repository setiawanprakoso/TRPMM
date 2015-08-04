package xxx.trpmmmen;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by T on 26-Jul-15.
 */
public class piano2 extends Activity {
    String get_videoUrl;
    String judul;
    String downloads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano2); //nama yg d layout

        Bundle b = getIntent().getExtras();
        get_videoUrl = b.getString("parse_url");
        judul = b.getString("title");
        downloads = b.getString("downloads");

        final VideoView myVideo = (VideoView) findViewById(R.id.myVideopian);
        final TextView txtTitle = (TextView) findViewById(R.id.txtTitlepian);
        TextView txtDownloads = (TextView) findViewById(R.id.txtDownloadspian);

        txtTitle.setText(judul);
        txtDownloads.setText(downloads+" Downloads");
        String url = get_videoUrl;

        Uri vidUri = Uri.parse(url);
        myVideo.setVideoURI(vidUri);
        myVideo.start();

        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(myVideo);
        Button share = (Button) findViewById(R.id.sharepiano);
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Sedanag menonton "+ txtTitle.getText().toString());
                startActivity(Intent.createChooser(i, "Share via"));
            }
        });
        Button play = (Button) findViewById(R.id.playpiano);
        Button pause = (Button) findViewById(R.id.pausepiano);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVideo.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVideo.pause();
            }
        });


    }
}
