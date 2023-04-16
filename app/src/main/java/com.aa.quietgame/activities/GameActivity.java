import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    private ArrayList<ProfileModel> playersList;
    private int currentRound = 0;
    private int currentRoundTime;
    private Handler handler;
    private Runnable countdownRunnable;

    private TextView textViewRound;
    private TextView textViewTimer;
    private TextView textViewCurrentPlayer;
    private Button buttonStart;
    private Button buttonFinish;
    private ImageView imageViewAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playersList = getIntent().getParcelableArrayListExtra("playersList");
        Collections.shuffle(playersList);

        textViewRound = findViewById(R.id.text_view_round);
        textViewTimer = findViewById(R.id.text_view_timer);
        textViewCurrentPlayer = findViewById(R.id.text_view_current_player);
        buttonStart = findViewById(R.id.button_start);
        buttonFinish = findViewById(R.id.button_finish);
        imageViewAvatar = findViewById(R.id.image_view_avatar);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRound();
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endGame();
            }
        });
    }

    private void startRound() {
        currentRound++;
        currentRoundTime = 0;

        textViewRound.setText(getString(R.string.round_number, currentRound));
        textViewCurrentPlayer.setText(playersList.get(0).getName());
        imageViewAvatar.setImageResource(playersList.get(0).getAvatar());

        handler = new Handler();
        countdownRunnable = new Runnable() {
            @Override
            public void run() {
                currentRoundTime++;
                textViewTimer.setText(getString(R.string.time_remaining, Constants.GAME_ROUND_DURATION - currentRoundTime));
                if (currentRoundTime == Constants.GAME_ROUND_DURATION) {
                    nextPlayer();
                } else {
                    handler.postDelayed(this, 1000);
                }
            }
        };

        handler.postDelayed(countdownRunnable, 1000);
    }

    private void nextPlayer() {
        handler.removeCallbacks(countdownRunnable);
        playersList.remove(0);
        if (playersList.size() == 1) {
            endGame();
        } else {
            startRound();
        }
    }

    private void endGame() {
        handler.removeCallbacks(countdownRunnable);
        GameService gameService = new GameService(this);
        gameService.saveGame(playersList.get(0));
        setResult(RESULT_OK);
        finish();
    }
}
