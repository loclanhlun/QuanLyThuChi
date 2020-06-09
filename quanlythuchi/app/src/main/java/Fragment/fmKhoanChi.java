package Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.quanlythuchi.R;

import java.util.ArrayList;

import Adapter.KhoanChiAdapter;
import Model.KhoanChi;
import SQLite.Database;

public class fmKhoanChi extends Fragment {
    public void onStart(){
        super.onStart();
    }
    public fmKhoanChi(){}
    private View rootview;
    KhoanChiAdapter adapter;
    ArrayList<KhoanChi> list;
    ListView lv_khoanchi;
    Database database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_fm_khoan_chi, container,false);
        initView();

        return rootview;

    }

    private void initView() {
        database = new Database(getActivity());
        lv_khoanchi = rootview.findViewById(R.id.lv_khoangchi);
        list = new ArrayList<>();
        adapter = new KhoanChiAdapter(getActivity(), R.layout.list_item_khoan_chi, list);
        Cursor datakhoanchi = database.getData("SELECT * FROM CHI");
        list.clear();
        while (datakhoanchi.moveToNext()){
            String a = datakhoanchi.getString(0);
            String b = datakhoanchi.getString (1);
            int c = (int) datakhoanchi.getInt(2);
            String d = datakhoanchi.getString(3);

            list.add(new KhoanChi(a,b,c,d));

        }
        adapter.notifyDataSetChanged();
        lv_khoanchi.setAdapter(adapter);
    }
}
