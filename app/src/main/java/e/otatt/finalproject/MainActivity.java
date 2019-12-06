package e.otatt.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {
//    public static final String EXTRA_URL = "imageUrl";
//    public static final String EXTRA_CREATOR = "creatorName";
//    public static final String EXTRA_LIKES = "likeCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new HomeFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.menu_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.menu_account:
                    selectedFragment = new AccountFragment();
//                    selectedFragment = new MyYouTubeFragment(); //testing player
                    break;
                case R.id.menu_cart:
                    selectedFragment = new MyCartFragment();
                    break;
                case R.id.menu_products:
                    selectedFragment = new ProductsFragment();

                    break;


            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, selectedFragment).commit();

            return true;
        }
    };


//
//    @Override
//    public void openDetail(String imageUrl, String creatorName, int likeCount) {
//        Intent detailIntent = new Intent(this, DetailActivity.class);
//
//        detailIntent.putExtra(EXTRA_URL, imageUrl);
//        detailIntent.putExtra(EXTRA_CREATOR, creatorName);
//        detailIntent.putExtra(EXTRA_LIKES, likeCount);
//
//        startActivity(detailIntent);
//    }


//    public void startPlayer(){
//        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
//
//        youTubePlayerFragment.initialize("DEVELOPER_KEY", new OnInitializedListener() {
//
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
//
//                if (!wasRestored) {
//                    YPlayer = player;
//                    YPlayer.setFullscreen(true);
//                    YPlayer.loadVideo("2zNSgSzhBfM");
//                    YPlayer.play();
//                }
//
//            }
//
//            @Override
//            public void onInitializationFailure(Provider arg0, YouTubeInitializationResult arg1) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();
//    }

//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//    }
}
