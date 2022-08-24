package smir.shitab14.weexdemo.mywidgets

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import org.apache.weex.IWXRenderListener
import org.apache.weex.RenderContainer
import org.apache.weex.WXSDKInstance
import org.apache.weex.common.WXRenderStrategy

/**
 * Created by Shitab Mir on 24 August, 2022.
 * HungryNaki (Technology), Daraz Bangladesh Limited, Alibaba Group
 * mushfiq.islam@hungrynaki.com | shitabmir@gmail.com
 **/
class MasterFrameLayout(context: Context, attrs: AttributeSet) : FrameLayout(context) {
    private var renderContainer: RenderContainer? = null
    private val renderContainerLayoutChangeListener =
        OnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            renderContainer?.let {
                //                WeexResizeHack.fixWeexViewSize(it, false, true)
            }
        }
    private var mWXSDKInstance: WXSDKInstance? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        renderContainer = RenderContainer(context)
        renderContainer?.addOnLayoutChangeListener(renderContainerLayoutChangeListener)
        addView(renderContainer)
        mWXSDKInstance = WXSDKInstance(context).apply {
            Log.e("SHITABUGGER", this.bundleUrl.toString())
            setRenderContainer(renderContainer)
        }
        mWXSDKInstance?.registerRenderListener(object: IWXRenderListener {

            // IWXRenderListener methods
            override fun onViewCreated(p0: WXSDKInstance?, p1: View?) {

                Log.e("SHITABUGGER", "onViewCreated")
            }

            override fun onRenderSuccess(p0: WXSDKInstance?, p1: Int, p2: Int) {
                Log.e("SHITABUGGER", "onRenderSuccess")
            }

            override fun onRefreshSuccess(p0: WXSDKInstance?, p1: Int, p2: Int) {
                Log.e("SHITABUGGER", "onRefreshSuccess")
            }

            override fun onException(p0: WXSDKInstance?, p1: String?, p2: String?) {
                Log.e("SHITABUGGER", "BundleUrl: ${p0?.bundleUrl} Param01:${p1.toString()} Param02:${p2.toString()}")

            }
        })
        /**
         * bundleUrl source http://dotwe.org/vue/38e202c16bdfefbdb88a8754f975454c
         */
        val pageName = "WXSample"
//        val bundleUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_light_color_92x30dp.png"
        val bundleUrl = "http://dotwe.org/vue/66e5e8627346e37f94bda0e5a28834ef"
//        val bundleUrl = "http://dotwe.org/raw/dist/38e202c16bdfefbdb88a8754f975454c.bundle.wx"
        mWXSDKInstance?.renderByUrl(pageName, bundleUrl, null, null, WXRenderStrategy.APPEND_ASYNC)
    }

    override fun onDetachedFromWindow() {
        mWXSDKInstance?.destroy()
        mWXSDKInstance?.registerRenderListener(null)
        mWXSDKInstance = null
        super.onDetachedFromWindow()
    }

}