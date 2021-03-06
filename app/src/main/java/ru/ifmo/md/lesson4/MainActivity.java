package ru.ifmo.md.lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_avtivity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_avtivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String expression = editText.getText().toString();
        TextView textView = (TextView) findViewById(R.id.textView);
        try {
            if (expression.length() > 0)
                textView.setText(((Double) (new MyCalculateEngine()).calculate(expression)).toString());
        } catch (final CalculationException ex) {
            textView.setText("Error");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, ex.toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
