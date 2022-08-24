package smir.shitab14.weexdemo.factory;

import androidx.annotation.NonNull;

import org.apache.weex.common.TypeModuleFactory;

import java.lang.ref.WeakReference;

/**
 * Created by Shitab Mir on 24 August, 2022.
 * HungryNaki (Technology), Daraz Bangladesh Limited, Alibaba Group
 * mushfiq.islam@hungrynaki.com | shitabmir@gmail.com
 **/
public class MyTypeModuleFactory extends TypeModuleFactory<MyTypeModule> {
    private WeakReference<MyTypeModule.WeexActionBar> weexActionBarRef;
    private WeakReference<MyTypeModule.WeexBottomNavigationBar> weexBottomNavigationBarRef;

    public static MyTypeModuleFactory getInstance() {
        return Holder.instance;
    }

    private MyTypeModuleFactory(Class<MyTypeModule> clz) {
        super(clz);
    }

    public void attach(@NonNull MyTypeModule.WeexActionBar weexActionBar,
                       @NonNull MyTypeModule.WeexBottomNavigationBar weexBottomNavigationBar) {
        weexActionBarRef = new WeakReference<>(weexActionBar);
        weexBottomNavigationBarRef = new WeakReference<>(weexBottomNavigationBar);
    }

    @Override
    public MyTypeModule buildInstance() {
        MyTypeModule.WeexActionBar weexActionBar = weexActionBarRef.get();
        MyTypeModule.WeexBottomNavigationBar weexBottomNavigationBar = weexBottomNavigationBarRef.get();

        if (weexActionBar == null) {
            throw new IllegalStateException("weexActionBar is null");
        }
        if (weexBottomNavigationBar == null) {
            throw new IllegalStateException("weexBottomNavigationBar is null");
        }

        return new MyTypeModule(weexActionBar, weexBottomNavigationBar);
    }

    private static class Holder {
        static MyTypeModuleFactory instance = new MyTypeModuleFactory(MyTypeModule.class);
    }
}
