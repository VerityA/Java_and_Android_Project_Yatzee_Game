package codeclan.com.yatzee.TheScoreButtons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import codeclan.com.yatzee.R;

/**
 * Created by user on 25/03/2018.
 */

public class ScoreButtonAdaptor extends ArrayAdapter {

    public ScoreButtonAdaptor(Context context, ArrayList<ScoreButton> scoreButtons) {
        super(context, 0,  scoreButtons);
    }

    @Override
    public View getView(int position, View viewList, ViewGroup parent) {
        ScoreButton scoreButton = (ScoreButton) getItem(position);

        if (viewList == null) {
            viewList = LayoutInflater.from(getContext()).inflate(R.layout.score_button_item, parent, false);
        }

        String name = scoreButton.getStrategyType().getName();
        Integer resIDName = getContext().getResources().getIdentifier(name, "string", getContext().getPackageName());
        TextView strategyName = viewList.findViewById(R.id.strategy_name);
        strategyName.setText(resIDName);

        String image = scoreButton.getStrategyType().getImage();
        Integer resIDImage = getContext().getResources().getIdentifier(image, "drawable", getContext().getPackageName());
        ImageView strategyImage = viewList.findViewById(R.id.strategy_image);
        strategyImage.setImageResource(resIDImage);

        Button p1ScoreButton = viewList.findViewById(R.id.player1_score);


        if(scoreButton.getScoreValue() == null) {
            p1ScoreButton.setText(null);
        } else {
            p1ScoreButton.setText(scoreButton.getScoreValue().toString());
        }

        Button p2ScoreButton = viewList.findViewById(R.id.player2_score);

//        if(scoreButton.getP2ScoreValue() == null) {
//            p1ScoreButton.setText(null);
//        } else {
//            p1ScoreButton.setText(scoreButton.getP2ScoreValue().toString());
//        }

        p1ScoreButton.setTag(scoreButton);
        p2ScoreButton.setTag(scoreButton);

        return viewList;
    }
}
