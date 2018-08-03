package com.fangyi.component_library.func.utils.dbutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.fangyi.component_library.R;
import com.fangyi.component_library.func.utils.SDCardUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by FANGYI on 2016/9/4.
 */

public class DBHelper {

    private final int BUFFER_SIZE = 400000;

    private static final String DB_NAME = "kingdeeBusiness.db";

    //SD卡目录
    public static String DB_PATH = String.valueOf(Environment.getExternalStorageDirectory());


    private SQLiteDatabase database;
    private Context context;

    public DBHelper(Context context) {

        this.context = context;
    }

    public SQLiteDatabase openDatabase() {

        List<String> paths = SDCardUtils.getSDCardPaths();

        if (paths.size() > 1) {
            DB_PATH = paths.get(1);
        }

        this.database = this.openDatabase(DB_PATH + File.separator + DB_NAME);
        return database;
    }

    private SQLiteDatabase openDatabase(String dbfile) {
        try {
            if (!(new File(dbfile).exists())) {
                InputStream is = this.context.getResources().openRawResource(
                        R.raw.kingdee); //欲导入的数据库
                FileOutputStream fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,
                    null);
            return db;
        } catch (FileNotFoundException e) {
            Log.e("Database", "=================File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Database", "=================IO exception");
            e.printStackTrace();
        }
        return null;
    }

    public void closeDatabase() {
        this.database.close();
    }
}
