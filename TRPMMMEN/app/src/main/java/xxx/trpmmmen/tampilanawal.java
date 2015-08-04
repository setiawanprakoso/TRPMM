package xxx.trpmmmen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class tampilanawal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilanawal);
        final Button gitar = (Button) findViewById(R.id.gitarbtn);
        final Button drumm = (Button) findViewById(R.id.drumbtn);
        final Button pianoo = (Button) findViewById(R.id.pianobtn);
        gitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tampilanawal.this , gitar.class);
                startActivity(intent);
            }
        });
        drumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tampilanawal.this,drum.class);
                startActivity(intent);
            }
        });
        pianoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tampilanawal.this, piano.class);
                startActivity(intent);
            }
        });
    }
}
