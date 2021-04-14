package com.newcheckstop.testproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.HashMap;

public class WebViewButtonActivity extends AppCompatActivity {

    private WebView mWebView;
    private ProgressBar mProgressBar;

    public class TestJSEvent{

        @JavascriptInterface
        public void showToash(String toast){
            Log.i("WebViewButtonActivity","showToash");
            Toast.makeText(WebViewButtonActivity.this,toast,Toast.LENGTH_LONG).show();
        };
    }
    @SuppressLint({"SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_button);

        mProgressBar = (ProgressBar) findViewById(R.id.webview_progressBar);

        mWebView = (WebView) findViewById(R.id.web_view);
        //打开调试,详细见腾讯文档
        WebView.setWebContentsDebuggingEnabled(true);

        //设置head
        HashMap<String,String> headMap = new HashMap<>();
        headMap.put("token","123456");
        mWebView.loadUrl("https://www.baidu.com",headMap);
//        mWebView.loadUrl("https://www.baidu.com");
//        mWebView.loadUrl("file:///android_asset/dist/index.html#/map?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTg0NTEwNTAsImlzcyI6IldvSWtnUzRvMjVPeFdtYkhscXpvUXVZdDZXbDlqc0NiIn0.AOIcpmIQz3rZ9pd3dvNabWxqb244JoTTTYNbkE_Tz9o&map=GaoDe.Normal.Map&lon=113.738488&lat=23.016659&range=1500");
        //cookie设置
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("domain","cookie");
        cookieManager.removeAllCookie();


        mWebView.getSettings().setDomStorageEnabled(true);

        mWebView.getSettings().setJavaScriptEnabled(true);

        // JS调用原生APP
        mWebView.addJavascriptInterface(new TestJSEvent(),"TestFirstApp");



        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if(url.contains("404")){
//                    view.loadUrl("http://www.zhihu.com");
//                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //页面开始加载。加载Loading动画
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //页面加载结束。隐藏Loading动画
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                //url 替换
                if(url.contains("logo.png"))
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override
            public void onFormResubmission(WebView view, Message dontResend, Message resend) {
                super.onFormResubmission(view, dontResend, resend);
            }

            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                super.doUpdateVisitedHistory(view, url, isReload);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient(){

            //进度条
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setProgress(newProgress);
                if(newProgress == 100 ){
                    mProgressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                //获取网页title
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                super.onReceivedTouchIconUrl(view, url, precomposed);
            }

            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }

            @Override
            public void onCloseWindow(WebView window) {
                super.onCloseWindow(window);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                return super.onJsBeforeUnload(view, url, message, result);
            }

            @Override
            public void onPermissionRequest(PermissionRequest request) {
                super.onPermissionRequest(request);
            }

            @Override
            public void onPermissionRequestCanceled(PermissionRequest request) {
                super.onPermissionRequestCanceled(request);
            }

            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mWebView != null && mWebView.canGoBack()){
            //导航
            WebBackForwardList webBackForwardList = mWebView.copyBackForwardList();
            WebHistoryItem historyItem = webBackForwardList.getItemAtIndex(0);
            String historyUrl = historyItem.getUrl();
            //历史记录
            mWebView.goBack();
            //前进
            mWebView.goForward();
            //前进或后退
            mWebView.goBackOrForward(1);
            //刷新
            mWebView.reload();
        }else{
            super.onBackPressed();
        }

    }
}