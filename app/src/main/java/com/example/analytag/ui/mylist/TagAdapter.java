package com.example.analytag.ui.mylist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.analytag.R;

import io.realm.RealmList;

public class TagAdapter extends BaseAdapter {
	RealmList<String> list;
	Context context;

	public TagAdapter(RealmList<String> list, Context context){
		this.list = list;
		this.context = context;
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
		view = LayoutInflater.from(context).inflate(R.layout.mylist_tag_view, viewGroup, false);

		for(String t : list)
			Log.i("tags", list.get(i));

		TextView tag = (TextView) view.findViewById(R.id.myListTagId);
		tag.setText(list.get(i));

		return view;
	}
}
