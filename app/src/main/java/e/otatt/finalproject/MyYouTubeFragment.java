package e.otatt.finalproject;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class MyYouTubeFragment extends Fragment {
    private static final int RECOVERY_REQUEST = 1;
    private FragmentActivity myContext;
    private View view;
    private YouTubePlayer playerView;
//    private Button btnPlay;
//    YouTubePlayer.OnInitializedListener listener;
    private static final String API_KEY = YoutubeConfig.getApiKey();
    private String videoCode = "cL3QcjPa6ts";



//    public MyYouTubeFragment(String videoCode) {
//        this.videoCode = videoCode;
//    }


        public MyYouTubeFragment() {
        // Required empty public constructor
    }

//    public static MyYouTubeFragment newInstance(){
//        MyYouTubeFragment playerYouTubeFrag = new MyYouTubeFragment();
//
//        playerYouTubeFrag.initialize(API_KEY, this);
//        return playerYouTubeFrag;
//    }
//
@Override
public void onAttach(Activity activity) {

    if (activity instanceof FragmentActivity) {
        myContext = (FragmentActivity) activity;
    }

    super.onAttach(activity);
}

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_youtube_player, container, false);


            YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


            youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    playerView = youTubePlayer;
                    playerView.setFullscreen(true);
                    playerView.loadVideo(getVideoCode());
                    playerView.play();
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    if (youTubeInitializationResult.isUserRecoverableError()) {
                        youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
                    } else {
                        Toast.makeText(getActivity(), "Error Intializing Youtube Player", Toast.LENGTH_LONG).show();
                    }
                }
            });

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();


            return view;
    }

    public String getVideoCode() {
        return videoCode;
    }
}
