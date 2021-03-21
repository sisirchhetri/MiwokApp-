package com.example.android.miwok;

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
 * Use the {@link PhrasesFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    /**
     * This Listener gets triggered when the click {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private final MediaPlayer.OnCompletionListener mCompletionListener = mp -> releaseMediaPlayer();


    public PhrasesFragment() {
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



        //Create a list of Word object
        ArrayList<Word> words = new ArrayList<>();

        words.add( new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","kenekaku", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem", R.raw.phrase_come_here));


        WordAdapter wordAdapter = new WordAdapter(getActivity(), words,R.color.category_phrases );

        ListView listView = (ListView) rootView.findViewById(R.id.list);

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
       // return inflater.inflate(R.layout.fragment_phrases, container, false);
    return rootView;
    }



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