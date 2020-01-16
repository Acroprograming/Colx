package com.example.santl.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by santl on 05-01-2020.
 */

public class Background extends AsyncTask<String,String,String> {
    Context context;
    AlertDialog alertDialog;
    String ip = "192.168.43.112:8080";
    static String name,lname,id;
    Background(Context ctx) {
        context = ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("status");
    }
    @Override
    protected String doInBackground(String... param) {
        String type = param[0];
        if (type.equals("log_in")) {
            try {
                String roll_number = param[1];
                String password = param[2];
                String login_url = "http://" + ip + "/Colx/login.php";
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("roll_number", "UTF-8") + "=" + URLEncoder.encode(roll_number, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result[] = new String[4];
                String line = "";
                int i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    result[i] = line;
                    i++;
                }
                name = result[2];
                lname = result[3];
                id=result[1];
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.i("result",result[0]);
                Log.i("result",result[1]);
                //Log.i("result",result[2]);
                //Log.i("result",result[3]);
                return result[0];
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("signup")){
            try {
                String fname= param[1];
                String lname=param[2];
                String roll_number=param[3];
                String year=param[4];
                String Class=param[5];
                String section=param[6];
                String mobile_number=param[7];
                String email=param[8];
                String password=param[9];
                String signup_url = "http://" + ip + "/Colx/signup.php";
                URL url = new URL(signup_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("fname","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")+"&"
                        +URLEncoder.encode("lname","UTF-8")+"="+URLEncoder.encode(lname,"UTF-8")+"&"
                        +URLEncoder.encode("roll_number","UTF-8")+"="+URLEncoder.encode(roll_number,"UTF-8")+"&"
                        +URLEncoder.encode("year","UTF-8")+"="+URLEncoder.encode(year,"UTF-8")+"&"
                        +URLEncoder.encode("Class","UTF-8")+"="+URLEncoder.encode(Class,"UTF-8")+"&"
                        +URLEncoder.encode("section","UTF-8")+"="+URLEncoder.encode(section,"UTF-8")+"&"
                        +URLEncoder.encode("mobile_number","UTF-8")+"="+URLEncoder.encode(mobile_number,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    result = result + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("sell")){
            try {
                String item_name = param[1];
                String description=param[2];
                String sell_url = "http://" + ip + "/Colx/sell.php";
                URL url = new URL(sell_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("item_name","UTF-8")+"="+URLEncoder.encode(item_name,"UTF-8")+"&"
                        +URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8")+"&"
                        +URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    result = result + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {


            if (result.equals("login success")) {
                alertDialog.setMessage("Welcome " + name);
                alertDialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, Sell.class);
                        context.startActivity(intent);
                    }
                }, 1000);
            } else if (result.equals("login not success")) {
                alertDialog.setMessage(result);
                alertDialog.show();
            } else if (result.equals("registration success")) {
                alertDialog.setMessage(result);
                alertDialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                    }
                }, 1000);
            } else if (result.equals("registration not success")) {
                alertDialog.setMessage(result);
                alertDialog.show();
            } else if (result.equals("successfully added for sale")) {
                alertDialog.setMessage(result);
                alertDialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, signupActivity.class);
                        context.startActivity(intent);
                    }
                }, 1000);
            } else if (result.equals("failed to sell the item")) {
                alertDialog.setMessage(result);
                alertDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }


