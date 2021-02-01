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
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

import static io.realm.Realm.getApplicationContext;

public class MylistFragment extends Fragment {

	Button addButton_myL, saveButton;
	LinearLayout myContent;

	Animation fromsmall ;

	EditText titleTag, yourTag, yourTag2, yourTag3;

	Realm realm;
	ExpandableListView collectionList;
	ArrayList<String> yourTagList;

	Button saveEditButton, removeYesButton, removeNoButton;
	LinearLayout editContent, removeContent;

	EditText editTitle, editTag1, editTag2, editTag3;


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


		myContent = (LinearLayout) root.findViewById(R.id.myContent);

		fromsmall = AnimationUtils.loadAnimation(getContext(), R.anim.fromsmall);
		myContent.setVisibility(View.GONE);

		titleTag = (EditText) root.findViewById(R.id.titleId);
		yourTag = (EditText) root.findViewById(R.id.yourTagId);
		yourTag2 = (EditText) root.findViewById(R.id.yourTagId2);
		yourTag3 = (EditText) root.findViewById(R.id.yourTagId3);

		collectionList = (ExpandableListView) root.findViewById(R.id.expandableListView);

		saveEditButton = (Button) root.findViewById(R.id.buttonEditSave);

		removeYesButton = (Button) root.findViewById(R.id.removeYesButton);
		removeNoButton = (Button) root.findViewById(R.id.removeNoButton);

		editContent = root.findViewById(R.id.editContent);
		editTitle = (EditText) root.findViewById(R.id.editTitle);
		editTag1 = (EditText) root.findViewById(R.id.editTag1);
		editTag2 = (EditText) root.findViewById(R.id.editTag2);
		editTag3 = (EditText) root.findViewById(R.id.editTag3);

		removeContent = (LinearLayout) root.findViewById(R.id.removeContent);


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
				//clear prev text
				titleTag.getText().clear();
				yourTag.getText().clear();
				yourTag2.getText().clear();
				yourTag3.getText().clear();
				//pop-up pops
				editContent.setVisibility(View.GONE);
				myContent.setVisibility(View.VISIBLE);
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

				myContent.setVisibility(View.GONE);

				showCollections();
			}
		});

		saveEditButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("save", "true");

				// get new data
				String title = editTitle.getText().toString();
				ArrayList<String> tagList = new ArrayList<>();
				tagList.add(editTag1.getText().toString());
				tagList.add(editTag2.getText().toString());
				tagList.add(editTag3.getText().toString());

				// edit realm
				RealmResults<TagCollection> query = realm.where(TagCollection.class)
						.equalTo("title", title).findAll();

				realm.beginTransaction();
				if(query.size() != 0) {
					query.get(0).setTitle(title);
					query.get(0).removeTags();
					for (String tag : tagList)
						query.get(0).addTag(tag);
				}
				realm.commitTransaction();

				// finish work
				tagList.clear();
				editContent.setVisibility(View.GONE);
				showCollections();
			}
		});

		removeYesButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// get new data
				String title = editTitle.getText().toString();

				// edit realm
				realm.beginTransaction();
				RealmResults<TagCollection> query = realm.where(TagCollection.class)
						.equalTo("title", title).findAll();
				query.get(0).deleteFromRealm();
				realm.commitTransaction();

				// finish work
				removeContent.setVisibility(View.GONE);
				showCollections();
			}
		});

		removeNoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				removeContent.setVisibility(View.GONE);
			}
		});

		return root;
	}


	public void addToCollections(final String title, final ArrayList<String> tags) {
		RealmResults<TagCollection> query = realm.where(TagCollection.class)
				.equalTo("title", title).findAll();

		if(query.size() == 0) {
			realm.beginTransaction();
			TagCollection newCollection = realm.createObject(TagCollection.class);
			newCollection.setTitle(title);
			for(String newTag : tags)
				newCollection.addTag(newTag);
			realm.commitTransaction();

			Toast.makeText(getApplicationContext(), "Saved Successfully", Toast.LENGTH_LONG).show();
		}
		else
			Toast.makeText(getApplicationContext(), "\"" + title + "\" already exists", Toast.LENGTH_LONG).show();
	}


	public void showCollections() {
		RealmResults<TagCollection> collections = realm.where(TagCollection.class).findAll();

		for(TagCollection col: collections)
			Log.i("col", col.toString());

		if(collections.size() > 0){
			ExpandableCollectionAdapter adapter = new ExpandableCollectionAdapter(collections, realm, getApplicationContext());
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