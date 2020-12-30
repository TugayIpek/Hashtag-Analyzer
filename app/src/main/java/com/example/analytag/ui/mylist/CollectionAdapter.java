package com.example.analytag.ui.mylist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.analytag.R;
import com.example.analytag.TagCollection;

import java.util.List;

import static io.realm.Realm.getApplicationContext;

public class CollectionAdapter extends BaseAdapter {
	List<TagCollection> list;
	Context context;
	ListView tagList;

	public CollectionAdapter(List<TagCollection> list, Context context){
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
		view = LayoutInflater.from(context).inflate(R.layout.collection_view, viewGroup, false);

		TextView title = (TextView) view.findViewById(R.id.titleFirstId);

		/*
		TextView tag1 = (TextView) view.findViewById(R.id.tagFirstId);
		TextView tag2 = (TextView) view.findViewById(R.id.tagSecondId);
		TextView tag3 = (TextView) view.findViewById(R.id.tagThirdId);
		 */

		title.setText(list.get(i).getTitle());
		/*
		tag1.setText(list.get(i).getTag(0));
		tag2.setText(list.get(i).getTag(1));
		tag3.setText(list.get(i).getTag(2));
		 */

		if(list.size() > 0){
			Adapter adapter = new TagAdapter(list.get(i).getTags(), getApplicationContext());

			//Log.i("tags", list.get(i).toString());

			//tagList = (ListView) view.findViewById(R.id.tagsId);
			//tagList.setAdapter((ListAdapter) adapter);
		}



		return view;
	}
}
