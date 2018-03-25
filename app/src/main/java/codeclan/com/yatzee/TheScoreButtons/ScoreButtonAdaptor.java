package codeclan.com.yatzee.TheScoreButtons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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


        return viewList;
    }
}
