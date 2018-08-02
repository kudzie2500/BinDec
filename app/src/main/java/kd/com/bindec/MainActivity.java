package kd.com.bindec;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputEditText tlDec = (TextInputEditText) findViewById(R.id.textDecimal);
        final TextInputEditText tlBin = (TextInputEditText) findViewById(R.id.textBinary);

        ImageButton btnDec = (ImageButton)findViewById(R.id.btnDecToBin);
        ImageButton btnBin = (ImageButton)findViewById(R.id.btnBinToDec);

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!tlDec.getText().toString().isEmpty()) {
                        String result = toBin(Integer.valueOf(tlDec.getText().toString()));

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Answer in Binary is " + result)
                                .setTitle("Conversion to Binary");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        tlDec.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Please type in some input", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){e.printStackTrace();}
            }
        });

        btnBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!tlBin.getText().toString().isEmpty()) {
                        String result = String.valueOf(toDec(tlBin.getText().toString()));
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Answer in Decimal is " + result)
                                .setTitle("Conversion to Decimal");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        tlBin.setText("");
                    }else{
                        Toast.makeText(MainActivity.this, "Error input field empty!", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){e.printStackTrace();}
            }
        });


        Button btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tlBin.setText("");
                tlDec.setText("");
            }
        });

    }

    public static String toBin(int x){
        String bin = "";
        int i = 0;
        while (x > 0) {

            // storing remainder in binary array
            bin = bin + (x % 2);
            x = x / 2;
            i++;
        }
        String reverse = new StringBuffer(bin).reverse().toString();
        return reverse;
    }

    public static int toDec(String x){
        int dec = Integer.parseInt(x,2);
        return dec;
    }
}
