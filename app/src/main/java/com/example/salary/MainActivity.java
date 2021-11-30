package com.example.salary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtSelected= findViewById(R.id.txtSelected);
        NumberPicker numberPicker=findViewById(R.id.numberPicker);
        NumberPicker expPicker=findViewById(R.id.pickerExp);
        TextView lblExp=findViewById(R.id.lblExp);
        Button btnCalculate=findViewById(R.id.btnCalculate);
        CheckBox ckbCsh=findViewById(R.id.ckbCsh);
        CheckBox ckPhp=findViewById(R.id.ckbPhp);
        CheckBox ckbJava=findViewById(R.id.ckbJava);
        CheckBox ckbPython=findViewById(R.id.ckbPython);
        CheckBox ckbSwift=findViewById(R.id.ckbSwift);
        final int[] baseSalary = {0};
        final int[] exp = {0};
        Qualification.initQualification();
        numberPicker.setMaxValue(Qualification.getQualifications().size()-1);
        numberPicker.setMinValue(0);
        numberPicker.setValue(1);
        expPicker.setValue(0);
        expPicker.setMinValue(0);
        expPicker.setMaxValue(10);
        expPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                lblExp.setText("Experience: "+newVal);
                exp[0] =newVal;
            }
        });
        Qualification.qualificationSalary();
        numberPicker.setDisplayedValues(Qualification.qualificationNames());
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                txtSelected.setText("selected: "+Qualification.getQualifications().get(newVal).getName());
                baseSalary[0] =Qualification.getQualifications().get(newVal).getSalary();
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            int mainsalary=0;
            @Override
            public void onClick(View v) {
                if(exp[0]>=5){
                    mainsalary=baseSalary[0]+(exp[0]*300);
                }
                if(exp[0]<5){
                    mainsalary=baseSalary[0]+(exp[0]*200);
                }
                if(ckbCsh.isChecked()){
                    mainsalary=baseSalary[0]+1500;
                }
                if(ckbJava.isChecked()){
                    baseSalary[0]=baseSalary[0]+2000;
                }
                if(ckPhp.isChecked()){
                    mainsalary=baseSalary[0]+1000;
                }
                if(ckbPython.isChecked()){
                    mainsalary=baseSalary[0]+3000;
                }
                if(ckbCsh.isChecked()){
                    mainsalary=baseSalary[0]+3000;
                }
                if(mainsalary!=0){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Salary: "+mainsalary);
                    alertDialogBuilder.setPositiveButton("OK",null);
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                else if(mainsalary==0){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Please Select");
                    alertDialogBuilder.setPositiveButton("OK",null);
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }


            }
        });
    }
}