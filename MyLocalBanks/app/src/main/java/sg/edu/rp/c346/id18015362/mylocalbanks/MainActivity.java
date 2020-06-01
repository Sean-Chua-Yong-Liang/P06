package sg.edu.rp.c346.id18015362.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    TextView tvID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        tvID = (TextView) v;

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String url = "";
        String contact = "";
        if(item.getItemId() == R.id.website){
            if(tvID.getId() == R.id.tvDBS){
                url = getString(R.string.dbsWeb);
            }
            else if(tvID.getId() == R.id.tvOCBC){
                url = getString(R.string.ocbcWeb);
            }
            else if(tvID.getId() == R.id.tvUOB){
                url = getString(R.string.uobWeb);
            }
            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intentWeb);
        }
        else if(item.getItemId() == R.id.contact) {
            if(tvID.getId() == R.id.tvDBS){
                contact = getString(R.string.dbsContact);
            }
            else if(tvID.getId() == R.id.tvOCBC){
                contact = getString(R.string.ocbcContact);
            }
            else if(tvID.getId() == R.id.tvUOB){
                contact = getString(R.string.uobContact);
            }

            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact));
            startActivity(intentCall);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.EnglishSelection){
            tvDBS.setText(R.string.dbs);
            tvOCBC.setText(R.string.ocbc);
            tvUOB.setText(R.string.uob);
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(R.string.chDBS);
            tvOCBC.setText(R.string.chOCBC);
            tvUOB.setText(R.string.chUOB);
        }


        return super.onOptionsItemSelected(item);
    }



}
