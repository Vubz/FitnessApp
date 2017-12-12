package com.example.valentebriones.fitnessappfinal;

import android.Manifest;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CalorieCounter extends Fragment implements View.OnClickListener{
    Button b;
    EditText input1,input2,input3,input4;
    TextView total;

    public CalorieCounter() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View = inflater.inflate(R.layout.fragment_calorie_counter, container, false);
        b=(Button) View.findViewById(R.id.calculate);
        total = (TextView)View.findViewById(R.id.totalcalories);
        b.setOnClickListener(this);

        return View;
    }
    @Override
    public void onClick(View v) {
        input1=(EditText)v.findViewById(R.id.breakfast);
        input2=(EditText)v.findViewById(R.id.lunch);
        input3=(EditText)v.findViewById(R.id.dinner);
        input4=(EditText)v.findViewById(R.id.extra);


        String text1 = input1.getText().toString();
        int breakfast= Integer.parseInt(text1);
        String text2 = input1.getText().toString();
        int lunch= Integer.parseInt(text2);
        String text3 = input1.getText().toString();
        int dinner = Integer.parseInt(text3);
        String text4 = input1.getText().toString();
        int extra = Integer.parseInt(text4);

        total.setText(breakfast+lunch+dinner+extra);
    }
}





