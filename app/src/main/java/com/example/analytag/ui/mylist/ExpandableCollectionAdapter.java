package com.example.analytag.ui.mylist;

import android.content.Context;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.analytag.R;
import com.example.analytag.TagCollection;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ExpandableCollectionAdapter extends BaseExpandableListAdapter {
	List<TagCollection> list;
	Realm realm;
	Context context;
	View root;

	public ExpandableCollectionAdapter(List<TagCollection> list, Realm realm, Context context) {
		this.list = list;
		this.realm = realm;
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
		//show collection
		TextView titleTextView = (TextView) view
				.findViewById(R.id.titleFirstId);
		titleTextView.setTypeface(null, Typeface.BOLD);
		titleTextView.setText(title);

		//edit collection
		Button editButton = (Button) view.findViewById(R.id.editButton_myList);
		root = (View) viewGroup.getParent();
		final int j = i;

		editButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RealmResults<TagCollection> query = realm.where(TagCollection.class)
						.equalTo("title", (String) getGroup(j)).findAll();
				TagCollection col = query.get(0);

				((EditText) root.findViewById(R.id.editTitle)).setText(col.getTitle());
				((EditText) root.findViewById(R.id.editTag1)).setText(col.getTag(0));
				((EditText) root.findViewById(R.id.editTag2)).setText(col.getTag(1));
				((EditText) root.findViewById(R.id.editTag3)).setText(col.getTag(2));

				LinearLayout myContent = (LinearLayout) root.findViewById(R.id.myContent);
				myContent.setVisibility(View.GONE);
				LinearLayout editContent = (LinearLayout) root.findViewById(R.id.editContent);
				editContent.setVisibility(View.VISIBLE);

				Animation fromsmall = AnimationUtils.loadAnimation(context, R.anim.fromsmall);
				editContent.startAnimation(fromsmall);
			}
		});

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
