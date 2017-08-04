package com.pupukkaltim.pkthighlight.subuser.lain.komoditas;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.pupukkaltim.pkthighlight.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Komoditas extends AppCompatActivity implements View.OnClickListener {
    private PDFView pdfViewa;
    private ProgressDialog pDialoga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showuser);
        pdfViewa = (PDFView) findViewById(R.id.pdfView);
        Button btn = (Button) findViewById(R.id.refresh);
        btn.setOnClickListener(this);
        pdfViewa.fromFile(new File(Environment.getExternalStorageDirectory().toString()+"/Download/PKT/Lain/Komoditas/Harga Komoditas.pdf")).load();
    }

    @Override
    public void onClick(View v) {
        new DownloadFileFromURL().execute("https://firebasestorage.googleapis.com/v0/b/ptpupukkaltim-29298.appspot.com/o/amoniak%2Famoniak.pdf?alt=media&token=a659dbe8-03d7-4dbe-8b11-a46d8dfc8ea9");
    }

    class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("Starting download");
            pDialoga = new ProgressDialog(Komoditas.this);
            pDialoga.setMessage("Please wait...");
            pDialoga.setIndeterminate(false);
            pDialoga.setCancelable(false);
            pDialoga.show();
        }
        /**
         * Downloading file in background thread
         * */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                String root = Environment.getExternalStorageDirectory().toString();

                System.out.println("Downloading");
                URL url = new URL(f_url[0]);

                URLConnection conection = url.openConnection();
                conection.connect();
                // getting file length
                int lenghtOfFile = conection.getContentLength();

                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream to write file

                OutputStream output = new FileOutputStream(root+"/Download/PKT/Lain/Komoditas/Harga Komoditas.pdf");
                byte data[] = new byte[1024];

                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    // writing data to file
                    output.write(data, 0, count);
                }
                // flushing output
                output.flush();
                // closing streams
                output.close();
                input.close();
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }

        /**
         * After completing background task
         * **/
        @Override
        protected void onPostExecute(String file_url) {
            System.out.println("Downloaded");
            pdfViewa.fromFile(new File(Environment.getExternalStorageDirectory().toString()+"/Download/PKT/Lain/Komoditas/Harga Komoditas.pdf")).load();
            pDialoga.dismiss();
        }
    }
}
