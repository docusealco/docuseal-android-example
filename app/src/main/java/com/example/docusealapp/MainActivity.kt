package com.example.docusealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : ComponentActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        setupWebView()
        loadHtmlContent()
    }

    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }
        }
    }

    private fun loadHtmlContent() {
        val html = """
            <html>
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <script src="https://cdn.docuseal.co/js/form.js"></script>
                </head>
                <body>
                    <docuseal-form
                        id="docusealForm"
                        data-src="https://docuseal.co/d/LEVGR9rhZYf86M"
                        data-email="signer@example.com">
                    </docuseal-form>
                </body>
            </html>
        """
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)
    }
}
