package sg.edu.rp.c346.id18015362.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.EnglishSelection){
            tvTranslatedText.setText("Hello");
        }
        else if(item.getItemId() == R.id.italianSelection){
            tvTranslatedText.setText("Ciao");
        }
        else{
            tvTranslatedText.setText("Translation Error");
        }

        return super.onContextItemSelected(item);
    }

}
