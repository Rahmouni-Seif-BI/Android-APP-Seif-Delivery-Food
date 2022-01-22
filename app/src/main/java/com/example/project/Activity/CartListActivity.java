package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.project.Adapter.CartListAdapter;
import com.example.project.Helper.ManagementCart;
import com.example.project.Interface.ChangeNumberItemsListener;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity
{
    /*======<<<<------ DECLARATION ------>>>>============*/
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    /*======<<<<------ /DECLARATION ------>>>>============*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        calculateCard();
        bottomNavigation();
    }

    /*======<<<<------ NAVIGATION BAR ------>>>>============*/
    private void bottomNavigation() {

        /*======<<<<------ INITIALISATION ------>>>>============*/
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout suppBtn = findViewById(R.id.suppBtn);
        LinearLayout settingsBtn = findViewById(R.id.settingbBtn);
        /*======<<<<------ /INITIALISATION ------>>>>============*/


        /*======<<<<------ REDIRECT TO MAINACTIVITY ------>>>>============*/
        homeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(CartListActivity.this, MainActivity.class));
            }
        });
        /*======<<<<------ /REDIRECT TO MAINACTIVITY ------>>>>============*/


        /*======<<<<------ REDIRECT TO ProfileActivity ------>>>>============*/
        profileBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(CartListActivity.this, ProfileActivity.class));
            }
        });
        /*======<<<<------ /REDIRECT TO ProfileActivity ------>>>>============*/


        /*======<<<<------ REDIRECT TO SuppActivity ------>>>>============*/
        suppBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(CartListActivity.this, SuppActivity.class));
            }
        });
        /*======<<<<------ /REDIRECT TO SuppActivity ------>>>>============*/


        /*======<<<<------ REDIRECT TO SettingsActivity ------>>>>============*/
        settingsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(CartListActivity.this, SettingsActivity.class));
            }
        });
        /*======<<<<------ /REDIRECT TO SettingsActivity ------>>>>============*/

    /*======<<<<------ /NAVIGATION BAR ------>>>>============*/

    }


    /*======<<<<------ CARD ------>>>>============*/
    private void initList()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCard(), this, new ChangeNumberItemsListener()
        {
            @Override
            public void changed()
            {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCard().isEmpty())
            {
            emptyTxt.setVisibility(View.VISIBLE);
            }
        else
            {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            }
    }
    /*======<<<<------ /CARD ------>>>>============*/


    /*======<<<<------ CALCULATE CARD SHOP ------>>>>============*/
    private void calculateCard()
    {
        double percentTax = 0.02;
        double delivery = 4.5;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText(itemTotal +" DT" );
        taxTxt.setText(tax + " DT" );
        deliveryTxt.setText(delivery + " DT");
        totalTxt.setText(total + " DT");
    }
    /*======<<<<------ /CALCULATE CARD SHOP ------>>>>============*/



    /*======<<<<------ INITIALISATION ------>>>>============*/
    private void initView()
    {
        recyclerViewList = findViewById(R.id.recyclerview);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView4);
    }
    /*======<<<<------ INITIALISATION ------>>>>============*/

}