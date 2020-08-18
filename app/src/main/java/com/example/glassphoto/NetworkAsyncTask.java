package com.example.glassphoto;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;

public class NetworkAsyncTask extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... strings) {

        FTPClient con = null;

        @Override
        protected Void doInBackground(String... path) {
            con = new FTPClient();
            try {
                con.connect("45.32.136.116", 22);

                if (con.login("root", "Hanmi1357")) {
                    con.enterLocalPassiveMode();
                    con.setFileType(FTP.BINARY_FILE_TYPE);

                    String data = "/storage/emulated/0/Pictures/1594684274645.jpg";

                    FileInputStream in = new FileInputStream(data);
                    boolean result = con.storeFile("root/docs/media", in);
                    in.close();
                    if (result) Log.v("Upload result", "suceeded");
                    con.logout();
                    con.disconnect();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);

    }
    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
    }

}
    /**
     * FTP File Connector
     */

    public void FTPupload(String path) {
        try {
            AsyncTask<String, Void, Void> asyncTask = new AsyncTask<String, Void, Void>() {

                }
            };
        }
        catch (Exception e) {
            // No error
        }
    }