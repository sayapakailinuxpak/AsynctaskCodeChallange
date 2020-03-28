package com.eldisprojectcodelabs.asynctaskcodechallange;

import android.os.AsyncTask;
import android.service.autofill.TextValueSanitizer;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class UploadBackground extends AsyncTask<Void, Integer, String> {
    int progressPercentCompleted = 100;
    private WeakReference<TextView> textViewWeakReference;


    UploadBackground(TextView textView){
        textViewWeakReference = new WeakReference<>(textView);
    }


    @Override
    protected String doInBackground(Void... voids) {
        int i;
        for (i = 0; i <= progressPercentCompleted; i+=1){
            try{
                Thread.sleep(i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(i);
        }

        return "Done";

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textViewWeakReference.get().setText("Completed in " + values[0] + " %");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textViewWeakReference.get().setText(s);
    }


}
