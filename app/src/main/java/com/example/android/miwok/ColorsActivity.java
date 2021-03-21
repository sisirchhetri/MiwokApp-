package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.word_list);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ColorsFragment())
                .commit();

    }
}
//   /* * Handles playback of all the sound files*/
//    private MediaPlayer mMediaPlayer;
//
//
//    /**
//     * This Listener gets triggered when the click {@link MediaPlayer} has completed
//     * playing the audio file.
//     */
//    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };
////Create a list of Word object
//        ArrayList<Word> words = new ArrayList<>();
//
//        words.add( new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
//        words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
//        words.add(new Word("brown","ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
//        words.add(new Word("gray","ṭopoppi", R.drawable.color_gray,R.raw.color_gray));
//        words.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
//        words.add(new Word("white","kelelli", R.drawable.color_white, R.raw.color_white));
//        words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
//        words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,
//                R.raw.color_mustard_yellow));
//
//
//
//        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
//        // adapter knows how to create layouts for each item in the list, using the
//        // simple_list_item_1.xml layout resource defined in the Android framework.
//        // This list item layout contains a single {@link TextView}, which the adapter will set to
//        // display a single word.
//        //     ArrayAdapter<String> itemsAdapter =
//        //           new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
////        ArrayAdapter<Word> itemsAdapter =
////                new ArrayAdapter<>(this, R.layout.list_item, words);
//
//        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_colors);
//
//        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
//        // There should be a {@link ListView} with the view ID called list, which is declared in the
//        // activity_numbers.xml layout file.
//        ListView listView = (ListView) findViewById(R.id.list);
//
//        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
//        // {@link ListView} will display list items for each word in the list of words.
//        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
//        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
//        listView.setAdapter(wordAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                //Get the {@link Word} object at the given position the user clicked on
//                Word word = words.get(position);
//
//                //Release the media player if it currently exits because we are about to play a different sound.
//                releaseMediaPlayer();
//
//                        mMediaPlayer = MediaPlayer.create(ColorsActivity.this,word.getmAudioResourceId());
//
//
//
//                //start the audio file
//                mMediaPlayer.start();
//
//                //Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing.
//                mMediaPlayer.setOnCompletionListener(mCompletionListener);
//
////                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
////                    @Override
////                    public void onCompletion(MediaPlayer mp) {
////                        releaseMediaPlayer();
////                    }
////                });
//
////                Toast.makeText(NumbersActivity.this,"List item clicked", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        //When the activity is stopped, release the media player resources beacuse we
//        //wont be playing any more sounds.
//        releaseMediaPlayer();
//    }
//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mMediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mMediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mMediaPlayer = null;
//        }
//    }
//
//}