package sg.edu.rp.c346.id22016845.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dbs;
    TextView ocbc;
    TextView uob;
    TextView bankList;
    TextView titular;
    TextView access;
    TextView thankyou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs=findViewById(R.id.textViewDBS);
        registerForContextMenu(dbs);
        ocbc=findViewById(R.id.textViewOCBC);
        registerForContextMenu(ocbc);
        uob=findViewById(R.id.textViewUOB);
        registerForContextMenu(uob);
        titular=findViewById(R.id.textViewTitular);
        access=findViewById(R.id.textViewAccess);
        bankList=findViewById(R.id.textViewBankList);
        thankyou=findViewById(R.id.textViewThankYou);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.EnglishSelection){
            titular.setText("My Local Banks");
            access.setText("Accessing all the banks fast and conveniently!");
            bankList.setText("Bank List");
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            thankyou.setText("Thank you for using the app!");
            return true;
        }else if(id==R.id.ChineseSelection){
            titular.setText("我的本地银行");
            access.setText("快速方便地访问所有银行!");
            bankList.setText("银行名单");
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            thankyou.setText("谢谢你使用这个应用程序!");

        }
        return super.onOptionsItemSelected(item);
    }
    String wordClicked="";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact");
        if (v == dbs) {
            wordClicked = "dbs";
        } else if (v == ocbc) {
            wordClicked = "ocbc";
        } else if (v == uob) {
            wordClicked = "uob";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(wordClicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0){
                Intent intent= new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1800111111));
                startActivity(intentCall);
            }
        }else if(wordClicked.equalsIgnoreCase("ocbc")){
            if(item.getItemId()==0){
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1800363333));
                startActivity(intentCall);
            }
        }else if(wordClicked.equalsIgnoreCase("uob")){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+1800222212));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item);
    }
}