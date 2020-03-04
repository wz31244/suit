package com.example.suit.model.apis;

import java.util.List;

public class HomeBean {

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BannerBean> banner;
        private List<ChannelBean> channel;
        private List<NewGoodsListBean> newGoodsList;
        private List<HotGoodsListBean> hotGoodsList;
        private List<BrandListBean> brandList;
        private List<TopicListBean> topicList;
        private List<CategoryListBean> categoryList;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<ChannelBean> getChannel() {
            return channel;
        }

        public void setChannel(List<ChannelBean> channel) {
            this.channel = channel;
        }

        public List<NewGoodsListBean> getNewGoodsList() {
            return newGoodsList;
        }

        public void setNewGoodsList(List<NewGoodsListBean> newGoodsList) {
            this.newGoodsList = newGoodsList;
        }

        public List<HotGoodsListBean> getHotGoodsList() {
            return hotGoodsList;
        }

        public void setHotGoodsList(List<HotGoodsListBean> hotGoodsList) {
            this.hotGoodsList = hotGoodsList;
        }

        public List<BrandListBean> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<BrandListBean> brandList) {
            this.brandList = brandList;
        }

        public List<TopicListBean> getTopicList() {
            return topicList;
        }

        public void setTopicList(List<TopicListBean> topicList) {
            this.topicList = topicList;
        }

        public List<CategoryListBean> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(List<CategoryListBean> categoryList) {
            this.categoryList = categoryList;
        }

        public static class BannerBean {
            /**
             * id : 1
             * ad_position_id : 1
             * media_type : 1
             * name : 合作 谁是你的菜
             * link :
             * image_url : http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg
             * content : 合作 谁是你的菜
             * end_time : 0
             * enabled : 1
             */

            private int id;
            private int ad_position_id;
            private int media_type;
            private String name;
            private String link;
            private String image_url;
            private String content;
            private int end_time;
            private int enabled;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAd_position_id() {
                return ad_position_id;
            }

            public void setAd_position_id(int ad_position_id) {
                this.ad_position_id = ad_position_id;
            }

            public int getMedia_type() {
                return media_type;
            }

            public void setMedia_type(int media_type) {
                this.media_type = media_type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }
        }

        public static class ChannelBean {
            /**
             * id : 1
             * name : 居家
             * url : /pages/category/category?id=1005000
             * icon_url : http://ac-3yr0g9cz.clouddn.com/c031ea3cf575f885cd1c.png
             * sort_order : 1
             */

            private int id;
            private String name;
            private String url;
            private String icon_url;
            private int sort_order;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }
        }

        public static class NewGoodsListBean {


            private int id;
            private String name;
            private String list_pic_url;
            private float retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public float getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(int retail_price) {
                this.retail_price = retail_price;
            }
        }

        public static class HotGoodsListBean {

            private int id;
            private String name;
            private String list_pic_url;
            private float retail_price;
            private String goods_brief;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public float getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(float retail_price) {
                this.retail_price = retail_price;
            }

            public String getGoods_brief() {
                return goods_brief;
            }

            public void setGoods_brief(String goods_brief) {
                this.goods_brief = goods_brief;
            }
        }

        public static class BrandListBean {

            private int id;
            private String name;
            private String list_pic_url;
            private String simple_desc;
            private String pic_url;
            private int sort_order;
            private int is_show;
            private float floor_price;
            private String app_list_pic_url;
            private int is_new;
            private String new_pic_url;
            private int new_sort_order;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getSimple_desc() {
                return simple_desc;
            }

            public void setSimple_desc(String simple_desc) {
                this.simple_desc = simple_desc;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }

            public int getIs_show() {
                return is_show;
            }

            public void setIs_show(int is_show) {
                this.is_show = is_show;
            }

            public float getFloor_price() {
                return floor_price;
            }

            public void setFloor_price(float floor_price) {
                this.floor_price = floor_price;
            }

            public String getApp_list_pic_url() {
                return app_list_pic_url;
            }

            public void setApp_list_pic_url(String app_list_pic_url) {
                this.app_list_pic_url = app_list_pic_url;
            }

            public int getIs_new() {
                return is_new;
            }

            public void setIs_new(int is_new) {
                this.is_new = is_new;
            }

            public String getNew_pic_url() {
                return new_pic_url;
            }

            public void setNew_pic_url(String new_pic_url) {
                this.new_pic_url = new_pic_url;
            }

            public int getNew_sort_order() {
                return new_sort_order;
            }

            public void setNew_sort_order(int new_sort_order) {
                this.new_sort_order = new_sort_order;
            }
        }

        public static class TopicListBean {
            /**
             * id : 314
             * title : 关爱他成长的每一个足迹
             * content : <img src="//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg">
             <img src="//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg">
             <img src="//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg">
             <img src="//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg">
             <img src="//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg">
             <img src="//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg">
             <img src="//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg">
             * avatar : https://yanxuan.nosdn.127.net/14943186689221563.png
             * item_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
             * subtitle : 专业运动品牌同厂，毛毛虫鞋买二送一
             * topic_category_id : 2
             * price_info : 0
             * read_count : 6.4k
             * scene_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
             * topic_template_id : 0
             * topic_tag_id : 0
             * sort_order : 1
             * is_show : 1
             */

            private int id;
            private String title;
            private String content;
            private String avatar;
            private String item_pic_url;
            private String subtitle;
            private int topic_category_id;
            private float price_info;
            private String read_count;
            private String scene_pic_url;
            private int topic_template_id;
            private int topic_tag_id;
            private int sort_order;
            private int is_show;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getItem_pic_url() {
                return item_pic_url;
            }

            public void setItem_pic_url(String item_pic_url) {
                this.item_pic_url = item_pic_url;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public int getTopic_category_id() {
                return topic_category_id;
            }

            public void setTopic_category_id(int topic_category_id) {
                this.topic_category_id = topic_category_id;
            }

            public float getPrice_info() {
                return price_info;
            }

            public void setPrice_info(float price_info) {
                this.price_info = price_info;
            }

            public String getRead_count() {
                return read_count;
            }

            public void setRead_count(String read_count) {
                this.read_count = read_count;
            }

            public String getScene_pic_url() {
                return scene_pic_url;
            }

            public void setScene_pic_url(String scene_pic_url) {
                this.scene_pic_url = scene_pic_url;
            }

            public int getTopic_template_id() {
                return topic_template_id;
            }

            public void setTopic_template_id(int topic_template_id) {
                this.topic_template_id = topic_template_id;
            }

            public int getTopic_tag_id() {
                return topic_tag_id;
            }

            public void setTopic_tag_id(int topic_tag_id) {
                this.topic_tag_id = topic_tag_id;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }

            public int getIs_show() {
                return is_show;
            }

            public void setIs_show(int is_show) {
                this.is_show = is_show;
            }
        }

        public static class CategoryListBean {

            private int id;
            private String name;
            private List<GoodsListBean> goodsList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<GoodsListBean> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBean> goodsList) {
                this.goodsList = goodsList;
            }

            public static class GoodsListBean {

                private int id;
                private String name;
                private String list_pic_url;
                private float retail_price;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getList_pic_url() {
                    return list_pic_url;
                }

                public void setList_pic_url(String list_pic_url) {
                    this.list_pic_url = list_pic_url;
                }

                public float getRetail_price() {
                    return retail_price;
                }

                public void setRetail_price(float retail_price) {
                    this.retail_price = retail_price;
                }
            }
        }
    }
}
