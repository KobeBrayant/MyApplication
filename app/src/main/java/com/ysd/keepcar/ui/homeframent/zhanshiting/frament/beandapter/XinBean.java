package com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter;

import java.util.List;

/**
 * Created by dell on 2018/1/11.
 */

public class XinBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":1357,"list":[{"poster":"/upload/static/carbrand/220.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"220","seriesName":"奥迪A3","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":18.49,"maxPrice":29.67,"buyDate":null},{"poster":"/upload/static/carbrand/224.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"224","seriesName":"奥迪Q5","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":35.85,"maxPrice":57.17,"buyDate":null},{"poster":"/upload/static/carbrand/221.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"221","seriesName":"奥迪A4L","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":27.1,"maxPrice":57.81,"buyDate":null},{"poster":"/upload/static/carbrand/222.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"222","seriesName":"奥迪A6L","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":85.63,"buyDate":null},{"poster":"/upload/static/carbrand/223.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"223","seriesName":"奥迪Q3","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":42.88,"buyDate":null},{"poster":"/upload/static/carbrand/230.png","brandId":"228","brandName":"进口奥迪","seriesId":"230","seriesName":"奥迪A3(进口)","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":25.5,"maxPrice":36.98,"buyDate":null},{"poster":"/upload/static/carbrand/231.png","brandId":"228","brandName":"进口奥迪","seriesId":"231","seriesName":"A3 e-tron","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":null,"maxPrice":null,"buyDate":null},{"poster":"/upload/static/carbrand/241.png","brandId":"228","brandName":"进口奥迪","seriesId":"241","seriesName":"奥迪Q5(进口)","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":67.8,"buyDate":null},{"poster":"/upload/static/carbrand/229.png","brandId":"228","brandName":"进口奥迪","seriesId":"229","seriesName":"奥迪A1","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":19.98,"maxPrice":31.18,"buyDate":null},{"poster":"/upload/static/carbrand/235.png","brandId":"228","brandName":"进口奥迪","seriesId":"235","seriesName":"奥迪A6","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":82,"buyDate":null}],"pages":136}
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
         * total : 1357
         * list : [{"poster":"/upload/static/carbrand/220.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"220","seriesName":"奥迪A3","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":18.49,"maxPrice":29.67,"buyDate":null},{"poster":"/upload/static/carbrand/224.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"224","seriesName":"奥迪Q5","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":35.85,"maxPrice":57.17,"buyDate":null},{"poster":"/upload/static/carbrand/221.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"221","seriesName":"奥迪A4L","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":27.1,"maxPrice":57.81,"buyDate":null},{"poster":"/upload/static/carbrand/222.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"222","seriesName":"奥迪A6L","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":85.63,"buyDate":null},{"poster":"/upload/static/carbrand/223.png","brandId":"219","brandName":"一汽-大众奥迪","seriesId":"223","seriesName":"奥迪Q3","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":42.88,"buyDate":null},{"poster":"/upload/static/carbrand/230.png","brandId":"228","brandName":"进口奥迪","seriesId":"230","seriesName":"奥迪A3(进口)","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":25.5,"maxPrice":36.98,"buyDate":null},{"poster":"/upload/static/carbrand/231.png","brandId":"228","brandName":"进口奥迪","seriesId":"231","seriesName":"A3 e-tron","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":null,"maxPrice":null,"buyDate":null},{"poster":"/upload/static/carbrand/241.png","brandId":"228","brandName":"进口奥迪","seriesId":"241","seriesName":"奥迪Q5(进口)","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":67.8,"buyDate":null},{"poster":"/upload/static/carbrand/229.png","brandId":"228","brandName":"进口奥迪","seriesId":"229","seriesName":"奥迪A1","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":19.98,"maxPrice":31.18,"buyDate":null},{"poster":"/upload/static/carbrand/235.png","brandId":"228","brandName":"进口奥迪","seriesId":"235","seriesName":"奥迪A6","modelName":null,"num":0,"currentPrice":null,"newCarPrice":null,"code":null,"minPrice":0,"maxPrice":82,"buyDate":null}]
         * pages : 136
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
             * poster : /upload/static/carbrand/220.png
             * brandId : 219
             * brandName : 一汽-大众奥迪
             * seriesId : 220
             * seriesName : 奥迪A3
             * modelName : null
             * num : 0.0
             * currentPrice : null
             * newCarPrice : null
             * code : null
             * minPrice : 18.49
             * maxPrice : 29.67
             * buyDate : null
             */

            private String poster;
            private String brandId;
            private String brandName;
            private String seriesId;
            private String seriesName;
            private Object modelName;
            private double num;
            private Object currentPrice;
            private Object newCarPrice;
            private Object code;
            private double minPrice;
            private double maxPrice;
            private Object buyDate;

            public String getPoster() {
                return poster;
            }

            public void setPoster(String poster) {
                this.poster = poster;
            }

            public String getBrandId() {
                return brandId;
            }

            public void setBrandId(String brandId) {
                this.brandId = brandId;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getSeriesId() {
                return seriesId;
            }

            public void setSeriesId(String seriesId) {
                this.seriesId = seriesId;
            }

            public String getSeriesName() {
                return seriesName;
            }

            public void setSeriesName(String seriesName) {
                this.seriesName = seriesName;
            }

            public Object getModelName() {
                return modelName;
            }

            public void setModelName(Object modelName) {
                this.modelName = modelName;
            }

            public double getNum() {
                return num;
            }

            public void setNum(double num) {
                this.num = num;
            }

            public Object getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(Object currentPrice) {
                this.currentPrice = currentPrice;
            }

            public Object getNewCarPrice() {
                return newCarPrice;
            }

            public void setNewCarPrice(Object newCarPrice) {
                this.newCarPrice = newCarPrice;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
            }

            public double getMinPrice() {
                return minPrice;
            }

            public void setMinPrice(double minPrice) {
                this.minPrice = minPrice;
            }

            public double getMaxPrice() {
                return maxPrice;
            }

            public void setMaxPrice(double maxPrice) {
                this.maxPrice = maxPrice;
            }

            public Object getBuyDate() {
                return buyDate;
            }

            public void setBuyDate(Object buyDate) {
                this.buyDate = buyDate;
            }
        }
    }
}
