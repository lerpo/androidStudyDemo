package com.example.androiddemo.datastore;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;

public class MycontentProvider extends ContentProvider {
    private static final String MAUTHORITIESNAME = "com.example.androiddemo.MycontentProvider";
    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int USER = 1;
    // 构建URI
    static {
        matcher.addURI(MAUTHORITIESNAME, "user", USER);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // 过滤URI
        int match = matcher.match(uri);
        switch (match) {
            case USER:
               return DataBaseUtil.getInstance(MycontentProvider.this.getContext()).queryReturnCursor();
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // 过滤URI
        int match = matcher.match(uri);
        switch (match) {
            case USER:
                DataBaseUtil.getInstance(MycontentProvider.this.getContext()).add(values.getAsString("name"),values.getAsInteger("name"),values.getAsString("sex"));
            default:
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int match = matcher.match(uri);
        switch (match) {
            case USER:
                DataBaseUtil.getInstance(MycontentProvider.this.getContext()).update(values.getAsString("name"),values.getAsString("updatedName"));
            default:
                break;
        }
        return 0;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }
}
