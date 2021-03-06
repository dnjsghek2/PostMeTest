package gpslocation.wonho.example.com.postmetest.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import gpslocation.wonho.example.com.postmetest.Interface.OnItemTouchListener;
import gpslocation.wonho.example.com.postmetest.R;

/**
 * Created by wonhochoi on 2016. 8. 24..
 */
public class CH_Pick_Rc_Adapter extends RecyclerView.Adapter<CH_Pick_Rc_Adapter.ViewHolder>{
    private List<String> cards;
    private OnItemTouchListener onItemTouchListener;


    public CH_Pick_Rc_Adapter(List<String> cards, OnItemTouchListener onItemTouchListener) {
        this.cards = cards;
        this.onItemTouchListener = onItemTouchListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v_post_card, viewGroup, false);
        return new CH_Pick_Rc_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CH_Pick_Rc_Adapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(cards.get(i));

    }
    @Override
    public int getItemCount() {
        return cards == null ? 0 : cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private Button button2;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.card_view_title);
            button2 = (Button) itemView.findViewById(R.id.card_view_button2);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemTouchListener.onButton2Click(v, getLayoutPosition());
                }
            });
        }
    }
}
