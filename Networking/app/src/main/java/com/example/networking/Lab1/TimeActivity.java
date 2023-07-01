package com.example.networking.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networking.R;

public class TimeActivity extends AppCompatActivity {
    private EditText ed_time;
    private Button btn_run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ed_time = findViewById(R.id.ed_time);
        btn_run = findViewById(R.id.btn_run);


        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeAsyncTask timeAsyncTask =  new TimeAsyncTask(TimeActivity.this,ed_time);
                String sleepTime = ed_time.getText().toString().trim();
                if(TextUtils.isEmpty(sleepTime)){
                    Toast.makeText(TimeActivity.this,"Please input your time",Toast.LENGTH_SHORT).show();
                }else{
                    timeAsyncTask.execute(sleepTime);
                }
            }
        });
    }


    //asynctask
    class TimeAsyncTask extends AsyncTask<String,String ,String> {
        //message
        private String msg;
        ProgressDialog progressDialog;
        private EditText editText;
        private Context mContext;
        public TimeAsyncTask(Context context,EditText editText){
            this.mContext = context;
            this.editText = editText;
        }
        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping...");

                int mTime = Integer.parseInt(strings[0]) * 1000;
                msg = "Sleep for " + strings[0] + " seconds";
                try {
                    Thread.sleep(mTime);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            return msg;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(mContext,"Notification","Wait for "+ editText.getText().toString() +" seconds");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

    }
}

