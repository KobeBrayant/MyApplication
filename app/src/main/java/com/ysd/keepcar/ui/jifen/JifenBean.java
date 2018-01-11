package com.ysd.keepcar.ui.jifen;

import java.util.List;

/**
 * Created by dell on 2018/1/11.
 */

public class JifenBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":3,"list":[{"productType":"余额券","code":"CCCCCCC","integralValue":10,"salesNum":3,"shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","poster":"海报照片","productName":"我的余额券测试","exchangeLimitMax":null,"detail":"描述详情富文本","storeTotalAmount":null,"discountContent":null,"isShowMemberFlag":"1"},{"productType":"项目","code":"RSIP8C29C2ABFB0842C7836F6A1A70C497C9","integralValue":150,"salesNum":1,"shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","poster":"12","productName":"积分商城01勿动","exchangeLimitMax":null,"detail":"详情","storeTotalAmount":null,"discountContent":null,"isShowMemberFlag":"1"},{"productType":"项目","code":"RSIPAC458056E44D49568EBB49387A0AA56C","integralValue":200,"salesNum":1,"shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","poster":"12","productName":"积分商城02勿动","exchangeLimitMax":null,"detail":"详情","storeTotalAmount":null,"discountContent":null,"isShowMemberFlag":"1"}],"pages":1}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 3
         * list : [{"productType":"余额券","code":"CCCCCCC","integralValue":10,"salesNum":3,"shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","poster":"海报照片","productName":"我的余额券测试","exchangeLimitMax":null,"detail":"描述详情富文本","storeTotalAmount":null,"discountContent":null,"isShowMemberFlag":"1"},{"productType":"项目","code":"RSIP8C29C2ABFB0842C7836F6A1A70C497C9","integralValue":150,"salesNum":1,"shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","poster":"12","productName":"积分商城01勿动","exchangeLimitMax":null,"detail":"详情","storeTotalAmount":null,"discountContent":null,"isShowMemberFlag":"1"},{"productType":"项目","code":"RSIPAC458056E44D49568EBB49387A0AA56C","integralValue":200,"salesNum":1,"shopName":"一汽大众\u2014北京昌平分店","shopCode":"SHOP00000010","poster":"12","productName":"积分商城02勿动","exchangeLimitMax":null,"detail":"详情","storeTotalAmount":null,"discountContent":null,"isShowMemberFlag":"1"}]
         * pages : 1
         */

        private int total;
        private int pages;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * productType : 余额券
             * code : CCCCCCC
             * integralValue : 10.0
             * salesNum : 3.0
             * shopName : 一汽大众—北京昌平分店
             * shopCode : SHOP00000010
             * poster : 海报照片
             * productName : 我的余额券测试
             * exchangeLimitMax : null
             * detail : 描述详情富文本
             * storeTotalAmount : null
             * discountContent : null
             * isShowMemberFlag : 1
             */

            private String productType;
            private String code;
            private double integralValue;
            private double salesNum;
            private String shopName;
            private String shopCode;
            private String poster;
            private String productName;
            private Object exchangeLimitMax;
            private String detail;
            private Object storeTotalAmount;
            private Object discountContent;
            private String isShowMemberFlag;

            public String getProductType() {
                return productType;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public double getIntegralValue() {
                return integralValue;
            }

            public void setIntegralValue(double integralValue) {
                this.integralValue = integralValue;
            }

            public double getSalesNum() {
                return salesNum;
            }

            public void setSalesNum(double salesNum) {
                this.salesNum = salesNum;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopCode() {
                return shopCode;
            }

            public void setShopCode(String shopCode) {
                this.shopCode = shopCode;
            }

            public String getPoster() {
                return poster;
            }

            public void setPoster(String poster) {
                this.poster = poster;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public Object getExchangeLimitMax() {
                return exchangeLimitMax;
            }

            public void setExchangeLimitMax(Object exchangeLimitMax) {
                this.exchangeLimitMax = exchangeLimitMax;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public Object getStoreTotalAmount() {
                return storeTotalAmount;
            }

            public void setStoreTotalAmount(Object storeTotalAmount) {
                this.storeTotalAmount = storeTotalAmount;
            }

            public Object getDiscountContent() {
                return discountContent;
            }

            public void setDiscountContent(Object discountContent) {
                this.discountContent = discountContent;
            }

            public String getIsShowMemberFlag() {
                return isShowMemberFlag;
            }

            public void setIsShowMemberFlag(String isShowMemberFlag) {
                this.isShowMemberFlag = isShowMemberFlag;
            }
        }
    }
}
