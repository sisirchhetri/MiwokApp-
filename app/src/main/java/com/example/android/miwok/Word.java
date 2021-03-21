package com.example.android.miwok;
/**
 *{@link Word} represents a vocabulary word that the user wants
 * to learn.
 * It contains a def. translation and a Miwork translatiion for
 * that word.
 */
public class Word {
    //Default translation for the word
    private  String mDefaultTranslation;

    /**Miwok translation for the word**/
    private String mMiwokTranslation;

    //Resource Id of image for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

   /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED =-1;

    /** Audio resource ID for the word */
    private  int mAudioResourceId;

    /**
     * Create a new Word object
     *
     * @param mDefaultTranslation is the word in a language that the user is already familiar
     *                            with(such as English)
     * @param mMiwokTranslation  is th word in the Miwork language
     *
     * @param mAudioResourceId is the resource ID for the audio file associated with this word
     *
     */
    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     *
     * @param mDefaultTranslation
     * @param mMiwokTranslation
     *
     * @param mImageResourceId is the drawable resource ID fo the image
     *                         associated with the word.
     *
     * @param mAudioResourceId is the resource ID for the audio file associated with this word.
     */
    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     *Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     *  Get the miwok translation of the word
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() { return mImageResourceId; }

    /**
     *Returns whether or not there is an image for this word.
     *
     **/

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

/** Returns the audio resource ID of the word.
 * @return
 */
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
