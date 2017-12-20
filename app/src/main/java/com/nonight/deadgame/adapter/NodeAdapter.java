package com.nonight.deadgame.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hanks.htextview.fade.FadeTextView;
import com.nonight.deadgame.R;
import com.nonight.deadgame.model.InstanceNode;
import com.nonight.deadgame.model.enums.InstanceNodeType;
import com.nonight.deadgame.model.enums.NodeStatus;

import java.io.File;
import java.util.List;

/**
 * Created by 祈愿星痕 on 2016/11/4.
 */
public class NodeAdapter extends BaseAdapter {

    private int resourceId;
    private List<InstanceNode> list;
    private boolean first = true;
    private Context context;


    public NodeAdapter(Context context, List<InstanceNode> objects) {

        this.list = objects;
        this.context = context;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstanceNode instanceNode = list.get(position);
        View view = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final DramaViewHolder dramaViewHolder;
//        if (convertView == null) {
//            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
//            viewHolder = new ViewHolder();
//
//
//            view.setTag(viewHolder);
//        } else {
//            view = convertView;
//            viewHolder = (ViewHolder) view.getTag();
//        }

        if (instanceNode.getNodeType() == InstanceNodeType.DRAMA){
            view = inflater.inflate(R.layout.item_play_tv, parent, false);
            dramaViewHolder = new DramaViewHolder();
            dramaViewHolder.fadeTextView = view.findViewById(R.id.item_play_tv_ftv);
            dramaViewHolder.fadeTextView.setText(instanceNode.getDramaContent());
        }else if (instanceNode.getNodeType() == InstanceNodeType.DRAMA){

        }else if (instanceNode.getNodeType() == InstanceNodeType.DRAMA){

        }else {

        }


        return view;
    }


    class DramaViewHolder {
        FadeTextView fadeTextView;
    }
}
