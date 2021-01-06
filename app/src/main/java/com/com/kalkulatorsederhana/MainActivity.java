package com.com.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //init component dan tipe data yang dibutuhkan
    private ArrayList<Integer> angka = new ArrayList();
    EditText input_pertama, input_kedua, input_ketiga;
    CheckBox checkBox_pertama, checkBox_kedua, checkBox_ketiga;
    Button tambah, kurang, perkalian, pembagian;
    TextView tv_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan ke xml
        input_pertama = findViewById(R.id.input_pertama);
        input_kedua = findViewById(R.id.input_kedua);
        input_ketiga = findViewById(R.id.input_ketiga);
        checkBox_pertama = findViewById(R.id.checkbox_pertama);
        checkBox_kedua = findViewById(R.id.checkbox_kedua);
        checkBox_ketiga = findViewById(R.id.checkbox_ketiga);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        perkalian = findViewById(R.id.perkalian);
        pembagian = findViewById(R.id.pembagian);
        tv_hasil = findViewById(R.id.hasil);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil =0;
                if (angka.size() <= 1){
                    tv_hasil.setText("Error");
                }else {
                    for (int i = 0; i < angka.size(); i++) {
                        Log.d(i+" : ", angka.get(i)+"");
                        hasil = hasil + angka.get(i);
                    }
                    tv_hasil.setText(hasil + "");
                }
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int hasil = 0;
                if (angka.size() <= 1){
                    tv_hasil.setText("Error");
                }else {
                    for (int i = 0; i < angka.size(); i++) {
                        Log.d(i+" : ", angka.get(i)+"");
                        if (i==0){
                            hasil = angka.get(0);
                        }else {
                        hasil = hasil - angka.get(i);}
                    }
                    tv_hasil.setText(hasil + "");
                }
            }
        });
        perkalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil = 0;
                if (angka.size() <= 1){
                    tv_hasil.setText("Error");
                }else {
                    for (int i = 0; i < angka.size(); i++) {
                        Log.d(i+" : ", angka.get(i)+"");
                        if (i==0){
                            hasil = angka.get(0);
                        }else {
                            hasil = hasil * angka.get(i);}
                    }
                    tv_hasil.setText(hasil + "");
                }
            }
        });
        pembagian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hasil = 0;
                if (angka.size() <= 1){
                    tv_hasil.setText("Error");
                }else {
                    for (int i = 0; i < angka.size(); i++) {
                        Log.d(i+" : ", angka.get(i)+"");
                        if (i==0){
                            hasil = angka.get(0);
                        }else {
                            hasil = hasil / angka.get(i);}
                    }
                    tv_hasil.setText(hasil + "");
                }
            }
        });

    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.checkbox_pertama:
                if (checked){
                    Log.d("angka pertama", input_pertama.getText().toString());
                    angka.add(0, Integer.parseInt(input_pertama.getText().toString()));
                }else {
                    angka.remove(new Integer(Integer.parseInt(input_pertama.getText().toString())));
                }
                break;
            case R.id.checkbox_kedua:
                if (checked){
                    angka.add(1, Integer.parseInt(input_kedua.getText().toString()));
                }else {
                    angka.remove(new Integer(Integer.parseInt(input_kedua.getText().toString())));
                }
                break;
            case R.id.checkbox_ketiga:
                if (checked){
                    angka.add(2, Integer.parseInt(input_ketiga.getText().toString()));
                }else {
                    angka.remove(new Integer(Integer.parseInt(input_ketiga.getText().toString())));
                }
                break;
        }
    }



}