package smir.shitab14.weexdemo.weex.extend.adapter;


import android.text.TextUtils;

//import com.taobao.weex.adapter.IWXAccessibilityRoleAdapter;

import org.apache.weex.adapter.IWXAccessibilityRoleAdapter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by moxun on 2017/11/13.
 */

public class DefaultAccessibilityRoleAdapter implements IWXAccessibilityRoleAdapter {
    private static Map<String, String> ENRoles = new HashMap<>();

    static {
        ENRoles.put("button", "Button");
        ENRoles.put("link", "HyperLink");
        ENRoles.put("img", "Picture");
        ENRoles.put("search", "Search");
        ENRoles.put("header", "Title");
    }

    @Override
    public String getRole(String key) {
        if (isEN()) {
            String enRole = ENRoles.get(key);
            if (!TextUtils.isEmpty(enRole)) {
                return enRole;
            }
        }
        return key;
    }

    private static boolean isEN() {
        try {
            return "EN".equals(Locale.getDefault().getCountry());
        } catch (Throwable t) {
        }
        return false;
    }
}
