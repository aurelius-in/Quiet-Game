import android.media.MediaRecorder;
import android.os.Handler;

import java.io.IOException;

public class SoundUtils {

    private static final int SAMPLE_RATE = 44100;
    private static final int MAX_AMPLITUDE_THRESHOLD = 10000;

    private MediaRecorder mRecorder;
    private Handler mHandler;
    private Runnable mUpdateSoundLevelRunnable;

    public SoundUtils() {
        mHandler = new Handler();
    }

    public void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setOutputFile("/dev/null");
        try {
            mRecorder.prepare();
            mRecorder.start();
            startUpdatingSoundLevel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        if (mRecorder != null) {
            stopUpdatingSoundLevel();
            mRecorder.stop();
            mRecorder.reset();
            mRecorder.release();
            mRecorder = null;
        }
    }

    private void startUpdatingSoundLevel() {
        mUpdateSoundLevelRunnable = new Runnable() {
            @Override
            public void run() {
                if (mRecorder != null) {
                    int amplitude = mRecorder.getMaxAmplitude();
                    if (amplitude > MAX_AMPLITUDE_THRESHOLD) {
                        // Sound detected
                        onSoundDetected();
                    }
                }
                mHandler.postDelayed(this, 100); // Update sound level every 100ms
            }
        };
        mHandler.postDelayed(mUpdateSoundLevelRunnable, 100);
    }

    private void stopUpdatingSoundLevel() {
        mHandler.removeCallbacks(mUpdateSoundLevelRunnable);
    }

    // Interface for detecting sound levels
    public interface SoundLevelListener {
        void onSoundDetected();
    }

    private SoundLevelListener mListener;

    public void setSoundLevelListener(SoundLevelListener listener) {
        mListener = listener;
    }

    private void onSoundDetected() {
        if (mListener != null) {
            mListener.onSoundDetected();
        }
    }
}
