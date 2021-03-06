package com.rubbersoft.android.valveleakage.ui;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.rubbersoft.android.valveleakage.model.Data;
import com.rubbersoft.android.valveleakage.model.ListAdapter;
import com.rubbersoft.android.valveleakage.utils.AppLog;
import com.rubbersoft.android.valveleakage.utils.Callback;
import com.rubbersoft.android.valveleakage.utils.ConfigConstants;
import com.rubbersoft.android.valveleakage.utils.DataBaseSource;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends ListFragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "ItemFragment";

    // TODO: Rename and change types of parameters
    private String mNodeName;//name of node this fragment is for
    private int mNotificationId;

    private Context context;
    private ListAdapter listAdapter;//adapter for handling views for list
    private List<Data> list;//data to be shown for list
    Callback callback;//callback used to notify list adapter



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    // TODO: Rename and change types of parameters
    public static ItemFragment newInstance(String param1) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mNodeName = getArguments().getString(ARG_PARAM1);
        }

        callback = new Callback() {

            @Override
            public void callback() {
                notifyDataChanged();
            }
        };

//        get data list and obtain notification if for the node
        switch (mNodeName) {
            case ConfigConstants.TABLE_NODE1:
                list = DataBaseSource.getInstance().dataNode1;
                mNotificationId = ConfigConstants.NODE1_NOTIFICATION_ID;
                break;
            case ConfigConstants.TABLE_NODE2:
                list = DataBaseSource.getInstance().dataNode2;
                mNotificationId = ConfigConstants.NODE2_NOTIFICATION_ID;
                break;
            case ConfigConstants.TABLE_NODE3:
                list = DataBaseSource.getInstance().dataNode3;
                mNotificationId = ConfigConstants.NODE3_NOTIFICATION_ID;
                break;
            case ConfigConstants.TABLE_NODE4:
                list = DataBaseSource.getInstance().dataNode4;
                mNotificationId = ConfigConstants.NODE4_NOTIFICATION_ID;
                break;
        }

//        make new adapter
        listAdapter = new ListAdapter(getActivity(), list);
//        set adapter for list
        setListAdapter(listAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }

    /*
    * here we set callback for list adapter data change notification
    * */
    @Override
    public void onResume() {
        super.onResume();
        switch (mNodeName) {
            case ConfigConstants.TABLE_NODE1:
                DataBaseSource.getInstance().call1 = callback;
                break;
            case ConfigConstants.TABLE_NODE2:
                DataBaseSource.getInstance().call1 = callback;
                break;
            case ConfigConstants.TABLE_NODE3:
                DataBaseSource.getInstance().call1 = callback;
                break;
            case ConfigConstants.TABLE_NODE4:
                DataBaseSource.getInstance().call1 = callback;
                break;
        }

    }

//    remove data change notification callback
    @Override
    public void onPause() {
        super.onPause();
        switch (mNodeName) {
            case ConfigConstants.TABLE_NODE1:
                DataBaseSource.getInstance().call1 = null;
                break;
            case ConfigConstants.TABLE_NODE2:
                DataBaseSource.getInstance().call1 = null;
                break;
            case ConfigConstants.TABLE_NODE3:
                DataBaseSource.getInstance().call1 = null;
                break;
            case ConfigConstants.TABLE_NODE4:
                DataBaseSource.getInstance().call1 = null;
                break;
        }
    }

//    notify data change
    public void notifyDataChanged() {
        listAdapter.notifyDataSetChanged();
    }

}
