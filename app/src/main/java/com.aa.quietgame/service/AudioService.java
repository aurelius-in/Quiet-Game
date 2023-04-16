public class AudioService {

    private MediaRecorder mediaRecorder;
    private AudioListener audioListener;

    public interface AudioListener {
        void onSoundDetected();
    }

    public void setAudioListener(AudioListener audioListener) {
        this.audioListener = audioListener;
    }

    public void startRecording() {
        if (mediaRecorder == null) {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.setOutputFile("/dev/null");
            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaRecorder.start();
        }
    }

    public void stopRecording() {
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            mediaRecorder.reset();
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }

    public void detectSound() {
        if (audioListener != null) {
            if (mediaRecorder != null) {
                double amplitude = mediaRecorder.getMaxAmplitude();
                if (amplitude > 0) {
                    audioListener.onSoundDetected();
                }
            }
        }
    }
}
