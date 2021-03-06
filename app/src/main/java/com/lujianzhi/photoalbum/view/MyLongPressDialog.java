package com.lujianzhi.photoalbum.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lujianzhi.photoalbum.R;
import com.lujianzhi.photoalbum.utils.MyUtil;

/**
 * Created by Lawson on 2016/4/24.
 */
public class MyLongPressDialog extends Dialog {

    private Context context;
    private View popView;
    private TextView set_cover;
    private TextView delete;
    private TextView download;

    private IMyClickListener myDeleteListener;
    private IMyClickListener mySetCoverListener;
    private IMyClickListener myDownloadListener;

    public MyLongPressDialog(Context context) {
        super(context, R.style.emptyDialog);
        this.context = context;
        popView = View.inflate(context, R.layout.long_press_menu, null);
        setContentView(popView, new ViewGroup.LayoutParams(MyUtil.getWindowWidth((Activity) context),
                ViewGroup.LayoutParams.WRAP_CONTENT));
        initView();
        initClickListener();
    }

    private void initView() {
        download = (TextView) popView.findViewById(R.id.download);
        delete = (TextView) popView.findViewById(R.id.delete);
        set_cover = (TextView) popView.findViewById(R.id.set_cover);
        delete.setVisibility(View.GONE);
        set_cover.setVisibility(View.GONE);
    }

    public void setDeleteVisible() {
        delete.setVisibility(View.VISIBLE);
    }

    public void setCoverVisible() {
        set_cover.setVisibility(View.VISIBLE);
    }

    public void setDownloadGone() {
        download.setVisibility(View.GONE);
    }

    public void setDeleteClickListener(IMyClickListener myClickListener) {
        this.myDeleteListener = myClickListener;
    }

    public void setSetCoverClickListener(IMyClickListener mySetCoverListener) {
        this.mySetCoverListener = mySetCoverListener;
    }

    public void setMyDownloadListener(IMyClickListener myDownloadListener) {
        this.myDownloadListener = myDownloadListener;
    }

    private void initClickListener() {

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDeleteListener.onClick();
                dismiss();
            }
        });

        set_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySetCoverListener.onClick();
                dismiss();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDownloadListener.onClick();
                dismiss();
            }
        });

    }

    public interface IMyClickListener {
        void onClick();
    }

}
