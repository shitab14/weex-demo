package smir.shitab14.weexdemo

//import android.support.multidex.MultiDex
/*import org.apache.weex.commons.adapter.DefaultWebSocketAdapterFactory
import org.apache.weex.commons.adapter.ImageAdapter
import org.apache.weex.commons.adapter.JSExceptionAdapter
import org.apache.weex.commons.adapter.PicassoBasedDrawableLoader*/
//import org.apache.weex.extend.adapter.ApmGenerator
//import org.apache.weex.extend.adapter.DefaultAccessibilityRoleAdapter
//import org.apache.weex.extend.adapter.DefaultConfigAdapter
//import org.apache.weex.extend.adapter.InterceptWXHttpAdapter
//import org.apache.weex.extend.adapter.WXAnalyzerDemoListener
//import org.apache.weex.extend.component.WXComponentSyncTest
//import org.apache.weex.extend.component.WXMask
//import org.apache.weex.extend.component.WXParallax
/*import org.apache.weex.extend.module.GeolocationModule
import org.apache.weex.extend.module.MyModule
import org.apache.weex.extend.module.RenderModule
import org.apache.weex.extend.module.SyncTestModule
import org.apache.weex.extend.module.WXEventModule
import org.apache.weex.extend.module.WXTitleBar
import org.apache.weex.extend.module.WXWsonTestModule*/
import android.app.Application
import android.util.Log
import androidx.multidex.MultiDex
//import com.taobao.weex.InitConfig
//import com.taobao.weex.WXSDKEngine
import org.apache.weex.InitConfig
import org.apache.weex.WXSDKEngine
import org.apache.weex.common.TypeModuleFactory
import org.apache.weex.common.WXException
import org.apache.weex.common.WXModule
import smir.shitab14.weexdemo.factory.MyTypeModuleFactory
import smir.shitab14.weexdemo.factory.MyTypeModuleFactory.getInstance
import smir.shitab14.weexdemo.weex.extend.adapter.*


/**
 * Created by Shitab Mir on 23 August, 2022.
 * HungryNaki (Technology), Daraz Bangladesh Limited, Alibaba Group
 * mushfiq.islam@hungrynaki.com | shitabmir@gmail.com
 **/
class WeexDemoApplication: Application() {

        override fun onCreate() {
                super.onCreate()

                MultiDex.install(this);

                val config = InitConfig.Builder()
//                        .setImgAdapter(FrescoImageAdapter()) //imageLib interface
                        .setHttpAdapter(InterceptWXHttpAdapter()) //network lib interface
                        .build()
                WXSDKEngine.initialize(this, config)

                /*try {
                        val myWeexModuleFactory = MyTypeModuleFactory.getInstance()
                        WXSDKEngine.registerModule<WXModule>(
                                "Shitab's Module",
                                myWeexModuleFactory, false
                        )
                } catch (e: WXException) {
                        Log.e("SHITABUGGER:Error", "${e.toString()}")

                }*/
        }


