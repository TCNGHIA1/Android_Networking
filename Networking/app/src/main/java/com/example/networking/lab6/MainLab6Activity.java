package com.example.networking.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networking.R;

import org.ksoap2.serialization.SoapObject;

public class MainLab6Activity extends AppCompatActivity {
    EditText editText;
    Button btnF, btnC;
    TextView tvResult;
    int convertStyle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab6);
        editText = (EditText) findViewById(R.id.ip_text);
        btnF = (Button) findViewById(R.id.btn_F_to_C);
        btnC = (Button) findViewById(R.id.btn_C_to_F);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnF.setOnClickListener(v->{
            invokeAsyncTask("Fahrenheit", Constants.F_TO_C_SOAP_ACTION,
                    Constants.F_TO_C_METHOD_NAME);
            convertStyle = 1;

        });
        btnC.setOnClickListener(v->{
            invokeAsyncTask("Celsius", Constants.C_TO_F_SOAP_ACTION,
                    Constants.C_TO_F_METHOD_NAME);
            convertStyle = 0;
        });
    }
    private void invokeAsyncTask(String convertParams, String soapAction,
                                 String methodName) {
        new ConvertTemperatureTask(this, soapAction, methodName,
                convertParams).execute(editText.getText()
                .toString().trim());
    }
    //call back data from background thread and set to views
    public void callBackDataFromAsyncTask(String result) {
        double resultTemperature = Double.parseDouble(result); //parse String to double
        if (convertStyle == 0) {// C degree to F degree
            tvResult.setText(editText.getText().toString().trim() + " degree Celsius = "
                            + String.format("%.2f", resultTemperature) + " degree  Fahrenheit");
        } else {// F degree to C degree
            tvResult.setText(editText.getText().toString().trim() + " degree Fahrenheit = "
                            + String.format("%.2f", resultTemperature) + " degree Celsius");
        }
    }

}

class ConvertTemperatureTask extends AsyncTask<String, Void, String>
{
    ProgressDialog pDialog;
    private MainLab6Activity activity;
    private String soapAction;
    private String methodName;
    private String paramsName;
    public ConvertTemperatureTask(MainLab6Activity activity, String soapAction,
                                  String methodName, String paramsName) {
        this.soapAction = soapAction;
        this.methodName = methodName;
        this.paramsName = paramsName;
        this.activity = activity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
    }
    @Override
    protected String doInBackground(String... params) {
        //create a new soap request object
        SoapObject request = new SoapObject(Constants.NAME_SPACE, methodName);
        //add properties for soap object
        request.addProperty(paramsName, params[0]);
        //request to server and get Soap Primitive response
        return WebServiceCall.callWSThreadSoapPrimitive(Constants.URL, soapAction, request);
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
        if (result == null) {
            Log.i("check", "cannot get result");
        } else {
            Log.i("check", result);
            //invoke call back method of Activity
            activity.callBackDataFromAsyncTask(result);
        }
    }
}
