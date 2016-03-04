package com.lujianzhi.photoalbum.utils;

import android.util.SparseArray;
import android.view.View;

/**
 * 网上看到的ViewHolder，
 * 以后使用Adapter可以不用每次都单独写ViewHolder
 *
 * Created by lujianzhi on 2016/1/21.
 */
public class ViewHolder {

    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

}
