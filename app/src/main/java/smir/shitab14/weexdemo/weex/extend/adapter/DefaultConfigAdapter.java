package smir.shitab14.weexdemo.weex.extend.adapter;

//import com.taobao.weex.adapter.IWXConfigAdapter;

import org.apache.weex.adapter.IWXConfigAdapter;

/**
 * @author zhongcang
 * @date 2019/6/19
 */
public class DefaultConfigAdapter implements IWXConfigAdapter {
    @Override
    public String getConfig(String nameSpace, String key, String defaultValue) {
        return defaultValue;
    }

    @Override
    public String getConfigWhenInit(String nameSpace, String key, String defaultValue) {
        return defaultValue;
    }

    @Override
    public boolean checkMode(String name) {
        return false;
    }
}
