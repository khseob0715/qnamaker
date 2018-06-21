package com.aiden.qnamaker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aiden.qnamaker.Fragment.MainFragment;
import com.aiden.qnamaker.Fragment.My_QnAFragment;
import com.aiden.qnamaker.Fragment.QnAFragment;
import com.aiden.qnamaker.Fragment.SetFragment;

public class MainActivity extends AppCompatActivity{

    ImageView mainButton, myQnAButton, QnAButton, setButton;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    int Current_Fragment_Index = 1;
    int Select_Fragment_Index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fragment를 불러오는 소스코드.
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, new MainFragment());
        fragmentTransaction.commit();

        mainButton = (ImageView)findViewById(R.id.mainButton);
        myQnAButton = (ImageView)findViewById(R.id.myQnAButton);
        QnAButton = (ImageView)findViewById(R.id.QnAButton);
        setButton = (ImageView)findViewById(R.id.setButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select_Fragment_Index = 1;
                Button_Image_Change(Current_Fragment_Index,Select_Fragment_Index);
                Fragment_Change(new MainFragment());
            }
        });
        myQnAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select_Fragment_Index = 2;
                Button_Image_Change(Current_Fragment_Index,Select_Fragment_Index);
                Fragment_Change(new My_QnAFragment());
            }
        });
        QnAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select_Fragment_Index = 3;
                Button_Image_Change(Current_Fragment_Index,Select_Fragment_Index);
                Fragment_Change(new QnAFragment());
            }
        });
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select_Fragment_Index = 4;
                Button_Image_Change(Current_Fragment_Index,Select_Fragment_Index);
                Fragment_Change(new SetFragment());
            }
        });

    }

    private void Button_Image_Change(int current_Fragment_Index, int select_Fragment_Index){
        switch (current_Fragment_Index){
            case 1:
                mainButton.setImageResource(R.drawable.icon01non);
                break;
            case 2:
                myQnAButton.setImageResource(R.drawable.icon02non);
                break;
            case 3:
                QnAButton.setImageResource(R.drawable.icon03non);
                break;
            case 4:
                setButton.setImageResource(R.drawable.icon04non);
                break;
        }
        switch (select_Fragment_Index){
            case 1:
                mainButton.setImageResource(R.drawable.icon01);
                break;
            case 2:
                myQnAButton.setImageResource(R.drawable.icon02);
                break;
            case 3:
                QnAButton.setImageResource(R.drawable.icon03);
                break;
            case 4:
                setButton.setImageResource(R.drawable.icon04);
                break;
        }
    }



    private void Fragment_Change(Fragment changeFragment){
        fragmentTransaction = fragmentManager.beginTransaction();

        if(Current_Fragment_Index > Select_Fragment_Index){
            fragmentTransaction.setCustomAnimations(R.anim.fromleft, R.anim.toright);
        }else if(Current_Fragment_Index < Select_Fragment_Index){
            fragmentTransaction.setCustomAnimations(R.anim.fromright, R.anim.toleft);
        }
        Current_Fragment_Index = Select_Fragment_Index;
        fragmentTransaction.replace(R.id.content, changeFragment);
        fragmentTransaction.commit();
    }

}
