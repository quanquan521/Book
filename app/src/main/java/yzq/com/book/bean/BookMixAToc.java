/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yzq.com.book.bean;
import java.io.Serializable;
import java.util.List;

/**
 * @author lfh.
 * @date 2016/8/7.
 */
public class BookMixAToc extends Base {

    /**
     * _id:577e528e2160421a02d7380d
     * name:优质书源
     * link:http://vip.zhuishushenqi.com/toc/577e528e2160421a02d7380d
     */
    public mixToc mixToc;
    public static class mixToc implements Serializable {
        public String book_id;
        public String book;
        public String chaptersUpdated;
        /**
         * title : 第一章 死在万花丛中
         * link : http://vip.zhuishushenqi.com/chapter/577e5290260289ff64a29213?cv=1467896464908
         * id : 577e5290260289ff64a29213
         * currency : 15
         * unreadble : false
         * isVip : false
         */

        public List<Chapters> chapters;//章节

        public static class Chapters implements Serializable {
            public String title;//章节标题
            public String link;//章节链接
            public String id;//章节id
            public int currency;//章节价格
            public boolean unreadble;//是否读过
            public boolean isVip;//是否是vip

            public Chapters() {
            }

            public Chapters(String title, String link) {
                this.title = title;
                this.link = link;
            }
        }
    }

}