    /*override fun onCreate() {
        super.onCreate()
        *//**
         * Set up for fresco usage.
         * Set<RequestListener> requestListeners = new HashSet<>();
         * requestListeners.add(new RequestLoggingListener());
         * ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
         * .setRequestListeners(requestListeners)
         * .build();
         * Fresco.initialize(this,config);
        </RequestListener> *//*
//    initDebugEnvironment(true, false, "DEBUG_SERVER_HOST");
        WXBridgeManager.updateGlobalConfig("wson_on")
        WXEnvironment.setOpenDebugLog(true)
        WXEnvironment.setApkDebugable(true)
        WXSDKEngine.addCustomOptions("appName", "WXSample")
        WXSDKEngine.addCustomOptions("appGroup", "WXApp")
        val builder =
            InitConfig.Builder() //.setImgAdapter(new FrescoImageAdapter())// use fresco adapter
//                .setImgAdapter(ImageAdapter())
//                .setDrawableLoader(PicassoBasedDrawableLoader(applicationContext))
//                .setWebSocketAdapterFactory(DefaultWebSocketAdapterFactory())
//                .setJSExceptionAdapter(JSExceptionAdapter())
                .setHttpAdapter(InterceptWXHttpAdapter())
                .setApmGenerater(ApmGenerator())
//        if (!TextUtils.isEmpty(BuildConfig.externalLibraryName)) {
//            builder.addNativeLibrary(BuildConfig.externalLibraryName)
//        }
        WXSDKManager.getInstance().wxConfigAdapter = DefaultConfigAdapter()
        WXSDKEngine.initialize(this, builder.build())
        WXSDKManager.getInstance().addWXAnalyzer(WXAnalyzerDemoListener())
        WXAnalyzerDataTransfer.isOpenPerformance = false
        WXSDKManager.getInstance().accessibilityRoleAdapter = DefaultAccessibilityRoleAdapter()
        try {
            Fresco.initialize(this)
            WXSDKEngine.registerComponent("synccomponent", WXComponentSyncTest::class.java)
//            WXSDKEngine.registerComponent(WXParallax.PARALLAX, WXParallax::class.java)
//            WXSDKEngine.registerModule("render", RenderModule::class.java)
//            WXSDKEngine.registerModule("event", WXEventModule::class.java)
//            WXSDKEngine.registerModule("syncTest", SyncTestModule::class.java)
            WXSDKEngine.registerComponent("mask", WXMask::class.java)
//            WXSDKEngine.registerModule("myModule", MyModule::class.java)
//            WXSDKEngine.registerModule("geolocation", GeolocationModule::class.java)
//            WXSDKEngine.registerModule("titleBar", WXTitleBar::class.java)
//            WXSDKEngine.registerModule("wsonTest", WXWsonTestModule::class.java)
            BindingX.register()
            *//**
             * override default image tag
             * WXSDKEngine.registerComponent("image", FrescoImageComponent.class);
             *//*

            //Typeface nativeFont = Typeface.createFromAsset(getAssets(), "font/native_font.ttf");
            //WXEnvironment.setGlobalFontFamily("bolezhusun", nativeFont);
            startHeron()
        } catch (e: WXException) {
            e.printStackTrace()
        }
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {}
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {
                // The demo code of calling 'notifyTrimMemory()'
                if (false) {
                    // We assume that the application is on an idle time.
                    WXSDKManager.getInstance().notifyTrimMemory()
                }
                // The demo code of calling 'notifySerializeCodeCache()'
                if (false) {
                    WXSDKManager.getInstance().notifySerializeCodeCache()
                }
            }
        })
    }

    *//**
     * @param connectable debug server is connectable or not.
     * if true, sdk will try to connect remote debug server when init WXBridge.
     *
     * @param debuggable enable remote debugger. valid only if host not to be "DEBUG_SERVER_HOST".
     * true, you can launch a remote debugger and inspector both.
     * false, you can  just launch a inspector.
     * @param host the debug server host, must not be "DEBUG_SERVER_HOST", a ip address or domain will be OK.
     * for example "127.0.0.1".
     *//*
    private fun initDebugEnvironment(connectable: Boolean, debuggable: Boolean, host: String) {
        if ("DEBUG_SERVER_HOST" != host) {
            WXEnvironment.sDebugServerConnectable = connectable
            WXEnvironment.sRemoteDebugMode = debuggable
            WXEnvironment.sRemoteDebugProxyUrl = "ws://$host:8088/debugProxy/native"
        }
    }

    private fun startHeron() {
        try {
            val heronInitClass =
                classLoader.loadClass("com/taobao/weex/heron/picasso/RenderPicassoInit")
            val method: Method =
                heronInitClass.getMethod("initApplication", Application::class.java)
            method.isAccessible = true
            method.invoke(null, this)
            Log.e("Weex", "Weex Heron Render Init Success")
        } catch (e: Exception) {
            Log.e("Weex", "Weex Heron Render Mode Not Found", e)
        }
    }*/

}