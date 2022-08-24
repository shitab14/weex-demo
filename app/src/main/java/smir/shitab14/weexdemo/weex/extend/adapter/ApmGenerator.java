package smir.shitab14.weexdemo.weex.extend.adapter;

//import com.taobao.weex.performance.IApmGenerator;
//import com.taobao.weex.performance.IWXApmMonitorAdapter;

import org.apache.weex.performance.IApmGenerator;
import org.apache.weex.performance.IWXApmMonitorAdapter;

/**
 * @author zhongcang
 * @date 2018/7/13
 */
public class ApmGenerator implements IApmGenerator {
    @Override
    public IWXApmMonitorAdapter generateApmInstance(String type) {
        return new WXInstanceApmAdapter();
    }
}
