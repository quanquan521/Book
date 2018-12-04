package yzq.com.book.ui.main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

import yzq.com.book.R;

/**
 * Created by A on 2017/9/20.
 */

public class SortFragmentTypeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList <String>list;
    private MyItemClickListener mListener;
    private int selectorPosition=-1;
    public interface MyItemClickListener {
         void onItemClick(View view, int postion);
    }

    public SortFragmentTypeAdapter(Context context , ArrayList<String> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.sortfragmet_name,parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder  myViewHolder = (MyViewHolder) holder;
        myViewHolder.name.setText(list.get(position));
        if (selectorPosition>=0){
            if (selectorPosition == position) {
                myViewHolder.layout.setBackgroundColor(Color.WHITE);
                myViewHolder.mark.setVisibility(View.VISIBLE);

            } else {
                //其他的恢复原来的状态
                myViewHolder.layout.setBackgroundColor(context.getResources().getColor(R.color.sortBackground));
                myViewHolder.mark.setVisibility(View.INVISIBLE);
            }
        }else {
            myViewHolder.layout.setBackgroundColor(context.getResources().getColor(R.color.sortBackground));
            myViewHolder.mark.setVisibility(View.INVISIBLE);
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {


        private LinearLayout layout;
        private LinearLayout mark;
        private TextView name;

        public MyViewHolder(View view)
        {
            super(view);
            layout= (LinearLayout) view.findViewById(R.id.layout);
            mark=view.findViewById(R.id.mark);
            name=view.findViewById(R.id.name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onItemClick(v,getPosition());
            }
        }
    }
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mListener = listener;
    }

    public void changeState(int pos) {
        selectorPosition = pos;
        notifyDataSetChanged();
    }
}
