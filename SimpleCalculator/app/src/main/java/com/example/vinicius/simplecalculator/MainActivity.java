package com.example.vinicius.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnResultClick(View v) {
        if(optr !=Operator.none){
            EditText eText = (EditText)findViewById(R.id.resultEdit);
            if (eText.getText().toString().matches("")) {
                Toast.makeText(this, "You did not enter data2!", Toast.LENGTH_SHORT).show();
                eText.setText("");
                return;
            }
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add){
                result = data1 + data2;
            } else if (optr == Operator.minus){
                result = data1 - data2;
            } else if (optr == Operator.multiply){
                result = data1 * data2;
            } else if (optr == Operator.divide){
                result = data1 / data2;
            }
            optr = Operator.none;
            data1 = result;
            if((result - (int)result) != 0)
                eText.setText(String.valueOf(result));
            else
                eText.setText(String.valueOf((int)result));
        }
    }

    public void btnAddClick(View v) {
        optr = Operator.add;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        if (eText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter data1!", Toast.LENGTH_SHORT).show();
            eText.setText("");
            return;
        }
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMinusClick(View v) {
        optr = Operator.minus;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        if (eText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter data1!", Toast.LENGTH_SHORT).show();
            eText.setText("");
            return;
        }
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultiplyClick(View v) {
        optr = Operator.multiply;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        if (eText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter data1!", Toast.LENGTH_SHORT).show();
            eText.setText("");
            return;
        }
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideClick(View v) {
        optr = Operator.divide;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        if (eText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter data1!", Toast.LENGTH_SHORT).show();
            eText.setText("");
            return;
        }
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText("");
    }

    public void btnDotClick(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + ".");
    }

    public void btn00Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "0");
    }

    public void btn01Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "1");
    }

    public void btn02Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "2");
    }

    public void btn03Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "3");
    }

    public void btn04Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "4");
    }

    public void btn05Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "5");
    }

    public void btn06Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "6");
    }

    public void btn07Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "7");
    }

    public void btn08Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "8");
    }

    public void btn09Click(View v) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "9");
    }
}
