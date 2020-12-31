package android.example.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button  eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button equal;
    private TextView info;
    private TextView results;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION= '*';
    private final char DIVISION  = '/';
    private final char EQU  = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    private Button clear;
    private Button cut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION= ADDITION;
                results.setText(String.valueOf(val1)+ "+");
                info.setText(null);
            }
        });
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION= SUBTRACTION;
                results.setText(String.valueOf(val1)+ "-");
                    info.setText(null);
                }
            });
        mul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION= MULTIPLICATION;
                    results.setText(String.valueOf(val1)+ "*");
                    info.setText(null);
                }
            });
        div.setOnClickListener(new View.OnClickListener()  {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION= DIVISION;
                    results.setText(String.valueOf(val1)+ "/");
                    info.setText(null);
                }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                results.setText(results.getText().toString() + String.valueOf(val2) + "=" + val1 );
                info.setText(null);
            }
        });
        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() >0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else
                {
                    val1= Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    results.setText(null);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                val1= Double.NaN;
                val2=Double.NaN;
                info.setText(null);
                results.setText(null);
            }
        });


    }
    private void setupUIViews (){
        one = (Button)findViewById(R.id.button1);
         two =(Button)findViewById(R.id.button2) ;
        three = (Button)findViewById(R.id.button3);
        four =(Button)findViewById(R.id.button4) ;
        five = (Button)findViewById(R.id.button5);
        six =(Button)findViewById(R.id.button6) ;
        seven = (Button)findViewById(R.id.button7);
        eight=(Button)findViewById(R.id.button8) ;
        nine = (Button)findViewById(R.id.button9);
        zero =(Button)findViewById(R.id.button0) ;
        mul = (Button)findViewById(R.id.buttonmul);
        add=(Button)findViewById(R.id.buttonadd) ;
        div = (Button)findViewById(R.id.buttondiv);
        sub=(Button)findViewById(R.id.buttonsub) ;
        info = (TextView)findViewById(R.id.tvcontrol);
        results = (TextView)findViewById(R.id.tvresults);
        equal = (Button)findViewById(R.id.buttoneq);
        clear= (Button)findViewById(R.id.buttonclr);
        cut = (Button)findViewById(R.id.buttoncut);
    }
    private void compute(){
        if (!Double.isNaN(val1))
        {
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
        }
        }
        else
            val1=Double.parseDouble(info.getText().toString());
    }
}