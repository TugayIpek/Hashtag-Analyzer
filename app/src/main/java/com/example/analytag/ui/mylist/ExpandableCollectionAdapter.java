package com.example.analytag.ui.mylist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.analytag.R;
import com.example.analytag.TagCollection;

import java.util.List;

public class ExpandableCollectionAdapter extends BaseExpandableListAdapter {
	List<TagCollection> list;
	Context context;

	public ExpandableCollectionAdapter(List<TagCollection> list, Context context) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getGroupCount() {
		return list.size();
	}

	@Override
	public int getChildrenCount(int i) {
		return list.get(i).getTagCount();
	}

	@Override
	public Object getGroup(int i) {
		return list.get(i).getTitle();
	}

	@Override
	public Object getChild(int i, int i1) {
		return list.get(i).getTag(i1);
	}

	@Override
	public long getGroupId(int i) {
		return i;
	}

	@Override
	public long getChildId(int i, int i1) {
		return i1;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
		String title = (String) getGroup(i);
		if (view == null) {
			LayoutInflater layoutInflater = (LayoutInflater) this.context.
					getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.collection_view, null);
		}
		TextView titleTextView = (TextView) view
				.findViewById(R.id.titleFirstId);
		titleTextView.setTypeface(null, Typeface.BOLD);
		titleTextView.setText(title);
		return view;
	}

	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		String tag = (String) getChild(i,i1);

		if (view == null) {
			LayoutInflater layoutInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.mylist_tag_view, null);
		}
		TextView expandedListTextView = (TextView) view
				.findViewById(R.id.myListTagId);
		expandedListTextView.setText("#"+tag);
		return view;
	}

	@Override
	public boolean isChildSelectable(int i, int i1) {
		return true;
	}
}
