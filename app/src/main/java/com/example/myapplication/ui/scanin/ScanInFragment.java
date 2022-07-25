package com.example.myapplication.ui.scanin;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentScanInBinding;

public class ScanInFragment extends Fragment implements View.OnClickListener, View.OnKeyListener {

    private FragmentScanInBinding binding;
    private View view;
    private View view_popup;
    private String str_rfid;

    Button btn,btn_search_doc,btn_search_product;
    EditText txt_rfid, txt_bc_ref1, txt_bc_ref2, txt_product_ref1, txt_product_ref2, txt_from_ref1, txt_from_ref2, txt_rack, txt_loc, txt_doc_no, txt_product_name, txt_qty_total_new;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ScaninViewModel scaninViewModel =
                new ViewModelProvider(this).get(ScaninViewModel.class);

        view = inflater.inflate(R.layout.fragment_scan_in, container, false);

        TextView txt_view = (TextView) view.findViewById(R.id.txt_rfid112);
        scaninViewModel.getText().observe(getViewLifecycleOwner(), txt_view::setText);
        init();
        return view;
    }

    private void init() {
        //SET EDITTEXT
        txt_rfid = (EditText) view.findViewById(R.id.txt_rfid);
        txt_product_ref1 = (EditText) view.findViewById(R.id.txt_product_ref1);
        txt_product_ref2 = (EditText) view.findViewById(R.id.txt_product_ref2);
        txt_from_ref1 = (EditText) view.findViewById(R.id.txt_from_ref1);
        txt_from_ref2 = (EditText) view.findViewById(R.id.txt_from_ref2);
        txt_rack = (EditText) view.findViewById(R.id.txt_rack);
        txt_loc = (EditText) view.findViewById(R.id.txt_loc);
        txt_doc_no = (EditText) view.findViewById(R.id.txt_doc_no);
        txt_bc_ref1 = (EditText) view.findViewById(R.id.txt_bc_ref1);
        txt_bc_ref2 = (EditText) view.findViewById(R.id.txt_bc_ref2);
        txt_product_name = (EditText) view.findViewById(R.id.txt_bc_ref1);

        //SET BUTTON
        btn = (Button) view.findViewById(R.id.btn_search_rfid);
        btn_search_doc = (Button) view.findViewById(R.id.btn_search_doc);
        btn_search_product = (Button) view.findViewById(R.id.btn_search_product);

        txt_rfid.setOnKeyListener(this);
        btn.setOnClickListener(this);
        btn_search_doc.setOnClickListener(this);
        btn_search_product.setOnClickListener(this);

//        txt_product_name.setFocusableInTouchMode(true);
//        txt_product_name.setFocusable(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {

            case R.id.btn_search_rfid:
                showDialog(this.getView());
                break;
            case  R.id.btn_search_doc:
                showDialog(this.getView());
                break;
            case R.id.btn_search_product:
                showDialog_DetailProduct(this.getView());

                break;

        }
    }
    public void showDialog(View view){

        String myTitle = "Detail Head IN";
        String myMessage = "\r\n1. สวัสดีครับ " +
                "\r\n2. jadf djasf dsjfsd fjddfjkdsf " +
                "\r\n3. fkjd fdsklfj dfljfl ladks" +
                "\r\n4. jdfjds fds";

        Bundle args = new Bundle();
        args.putString("key", myMessage);
        args.putString("title", myTitle);
        PopupDetailFragment newFragment = new PopupDetailFragment();
        FragmentTransaction ft = getFragmentManager ().beginTransaction();
        newFragment.setArguments(args);
//        newFragment.show(ft, "TAG");
    newFragment.setShowsDialog(true);
    }

    public void showDialog_DetailProduct(View view){

        String myTitle = "Detail Product IN";
        String myMessage = "\r\n1. สวัสดีครับ " +
                "\r\n2. jadf djasf dsjfsd fjddfjkdsf " +
                "\r\n3. fkjd fdsklfj dfljfl ladks" +
                "\r\n4. jdfjds fds";

        Bundle args = new Bundle();
        args.putString("key", myMessage);
        args.putString("title", myTitle);
        PopUpDatailProductFragment newFragment = new PopUpDatailProductFragment();
        FragmentTransaction ft = getFragmentManager ().beginTransaction();
        newFragment.setArguments(args);
        newFragment.show(ft, "TAG");
    }
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_SEARCH ||
                i == EditorInfo.IME_ACTION_DONE ||
                keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                        keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {


            if (!keyEvent.isShiftPressed()) {
                switch (view.getId()) {
                    case R.id.txt_rfid:
                        check_txt_rfid();
                        break;

                }
                return true;
            }

        }

        return false;
    }

    private void check_txt_rfid() {
        str_rfid = txt_rfid.toString();
        if (txt_rfid.length() <= 0) {
            msg("ระบุเลข RFID");
            txt_rfid.requestFocus();
        } else {
            if(check_rfid()){
                txt_rfid.setEnabled(false);
                txt_product_name.requestFocus();
            }else{
                msg("ไม่พบเลข RFID ที่ระบุ");
            }
        }
    }
    private boolean check_rfid(){
        return  false;
    }

    private  void msg(String msg){
        Toast toast = Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 59000);
    }
}
