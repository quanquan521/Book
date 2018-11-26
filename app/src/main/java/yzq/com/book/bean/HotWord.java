package yzq.com.book.bean;
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
 * 创建日期：on 2018/11/26.
 *
 * 描述：
 *
 *
 */
public class HotWord {

    /**
     * hotWords : ["神厨狂后","一世狂兵","农家小皇妃"," 百炼飞升录","都市之最强狂兵","夜少的二婚新妻","撩爱上瘾：总裁万万睡","画骨女仵作","透视医圣","武逆","暗夜深宠：老公，用力爱","穿越之兽世种田记","校花的全能保安","校花的贴身高手","天才萌宝鬼医娘亲","我的美女校长老婆","神印王座"]
     * newHotWords : [{"word":"神厨狂后","book":"59547894415a5973642e686a"},{"word":"一世狂兵","book":"5bbc585a279e1b0da1c798fb"},{"word":"农家小皇妃","book":"5b2390c461c5a840c920bf8b"},{"word":" 百炼飞升录","book":"529e48ab92303fb72301f529"},{"word":"都市之最强狂兵","book":"59305ea9eeecff1975986572"},{"word":"夜少的二婚新妻","book":"5ba0be03baf4690e4ef87c1f"},{"word":"撩爱上瘾：总裁万万睡","book":"59e03428c3aa10de76bf537c"},{"word":"画骨女仵作","book":"59b9b9d1b797812f5c192e4f"},{"word":"透视医圣","book":"571a00397e740345774a4910"},{"word":"武逆","book":"508a2b97f5cf27d115000006"},{"word":"暗夜深宠：老公，用力爱","book":"59fbd9cc23f360362d530739"},{"word":"穿越之兽世种田记","book":"593bdeb4e9c28dbc3900f400"},{"word":"校花的全能保安","book":"58f10c8c50c1a53b441be95c"},{"word":"校花的贴身高手","book":"5a7ab807ae439b2e9328803c"},{"word":"天才萌宝鬼医娘亲","book":"582d43e475b75cee63e3dc82"},{"word":"我的美女校长老婆","book":"583501fed28241ca2ad1109e"},{"word":"神印王座","book":"595b03596db8c7bb1658c3fd"}]
     * ok : true
     */

    private boolean ok;
    private List<String> hotWords;
    private List<NewHotWordsBean> newHotWords;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }

    public List<NewHotWordsBean> getNewHotWords() {
        return newHotWords;
    }

    public void setNewHotWords(List<NewHotWordsBean> newHotWords) {
        this.newHotWords = newHotWords;
    }

    public static class NewHotWordsBean {
        /**
         * word : 神厨狂后
         * book : 59547894415a5973642e686a
         */

        private String word;
        private String book;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }
    }
}
