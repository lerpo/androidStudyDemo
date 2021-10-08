package com.example.androiddemo.datastore;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStoreUtil {

    public static void saveFile(Context context, String fileName, String data) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        public static String readFile(Context context, String fileName){
            FileInputStream in = null;
            BufferedReader reader = null;
            StringBuilder builder = new StringBuilder();
            try{
                in = context.openFileInput(fileName);
                reader = new BufferedReader(new InputStreamReader(in));
                String line= "";
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if(reader != null){
                    try{
                        reader.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
            return builder.toString();
        }
}
