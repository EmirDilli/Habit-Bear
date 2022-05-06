package com.oyku.habitbear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.oyku.habitbear.BackEnd.*;

public class Inventory extends AppCompatActivity implements View.OnClickListener {
    private Clothes clothes;
    private int type;
    private int whichClotheInType;
    private Account account;
    private boolean redTshirt = false;
    private boolean greenTshirt = false;
    private boolean blueTshirt = false;
    private boolean redPants = false;
    private boolean greenPants = false;
    private boolean bluePants = false;
    private boolean moustache = false;
    private boolean glasses = false;
    ImageView bear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        User.p1 = findViewById(R.id.c1);
        User.p1.setOnClickListener(this::onClick);
        User.p2 = findViewById(R.id.c2);
        User.p2.setOnClickListener(this::onClick);
        User.p3 = findViewById(R.id.c3);
        User.p3.setOnClickListener(this::onClick);
        User.p4 = findViewById(R.id.c4);
        User.p4.setOnClickListener(this::onClick);
        User.p5 = findViewById(R.id.c5);
        User.p5.setOnClickListener(this::onClick);
        User.p6 = findViewById(R.id.c6);
        User.p6.setOnClickListener(this::onClick);
        User.p7 = findViewById(R.id.c7);
        User.p7.setOnClickListener(this::onClick);
        User.p8 = findViewById(R.id.c8);
        User.p8.setOnClickListener(this::onClick);
        bear = findViewById(R.id.bear);

        for (int i = 0; i < User.user.getMyClothes().length; i++) {
            for (int j = 0; j < User.user.getMyClothes()[0].length; j++) {
                if (!(User.user.getMyClothes()[i][j] == null)) {
                    if (i * 3 + j + 1 == 1) {
                        User.p1.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 2) {
                        User.p2.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 3) {
                        User.p3.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 4) {
                        User.p4.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 5) {
                        User.p5.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 6) {
                        User.p6.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 7) {
                        User.p7.setVisibility(View.VISIBLE);
                    }
                    if (i * 3 + j + 1 == 8) {
                        User.p8.setVisibility(View.VISIBLE);
                    }

                }
            }

        }


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == User.p1.getId()) {
            redTshirt = true;
            greenTshirt = false;
            blueTshirt = false;
        } else if (view.getId() == User.p2.getId()) {
            greenTshirt = true;
            redTshirt = false;
            blueTshirt = false;
        } else if (view.getId() == User.p3.getId()) {
            blueTshirt = true;
            greenTshirt = false;
            redTshirt = false;
        }
        if (view.getId() == User.p4.getId()) {
            redPants = true;
            greenPants = false;
            bluePants = false;
        } else if (view.getId() == User.p5.getId()) {
            greenPants = true;
            redPants = false;
            bluePants = false;
        } else if (view.getId() == User.p6.getId()) {
            bluePants = true;
            greenPants = false;
            redPants = false;
        }
        if (view.getId() == User.p7.getId()) {
            moustache = true;
            glasses = false;
        } else if (view.getId() == User.p8.getId()) {
            moustache = false;
            glasses = true;
        } else {
            moustache = false;
            glasses = false;
        }

        if (redTshirt && redPants && moustache) {
            bear.setImageResource(R.mipmap.ayiredpantsmus);
        } else if (redTshirt && redPants && glasses) {
            bear.setImageResource(R.mipmap.ayiglassredpants);
        } else if (redTshirt && greenPants && glasses) {
            bear.setImageResource(R.mipmap.ayigreenpantsglass);
        } else if (redTshirt && greenPants && moustache) {
            bear.setImageResource(R.mipmap.ayigreenpantsmus);
        } else if (redTshirt && bluePants && glasses) {
            bear.setImageResource(R.mipmap.ayibluepantsglass);
        } else if (redTshirt && bluePants && moustache) {
            bear.setImageResource(R.mipmap.redbluemus);
        } else if (greenTshirt && redPants && moustache) {
            bear.setImageResource(R.mipmap.greenredmus);
        } else if (greenTshirt && redPants && glasses) {
            bear.setImageResource(R.mipmap.greenredglass);
        }  else if (greenTshirt && greenPants && moustache) {
            bear.setImageResource(R.mipmap.ayigreenmus);
        } else if (greenTshirt && greenPants && glasses) {
            bear.setImageResource(R.mipmap.greengreenglass);
        } else if (greenTshirt && bluePants && moustache) {
            bear.setImageResource(R.mipmap.greenbluemus);
        } else if (greenTshirt && bluePants && glasses) {
            bear.setImageResource(R.mipmap.greenblueglass);
        }else if (blueTshirt && redPants && moustache) {
            bear.setImageResource(R.mipmap.blueredmus);
        } else if (blueTshirt && redPants && glasses) {
            bear.setImageResource(R.mipmap.blueredglass);
        } else if (blueTshirt && greenPants && moustache) {
            bear.setImageResource(R.mipmap.bluegreenmus);
        } else if (blueTshirt && greenPants && glasses) {
            bear.setImageResource(R.mipmap.bluegreenglass);
        }  else if (blueTshirt && bluePants && moustache) {
            bear.setImageResource(R.mipmap.bluebluemus);
        } else if (blueTshirt && bluePants && glasses) {
            bear.setImageResource(R.mipmap.blueblueglass);
        }else if (redTshirt && redPants) {
            bear.setImageResource(R.mipmap.ayiredpants);
        } else if (redTshirt && greenPants) {
            bear.setImageResource(R.mipmap.ayigreenpants);
        }else if (redTshirt && bluePants) {
            bear.setImageResource(R.mipmap.ayibluepants);
        }else if (greenTshirt && redPants) {
            bear.setImageResource(R.mipmap.greenred);
        }else if (greenTshirt && greenPants) {
            bear.setImageResource(R.mipmap.greengreen);
        } else if (greenTshirt && bluePants) {
            bear.setImageResource(R.mipmap.greenblue);
        } else if (blueTshirt && redPants) {
            bear.setImageResource(R.mipmap.bluered);
        } else if (blueTshirt && greenPants) {
            bear.setImageResource(R.mipmap.bluegreen);
        } else if (blueTshirt && bluePants) {
            bear.setImageResource(R.mipmap.blueblue);
        }

        else if(greenTshirt)
        {
            bear.setImageResource(R.mipmap.ayigreen);
        }
        else if(blueTshirt)
        {
            bear.setImageResource(R.mipmap.ayiblue);
        }
        else if(redPants)
        {
            bear.setImageResource(R.mipmap.ayiredpants);
        }
        else if(greenPants)
        {
            bear.setImageResource(R.mipmap.ayigreenpants);
        }
        else if(bluePants)
        {
            bear.setImageResource(R.mipmap.ayibluepants);
        }
        else if(moustache)
        {
            bear.setImageResource(R.mipmap.ayimus);
        }
        else if(glasses)
        {
            bear.setImageResource(R.mipmap.ayiglass);
        }


    }

}