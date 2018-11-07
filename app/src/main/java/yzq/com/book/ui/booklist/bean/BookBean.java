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
     * time : 1541234010793
     * data : [{"book_id":3,"sort_id":0,"img":"http://120.78.65.69:8080/Book/images/net.jpg","book":"军少霸宠二婚妻","chaptersUpdated":null,"chapters":null}]
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
         * book_id : 3
         * sort_id : 0
         * img : http://120.78.65.69:8080/Book/images/net.jpg
         * book : 军少霸宠二婚妻
         * chaptersUpdated : null
         * chapters : null
         */

        private int book_id;
        private int sort_id;
        private String img;
        private String book;
        private Object chaptersUpdated;
        private Object chapters;

        public int getBook_id() {
            return book_id;
        }

        public void setBook_id(int book_id) {
            this.book_id = book_id;
        }

        public int getSort_id() {
            return sort_id;
        }

        public void setSort_id(int sort_id) {
            this.sort_id = sort_id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public Object getChaptersUpdated() {
            return chaptersUpdated;
        }

        public void setChaptersUpdated(Object chaptersUpdated) {
            this.chaptersUpdated = chaptersUpdated;
        }

        public Object getChapters() {
            return chapters;
        }

        public void setChapters(Object chapters) {
            this.chapters = chapters;
        }
    }
}
