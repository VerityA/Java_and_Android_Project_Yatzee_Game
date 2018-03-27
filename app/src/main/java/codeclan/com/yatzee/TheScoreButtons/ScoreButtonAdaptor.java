package codeclan.com.yatzee.TheScoreButtons;

import android.content.Context;
import android.util.Log;
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

//        ArrayList<Strategy> lowerScoreStrategies = new ArrayList<>();
//        lowerScoreStrategies.add(Strategy.ONES);
//        lowerScoreStrategies.add(Strategy.TWOS);
//        lowerScoreStrategies.add(Strategy.THREES);
//        lowerScoreStrategies.add(Strategy.FOURS);
//        lowerScoreStrategies.add(Strategy.FIVES);
//        lowerScoreStrategies.add(Strategy.SIXES);

        String colour = scoreButton.getStrategyType().getColour();
        Log.d("test colour", scoreButton.getStrategyType().getColour());
        Integer resIDColour = getContext().getResources().getIdentifier(colour, "color", getContext().getPackageName());

        //21300001
        //21200004

        Log.d("res Id", resIDColour.toString());
        Log.d("darker green", "color: " + R.color.darker_green);



        viewList.setBackgroundColor( getContext().getResources().getColor(resIDColour) );
//        if (lowerScoreStrategies.contains(scoreButton.getStrategyType()) )
//        {viewList.setBackgroundColor(R.color.pale_green);}



        if(scoreButton.getP1ScoreValue() == null) {
            p1ScoreButton.setText(null);
        } else {
            p1ScoreButton.setText(scoreButton.getP1ScoreValue().toString());
        }

        Button p2ScoreButton = viewList.findViewById(R.id.player2_score);

        if(scoreButton.getP2ScoreValue() == null) {
            p2ScoreButton.setText(null);
        } else {
            p2ScoreButton.setText(scoreButton.getP2ScoreValue().toString());
        }

        p1ScoreButton.setTag(scoreButton);
        p2ScoreButton.setTag(scoreButton);


        return viewList;
    }
}
