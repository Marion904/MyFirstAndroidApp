package fr.wcs.myfirstapplicationtuto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final TextView congrats = (TextView) findViewById(R.id.textView2);
        final Button button = (Button) findViewById(R.id.button);
        final String toast = getString(R.string.toast);
        final String toast2 = getString(R.string.toast2);
        final String welcome = getString(R.string.welcome);
        editText.setEnabled(false);
        editText2.setEnabled(false);
        congrats.setVisibility(View.INVISIBLE);

        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton button2, boolean isChecked) {

               /* if (checkBox.isChecked()) {
                    editText.setEnabled(true);
                    editText2.setEnabled(true);
                    button.setEnabled(true);
                } else {
                    editText.setEnabled(false);
                    editText2.setEnabled(false);
                    button.setEnabled(false);

                }*/
                editText.setEnabled(checkBox.isChecked());
                editText2.setEnabled(checkBox.isChecked());
                button.setEnabled(checkBox.isChecked());

                if(!checkBox.isChecked()){
                    congrats.setVisibility(View.INVISIBLE);
                    editText.setText(null);
                    editText2.setText(null);

                }


           }

        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(editText.length()==0 || editText2.length()==0) {
                    Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
                    congrats.setVisibility(View.INVISIBLE);
                }
                else if(editText.length()<2 || editText2.length()<2){
                    Toast.makeText(MainActivity.this, toast2, Toast.LENGTH_SHORT).show();
                    congrats.setVisibility(View.INVISIBLE);
                }
                else {
                    congrats.setText(welcome+" "+editText.getText() + " " + editText2.getText()+"!");
                    congrats.setVisibility(View.VISIBLE);

                }

            }
        });


    }
    /*    public void sendMesage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = "Félicitations "+editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        message +=" "+editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
*/
}
