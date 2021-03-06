package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FamilyFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class FamilyFragment extends Fragment {

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //Create and setup the {@link AudioManager} to request audio focus. (initialize) AD Manager
        /**
         * getSystemService(String)??? because the Fragment does not have access to system services, whereas the Activity does (see link). mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
         *
         * Fix the error by getting the Activity object instance first. This is the Activity that encloses the current Fragment, which will be the NumbersActivity for the NumbersFragment. Then call getSystemService(String) on that Activity object
         */
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Create a list of Word object
        final   ArrayList<Word> words = new ArrayList<>();

        words.add( new Word("father","??p??",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("mother","?????a",R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son","angsi",R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter","tune",R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother","taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","te???e",R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother","ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather","paapa",R.drawable.family_grandfather, R.raw.family_grandfather));


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        //     ArrayAdapter<String> itemsAdapter =
        //           new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
//        ArrayAdapter<Word> itemsAdapter =
//                new ArrayAdapter<>(this, R.layout.list_item, words);

        WordAdapter wordAdapter = new WordAdapter(getActivity(), words,R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = words.get(position);

                //Release the media player if it currently exits because we are about to play a different sound.
                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(getActivity(),word.getmAudioResourceId());

                mMediaPlayer.start();

                //Setup a listener on the media player, so that we can stop and release the media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);

//                Toast.makeText(NumbersActivity.this,"List item clicked", Toast.LENGTH_SHORT).show();

            }
        });
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_family, container, false);

        return rootView ;
    }
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        //When the activity is stopped, release the media player resources beacuse we
        //wont be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}