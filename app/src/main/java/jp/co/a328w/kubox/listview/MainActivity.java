package jp.co.a328w.kubox.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listview) ListView mListView;

    private BaseAdapter mAdapter;
    private List<User> mUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mUserList = new ArrayList<User>();
        mUserList.add(new User("真木よう子", 90));
        mUserList.add(new User("高岡早紀", 90));
        mUserList.add(new User("馬場ふみか", 90));


        mAdapter = new ListViewAdapter(this.getApplicationContext(), R.layout.listview_row, mUserList);

        // ListViewにadapterをセット
        mListView.setAdapter(mAdapter);

    }

    @OnClick(R.id.buttonAdd)
    public void onClickButtonAdd(Button m){
        Log.d("test", "追加ボタン押した");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        mUserList.add(0, new User("石原ともみ " + simpleDateFormat.format(date), 90));
        mAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.buttonLogout)
    public void onClickButtonLogout(Button m){
        Log.d("test", "ログアウトボタン押した");
        mUserList.clear();
        mAdapter.notifyDataSetChanged();

    }

}
