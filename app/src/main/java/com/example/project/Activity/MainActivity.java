package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.project.Adapter.CategoryAdapter;
import com.example.project.Adapter.PopularAdapter;
import com.example.project.Domain.CategoryDomain;
import com.example.project.Domain.FoodDomain;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{

         /*======<<<<------ DECLARATION SILER ------>>>>============*/
             RecyclerView rcvBanner;
             List<Integer> urls;
             Timer timer;
             TimerTask timerTask;
             int position;
             LinearLayoutManager layoutManager;
         /*======<<<<------ /DECLARATION SLIDER ------>>>>============*/


         /*======<<<<------ DECLARATION VALUES ------>>>>============*/
             private RecyclerView.Adapter adapter, adapter2;
             private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
             private TextView welcomename;
             private String name,namedb;
             private ImageView logout;
         /*======<<<<------ DECLARATION VALUES ------>>>>============*/

         @Override
         protected void onCreate(Bundle savedInstanceState)
         {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);

         /*======<<<<------ SLIDER BEGIN ------>>>>============*/

             /*======<<<<------ SLIDER INITIALISATION VALUES ------>>>>============*/
                 rcvBanner = findViewById(R.id.rcvBanner);
                 layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                 rcvBanner.setLayoutManager(layoutManager);
                 getListurl();
                 BannerAdapter bannerAdapter = new BannerAdapter(this, urls);
                 rcvBanner.setAdapter(bannerAdapter);
             /*======<<<<------ /SLIDER INITIALISATION VALUES ------>>>>============*/


                 if (urls != null)
                 {
                     position = Integer.MAX_VALUE / 2;
                     rcvBanner.scrollToPosition(position);
                 }
                 SnapHelper snapHelper = new LinearSnapHelper();
                 snapHelper.attachToRecyclerView(rcvBanner);
                 rcvBanner.smoothScrollBy(5, 0);
                 rcvBanner.addOnScrollListener(new RecyclerView.OnScrollListener()
                 {
                     @Override
                     public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState)
                     {
                         super.onScrollStateChanged(recyclerView, newState);

                         if (newState == 1) {
                             stopAutoScrollBanner();
                         } else if (newState == 0) {
                             position = layoutManager.findFirstCompletelyVisibleItemPosition();
                             runAutoScrollBanner();
                         }
                     }
                 });
         /*======<<<<------ /SLIDER END ------>>>>============*/


             /*======<<<<------ MAIN METHODS ------>>>>============*/
             recyclerViewCategory();
             recyclerViewPopular();
             recyclerViewPopular2();
             recyclerViewDrink();
             recyclerViewSandwich();
             bottomNavigation();
             /*======<<<<------ /MAIN METHODS ------>>>>============*/

             /*======<<<<------ /SET NAME USER ------>>>>============*/
             welcomename=(TextView)findViewById(R.id.welcomename);
             name = welcomename.getText().toString();
             namedb=getIntent().getStringExtra("name");
             welcomename.setText("Welcome "+namedb);
             /*======<<<<------ /SET NAME USER ------>>>>============*/

         }

        /*======<<<<------ METHOD onResume ------>>>>============*/
        @Override
        protected void onResume()
        {
            super.onResume();
            runAutoScrollBanner();
        }
        /*======<<<<------ /METHOD onResume ------>>>>============*/



        /*======<<<<------ METHOD onPause ------>>>>============*/
        @Override
        protected void onPause()
        {
            super.onPause();
            stopAutoScrollBanner();
        }
        /*======<<<<------ /METHOD onPause ------>>>>============*/


        /*======<<<<------ METHOD stopAutoScrollBanner ------>>>>============*/
        private void stopAutoScrollBanner()
        {
            if (timer != null && timerTask != null) {
                timerTask.cancel();
                timer.cancel();
                timer = null;
                timerTask = null;
                position = layoutManager.findFirstCompletelyVisibleItemPosition();
            }
        }
        /*======<<<<------ /METHOD stopAutoScrollBanner ------>>>>============*/



        /*======<<<<------ METHOD runAutoScrollBanner ------>>>>============*/
        private void runAutoScrollBanner()
        {
            if (timer == null && timerTask == null)
            {
                timer = new Timer();
                timerTask = new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        if (position == Integer.MAX_VALUE)
                            {
                                position = Integer.MAX_VALUE / 2;
                                rcvBanner.scrollToPosition(position);
                                rcvBanner.smoothScrollBy(5, 0);
                            }
                        else
                            {
                            position++;
                            rcvBanner.smoothScrollToPosition(position);
                            }
                    }
                };
                timer.schedule(timerTask, 4000, 4000);
            }
        }
        /*======<<<<------ /METHOD runAutoScrollBanner ------>>>>============*/



        /*======<<<<------ METHOD runAutoScrollBanner ------>>>>============*/
        private void getListurl() {
            urls = new ArrayList<Integer>();

            urls.add(R.drawable.bg1food);
            urls.add(R.drawable.bg2food);
            urls.add(R.drawable.bg3food3);
            urls.add(R.drawable.bg5food55);
        }
        /*======<<<<------ /METHOD runAutoScrollBanner ------>>>>============*/


    /*======<<<<------ /METHOD  ------>>>>============*/





    /*======<<<<------ NAVIGATION BAR  ------>>>>============*/
    private void bottomNavigation()
            {
            /*======<<<<------ DECLARATION  ------>>>>============*/
                FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
                ImageView logout = findViewById(R.id.logoutmain);
                LinearLayout profileBtn = findViewById(R.id.profileBtn);
                LinearLayout suppBtn = findViewById(R.id.suppBtn);
                LinearLayout settingsBtn = findViewById(R.id.settingsbBtn);
            /*======<<<<------ /DECLARATION  ------>>>>============*/



            /*======<<<<------ REDIRECT TO floatingActionButton  ------>>>>============*/
                floatingActionButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(MainActivity.this, CartListActivity.class));
                    }
                });
            /*======<<<<------ /REDIRECT TO floatingActionButton  ------>>>>============*/



            /*======<<<<------ REDIRECT TO IntroActivity  ------>>>>============*/
                logout.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        Intent i = new Intent(MainActivity.this, IntroActivity.class);
                        startActivity(i);
                    }
                });
            /*======<<<<------ /REDIRECT TO IntroActivity  ------>>>>============*/



            /*======<<<<------ REDIRECT TO ProfileActivity  ------>>>>============*/
                profileBtn.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                        intent.putExtra("name",namedb);
                        startActivity(intent);

                    }
                });
            /*======<<<<------ /REDIRECT TO ProfileActivity  ------>>>>============*/



            /*======<<<<------ REDIRECT TO SuppActivity  ------>>>>============*/
                suppBtn.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(MainActivity.this,SuppActivity.class);
                        intent.putExtra("name",namedb);
                        startActivity(intent);
                    }
                });
            /*======<<<<------ /REDIRECT TO SuppActivity  ------>>>>============*/



            /*======<<<<------ REDIRECT TO SettingsActivity  ------>>>>============*/
                settingsBtn.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
                        intent.putExtra("name",namedb);
                        startActivity(intent);
                    }
                });
            /*======<<<<------ /REDIRECT TO SettingsActivity  ------>>>>============*/

            }



    /*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[------ POPULAR LISTE------]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
         private void recyclerViewPopular()
         {
             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
             recyclerViewPopularList = findViewById(R.id.recyclerView2);
             recyclerViewPopularList.setLayoutManager(linearLayoutManager);

             ArrayList<FoodDomain> foodlist = new ArrayList<>();
             foodlist.add(new FoodDomain("Djeja Routie", "djeja", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 13.8));
             foodlist.add(new FoodDomain("Makloub Escalope", "makloub", "escalope gruié , fromage sauce, Lettuce, tomato ", 6.5));
             foodlist.add(new FoodDomain("Coka", "coka", " glace ", 3.5));
             foodlist.add(new FoodDomain("Frites", "frites", " supplement ", 1.5));

             adapter2 = new PopularAdapter(foodlist);
             recyclerViewPopularList.setAdapter(adapter2);
         }

    /*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[------ TOUNSSI  LISTE ------]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
         private void recyclerViewPopular2()
         {
             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
             recyclerViewPopularList = findViewById(R.id.recyclerView1);
             recyclerViewPopularList.setLayoutManager(linearLayoutManager);

             ArrayList<FoodDomain> foodlist = new ArrayList<>();
             foodlist.add(new FoodDomain("Ojja Merguez", "ojja", "Merguez ,Felfel, Bsal,  Adham mrawba, tmatem", 18.5));
             foodlist.add(new FoodDomain("Plat Tunisien", "plattounssi", "tmatem , thon , felfe, zitoun ,bsal , slata khadhra , slata mechweya  ", 7.6));
             foodlist.add(new FoodDomain("Plat Kafteji", "kafteji", " frite , adham , tastira , bnin khoudh  ", 4.5));
             foodlist.add(new FoodDomain("Kosksi Hout", "kosksihout", " kosksi dyeri , hout frechek , felfel mo9li   ", 12.5));
             foodlist.add(new FoodDomain("Kosksi Alouch", "kosksilham", " ksksi chamsi , alouch hlib , bennaaa ", 14.5));


             adapter2 = new PopularAdapter(foodlist);
             recyclerViewPopularList.setAdapter(adapter2);
         }
    /*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[------ /TOUNSSI  LISTE ------]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/



    /*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[------ DRINK LISTE------]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
         private void recyclerViewDrink()
         {
             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
             recyclerViewPopularList = findViewById(R.id.recyclerViewDrink);
             recyclerViewPopularList.setLayoutManager(linearLayoutManager);

             ArrayList<FoodDomain> foodlist = new ArrayList<>();
             foodlist.add(new FoodDomain("Canette Fanta", "fanta", "Freeesh", 3.0));
             foodlist.add(new FoodDomain("Canette Coka", "coka", "Freeesh", 2.8));
             foodlist.add(new FoodDomain("Canette Boga", "boga", "Freeesh", 2.9));
             foodlist.add(new FoodDomain("Canette Apla", "apla", "Freeesh", 2.5));
             foodlist.add(new FoodDomain("Canette Pepsi", "pepsi", "Freeesh", 2.9));
             foodlist.add(new FoodDomain("Canette Red Bull", "redbull", "Enegrgy", 6.5));
             foodlist.add(new FoodDomain("Canette Shark", "shark", "Enegrgy", 6.2));

             adapter2 = new PopularAdapter(foodlist);
             recyclerViewPopularList.setAdapter(adapter2);
         }




    /*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[------ SANDWICH LISTE------]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
         private void recyclerViewSandwich()
         {

             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
             recyclerViewPopularList = findViewById(R.id.recyclerViewSandwich);
             recyclerViewPopularList.setLayoutManager(linearLayoutManager);

             ArrayList<FoodDomain> foodlist = new ArrayList<>();
             foodlist.add(new FoodDomain("Sandwich Jambon", "jambon", "slata mechweya , fromage ,omlet ,hrissa Jambon", 5.3));
             foodlist.add(new FoodDomain("Sandwich Thon", "thon", "Thon,slata mechweya ,salata khadha,", 4.9));
             foodlist.add(new FoodDomain("Panini", "panini", "fromage,frite, hrissa,mayonez", 3.5));
             foodlist.add(new FoodDomain("Makloub", "makloub", "scalope,slata mechweya,hrisa,fromage,slata khadhra", 6.5));
             foodlist.add(new FoodDomain("Burger", "burger", "fromage,slata,chawarma", 7.5));

             adapter2 = new PopularAdapter(foodlist);
             recyclerViewPopularList.setAdapter(adapter2);

         }


    /*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[------ CATEGORY  LISTE ------]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
         private void recyclerViewCategory()
         {
             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
             recyclerViewCategoryList = findViewById(R.id.recyclerView3);
             recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

             ArrayList<CategoryDomain> categoryList = new ArrayList<>();
             categoryList.add(new CategoryDomain("Tounssi", "tounsi"));
             categoryList.add(new CategoryDomain("Sandwich", "sandwich"));

             categoryList.add(new CategoryDomain("Burger", "cat_2"));
             categoryList.add(new CategoryDomain("Drink", "cat_3"));



             adapter = new CategoryAdapter(categoryList);
             recyclerViewCategoryList.setAdapter(adapter);
         }
}