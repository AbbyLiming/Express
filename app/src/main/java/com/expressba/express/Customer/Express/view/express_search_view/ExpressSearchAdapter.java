package com.expressba.express.Customer.Express.view.express_search_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.expressba.express.model.ExpressInfo;
import com.expressba.express.R;

import java.util.List;

/**
 * Created by 黎明 on 2016/4/17.
 * 显示express-search-list的适配器
 */
public class ExpressSearchAdapter extends BaseAdapter {
    private List<ExpressInfo> elist;
    private LayoutInflater mInflater;

    public ExpressSearchAdapter(Context context, List<ExpressInfo> data) {
        elist = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (elist != null)
            return elist.size();
        else return 0;
    }

    @Override
    public Object getItem(int position) {
        if (elist != null)
            return elist.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (elist != null)
            return position;
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder view = null;
        if (convertView == null) {
            view = new viewHolder();
            convertView = mInflater.inflate(R.layout.express_item, null);
            view.ID = (TextView) convertView.findViewById(R.id.ID);
            view.rname = (TextView) convertView.findViewById(R.id.rname);
            view.sname = (TextView) convertView.findViewById(R.id.sname);
            view.GetTime = (TextView) convertView.findViewById(R.id.gettime);
            convertView.setTag(view);
        } else {
            view = (viewHolder) convertView.getTag();
        }
        view.ID.setText(elist.get(position).getID());
        view.sname.setText(elist.get(position).getSname());
        view.rname.setText(elist.get(position).getRname());
        view.GetTime.setText(elist.get(position).getGetTime());
        return convertView;
    }

    class viewHolder {
        public TextView ID, sname, rname, GetTime;//gettime
    }
}

