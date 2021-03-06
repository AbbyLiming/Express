package com.expressba.express.user.me;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.expressba.express.main.MyApplication;
import com.expressba.express.R;
import com.expressba.express.main.UIFragment;
import com.expressba.express.myelement.MyFragmentManager;
import com.expressba.express.user.address.AddressFragment;
import com.expressba.express.user.expresshistory.ExpressHistoryFragment;
import com.expressba.express.user.expresshistory.ExpressHistoryPresenterImpl;
import com.expressba.express.user.password.ChangePasswordFragment;
import com.expressba.express.user.telephone.ChangeTelFragment;

/**
 * Created by chao on 2016/4/17.
 */
public class MeFragment extends UIFragment implements MeView,View.OnClickListener{
    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_me_fragment,container,false);
        TextView textView = (TextView) view.findViewById(R.id.top_bar_center_text);
        textView.setText("我");
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        view.findViewById(R.id.top_bar_left_img).setOnClickListener(this);
        view.findViewById(R.id.user_receive_address).setOnClickListener(this);
        view.findViewById(R.id.user_tel).setOnClickListener(this);
        view.findViewById(R.id.user_password).setOnClickListener(this);
        view.findViewById(R.id.send_record).setOnClickListener(this);
        view.findViewById(R.id.receive_record).setOnClickListener(this);
        view.findViewById(R.id.about_soft).setOnClickListener(this);
        view.findViewById(R.id.user_send_address).setOnClickListener(this);
        view.findViewById(R.id.user_me_login_out).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_img:
                getFragmentManager().popBackStack();
                break;
            case R.id.user_receive_address:
                toUserReceiveAddress();
                break;
            case R.id.user_send_address:
                toUserSendAddress();
                break;
            case R.id.user_tel:
                toTelChange();
                break;
            case R.id.user_password:
                toPasswordChange();
                break;
            case R.id.send_record:
                toSendRecordFragment();
                break;
            case R.id.receive_record:
                toReceiveRecordFragment();
                break;
            case R.id.about_soft:
                toAboutSoftFragment();
                break;
            case R.id.my_complaint:
                toMyComplaint();
                break;
            case R.id.user_me_login_out:
                loginOut();
                break;
        }
    }

    /**
     * 跳转到收货地址
     */
    @Override
    public void toUserReceiveAddress(){
        //AddressFragment addressFragment = new AddressFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("receiveOrSend", AddressFragment.RECEIVE);
        bundle.putBoolean("isme",true);

        //addressFragment.setArguments(bundle);

        MyFragmentManager.turnFragment(MeFragment.class,AddressFragment.class,bundle,getFragmentManager());

        /*transaction.replace(R.id.fragment_container_layout,addressFragment);
        transaction.addToBackStack("mefragment");
        transaction.commit();*/
    }

    /**
     * 修改手机号
     */
    @Override
    public void toTelChange() {
        ChangeTelFragment changeTelFragment = new ChangeTelFragment();

        transaction.replace(R.id.fragment_container_layout,changeTelFragment);
        transaction.addToBackStack("mefragment");
        transaction.commit();
    }

    /**
     * 修改密码
     */
    @Override
    public void toPasswordChange() {
        ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();

        transaction.replace(R.id.fragment_container_layout,changePasswordFragment);
        transaction.addToBackStack("mefragment");
        transaction.commit();
    }

    /**
     * 用户发货地址
     */
    @Override
    public void toUserSendAddress() {
        AddressFragment addressFragment = new AddressFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("receiveOrSend", AddressFragment.SEND);
        bundle.putBoolean("isme",true);
        addressFragment.setArguments(bundle);

        transaction.replace(R.id.fragment_container_layout,addressFragment);
        transaction.addToBackStack("mefragment");
        transaction.commit();
    }

    /**
     * 注销登陆
     */
    @Override
    public void loginOut() {
        ((MyApplication)getActivity().getApplication()).getUserInfo().setLoginState(false);
        //LoginFragment loginFragment = new LoginFragment();
        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        //transaction.replace(R.id.fragment_container_layout,loginFragment);
        getFragmentManager().popBackStack();
        transaction.commit();
    }


    @Override
    public void toReceiveRecordFragment() {
        ExpressHistoryFragment historyFragment = new ExpressHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("sendorrecieve", ExpressHistoryPresenterImpl.HISTORY_RECEIVE);
        historyFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container_layout,historyFragment);
        transaction.addToBackStack("mefragment");
        transaction.commit();
    }

    @Override
    public void toSendRecordFragment(){
        ExpressHistoryFragment historyFragment = new ExpressHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("sendorrecieve", ExpressHistoryPresenterImpl.HISTORY_SEND);
        historyFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container_layout,historyFragment);
        transaction.addToBackStack("mefragment");
        transaction.commit();
    }

    /**
     *关于软件
     */
    @Override
    public void toAboutSoftFragment(){

    }

    /**
     * 我的投诉
     */
    @Override
    public void toMyComplaint(){

    }

}
