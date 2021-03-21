 package com.example.android.miwok;

 import android.content.Context;
 import android.media.AudioManager;
 import android.media.MediaPlayer;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ListView;

 import androidx.appcompat.app.AppCompatActivity;

 import java.util.ArrayList;

 public class NumbersActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_category);
         getSupportFragmentManager().beginTransaction()
                 .replace(R.id.container, new NumbersFragment())
                 .commit();
     }

 }

//     private MediaPlayer mMediaPlayer;
//     /**Handles audio focus when playing a sound file */
//     private AudioManager mAudioManager;
//
//
//     AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
//             new AudioManager.OnAudioFocusChangeListener() {
//                 public void onAudioFocusChange(int focusChange) {
//                     if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                         // Permanent loss of audio focus
//                         // Pause playback immediately
//                         releaseMediaPlayer();
//                     }
//                     else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
//                             || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                         // Pause playback
//                         // Lower the volume, keep playing
//                         mMediaPlayer.pause();
//                         mMediaPlayer.seekTo(0);
//                     }  else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                         // Your app has been granted audio focus again
//                         // Raise volume to normal, restart playback if necessary
//                         mMediaPlayer.start();
//                     }
//
//                 }
//             };
//
//     /**
//      * This Listener gets triggered when the click {@link MediaPlayer} has completed
//      * playing the audio file.
//      */
//     private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
//         @Override
//         public void onCompletion(MediaPlayer mp) {
//             releaseMediaPlayer();
//         }
//     };
//
//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         //setContentView(R.layout.word_list);
//         setContentView(R.layout.activity_category);
//         getSupportFragmentManager().beginTransaction().replace(R.id.container,new NumbersFragment()).commit();
//
//         //Create and setup the {@link AudioManager} to request audio focus. (initialize) AD Manager
//         mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//
//         //Create a list of Word object
//         final   ArrayList<Word> words = new ArrayList<>();
//
//         words.add( new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
//         words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
//         words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
//         words.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
//         words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
//         words.add(new Word("six","temmokka",R.drawable.number_six, R.raw.number_six));
//         words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
//         words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
//         words.add(new Word("nine","wo’e",R.drawable.number_nine,R.raw.number_nine));
//         words.add(new Word("ten","na’aacha",R.drawable.number_ten, R.raw.number_ten));
//
//         // Verify the contents of the list by printing out each element to the logs
//      /*  Log.v("NumbersActivity", "Word at index 0: " + words.get(0));
//        Log.v("NumbersActivity", "Word at index 1: " + words.get(1));
//        Log.v("NumbersActivity", "Word at index 2: " + words.get(2));
//        Log.v("NumbersActivity", "Word at index 3: " + words.get(3));
//        Log.v("NumbersActivity", "Word at index 4: " + words.get(4));
//        Log.v("NumbersActivity", "Word at index 5: " + words.get(5));
//        Log.v("NumbersActivity", "Word at index 6: " + words.get(6));
//        Log.v("NumbersActivity", "Word at index 7: " + words.get(7));
//        Log.v("NumbersActivity", "Word at index 8: " + words.get(8));
//        Log.v("NumbersActivity", "Word at index 9: " + words.get(9));
//
//       */
//         //Find the root view of the whole layout
//       /* LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//
//        int index = 0;
//
//        while (index < words.size() ){
//            //Create a new TextView that displayed the word at the
//            //particular index & add the View as a child to the rootView.
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//
//            index++;
//        }
//
//        */
//
//         // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
//         // adapter knows how to create layouts for each item in the list, using the
//         // simple_list_item_1.xml layout resource defined in the Android framework.
//         // This list item layout contains a single {@link TextView}, which the adapter will set to
//         // display a single word.
//         //     ArrayAdapter<String> itemsAdapter =
//         //           new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
////        ArrayAdapter<Word> itemsAdapter =
////                new ArrayAdapter<>(this, R.layout.list_item, words);
//
//         WordAdapter wordAdapter = new WordAdapter(this, words,R.color.category_numbers);
//
//         // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
//         // There should be a {@link ListView} with the view ID called list, which is declared in the
//         // activity_numbers.xml layout file.
//         ListView listView = (ListView) findViewById(R.id.list);
//
//         // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
//         // {@link ListView} will display list items for each word in the list of words.
//         // Do this by calling the setAdapter method on the {@link ListView} object and pass in
//         // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
//         listView.setAdapter(wordAdapter);
//
//         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//             @Override
//             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                 Word word = words.get(position);
//                 //Release the media player if it currently exits because we are about to play a different sound.
//
//                 // Request audio focus for playback
//                 int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
//                         // Use the music stream.
//                         AudioManager.STREAM_MUSIC,
//                         // Request permanent focus.
//                         AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//
//                 if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                     // We have audio focus now
//
//
//                     releaseMediaPlayer();
//                     mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
//
//                     mMediaPlayer.start();
//
//                     //Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing.
//                     mMediaPlayer.setOnCompletionListener(mCompletionListener);
//
//                     //                Toast.makeText(NumbersActivity.this,"List item clicked", Toast.LENGTH_SHORT).show();
//
//                 }
//             }
//         });
//     }
//
//     @Override
//     protected void onStop() {
//         super.onStop();
//         //When the activity is stopped, release the media player resources beacuse we
//         //wont be playing any more sounds.
//         releaseMediaPlayer();
//     }
//
//     /**
//      * Clean up the media player by releasing its resources.
//      */
//     private void releaseMediaPlayer() {
//         // If the media player is not null, then it may be currently playing a sound.
//         if (mMediaPlayer != null) {
//             // Regardless of the current state of the media player, release its resources
//             // because we no longer need it.
//             mMediaPlayer.release();
//
//             // Set the media player back to null. For our code, we've decided that
//             // setting the media player to null is an easy way to tell that the media player
//             // is not configured to play an audio file at the moment.
//             mMediaPlayer = null;
//
//             // Abandon audio focus when playback complete
//             mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
//         }
//     }
// }