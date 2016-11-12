package techspex.rsoc.i;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void Login(View v){
        Intent i = new Intent(MenuActivity.this,MainActivity.class);
        startActivity(i);
    }
    public void News(View v){
        Intent i = new Intent(MenuActivity.this,PieActivity.class);
        startActivity(i);
    }
}

