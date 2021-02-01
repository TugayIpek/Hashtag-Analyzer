package com.example.analytag.ui.mylist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.analytag.MainActivity;
import com.example.analytag.R;
import com.example.analytag.TagCollection;
import com.example.analytag.ui.APIServiceAnalyze;
import com.example.analytag.ui.Analyze;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static io.realm.Realm.getApplicationContext;

public class ExpandableCollectionAdapter extends BaseExpandableListAdapter {
	List<TagCollection> list;
	Realm realm;
	Context context;
	View root;

	APIServiceAnalyze analyze = new APIServiceAnalyze();

	public ExpandableCollectionAdapter(List<TagCollection> list, Realm realm, Context context) {
		this.list = list;
		this.realm = realm;
		this.context = context;

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
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

		final int j = i;

		//edit collection
		Button editButton = (Button) view.findViewById(R.id.editButton_myList);
		root = (View) viewGroup.getParent();

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
				LinearLayout popup = (LinearLayout) root.findViewById(R.id.removeContent);
				popup.setVisibility(View.GONE);
				LinearLayout editContent = (LinearLayout) root.findViewById(R.id.editContent);
				editContent.setVisibility(View.VISIBLE);

				Animation fromsmall = AnimationUtils.loadAnimation(context, R.anim.fromsmall);
				editContent.startAnimation(fromsmall);
			}
		});

		//remove collections
		Button removeButton = (Button) view.findViewById(R.id.removeButton_myList);
		root = (View) viewGroup.getParent();

		removeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((EditText) root.findViewById(R.id.editTitle)).setText((String) getGroup(j));

				LinearLayout myContent = (LinearLayout) root.findViewById(R.id.myContent);
				myContent.setVisibility(View.GONE);
				LinearLayout editContent = (LinearLayout) root.findViewById(R.id.editContent);
				editContent.setVisibility(View.GONE);
				LinearLayout popup = (LinearLayout) root.findViewById(R.id.removeContent);
				popup.setVisibility(View.VISIBLE);

				Animation fromsmall = AnimationUtils.loadAnimation(context, R.anim.fromsmall);
				popup.startAnimation(fromsmall);
			}
		});

		return view;
	}

	@Override
	public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		final String tag = (String) getChild(i,i1);

		if (view == null) {
			LayoutInflater layoutInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.mylist_tag_view, null);
		}
		//show tag
		TextView expandedListTextView = (TextView) view
				.findViewById(R.id.myListTagId);
		expandedListTextView.setText("#"+tag);

		//analyze tag

		TextView tagClick = (TextView) view.findViewById(R.id.myListTagId);

		tagClick.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Tag Click " + tag, Toast.LENGTH_LONG).show();
/*
				ArrayList<String> datas = null;
				datas =analyze.APIAnalyze(tag);

				Intent intent = new Intent(context, Analyze.class);
				intent.putExtra("tag", tag);
				intent.putExtra("datas", datas);
				context.startActivity(intent);
				
 */
			}
		});


		return view;
	}


	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		final String tag = (String) getChild(groupPosition,childPosition);
		Toast.makeText(getApplicationContext(), "Tag Click " + tag, Toast.LENGTH_LONG).show();

		ArrayList<String> datas = null;
		datas =analyze.APIAnalyze(tag);

		Intent intent = new Intent(context, Analyze.class);
		intent.putExtra("tag", tag);
		intent.putExtra("datas", datas);
		context.startActivity(intent);

		return false;
	}

	@Override
	public boolean isChildSelectable(int i, int i1) {
		return true;
	}
}
