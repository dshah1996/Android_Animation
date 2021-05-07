package com.example.gameapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

public class wRunner extends View {

    //Bitmap object
    Bitmap sky_far, sky_close, highway, vehicle;
    int Width, Height, nwidth, nheight;


    int vanX, vanY, vanFrame = 0;
    int sky_farX = 0, sky_closeX = 0, highwayX = 0, vehicleX,vehicleY;
    //Array type to hold multiple image
    Bitmap sonic[] = new Bitmap[13];
    Runnable runnable;
    //handler object allow to schedule runnable
    Handler handler;
    final long In_Millis = 25;



    public wRunner(Context context) {
        super(context);
        highway = BitmapFactory.decodeResource(getResources(),R.drawable.highway);
        sky_close = BitmapFactory.decodeResource(getResources(),R.drawable.skyline_close);
        sky_far = BitmapFactory.decodeResource(getResources(),R.drawable.skyline_far);
        vehicle = BitmapFactory.decodeResource(getResources(),R.drawable.owl);
        sonic[0] = BitmapFactory.decodeResource(getResources(),R.drawable.img1);
        sonic[1] = BitmapFactory.decodeResource(getResources(),R.drawable.img1);
        sonic[2] = BitmapFactory.decodeResource(getResources(),R.drawable.img2);
        sonic[3] = BitmapFactory.decodeResource(getResources(),R.drawable.img2);
        sonic[4] = BitmapFactory.decodeResource(getResources(),R.drawable.img3);
        sonic[5] = BitmapFactory.decodeResource(getResources(),R.drawable.img3);
        sonic[6] = BitmapFactory.decodeResource(getResources(),R.drawable.img4);
        sonic[7] = BitmapFactory.decodeResource(getResources(),R.drawable.img4);
        sonic[8] = BitmapFactory.decodeResource(getResources(),R.drawable.img5);
        sonic[9] = BitmapFactory.decodeResource(getResources(),R.drawable.img5);
        sonic[10] = BitmapFactory.decodeResource(getResources(),R.drawable.img6);
        sonic[11] = BitmapFactory.decodeResource(getResources(),R.drawable.img7);
        sonic[12] = BitmapFactory.decodeResource(getResources(),R.drawable.img7);

        //screen height and width
        Display display =((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Width = size.x;
        Height = size.y;

        nheight = Height;
        nwidth =  Height;
        //set height and width with new height
        sky_far = Bitmap.createScaledBitmap(sky_far, nwidth,nheight,false);
        sky_close = Bitmap.createScaledBitmap(sky_close, nwidth,nheight,false);
        highway = Bitmap.createScaledBitmap(highway, nwidth,nheight,false);
        //for vehicle
        vehicleX = Width / 2 ;
        vehicleY = Height - 300;



        //set the pos of character
        vanX = Width / 2 - 200;
        vanY = Height - 500;
        handler = new Handler();

        runnable = new Runnable(){
            @Override
            public void run(){
                invalidate();
            }

        };

    }
    //for all animation
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);


        sky_farX -= 3;
        if(sky_farX < -nwidth){
            sky_farX = 0;

        }
        canvas.drawBitmap(sky_far,sky_farX,0,null);
        //when reach edges
        if(sky_farX < Width - nwidth){
            canvas.drawBitmap(sky_far,sky_farX+nwidth,0,null);

        }
        sky_closeX -= 4;
        if(sky_closeX < -nwidth){
            sky_closeX = 0;

        }
        canvas.drawBitmap(sky_close,sky_closeX,400,null);
        if(sky_closeX < Width - nwidth){
            canvas.drawBitmap(sky_close,sky_closeX+nwidth,400,null);

        }

        highwayX = 5;
        if(highwayX < - nwidth){
            highwayX = 0;

        }
        canvas.drawBitmap(highway,highwayX,1600,null);
        if(highwayX < Width - nwidth){
            canvas.drawBitmap(highway,highwayX + nwidth,1600,null);

        }

        vehicleX -= 5;
        if(vehicleX < - nwidth){
            vehicleX = 0;
        }
        canvas.drawBitmap(vehicle,vehicleX + nwidth ,vehicleY,null);
        vanFrame++;
        if(vanFrame == 12)
            vanFrame = 0;
        canvas.drawBitmap(sonic[vanFrame],vanX,vanY,null);

        //run method execute after 25 milliseconds
        handler.postDelayed(runnable,In_Millis);


    }

}