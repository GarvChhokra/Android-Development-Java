package com.example.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText editTextexcell;

    private File filePath=new File(Environment.getExternalStorageDirectory()+"/Demo.xls");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        editTextexcell=findViewById(R.id.input0);
        editTextexcell=findViewById(R.id.input1);
        editTextexcell=findViewById(R.id.input2);
        editTextexcell=findViewById(R.id.input3);
        editTextexcell=findViewById(R.id.input4);
        editTextexcell=findViewById(R.id.input5);
        editTextexcell=findViewById(R.id.input6);
        editTextexcell=findViewById(R.id.input7);
        editTextexcell=findViewById(R.id.input8);



    }

    public void done(View view){

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");


        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);


        hssfCell.setCellValue(editTextexcell.getText().toString());



        HSSFWorkbook hssfWorkbook1 = new HSSFWorkbook();
        HSSFSheet hssfSheet1 = hssfWorkbook.createSheet("Custom Sheet");


        HSSFRow hssfRow1 = hssfSheet.createRow(1);
        HSSFCell hssfCell1 = hssfRow.createCell(1);


        hssfCell.setCellValue(editTextexcell.getText().toString());


        try {
            if (!filePath.exists()){
                filePath.createNewFile();
            }


            FileOutputStream fileOutputStream= new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);


            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}