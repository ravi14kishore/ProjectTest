package com.example.hp.findyourtechnician;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SubCategoryPage extends AppCompatActivity {

    Spinner ActivitySubCategory_Spinner;
    ArrayAdapter<CharSequence> ActivitySubCategory_adapter;
    String SubCategorySelected;
    TextView ActivitySubCategory_DescriptionTextView;
    EditText ActivitySubCategory_Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_page);
        Intent intent = getIntent();
        final String Category = intent.getStringExtra("Category");
        ActivitySubCategory_Spinner = (Spinner)findViewById(R.id.ContentTechnicianDetails_spinner);
        if(Category.equalsIgnoreCase("Carpenter"))
            ActivitySubCategory_adapter = ArrayAdapter.createFromResource(this,R.array.Carpenter_SubCategory,android.R.layout.simple_spinner_item);
        else if(Category.equalsIgnoreCase("Electrician"))
            ActivitySubCategory_adapter = ArrayAdapter.createFromResource(this,R.array.Electrician_SubCategory,android.R.layout.simple_spinner_item);
        else if(Category.equalsIgnoreCase("Painter"))
            ActivitySubCategory_adapter = ArrayAdapter.createFromResource(this,R.array.Painter_SubCategory,android.R.layout.simple_spinner_item);
        else if(Category.equalsIgnoreCase("Plumber"))
            ActivitySubCategory_adapter = ArrayAdapter.createFromResource(this,R.array.Plumber_SubCategory,android.R.layout.simple_spinner_item);
        else
            ActivitySubCategory_adapter = ArrayAdapter.createFromResource(this,R.array.Mechanic_SubCategory,android.R.layout.simple_spinner_item);

        ActivitySubCategory_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ActivitySubCategory_Spinner.setAdapter(ActivitySubCategory_adapter);
        ActivitySubCategory_DescriptionTextView = (TextView)findViewById(R.id.ContentSubCategory_DescriptionTextView);
        ActivitySubCategory_Description = (EditText)findViewById(R.id.ContentSubCategory_Description);

        ActivitySubCategory_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SubCategorySelected = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(SubCategoryPage.this,technicians_list.class);
                intent.putExtra("Category",Category);
                intent.putExtra("SubCategory",SubCategorySelected);
                startActivity(intent);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
