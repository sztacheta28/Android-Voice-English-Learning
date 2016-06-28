package pl.edu.uksw.voiceenglishlearning;

import android.content.res.ColorStateList;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import com.github.clans.fab.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    int goodanswearBtnIdx = 0;

    public static int goodAnswears = 0;
    public static int badAnswears = 0;

    List<DictionaryHelper> dictionary = new ArrayList<DictionaryHelper>();

    @BindView(R.id.englishWord)
    TextView englishWordTextView;

    @BindView(R.id.answear1)
    Button answearBtn1;

    @BindView(R.id.answear2)
    Button answearBtn2;

    @BindView(R.id.answear3)
    Button answearBtn3;

    @BindView(R.id.answear4)
    Button answearBtn4;

    @BindView(R.id.next)
    Button nextBtn;

    @BindView(R.id.fab)
    FloatingActionButton fab;


    Random rnd = new Random();

    String englishWord = "";
    String polishWord = "";

    final MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);

        loadWords();

        randomWord();
    }

    @OnClick(R.id.answear1)
    public void onAnswer1(View view) {
        if(goodanswearBtnIdx == 0){
            ++MainActivity.goodAnswears;
            view.setBackgroundResource(R.drawable.good_answear_button);
        }else{
            ++MainActivity.badAnswears;
            view.setBackgroundResource(R.drawable.bad_answear_button);
            ((Button)view).setTextColor(getResources().getColor(R.color.white));

            if(goodanswearBtnIdx == 1){
                answearBtn2.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 2){
                answearBtn3.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 3){
                answearBtn4.setBackgroundResource(R.drawable.good_answear_button);
            }
        }

        answearBtn1.setClickable(false);
        answearBtn2.setClickable(false);
        answearBtn3.setClickable(false);
        answearBtn4.setClickable(false);
        nextBtn.setVisibility(View.VISIBLE);
        englishWordTextView.setText(englishWord);
    }

    @OnClick(R.id.answear2)
    public void onAnswer2(View view) {
        if(goodanswearBtnIdx == 1){
            ++MainActivity.goodAnswears;
            view.setBackgroundResource(R.drawable.good_answear_button);
        }else{
            ++MainActivity.badAnswears;
            view.setBackgroundResource(R.drawable.bad_answear_button);
            ((Button)view).setTextColor(getResources().getColor(R.color.white));

            if(goodanswearBtnIdx == 0){
                answearBtn1.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 2){
                answearBtn3.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 3){
                answearBtn4.setBackgroundResource(R.drawable.good_answear_button);
            }
        }

        answearBtn1.setClickable(false);
        answearBtn2.setClickable(false);
        answearBtn3.setClickable(false);
        answearBtn4.setClickable(false);
        nextBtn.setVisibility(View.VISIBLE);
        englishWordTextView.setText(englishWord);
    }

    @OnClick(R.id.answear3)
    public void onAnswer3(View view) {
        if(goodanswearBtnIdx == 2){
            ++MainActivity.goodAnswears;
            view.setBackgroundResource(R.drawable.good_answear_button);
        }else{
            ++MainActivity.badAnswears;
            view.setBackgroundResource(R.drawable.bad_answear_button);
            ((Button)view).setTextColor(getResources().getColor(R.color.white));

            if(goodanswearBtnIdx == 0){
                answearBtn1.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 1){
                answearBtn2.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 3){
                answearBtn4.setBackgroundResource(R.drawable.good_answear_button);
            }
        }

        answearBtn1.setClickable(false);
        answearBtn2.setClickable(false);
        answearBtn3.setClickable(false);
        answearBtn4.setClickable(false);
        nextBtn.setVisibility(View.VISIBLE);
        englishWordTextView.setText(englishWord);
    }

    @OnClick(R.id.answear4)
    public void onAnswer4(View view) {
        if(goodanswearBtnIdx == 3){
            ++MainActivity.goodAnswears;
            view.setBackgroundResource(R.drawable.good_answear_button);
        }else{
            ++MainActivity.badAnswears;
            view.setBackgroundResource(R.drawable.bad_answear_button);
            ((Button)view).setTextColor(getResources().getColor(R.color.white));

            if(goodanswearBtnIdx == 0){
                answearBtn1.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 1){
                answearBtn2.setBackgroundResource(R.drawable.good_answear_button);
            }else if(goodanswearBtnIdx == 2){
                answearBtn3.setBackgroundResource(R.drawable.good_answear_button);
            }
        }

        answearBtn1.setClickable(false);
        answearBtn2.setClickable(false);
        answearBtn3.setClickable(false);
        answearBtn4.setClickable(false);
        nextBtn.setVisibility(View.VISIBLE);
        englishWordTextView.setText(englishWord);
    }

    @OnClick(R.id.next)
    public void onNext(View view){
        randomWord();
        answearBtn1.setClickable(true);
        answearBtn1.setBackgroundResource(R.drawable.normal_button);
        answearBtn1.setTextColor(getResources().getColor(R.color.black));
        answearBtn2.setClickable(true);
        answearBtn2.setBackgroundResource(R.drawable.normal_button);
        answearBtn2.setTextColor(getResources().getColor(R.color.black));
        answearBtn3.setClickable(true);
        answearBtn3.setBackgroundResource(R.drawable.normal_button);
        answearBtn3.setTextColor(getResources().getColor(R.color.black));
        answearBtn4.setClickable(true);
        answearBtn4.setBackgroundResource(R.drawable.normal_button);
        answearBtn4.setTextColor(getResources().getColor(R.color.black));
        nextBtn.setVisibility(View.GONE);
        englishWordTextView.setText("");
    }

    @OnClick(R.id.fab)
    public void onFab(View view) {
        Snackbar.make(view, "Choose good answear", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();

        Log.d("TEST", englishWord);

        String url = "http://dictionary.cambridge.org/media/english-polish/us_pron/";
        url += englishWord.charAt(0)+"/";
        for(int i=0; i<3; ++i){
            if(i<englishWord.length()){
                url += englishWord.charAt(i);
            } else {
                url += "_";
            }
        }
        url += "/";

        for(int i=0; i<5; ++i){
            if(i<englishWord.length()){
                url += englishWord.charAt(i);
            } else {
                url += "_";
            }
        }
        url += "/"+englishWord+".mp3";

        Log.d("TEST", url);

        fab.setProgress(0, false);

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mp.stop();
            mp.reset();
            mp.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mp.start();
                fab.setProgress(100, true);
            }
        });
        mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
                return false;
            }
        });


        mp.prepareAsync();
    }

    private void randomWord(){
        int idx = rnd.nextInt(dictionary.size());
        englishWord = dictionary.get(idx).englishWord;
        polishWord = dictionary.get(idx).polishWord;

        goodanswearBtnIdx = rnd.nextInt(4);
        if(goodanswearBtnIdx == 0){
            answearBtn1.setText(polishWord);
        }
        else if(goodanswearBtnIdx ==1){
            answearBtn2.setText(polishWord);
        }
        else if(goodanswearBtnIdx ==2){
            answearBtn3.setText(polishWord);
        }
        else if(goodanswearBtnIdx ==3){
            answearBtn4.setText(polishWord);
        }

        for(int i=0; i<4; ++i){
            if(i != goodanswearBtnIdx) {
                int idxRndPolishWord;
                while((idxRndPolishWord = rnd.nextInt(dictionary.size())) == goodanswearBtnIdx);

                String rndPolishWord = dictionary.get(idxRndPolishWord).polishWord;

                if (i == 0) {
                    answearBtn1.setText(rndPolishWord);
                } else if (i == 1) {
                    answearBtn2.setText(rndPolishWord);
                } else if (i == 2) {
                    answearBtn3.setText(rndPolishWord);
                } else if (i == 3) {
                    answearBtn4.setText(rndPolishWord);
                }
            }
        }
    }

    private void loadWords() {
        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("angielskieslowka", "raw", getPackageName()));

        BufferedReader r = new BufferedReader(new InputStreamReader(ins));

        try {
            String line = "";

            while((line = r.readLine())!=null){
                String[] elements = line.split("  ");
                DictionaryHelper dictionaryHelper = new DictionaryHelper();
                dictionaryHelper.englishWord = elements[1];
                dictionaryHelper.polishWord = elements[2];

                dictionary.add(dictionaryHelper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class DictionaryHelper{
        String englishWord;
        String polishWord;
    }
}
