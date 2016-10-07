package jp.co.a328w.kubox.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kubox on 2016/10/07.
 */

public class ListViewAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<User> mUserList;
    private int mLayoutId;

    static class ViewHolder {
        TextView name;
        TextView size;
    }

    public ListViewAdapter(Context context, int itemLayoutId, List<User> userList ){

        mInflater = LayoutInflater.from(context);
        mLayoutId = itemLayoutId;
        mUserList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;


        if (convertView == null) {
            Log.d("convertView == null()", "position= "+position);
            convertView = mInflater.inflate(mLayoutId, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewName);
            holder.size = (TextView) convertView.findViewById(R.id.textViewSize);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Log.d("testUserName", mUserList.get(position).getName());

//        holder.name.setText(String.valueOf(position+1) + " : " + mUserList.get(position).getName());
//        holder.size.setText(String.valueOf(position+1) + " : " + String.valueOf(mUserList.get(position).getSize()));
          holder.name.setText(mUserList.get(position).getName());
          holder.size.setText(String.valueOf(mUserList.get(position).getSize()));
        return convertView;
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
