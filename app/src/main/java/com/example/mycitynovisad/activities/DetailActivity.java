package com.example.mycitynovisad.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycitynovisad.R;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private String description;
    private String address;

    private int category;

    private static final int SIGHTS = 1;
    private static final int NATURE_AND_CULTURE = 2;
    private static final int SHOP = 3;
    private static final int FOOD = 4;

    private static final int DEFAULT_NUMBER = 0;
    private static final int NO_IMAGE_PROVIDED = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent detailIntent = getIntent();

        category = detailIntent.getIntExtra(getString(R.string.category), DEFAULT_NUMBER);

        int imageId = detailIntent.getIntExtra(getString(R.string.image_id), NO_IMAGE_PROVIDED);
        String name = detailIntent.getStringExtra(getString(R.string.name));
        description = detailIntent.getStringExtra(getString(R.string.description));
        String address = detailIntent.getStringExtra(getString(R.string.address));
        String transport = detailIntent.getStringExtra(getString(R.string.transport));
        String phone = detailIntent.getStringExtra(getString(R.string.phone));
        String web = detailIntent.getStringExtra(getString(R.string.web));
        String hours = detailIntent.getStringExtra(getString(R.string.hours));
        String fee = detailIntent.getStringExtra(getString(R.string.fee));

        setTitle(name);

        ImageView imageView = findViewById(R.id.detail_image_view);
        imageView.setImageResource(imageId);

        setDescriptionTextView();

        final TextView addressTextView = findViewById(R.id.detail_address);

        addressTextView.setOnClickListener(view -> {
            Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                    + addressTextView.getText().toString()));
            startActivity(geoIntent);
        });

        setDetails(R.id.detail_address, address, R.drawable.ic_location);
        setDetails(R.id.detail_transport, transport, R.drawable.ic_subway);
        setDetails(R.id.detail_phone, phone, R.drawable.ic_call);
        setDetails(R.id.detail_web, web, R.drawable.ic_public);
        setDetails(R.id.detail_hours, hours, R.drawable.ic_time);
        setDetails(R.id.detail_fee, fee, R.drawable.ic_money);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    private void setDetails(int textViewId, String string, int icResourceId) {
        TextView textView = findViewById(textViewId);
        if (string == null) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setText(string);
            textView.setCompoundDrawablesWithIntrinsicBounds(icResourceId, DEFAULT_NUMBER,
                    DEFAULT_NUMBER, DEFAULT_NUMBER);
            if (string.equals(address)) {

                SpannableString spanStr = new SpannableString(address);
                spanStr.setSpan(new UnderlineSpan(), DEFAULT_NUMBER, spanStr.length(), DEFAULT_NUMBER);
                textView.setText(spanStr);
            }
        }
    }

    private void setDescriptionTextView() {

        TextView descriptionTextView = findViewById(R.id.detail_long_description);
        descriptionTextView.setText(description);

        switch (category) {
            case SIGHTS:
                descriptionTextView.setBackgroundResource(R.color.color_description_sights);
                descriptionTextView.setTextColor(getResources().getColor(R.color.color_description_sights_text));
                break;

            case NATURE_AND_CULTURE:
                descriptionTextView.setBackgroundResource(R.color.color_description_nature);
                descriptionTextView.setTextColor(getResources().getColor(R.color.color_description_nature_text));
                break;

            case SHOP:
                descriptionTextView.setBackgroundResource(R.color.color_description_shop);
                descriptionTextView.setTextColor(getResources().getColor(R.color.color_description_shop_text));
                break;

            case FOOD:
                descriptionTextView.setBackgroundResource(R.color.color_description_food);
                descriptionTextView.setTextColor(getResources().getColor(R.color.color_description_food_text));
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
