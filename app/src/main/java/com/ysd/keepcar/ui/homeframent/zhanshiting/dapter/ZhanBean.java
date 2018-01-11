package com.ysd.keepcar.ui.homeframent.zhanshiting.dapter;

import java.util.List;

/**
 * Created by dell on 2018/1/11.
 */

public class ZhanBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":1,"list":[{"poster":"/upload/P01/P01001/P01_P01001_M011_SHOP00000010_5B6761F33C9D411CBEF764AB222BF8BD.jpg","brandName":"大众","seriesName":"捷达","modelName":"2008款 CIF 1.6L 手动都市春天基本型LPG两用燃料","num":0,"currentPrice":10000,"newCarPrice":0,"code":"BCSHE1A1BCDC950B4C70A330D8F9493D0F2E","buyDate":"2017-12"}],"pages":1}
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
         * total : 1
         * list : [{"poster":"/upload/P01/P01001/P01_P01001_M011_SHOP00000010_5B6761F33C9D411CBEF764AB222BF8BD.jpg","brandName":"大众","seriesName":"捷达","modelName":"2008款 CIF 1.6L 手动都市春天基本型LPG两用燃料","num":0,"currentPrice":10000,"newCarPrice":0,"code":"BCSHE1A1BCDC950B4C70A330D8F9493D0F2E","buyDate":"2017-12"}]
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
             * poster : http://39.106.173.47:8080/saas-img/upload/P01/P01001/P01_P01001_M011_SHOP00000010_5B6761F33C9D411CBEF764AB222BF8BD.jpg
             * brandName : 大众
             * seriesName : 捷达
             * modelName : 2008款 CIF 1.6L 手动都市春天基本型LPG两用燃料
             * num : 0.0
             * currentPrice : 10000.0
             * newCarPrice : 0.0
             * code : BCSHE1A1BCDC950B4C70A330D8F9493D0F2E
             * buyDate : 2017-12
             */

            private String poster;
            private String brandName;
            private String seriesName;
            private String modelName;
            private double num;
            private double currentPrice;
            private double newCarPrice;
            private String code;
            private String buyDate;

            public String getPoster() {
                return poster;
            }

            public void setPoster(String poster) {
                this.poster = poster;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getSeriesName() {
                return seriesName;
            }

            public void setSeriesName(String seriesName) {
                this.seriesName = seriesName;
            }

            public String getModelName() {
                return modelName;
            }

            public void setModelName(String modelName) {
                this.modelName = modelName;
            }

            public double getNum() {
                return num;
            }

            public void setNum(double num) {
                this.num = num;
            }

            public double getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(double currentPrice) {
                this.currentPrice = currentPrice;
            }

            public double getNewCarPrice() {
                return newCarPrice;
            }

            public void setNewCarPrice(double newCarPrice) {
                this.newCarPrice = newCarPrice;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getBuyDate() {
                return buyDate;
            }

            public void setBuyDate(String buyDate) {
                this.buyDate = buyDate;
            }
        }
    }
}
