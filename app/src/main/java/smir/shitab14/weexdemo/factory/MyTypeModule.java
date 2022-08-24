package smir.shitab14.weexdemo.factory;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.apache.weex.annotation.JSMethod;
import org.apache.weex.common.WXModule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shitab Mir on 24 August, 2022.
 * HungryNaki (Technology), Daraz Bangladesh Limited, Alibaba Group
 * mushfiq.islam@hungrynaki.com | shitabmir@gmail.com
 **/
@Keep
public class MyTypeModule extends WXModule {
    public static final String MODULE_NAME = "MyTypeModule";

//    private final WeexActionBar weexActionBar;
//    private final WeexBottomNavigationBar weexBottomNavigationBar;

    public MyTypeModule(@NonNull WeexActionBar weexActionBar,
                            @NonNull WeexBottomNavigationBar weexBottomNavigationBar) {
//        this.weexActionBar = weexActionBar;
//        this.weexBottomNavigationBar = weexBottomNavigationBar;
    }

    /**
     * Usage on JS side is something like
     * const MyModule = require('@weex-module/MyTypeModule');
     * MyModule.nativeFooBar("hello", 2);
     */
    @JSMethod(uiThread = true)
    @Keep
    public final void nativeFooBar(String first, int second) {
    }

    @JSMethod(uiThread = true)
    @Keep
    public final void showLogo() {
//        weexActionBar.showPageTitleLogo();
    }

    @JSMethod(uiThread = true)
    @Keep
    public final void setPageTitle(String title) {
//        weexActionBar.showPageTitle(title);
    }

    @JSMethod(uiThread = true)
    @Keep
    public final void setActiveTab(@Nullable String hash) {
        Pattern pattern = Pattern.compile("([A-z])\\w+");
        Matcher matcher = pattern.matcher(hash);
        String parsedHash;
        if (matcher.find()) {
            parsedHash = matcher.group();
        } else {
            parsedHash = null;
        }

//        GrocerBottomNavigationBar.Tab tab = GrocerBottomNavigationBar.Tab.toEnum(parsedHash);
//        weexBottomNavigationBar.setActiveTab(tab);
    }

    @JSMethod(uiThread = true)
    @Keep
    public final void showSearchBar(boolean show) {
//        weexActionBar.showSearchBar(show);
    }

    @JSMethod(uiThread = true)
    @Keep
    public final void scrollViewDidSignificantScrollUp() {
//        weexBottomNavigationBar.showTabBar(true);
    }

    @JSMethod(uiThread = true)
    @Keep
    public final void scrollViewDidSignificantScrollDown() {
//        weexBottomNavigationBar.showTabBar(false);
    }

    interface WeexActionBar {
        void showPageTitleLogo();

        void showPageTitle(@Nullable String title);

        void showSearchBar(boolean show);
    }

    interface WeexBottomNavigationBar {
//        void setActiveTab(GrocerBottomNavigationBar.Tab tab);

        void showTabBar(boolean show);
    }
}
