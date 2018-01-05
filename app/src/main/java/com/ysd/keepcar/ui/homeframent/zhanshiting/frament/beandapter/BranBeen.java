package com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter;

import java.util.List;

/**
 * Created by dell on 2018/1/5.
 */

public class BranBeen {


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"initKey":"A","key":null,"value":null,"price":null,"brandList":[{"key":"219","k":"A","value":"一汽-大众奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"228","k":"A","value":"进口奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"255","k":"A","value":"进口Audi Sport","logo":"/upload/static/carbrand/1.png"},{"key":"40000","k":"A","value":"一汽-大众奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"40002","k":"A","value":"进口奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"259","k":"A","value":"进口阿斯顿·马丁","logo":"/upload/static/carbrand/2.png"},{"key":"271","k":"A","value":"进口阿尔法·罗密欧","logo":"/upload/static/carbrand/3.png"},{"key":"277","k":"A","value":"进口AC Schnitzer","logo":"/upload/static/carbrand/4.png"},{"key":"282","k":"A","value":"进口Artega","logo":"/upload/static/carbrand/5.png"},{"key":"284","k":"A","value":"奥克斯","logo":"/upload/static/carbrand/6.png"},{"key":"33848","k":"A","value":"进口阿尔特","logo":"/upload/static/carbrand/33690.png"},{"key":"33875","k":"A","value":"进口ALPINA","logo":"/upload/static/carbrand/33702.png"}]},{"initKey":"B","key":null,"value":null,"price":null,"brandList":[{"key":"287","k":"B","value":"东风本田","logo":"/upload/static/carbrand/7.png"},{"key":"296","k":"B","value":"广汽本田","logo":"/upload/static/carbrand/7.png"},{"key":"306","k":"B","value":"进口本田","logo":"/upload/static/carbrand/7.png"},{"key":"320","k":"B","value":"上汽通用别克","logo":"/upload/static/carbrand/8.png"},{"key":"337","k":"B","value":"进口别克","logo":"/upload/static/carbrand/8.png"},{"key":"341","k":"B","value":"北京奔驰","logo":"/upload/static/carbrand/9.png"},{"key":"347","k":"B","value":"福建奔驰","logo":"/upload/static/carbrand/9.png"},{"key":"352","k":"B","value":"进口奔驰","logo":"/upload/static/carbrand/9.png"},{"key":"383","k":"B","value":"进口梅赛德斯-AMG","logo":"/upload/static/carbrand/9.png"},{"key":"402","k":"B","value":"进口梅赛德斯-迈巴赫","logo":"/upload/static/carbrand/9.png"},{"key":"40013","k":"B","value":"进口奔驰新能源","logo":"/upload/static/carbrand/9.png"},{"key":"404","k":"B","value":"华晨宝马","logo":"/upload/static/carbrand/10.png"},{"key":"409","k":"B","value":"进口宝马","logo":"/upload/static/carbrand/10.png"},{"key":"433","k":"B","value":"进口宝马M","logo":"/upload/static/carbrand/10.png"},{"key":"40015","k":"B","value":"华晨宝马新能源","logo":"/upload/static/carbrand/10.png"},{"key":"40020","k":"B","value":"进口宝马新能源","logo":"/upload/static/carbrand/10.png"},{"key":"442","k":"B","value":"比亚迪","logo":"/upload/static/carbrand/11.png"},{"key":"40024","k":"B","value":"比亚迪新能源","logo":"/upload/static/carbrand/11.png"},{"key":"468","k":"B","value":"上汽通用五菱","logo":"/upload/static/carbrand/12.png"},{"key":"476","k":"B","value":"东风标致","logo":"/upload/static/carbrand/13.png"},{"key":"489","k":"B","value":"广州标致","logo":"/upload/static/carbrand/13.png"},{"key":"491","k":"B","value":"进口标致","logo":"/upload/static/carbrand/13.png"},{"key":"515","k":"B","value":"北汽幻速","logo":"/upload/static/carbrand/14.png"},{"key":"523","k":"B","value":"进口保时捷","logo":"/upload/static/carbrand/15.png"},{"key":"40031","k":"B","value":"进口保时捷新能源","logo":"/upload/static/carbrand/15.png"},{"key":"531","k":"B","value":"北汽绅宝","logo":"/upload/static/carbrand/16.png"},{"key":"544","k":"B","value":"一汽奔腾","logo":"/upload/static/carbrand/17.png"},{"key":"550","k":"B","value":"北京汽车","logo":"/upload/static/carbrand/18.png"},{"key":"558","k":"B","value":"北汽威旺","logo":"/upload/static/carbrand/19.png"},{"key":"566","k":"B","value":"北汽制造","logo":"/upload/static/carbrand/20.png"},{"key":"581","k":"B","value":"进口宾利","logo":"/upload/static/carbrand/21.png"}]}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * initKey : A
         * key : null
         * value : null
         * price : null
         * brandList : [{"key":"219","k":"A","value":"一汽-大众奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"228","k":"A","value":"进口奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"255","k":"A","value":"进口Audi Sport","logo":"/upload/static/carbrand/1.png"},{"key":"40000","k":"A","value":"一汽-大众奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"40002","k":"A","value":"进口奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"259","k":"A","value":"进口阿斯顿·马丁","logo":"/upload/static/carbrand/2.png"},{"key":"271","k":"A","value":"进口阿尔法·罗密欧","logo":"/upload/static/carbrand/3.png"},{"key":"277","k":"A","value":"进口AC Schnitzer","logo":"/upload/static/carbrand/4.png"},{"key":"282","k":"A","value":"进口Artega","logo":"/upload/static/carbrand/5.png"},{"key":"284","k":"A","value":"奥克斯","logo":"/upload/static/carbrand/6.png"},{"key":"33848","k":"A","value":"进口阿尔特","logo":"/upload/static/carbrand/33690.png"},{"key":"33875","k":"A","value":"进口ALPINA","logo":"/upload/static/carbrand/33702.png"}]
         */

        private String initKey;
        private Object key;
        private Object value;
        private Object price;
        private List<BrandListBean> brandList;

        public String getInitKey() {
            return initKey;
        }

        public void setInitKey(String initKey) {
            this.initKey = initKey;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public List<BrandListBean> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<BrandListBean> brandList) {
            this.brandList = brandList;
        }

        public static class BrandListBean {
            /**
             * key : 219
             * k : A
             * value : 一汽-大众奥迪
             * logo : /upload/static/carbrand/1.png
             */

            private String key;
            private String k;
            private String value;
            private String logo;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getK() {
                return k;
            }

            public void setK(String k) {
                this.k = k;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }
    }
}
