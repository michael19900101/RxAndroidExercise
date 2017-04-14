package com.example.aotuman.rxandroidexercise.CartMegerRxAndRetrofit.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/4/2.
 */
public class NetBean {

    @SerializedName("args")
    private ArgsBean _$Args257; // FIXME check this code
    private HeadersBean headers;
    private String origin;
    private String url;

    public ArgsBean get_$Args257() {
        return _$Args257;
    }

    public void set_$Args257(ArgsBean _$Args257) {
        this._$Args257 = _$Args257;
    }

    public HeadersBean getHeaders() {
        return headers;
    }

    public void setHeaders(HeadersBean headers) {
        this.headers = headers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class ArgsBean {
        private String shopName;

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }
    }

    public static class HeadersBean {
        @SerializedName("Accept")
        private String _$Accept42; // FIXME check this code
        @SerializedName("Accept-Encoding")
        private String AcceptEncoding;
        @SerializedName("Accept-Language")
        private String AcceptLanguage;
        private String Connection;
        private String Cookie;
        private String Host;
        @SerializedName("Upgrade-Insecure-Requests")
        private String UpgradeInsecureRequests;
        @SerializedName("User-Agent")
        private String UserAgent;

        public String get_$Accept42() {
            return _$Accept42;
        }

        public void set_$Accept42(String _$Accept42) {
            this._$Accept42 = _$Accept42;
        }

        public String getAcceptEncoding() {
            return AcceptEncoding;
        }

        public void setAcceptEncoding(String AcceptEncoding) {
            this.AcceptEncoding = AcceptEncoding;
        }

        public String getAcceptLanguage() {
            return AcceptLanguage;
        }

        public void setAcceptLanguage(String AcceptLanguage) {
            this.AcceptLanguage = AcceptLanguage;
        }

        public String getConnection() {
            return Connection;
        }

        public void setConnection(String Connection) {
            this.Connection = Connection;
        }

        public String getCookie() {
            return Cookie;
        }

        public void setCookie(String Cookie) {
            this.Cookie = Cookie;
        }

        public String getHost() {
            return Host;
        }

        public void setHost(String Host) {
            this.Host = Host;
        }

        public String getUpgradeInsecureRequests() {
            return UpgradeInsecureRequests;
        }

        public void setUpgradeInsecureRequests(String UpgradeInsecureRequests) {
            this.UpgradeInsecureRequests = UpgradeInsecureRequests;
        }

        public String getUserAgent() {
            return UserAgent;
        }

        public void setUserAgent(String UserAgent) {
            this.UserAgent = UserAgent;
        }
    }
}
