package com.example.analytag.ui.preset_hashtag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.analytag.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    Context context;
    List<String> list;

    public CategoryAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.tag_view, viewGroup, false);
        TextView tv_text = view.findViewById(R.id.tv_text);
        tv_text.setText("#"+list.get(i));
        return view;
    }
}
