package com.joker.example.utils;

import android.content.Context;

import com.joker.example.R;

import java.lang.reflect.Field;

/**
 * Created by eric on 16-2-23.
 */
public class ResourceUtils {

    public static String[] getArrayResource(Context context,int resourceId){
        return context.getResources().getStringArray(R.array.register_storename);
    }

    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
