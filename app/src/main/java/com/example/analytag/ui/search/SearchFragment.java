package com.example.analytag.ui.search;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.analytag.R;
import com.example.analytag.ui.APIServiceAnalyze;
import com.example.analytag.ui.Analyze;
import java.util.ArrayList;
import java.util.List;
import static androidx.core.content.ContextCompat.getSystemService;
public class SearchFragment extends Fragment {

	EditText myEditText;
	Button analyze_button;
	String tag;
	APIServiceAnalyze analyze = new APIServiceAnalyze();
	RotateAnimation ra = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
	private List hashtagData;
	public View onCreateView(@NonNull LayoutInflater inflater,
	                         ViewGroup container, Bundle savedInstanceState) {

		View root = inflater.inflate(R.layout.fragment_search, container, false);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		myEditText = (EditText) root.findViewById(R.id.myEditText);
		analyze_button = (Button) root.findViewById(R.id.analyze_button);
		ra.setDuration(500);
		click();
		return root;
	}

	private void click(){
		analyze_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				analyze_button.startAnimation(ra); // animation start
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						tag = myEditText.getText().toString();
						ArrayList<String> datas = null;
						datas =analyze.APIAnalyze(tag);
						Intent intent = new Intent(getActivity().getApplicationContext(), Analyze.class);
						intent.putExtra("tag", tag);
						intent.putExtra("datas", datas);
						startActivity(intent);
					}
				}, 1000);
			}
		});
	}

	public List searchHashtag(String hashtag){

		return  null;
	}

	public List analyzerHashtag(List hashtagData){

		return null;
	}

	public List relatedHashtag(String hashtag){

		return null;
	}


	public List getHashtagData() {
		return hashtagData;
	}
}