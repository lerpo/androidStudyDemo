package com.example.androiddemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddemo.R;
import com.example.androiddemo.swipe.helper.WeSwipeHelper;
import com.example.androiddemo.swipe.helper.WeSwipeProxyAdapter;

import java.util.ArrayList;
import java.util.Map;

public class MyRecyclerViewAdapter2 extends WeSwipeProxyAdapter<MyRecyclerViewAdapter2.MyViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Map<String,String>> dataList;
    public Context context;
    public MyRecyclerViewAdapter2(Context context, ArrayList<Map<String,String>> dataList) {
        this.mInflater = LayoutInflater.from((context));
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_recyclerview_adapter2, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view,context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Map userInfo = dataList.get(position);
        holder.headImg.setImageDrawable(this.context.getResources().getDrawable(Integer.valueOf(userInfo.get("head").toString())));
        holder.name.setText(userInfo.get("name").toString());
        holder.talk.setText(userInfo.get("talk").toString());
        holder.time.setText(userInfo.get("time").toString());

        holder.zhiding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "置顶" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.yidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "已读" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "已删" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements WeSwipeHelper.SwipeLayoutTypeCallBack {
        private ImageView headImg;
        private TextView name;
        private TextView talk;
        private TextView time;
        private Context context;
        private LinearLayout slide;
        private TextView zhiding, yidu, shanchu;
        private RelativeLayout slideItem;
        private LinearLayout item_text;
        public MyViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.context = context;
            headImg = itemView.findViewById(R.id.headImg);
            name = itemView.findViewById(R.id.name);
            talk = itemView.findViewById(R.id.talk);
            time = itemView.findViewById(R.id.time);

            zhiding = itemView.findViewById(R.id.zhiding);
            yidu = itemView.findViewById(R.id.yidu);
            shanchu = itemView.findViewById(R.id.shanchu);
            slide = itemView.findViewById(R.id.slide);
            slideItem = itemView.findViewById(R.id.slide_itemView);
            item_text = itemView.findViewById(R.id.item_text);
        }
        //侧滑菜单的宽度，也是侧滑的距离。方法1.
        @Override
        public float getSwipeWidth() {
            //布局隐藏超过父布局的范围的时候这里得不到宽度
            return dip2px(context, 240);
        }

        //需要发生滑动的布局。方法2.
        @Override
        public View needSwipeLayout() {
            return slideItem;
        }
        //未滑动之前展现在屏幕中的布局。方法3.
        @Override
        public View onScreenView() {
            return item_text;
        }
    }
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
