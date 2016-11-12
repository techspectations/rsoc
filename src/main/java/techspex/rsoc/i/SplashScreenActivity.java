package techspex.rsoc.i;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;



public class SplashScreenActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       // TextView txt=(TextView) findViewById(R.id.textView6);
        //Typeface typ = Typeface.createFromAsset(getAssets(),"assas.ttf");
        //txt.setTypeface(typ);
       // Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
      //  txt.startAnimation(anim);



        Thread timerThread=new Thread(){
            public  void run(){
                try {
                    sleep(1500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent i=new Intent(SplashScreenActivity.this,MenuActivity.class);
                    startActivity(i);
                }
            }
        };
        timerThread.start();

    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}