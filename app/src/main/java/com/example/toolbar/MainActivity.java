package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);




        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id==R.id.home){
                    loadHome(new AFragment());
                    
                }else if (id==R.id.gallary){
                    loadGallery(new GalleryFragment());
                    
                } else if (id==R.id.events) {
                    loadEvents(new EventsFragment());
                } else if (id==R.id.merchandise) {
                    loadMerchandise(new MerchandiseFragment());
                } else if (id==R.id.contact_us) {
                    loadContactUs(new ContactUsFragment());
                }else if (id==R.id.about_us) {
                    loadAboutUs(new AboutFragment());
                }

                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }






            private void loadContactUs(ContactUsFragment contactUsFragment) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,contactUsFragment);
                ft.commit();
            }

            private void loadMerchandise(MerchandiseFragment merchandiseFragment) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,merchandiseFragment);
                ft.commit();
            }

            private void loadEvents(EventsFragment eventsFragment) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,eventsFragment);
                ft.commit();
            }

            private void loadGallery(GalleryFragment galleryFragment) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,galleryFragment);
                ft.commit();
            }


            private void loadAboutUs(AboutFragment aboutFragment) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,aboutFragment);
                ft.commit();
            }


            private void loadHome(Fragment fragment) {
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container,fragment);
                ft.commit();

            }


        });


    }

}