package smir.shitab14.weexdemo.weex.extend.adapter;

//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.taobao.weex.urlconnection.ByteArrayRequestEntity;
import com.taobao.weex.urlconnection.SimpleRequestEntity;
import com.taobao.weex.urlconnection.WeexURLConnectionManager;

import org.apache.weex.adapter.DefaultWXHttpAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by moxun on 16/12/29.
 */

public class InterceptWXHttpAdapter extends DefaultWXHttpAdapter {

    @NonNull
    @Override
    public DefaultWXHttpAdapter.IEventReporterDelegate getEventReporterDelegate() {
        return new IEventReporterDelegate() {

            WeexURLConnectionManager manager = new WeexURLConnectionManager(null);

            @Override
            public void preConnect(HttpURLConnection connection, @Nullable String body) {
                SimpleRequestEntity requestEntity = null;
                if (body != null) {
                    requestEntity = new ByteArrayRequestEntity(body.getBytes());
                }

                try {
                    manager.preConnect(connection, requestEntity);
                } catch (Throwable throwable) {
                    manager.httpExchangeFailed(new IOException("Exception on preConnect", throwable));
                }
            }

            @Override
            public void postConnect() {
                try {
                    manager.postConnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public InputStream interpretResponseStream(@Nullable InputStream inputStream) {
                return manager.interpretResponseStream(inputStream);
            }

            @Override
            public void httpExchangeFailed(IOException e) {
                manager.httpExchangeFailed(e);
            }
        };
    }
}
