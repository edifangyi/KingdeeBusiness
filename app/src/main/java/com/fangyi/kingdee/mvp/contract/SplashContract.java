package com.fangyi.kingdee.mvp.contract;

import com.fangyi.component_library.base.BasePresenter;
import com.fangyi.component_library.mvp.IModel;
import com.fangyi.component_library.mvp.IView;
import com.fangyi.component_library.func.utils.dbutils.bean.Users;

import io.reactivex.Observable;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public interface SplashContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void onLoginSucceed();

        void onLoginError();
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<Users> doLogin(String username, String password);

    }

    //方法
    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void doLogin(String name, String password);
    }
}
