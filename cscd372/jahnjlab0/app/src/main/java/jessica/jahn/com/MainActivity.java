package jessica.jahn.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    // This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Toast.makeText(this,
                    "Lab 0, Spring 2019, Jessica Jahn",
                    Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
