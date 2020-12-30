package com.example.analytag.ui.mylist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;
import com.example.analytag.TagCollection;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static io.realm.Realm.getApplicationContext;

public class MylistFragment extends Fragment {

	Button addButton_myL, saveButton, editButton;
	LinearLayout myContent;

	Animation fromsmall ;

	EditText titleTag, yourTag, yourTag2, yourTag3;

	TextView titleTextView, tagTextView, tagTextView2, tagTextView3, tagFirst, tagSecond, tagThird;

	Realm realm;
	ExpandableListView collectionList;
	ArrayList<String> yourTagList = new ArrayList();

	public MylistFragment() {
		this.yourTagList = new ArrayList<>();
		System.out.println(yourTagList);
	}

	private MylistViewModel mylistViewModel;


	public View onCreateView(@NonNull LayoutInflater inflater,
	                         ViewGroup container, Bundle savedInstanceState) {
		mylistViewModel = ViewModelProviders.of(this).get(MylistViewModel.class);
		View root = inflater.inflate(R.layout.fragment_mylist, container, false);

		realm = Realm.getDefaultInstance();

		//addButton_myL = (Button) root.findViewById(R.id.addButton1_myList);

		addButton_myL = (Button) root.findViewById(R.id.addButton1_myList);
		saveButton = (Button) root.findViewById(R.id.buttonSave);
		editButton = (Button) root.findViewById(R.id.editButton_myList);

		myContent = (LinearLayout) root.findViewById(R.id.myContent);

		fromsmall = AnimationUtils.loadAnimation(getContext(), R.anim.fromsmall);
		myContent.setAlpha(0);

		titleTag = (EditText) root.findViewById(R.id.titleId);
		yourTag = (EditText) root.findViewById(R.id.yourTagId);
		yourTag2 = (EditText) root.findViewById(R.id.yourTagId2);
		yourTag3 = (EditText) root.findViewById(R.id.yourTagId3);

		collectionList = (ExpandableListView) root.findViewById(R.id.expandableListView);

		/* Clear all data from realm
		RealmResults<TagCollection> collections = realm.where(TagCollection.class).findAll();
		realm.beginTransaction();
		collections.deleteAllFromRealm();
		realm.commitTransaction();
		*/

		showCollections();

		addButton_myL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				myContent.setAlpha(1);
				myContent.startAnimation(fromsmall);
			}
		});


		saveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				yourTagList.add(yourTag.getText().toString());
				yourTagList.add(yourTag2.getText().toString());
				yourTagList.add(yourTag3.getText().toString());

				addToCollections(titleTag.getText().toString(), yourTagList);

				yourTagList.clear();

				myContent.setAlpha(0);

				showCollections();
			}
		});

		return root;
	}


	public void addToCollections(final String title, final ArrayList<String> tags) {
		realm.beginTransaction();
		TagCollection newCollection = realm.createObject(TagCollection.class);

		newCollection.setTitle(title);
		for(String newTag : tags)
			newCollection.addTag(newTag);

		realm.commitTransaction();
		Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_LONG).show();
	}


	public void showCollections() {
		RealmResults<TagCollection> collections = realm.where(TagCollection.class).findAll();

		for(TagCollection col: collections)
			Log.i("col", col.toString());

		if(collections.size() > 0){
			ExpandableCollectionAdapter adapter = new ExpandableCollectionAdapter(collections, getApplicationContext());
			collectionList.setAdapter(adapter);
		}
	}

	public List hashtagHistory(String hashtag) {
		return null;
	}

	public List hashtagFavorite(String hashtag) {
		return null;
	}

}