package in.shgupta.gotowebdial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String web;
    String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button btnweb=(Button)findViewById(R.id.btnweb);
        Button btndial= (Button) findViewById(R.id.btndial);
        final EditText url=(EditText)findViewById(R.id.urlname);
        final EditText dialer= (EditText) findViewById(R.id.dialer);
       // web=url.getText().toString();


//
//        if (!web.startsWith("http://") && !web.startsWith("https://"))
//           web = "http://"+web;

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web=url.getText().toString();

                if (!web.startsWith("http://") && !web.startsWith("https://"))
                    web = "http://"+web;
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(i);
            }
        });

        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tel=dialer.getText().toString();

                Intent i=new Intent((Intent.ACTION_DIAL),Uri.parse("tel:"+tel));
                startActivity(i);
            }
        });
    }
}
