package yzq.com.book.ui.booklist.bean;
/**
 * Created by 无敌小圈圈
 */

import java.util.List;

/**
 *
 * 版权： 版权所有
 *
 * 作者：无敌小圈圈
 *
 * 版本：1.0
 *
 * 创建日期：on 2018/10/31.
 *
 * 描述：
 *
 *
 */
public class BookBean {

    /**
     * code : 200
     * msg : 访问成功！
     * time : 1540957725356
     * data : [{"id":1,"name":"Java","img":"http://120.78.65.69:8080/Book/images/java.jpg"},{"id":2,"name":"Adroid","img":null}]
     */

    private String code;
    private String msg;
    private long time;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : Java
         * img : http://120.78.65.69:8080/Book/images/java.jpg
         */

        private int book_id;
        private String book;
        private String img;

        public int getId() {
            return book_id;
        }

        public void setId(int id) {
            this.book_id = id;
        }

        public String getName() {
            return book;
        }

        public void setName(String name) {
            this.book = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
