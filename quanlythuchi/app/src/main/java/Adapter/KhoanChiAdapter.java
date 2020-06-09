package Adapter;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlythuchi.MainActivity;
import com.example.quanlythuchi.R;

import java.util.Calendar;
import java.util.List;

import Model.KhoanChi;

public class KhoanChiAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<KhoanChi> khoanChiList;

    public KhoanChiAdapter(Context context, int layout, List<KhoanChi> khoanChiList) {
        this.context = context;
        this.layout = layout;
        this.khoanChiList = khoanChiList;
    }


    @Override
    public int getCount() {
        return khoanChiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView khoanchi, loaichi, sotien, ngaythang;
        ImageView imgview;
        Button btnsua;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.khoanchi = (TextView) convertView.findViewById(R.id.tv_khoanchi);
            holder.loaichi = (TextView) convertView.findViewById(R.id.tv_loaichi);
            holder.sotien = (TextView) convertView.findViewById(R.id.tv_sotien);
            holder.ngaythang = (TextView) convertView.findViewById(R.id.tv_ngaythang);
            holder.imgview = (ImageView) convertView.findViewById(R.id.img_view);
            holder.btnsua = (Button) convertView.findViewById(R.id.btn_sua);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final KhoanChi kc = khoanChiList.get(position);
        holder.khoanchi.setText(kc.getKhoanChi());
        holder.loaichi.setText(kc.getLoaiChi());
        holder.sotien.setText(kc.getSoTien());
        holder.ngaythang.setText(kc.getNgayThang());

        holder.btnsua.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.N)

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogsua);

                final EditText edtkhoanchi = (EditText)dialog.findViewById(R.id.edt_khoanchi);
                final EditText edtloaichi = (EditText)dialog.findViewById(R.id.edt_loaichi);
                final EditText edtsotien = (EditText)dialog.findViewById(R.id.edt_sotien);


                edtkhoanchi.setText(kc.getKhoanChi());
                edtloaichi.setText(kc.getLoaiChi());
                edtsotien.setText(kc.getSoTien());




                Button btnLuu = (Button)dialog.findViewById(R.id.btn_luu);
                btnLuu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtkhoanchi.getText().toString();
                        String b = edtloaichi.getText().toString();
                        String c = edtsotien.getText().toString();


                    }
                });

            }
        });


        return convertView;
    }

}
