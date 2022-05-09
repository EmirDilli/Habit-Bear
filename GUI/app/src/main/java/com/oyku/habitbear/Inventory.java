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
    ImageView bear, back;


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
        back = findViewById(R.id.backInventory);
        back.setOnClickListener(this::onClick);

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


            if (User.redTshirt && User.redPants && User.moustache) {
                bear.setImageResource(R.mipmap.redredmus);
            } else if (User.redTshirt && User.redPants && User.glasses) {
                bear.setImageResource(R.mipmap.redredglass);

            } else if (User.redTshirt && User.greenPants && User.glasses) {
                bear.setImageResource(R.mipmap.redgreenglass);

            } else if (User.redTshirt && User.greenPants && User.moustache) {
                bear.setImageResource(R.mipmap.redgreenmus);

            } else if (User.redTshirt && User.bluePants && User.glasses) {
                bear.setImageResource(R.mipmap.redblueglass);

            } else if (User.redTshirt && User.bluePants && User.moustache) {
                bear.setImageResource(R.mipmap.redbluemus);

            } else if (User.greenTshirt && User.redPants && User.moustache) {
                bear.setImageResource(R.mipmap.greenredmus);

            } else if (User.greenTshirt && User.redPants && User.glasses) {
                bear.setImageResource(R.mipmap.greenredglass);

            }  else if (User.greenTshirt && User.greenPants && User.moustache) {
                bear.setImageResource(R.mipmap.greengreenmus);

            } else if (User.greenTshirt && User.greenPants && User.glasses) {
                bear.setImageResource(R.mipmap.greengreenglass);

            } else if (User.greenTshirt && User.bluePants && User.moustache) {
                bear.setImageResource(R.mipmap.greenbluemus);

            } else if (User.greenTshirt && User.bluePants && User.glasses) {
                bear.setImageResource(R.mipmap.greenblueglass);

            }else if (User.blueTshirt && User.redPants && User.moustache) {
                bear.setImageResource(R.mipmap.blueredmus);

            } else if (User.blueTshirt && User.redPants && User.glasses) {
                bear.setImageResource(R.mipmap.blueredglass);

            } else if (User.blueTshirt && User.greenPants && User.moustache) {
                bear.setImageResource(R.mipmap.bluegreenmus);

            } else if (User.blueTshirt && User.greenPants && User.glasses) {
                bear.setImageResource(R.mipmap.bluegreenglass);

            }  else if (User.blueTshirt && User.bluePants && User.moustache) {
                bear.setImageResource(R.mipmap.bluebluemus);

            } else if (User.blueTshirt && User.bluePants && User.glasses) {
                bear.setImageResource(R.mipmap.blueblueglass);

            }else if (User.redTshirt && User.redPants) {
                bear.setImageResource(R.mipmap.redred);

            } else if (User.redTshirt && User.greenPants) {
                bear.setImageResource(R.mipmap.redgreen);

            }else if (User.redTshirt && User.bluePants) {
                bear.setImageResource(R.mipmap.redblue);

            }else if (User.greenTshirt && User.redPants) {
                bear.setImageResource(R.mipmap.greenred);

            }else if (User.greenTshirt && User.greenPants) {
                bear.setImageResource(R.mipmap.greengreen);

            } else if (User.greenTshirt && User.bluePants) {
                bear.setImageResource(R.mipmap.greenblue);

            } else if (User.blueTshirt && User.redPants) {
                bear.setImageResource(R.mipmap.bluered);

            } else if (User.blueTshirt && User.greenPants) {
                bear.setImageResource(R.mipmap.bluegreen);

            } else if (User.blueTshirt && User.bluePants) {
                bear.setImageResource(R.mipmap.blueblue);
            }
            else if (User.redTshirt && User.moustache) {
                bear.setImageResource(R.mipmap.redmus);

            }else if (User.redTshirt && User.glasses) {
                bear.setImageResource(R.mipmap.redglass);

            }else if (User.greenTshirt && User.moustache) {
                bear.setImageResource(R.mipmap.ayigreenmus);

            }else if (User.greenTshirt && User.glasses) {
                bear.setImageResource(R.mipmap.ayigreenglass);

            } else if (User.blueTshirt && User.moustache) {
                bear.setImageResource(R.mipmap.bluemus);

            } else if (User.blueTshirt && User.glasses) {
                bear.setImageResource(R.mipmap.blueglass);

            }
            else if(User.redPants && User.moustache)
            {
                bear.setImageResource((R.mipmap.ayiredpantsmus));

            }
            else if (User.redPants && User.glasses) {
                bear.setImageResource(R.mipmap.ayiglassredpants);

            } else if (User.greenPants && User.moustache) {
                bear.setImageResource(R.mipmap.ayigreenpantsmus);

            } else if (User.greenPants && User.glasses) {
                bear.setImageResource(R.mipmap.ayigreenpantsglass);

            }
            else if (User.bluePants && User.moustache) {
                bear.setImageResource(R.mipmap.ayi31);

            } else if (User.bluePants && User.glasses) {
                bear.setImageResource(R.mipmap.ayibluepantsglass);

            }
            else if(User.redTshirt)
            {
                bear.setImageResource(R.mipmap.red);

            }
            else if(User.greenTshirt)
            { bear.setImageResource(R.mipmap.ayigreen);}

            else if(User.blueTshirt)
            { bear.setImageResource(R.mipmap.ayiblue);
            }
            else if(User.redPants)
            { bear.setImageResource(R.mipmap.ayiredpants);
            }
            else if(User.greenPants)
            { bear.setImageResource(R.mipmap.ayigreenpants);
            }
            else if(User.bluePants)
            { bear.setImageResource(R.mipmap.ayibluepants);
            }
            else if(User.moustache)
            { bear.setImageResource(R.mipmap.ayimus);
            }
            else if(User.glasses)
            { bear.setImageResource(R.mipmap.ayiglass);
            }

        }

        if (User.redTshirt && User.redPants && User.moustache) {
            bear.setImageResource(R.mipmap.redredmus);
        } else if (User.redTshirt && User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.redredglass);

        } else if (User.redTshirt && User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.redgreenglass);

        } else if (User.redTshirt && User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.redgreenmus);

        } else if (User.redTshirt && User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.redblueglass);

        } else if (User.redTshirt && User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.redbluemus);

        } else if (User.greenTshirt && User.redPants && User.moustache) {
            bear.setImageResource(R.mipmap.greenredmus);

        } else if (User.greenTshirt && User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.greenredglass);

        }  else if (User.greenTshirt && User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.greengreenmus);

        } else if (User.greenTshirt && User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.greengreenglass);

        } else if (User.greenTshirt && User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.greenbluemus);

        } else if (User.greenTshirt && User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.greenblueglass);

        }else if (User.blueTshirt && User.redPants && User.moustache) {
            bear.setImageResource(R.mipmap.blueredmus);

        } else if (User.blueTshirt && User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.blueredglass);

        } else if (User.blueTshirt && User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.bluegreenmus);

        } else if (User.blueTshirt && User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.bluegreenglass);

        }  else if (User.blueTshirt && User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.bluebluemus);

        } else if (User.blueTshirt && User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.blueblueglass);

        }else if (User.redTshirt && User.redPants) {
            bear.setImageResource(R.mipmap.redred);

        } else if (User.redTshirt && User.greenPants) {
            bear.setImageResource(R.mipmap.redgreen);

        }else if (User.redTshirt && User.bluePants) {
            bear.setImageResource(R.mipmap.redblue);

        }else if (User.greenTshirt && User.redPants) {
            bear.setImageResource(R.mipmap.greenred);

        }else if (User.greenTshirt && User.greenPants) {
            bear.setImageResource(R.mipmap.greengreen);

        } else if (User.greenTshirt && User.bluePants) {
            bear.setImageResource(R.mipmap.greenblue);

        } else if (User.blueTshirt && User.redPants) {
            bear.setImageResource(R.mipmap.bluered);

        } else if (User.blueTshirt && User.greenPants) {
            bear.setImageResource(R.mipmap.bluegreen);

        } else if (User.blueTshirt && User.bluePants) {
            bear.setImageResource(R.mipmap.blueblue);
        }
        else if (User.redTshirt && User.moustache) {
            bear.setImageResource(R.mipmap.redmus);

        }else if (User.redTshirt && User.glasses) {
            bear.setImageResource(R.mipmap.redglass);

        }else if (User.greenTshirt && User.moustache) {
            bear.setImageResource(R.mipmap.ayigreenmus);

        }else if (User.greenTshirt && User.glasses) {
            bear.setImageResource(R.mipmap.ayigreenglass);

        } else if (User.blueTshirt && User.moustache) {
            bear.setImageResource(R.mipmap.bluemus);

        } else if (User.blueTshirt && User.glasses) {
            bear.setImageResource(R.mipmap.blueglass);

        }
        else if(User.redPants && User.moustache)
        {
            bear.setImageResource((R.mipmap.ayiredpantsmus));

        }
        else if (User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.ayiglassredpants);

        } else if (User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.ayigreenpantsmus);

        } else if (User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.ayigreenpantsglass);

        }
        else if (User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.ayi31);

        } else if (User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.ayibluepantsglass);

        }
        else if(User.redTshirt)
        {
            bear.setImageResource(R.mipmap.red);

        }
        else if(User.greenTshirt)
        { bear.setImageResource(R.mipmap.ayigreen);}

        else if(User.blueTshirt)
        { bear.setImageResource(R.mipmap.ayiblue);
        }
        else if(User.redPants)
        { bear.setImageResource(R.mipmap.ayiredpants);
        }
        else if(User.greenPants)
        { bear.setImageResource(R.mipmap.ayigreenpants);
        }
        else if(User.bluePants)
        { bear.setImageResource(R.mipmap.ayibluepants);
        }
        else if(User.moustache)
        { bear.setImageResource(R.mipmap.ayimus);
        }
        else if(User.glasses)
        { bear.setImageResource(R.mipmap.ayiglass);
        }

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == back.getId())
        {
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
            User.user.updateDataToDatabase();
        }

        if (view.getId() == User.p1.getId()) {
            User.redTshirt = true;
            User.greenTshirt = false;
            User.blueTshirt = false;
        } else if (view.getId() == User.p2.getId()) {
            User.greenTshirt = true;
            User.redTshirt = false;
            User.blueTshirt = false;
        } else if (view.getId() == User.p3.getId()) {
            User.blueTshirt = true;
            User.greenTshirt = false;
            User.redTshirt = false;
        }
        if (view.getId() == User.p4.getId()) {
            User.redPants = true;
            User.greenPants = false;
            User.bluePants = false;
        } else if (view.getId() == User.p5.getId()) {
            User.greenPants = true;
            User.redPants = false;
            User.bluePants = false;
        } else if (view.getId() == User.p6.getId()) {
            User.bluePants = true;
            User.greenPants = false;
            User.redPants = false;
        }
        if (view.getId() == User.p7.getId()) {
            User.moustache = false;
            User.glasses = true;
        } else if (view.getId() == User.p8.getId()) {
            User.moustache = true;
            User.glasses = false;
        }
        if (User.redTshirt && User.redPants && User.moustache) {
            bear.setImageResource(R.mipmap.redredmus);
        } else if (User.redTshirt && User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.redredglass);

        } else if (User.redTshirt && User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.redgreenglass);

        } else if (User.redTshirt && User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.redgreenmus);

        } else if (User.redTshirt && User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.redblueglass);

        } else if (User.redTshirt && User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.redbluemus);

        } else if (User.greenTshirt && User.redPants && User.moustache) {
            bear.setImageResource(R.mipmap.greenredmus);

        } else if (User.greenTshirt && User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.greenredglass);

        }  else if (User.greenTshirt && User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.greengreenmus);

        } else if (User.greenTshirt && User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.greengreenglass);

        } else if (User.greenTshirt && User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.greenbluemus);

        } else if (User.greenTshirt && User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.greenblueglass);

        }else if (User.blueTshirt && User.redPants && User.moustache) {
            bear.setImageResource(R.mipmap.blueredmus);

        } else if (User.blueTshirt && User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.blueredglass);

        } else if (User.blueTshirt && User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.bluegreenmus);

        } else if (User.blueTshirt && User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.bluegreenglass);

        }  else if (User.blueTshirt && User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.bluebluemus);

        } else if (User.blueTshirt && User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.blueblueglass);

        }else if (User.redTshirt && User.redPants) {
            bear.setImageResource(R.mipmap.redred);

        } else if (User.redTshirt && User.greenPants) {
            bear.setImageResource(R.mipmap.redgreen);

        }else if (User.redTshirt && User.bluePants) {
            bear.setImageResource(R.mipmap.redblue);

        }else if (User.greenTshirt && User.redPants) {
            bear.setImageResource(R.mipmap.greenred);

        }else if (User.greenTshirt && User.greenPants) {
            bear.setImageResource(R.mipmap.greengreen);

        } else if (User.greenTshirt && User.bluePants) {
            bear.setImageResource(R.mipmap.greenblue);

        } else if (User.blueTshirt && User.redPants) {
            bear.setImageResource(R.mipmap.bluered);

        } else if (User.blueTshirt && User.greenPants) {
            bear.setImageResource(R.mipmap.bluegreen);

        } else if (User.blueTshirt && User.bluePants) {
            bear.setImageResource(R.mipmap.blueblue);
        }
        else if (User.redTshirt && User.moustache) {
            bear.setImageResource(R.mipmap.redmus);

        }else if (User.redTshirt && User.glasses) {
            bear.setImageResource(R.mipmap.redglass);

        }else if (User.greenTshirt && User.moustache) {
            bear.setImageResource(R.mipmap.ayigreenmus);

        }else if (User.greenTshirt && User.glasses) {
            bear.setImageResource(R.mipmap.ayigreenglass);

        } else if (User.blueTshirt && User.moustache) {
            bear.setImageResource(R.mipmap.bluemus);

        } else if (User.blueTshirt && User.glasses) {
            bear.setImageResource(R.mipmap.blueglass);

        }
        else if(User.redPants && User.moustache)
        {
            bear.setImageResource((R.mipmap.ayiredpantsmus));

        }
        else if (User.redPants && User.glasses) {
            bear.setImageResource(R.mipmap.ayiglassredpants);

        } else if (User.greenPants && User.moustache) {
            bear.setImageResource(R.mipmap.ayigreenpantsmus);

        } else if (User.greenPants && User.glasses) {
            bear.setImageResource(R.mipmap.ayigreenpantsglass);

        }
        else if (User.bluePants && User.moustache) {
            bear.setImageResource(R.mipmap.ayi31);

        } else if (User.bluePants && User.glasses) {
            bear.setImageResource(R.mipmap.ayibluepantsglass);

        }
        else if(User.redTshirt)
        {
            bear.setImageResource(R.mipmap.red);

        }
        else if(User.greenTshirt)
        { bear.setImageResource(R.mipmap.ayigreen);}

        else if(User.blueTshirt)
        { bear.setImageResource(R.mipmap.ayiblue);
        }
        else if(User.redPants)
        { bear.setImageResource(R.mipmap.ayiredpants);
        }
        else if(User.greenPants)
        { bear.setImageResource(R.mipmap.ayigreenpants);
        }
        else if(User.bluePants)
        { bear.setImageResource(R.mipmap.ayibluepants);
        }
        else if(User.moustache)
        { bear.setImageResource(R.mipmap.ayimus);
        }
        else if(User.glasses)
        { bear.setImageResource(R.mipmap.ayiglass);
        }



    }

}