package yzq.com.book.ui.main.bean;
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
public class CategoryList {


    /**
     * male : [{"name":"玄幻","bookCount":554199,"monthlyCount":21326,"icon":"/icon/玄幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F1228859_d14f18e849b34420904ead54936e440a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2107590%2F2107590_2607eaf03b2542ba88e4b75ac96bb12c.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41584%2F41584_873f1d8b2f7a447a8c59f3573094db1b.jpg%2F"]},{"name":"奇幻","bookCount":62879,"monthlyCount":2041,"icon":"/icon/奇幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2328044%2F2328044_3077a625538f4ef29384ba71e7387736.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2229427%2F2229427_b89561dfb0ff476281e95642b63032e4.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1130743%2F1130743_42e9200c279a48b7a31001d363ba401c.jpg%2F"]},{"name":"武侠","bookCount":47889,"monthlyCount":1567,"icon":"/icon/武侠_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F682805%2F682805_ad98924f53e74138a50e69208bd579be.png%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F994219%2F994219_21eb3060590440f9b8fd0c73895b8728.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2214174%2F2214174_edf5c5b304aa4c628faf0994b7f04d9c.jpg%2F"]},{"name":"仙侠","bookCount":152633,"monthlyCount":7324,"icon":"/icon/仙侠_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2014980%2F2014980_4886fb1ed53f453a9a76005611a3310a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2126166%2F2126166_c1002339e5664d7bb1a536e2608fa599.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1188355%2F1188355_9989e2c949d147f0ac423da594a54b3f.jpg%2F"]},{"name":"都市","bookCount":380599,"monthlyCount":15638,"icon":"/icon/都市_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F857368%2F857368_8428516582234635819871b0dd5862e7.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2078208%2F2078208_c0b7721c06b744baa3883f514a113120.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F683354_f01a24b90d6a429c8c052614cc2d6ede.jpg%2F"]},{"name":"职场","bookCount":17830,"monthlyCount":877,"icon":"/icon/职场_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1159594%2F1159594_5a3bc597b4f94a76b8f615471563f6a8.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2324039%2F2324039_c8676697c9324ff6a32b23b0f2813bca.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F870182%2F870182_b5ea5060cf45469484c45df07da56a02.jpg%2F"]},{"name":"历史","bookCount":76861,"monthlyCount":2767,"icon":"/icon/历史_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2326717%2F2326717_fa135a1044fa4602854e9cbe2f0663d5.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2371361%2F2371361_7deb47a053ce4fc0a3f7e42ae72cf4d3.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2078199%2F2078199_242a8ffcc41a4482b150ea28aa962c92.jpg%2F"]},{"name":"军事","bookCount":16438,"monthlyCount":764,"icon":"/icon/军事_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2266163%2F2266163_7ffd0ca6a6544f5f90a557478d325ef3.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2405465%2F2405465_f5af4826bd8d4fbca23e64c0d1a22fa7.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1164563%2F1164563_ad4392e59bcf434eac97df5c71d1d3ad.jpg%2F"]},{"name":"游戏","bookCount":87497,"monthlyCount":2511,"icon":"/icon/游戏_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2044454%2F2044454_5ca42e40354d4b898fa81d953a56320b.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2194747%2F2194747_b15f4efee26647bab7c7bbdb654da586.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2223994%2F2223994_9b7cd30b0025437c9bfa3bba2b6c575b.jpg%2F"]},{"name":"竞技","bookCount":6516,"monthlyCount":354,"icon":"/icon/竞技_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2406312%2F2406312_51d09a6f10a44dcf82c87336ae29bcc2.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2666276%2F2666276_0a1836381893480f8191fd5abea07a27.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2320278%2F2320278_0e9f80e789404fafb785956ebfea97fb.jpg%2F"]},{"name":"科幻","bookCount":126482,"monthlyCount":2630,"icon":"/icon/科幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2175391%2F2175391_2bed95dd170047198e9c550dde86f165.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2280410%2F2280410_972b063c4024437db50d489a84a428b3.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2248578%2F2248578_101a5b0485a646f6b38187bf36bd8e82.jpg%2F"]},{"name":"灵异","bookCount":52472,"monthlyCount":5172,"icon":"/icon/灵异_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2437722%2F2437722_0ae1b0af1e4643829952042800e879c5.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2225869%2F2225869_fbfd4ee3058f4c3ca6158395349eafb3.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2190222%2F2190222_35193469a0ab4198b58e13ec34d49b47.jpg%2F"]},{"name":"同人","bookCount":46733,"monthlyCount":407,"icon":"/icon/同人_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2044717%2F2044717_8909c1c627e441aa9009cd1c8d26af42.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1518279%2F1518279_f75d8d0662ba4fb18224be37cd75621c.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2638129%2F2638129_6fa4b1487ec740148e71851cfe4d0b2f.jpg%2F"]},{"name":"轻小说","bookCount":9565,"monthlyCount":375,"icon":"/icon/轻小说_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F3323245%2F3323245_4457d669d9f44dc68ce805a885a306d0.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2148576%2F2148576_626b71c9e87143c7920ef7188e45c7e7.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2204326%2F2204326_65ffd88476dc4894a9a970eeeda5cf89.jpg%2F"]}]
     * female : [{"name":"古代言情","bookCount":551415,"monthlyCount":15295,"icon":"/icon/古代言情_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2045755%2F2045755_7a7a750f61f64703977e72cca5c8dc90.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1505754%2F1505754_81b22622819e476fb78b2d760f94b617.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1158081%2F1158081_0340c4bbf5c144c885a089d96714753d.jpg%2F"]},{"name":"现代言情","bookCount":676571,"monthlyCount":21126,"icon":"/icon/现代言情_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F84550%2F84550_d9200ccb1ab0488ea8a1697143f5bba5.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2148350%2F2148350_934ff2b4b6d14bd7949be61df7eed913.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1367041%2F1367041_b7b17cbc9538413d9f4f4ed7a1e4fb02.jpg%2F"]},{"name":"青春校园","bookCount":149556,"monthlyCount":2901,"icon":"/icon/青春校园_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1200747%2F1200747_8acedaa3e7a547a8843feca07120b2c9.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2279091%2F2279091_9ad0367ced944ec5b1e0c1c96a11fab6.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2238873%2F2238873_8ef2608ca0634a38aa52dfdad35ae5ca.jpg%2F"]},{"name":"纯爱","bookCount":136718,"monthlyCount":1569,"icon":"/icon/耽美_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1174497%2F1174497_707e402c40c64a60ac7bc223f3a2c4ac.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2390042%2F2390042_3179d98d74f54b3b9939d32a391c0a42.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2270940%2F2270940_1605fc0e69614bb3861a8463f4da2d61.jpg%2F"]},{"name":"玄幻奇幻","bookCount":148139,"monthlyCount":832,"icon":"/icon/玄幻奇幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42127%2F42127_f23f08d9dd1942c8923cedd192425a22.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1240992%2F1240992_ab6af3f8592e44d08eee43e18a7ee6f2.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1524128%2F1524128_f4de778eb9484abb8a04f511dc6cae27.jpg%2F"]},{"name":"武侠仙侠","bookCount":76492,"monthlyCount":1863,"icon":"/icon/武侠仙侠_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2238871%2F2238871_6bc7ecde28084a0c984a2cbd5d1b61ed.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F243028%2F_243028_470038.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2282012%2F2282012_216dd1f93a414b5e9df531d05497bdb9.jpg%2F"]},{"name":"科幻","bookCount":17788,"monthlyCount":518,"icon":"/icon/科幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2207711%2F2207711_524c81ce00b74c508dcb8fa7cac18c75.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2329345%2F2329345_e76b549524a948978e3c9f2548f43406.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2189051%2F2189051_3531d35fe6d44414afb80aa8d7d4c10c.jpg%2F"]},{"name":"游戏竞技","bookCount":6064,"monthlyCount":4,"icon":"/icon/游戏竞技_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2988885%2F2988885_5f38079f513a47f6aa996bfccf4b56c6.jpg%2F","/agent/http://bbs.jjwxc.net/upload/201601/07/07-eacb34c.jpg","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2908738%2F2908738_964840284be24a3bb781e1c35c1cbc4a.jpg%2F"]},{"name":"悬疑灵异","bookCount":17906,"monthlyCount":1117,"icon":"/icon/悬疑灵异_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1457026%2F1457026_3aeb19659f0c460a8e86a997efbb6534.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1423134%2F1423134_4d765d70d7f44151b44cad100d42bb4a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2230500%2F2230500_28d011702e3f4d9899e54bcf70b1890a.jpg%2F"]},{"name":"同人","bookCount":121063,"monthlyCount":351,"icon":"/icon/同人_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1187728%2F1187728_289aab2057974cf7a595349d21fdf1e6.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2229966%2F2229966_8bd448377b104a29bba4f748d1f2d7be.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42014%2F_42014_918695.jpg%2F"]},{"name":"女尊","bookCount":22481,"monthlyCount":1474,"icon":"/icon/女尊_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F851414%2F_851414_740896.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2148904%2F2148904_1d79dbaf3b9e4b448a90097bd835b6fe.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F857217%2F857217_34eea5a4425d4437896b19d2774ac5da.jpg%2F"]},{"name":"莉莉","bookCount":26331,"monthlyCount":65,"icon":"/icon/百合_.png","bookCover":["/agent/http://ww1.sinaimg.cn/bmiddle/005K5T3Ogw1ezekp64o88j30b40fk3zd.jpg","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2190643%2F2190643_3b1ea6afd88d49eab7997ce14e100c6a.jpg%2F","/agent/http://img14.poco.cn/mypoco/myphoto/20130118/23/1732751262013011823473607_640.jpg"]}]
     * picture : [{"name":"热血","bookCount":849,"monthlyCount":126,"icon":"/icon/热血_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F168407%2F168407_749f2be713ea464193b3b4d8e314e00a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F181576%2F181576_db9f64dc8f2e4080a202f46f986cdbad.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2225872%2F2225872_67c9061a735f4846bb4cc98b7dd56026.png%2F"]},{"name":"魔幻","bookCount":398,"monthlyCount":57,"icon":"/icon/魔幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2225868%2F2225868_d6fb403eff2e407bbf1a2d43b7c85438.png%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F176271%2F176271_69ff019fe748444a9c27bfd55f71f21c.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F3118351%2F3118351_c25c309dbf844d3c84a4fa0cb9783864.jpg%2F"]},{"name":"科幻","bookCount":24,"monthlyCount":0,"icon":"/icon/科幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F195515%2F195515_b8f4e7f66e604c4293fcc462f048a948.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F149517%2F0cbbc5b49903426b8b9e3d9ee5318fb0.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F195173%2Fb0e15a8a4d8946df9b32d442922274d7.jpg%2F"]},{"name":"恋爱","bookCount":1174,"monthlyCount":167,"icon":"/icon/恋爱_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2156329%2F2156329_0f2e8fe8735442eea57af32115583e8c.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F180377%2F180377_620cd542bf0844a1a254fed5258bd3bc.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2592886%2F2592886_722b46f66a944e328f6ca65734fcea3e.jpg%2F"]},{"name":"搞笑","bookCount":1292,"monthlyCount":76,"icon":"/icon/搞笑_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2185190%2F2185190_02b51397c05d48b1baefd51fcaaa6023.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F173734%2F173734_c6d2e07448574d86801f1ad97b39aa24.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2443200%2F2443200_055de269532a4a8a9a39bf511b927209.jpg%2F"]},{"name":"悬疑","bookCount":443,"monthlyCount":92,"icon":"/icon/悬疑_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F177507%2F177507_31432d7db10f49e9868278d24f20e1ca.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2209161%2F2209161_8edb77d76a3b4ebf94d1e2a2d79e58e5.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2592889%2F2592889_9f2301df145143dbb9e209687da86065.jpg%2F"]},{"name":"少儿","bookCount":4551,"monthlyCount":1554,"icon":"/icon/少儿_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F197939%2Fff8713cfd9cd4893a49db3564d3811e4.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2079559%2F2079559_69f74d5ee39a400b84581d668d7641ad.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F196548%2Fb2fcd3c723d842f499d9c4d25c386761.jpg%2F"]}]
     * press : [{"name":"传记名著","bookCount":5025,"monthlyCount":1234,"icon":"/icon/传记名著_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F783085%2F_783085_901809.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42798%2F42798_72627be42841400d89e32bf8db97ec34.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1209327%2F1209327_fd3412af2a534a3eb970432860e1d2bc.jpg%2F"]},{"name":"出版小说","bookCount":16217,"monthlyCount":3677,"icon":"/icon/出版小说_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F55056%2F_55056_260551.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41937%2F_41937_602423.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1468251%2F1468251_11c57b5ceb124572ab3784e360257b73.jpg%2F"]},{"name":"人文社科","bookCount":67799,"monthlyCount":13996,"icon":"/icon/人文社科_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2053642%2F2053642_1675460130664e3295282eeea531f0b9.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2091345%2F2091345_default_cover.png%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1479473%2F_1479473_536534.jpg%2F"]},{"name":"生活时尚","bookCount":3234,"monthlyCount":488,"icon":"/icon/生活时尚_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2063886%2F2063886_ee5c3b3bb2cc4332a319c05adea1753f.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1529069%2F_1529069_328412.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1125603%2F_1125603_306865.jpg%2F"]},{"name":"经管理财","bookCount":5868,"monthlyCount":1743,"icon":"/icon/经管理财_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F19087%2F_19087_732103.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F34695%2F_34695_083305.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1134686%2F_1134686_216285.jpg%2F"]},{"name":"青春言情","bookCount":15528,"monthlyCount":2472,"icon":"/icon/青春言情_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2202149%2F2202149_ab670bc133bb44d9a83264284a97a8bd.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1427880%2F_1427880_678111.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2088321%2F2088321_f6f1b3ea033341d18ba9b930f50d28b7.jpg%2F"]},{"name":"外文原版","bookCount":1243,"monthlyCount":334,"icon":"/icon/外文原版_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2022998%2F2022998_17ff5053c0344d5db5c892fbd4d9dde6.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42735%2F_42735_042736.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1418090%2F1418090_718d012c55ce4d54832dd5374b3c741b.jpg%2F"]},{"name":"政治军事","bookCount":815,"monthlyCount":257,"icon":"/icon/政治军事_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F848281%2F848281_49325481b1054d029fc5c200923c5d24.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F597575%2F597575_bdbe2ad4835346a3b6c876ff715066c6.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2043686%2F2043686_f6d7f4a2769245648754943037d2e9aa.jpg%2F"]},{"name":"成功励志","bookCount":12100,"monthlyCount":2812,"icon":"/icon/成功励志_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F577424%2F577424_0414241d5b264c2d9c8787d554a58f63.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1148271%2F_1148271_859550.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F858627%2F_858627_838818.jpg%2F"]},{"name":"育儿健康","bookCount":12361,"monthlyCount":2781,"icon":"/icon/育儿健康_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2154248%2F2154248_51181588edee4bef8d794a534442fc2d.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2077896%2F2077896_9d45c4efb5734688a31efd793c5cdeb1.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2048782%2F2048782_f53486f14b72426d9a39be53cbbfc513.jpg%2F"]}]
     * ok : true
     */

    private boolean ok;
    private List<MaleBean> male;
    private List<FemaleBean> female;
    private List<PictureBean> picture;
    private List<PressBean> press;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<MaleBean> getMale() {
        return male;
    }

    public void setMale(List<MaleBean> male) {
        this.male = male;
    }

    public List<FemaleBean> getFemale() {
        return female;
    }

    public void setFemale(List<FemaleBean> female) {
        this.female = female;
    }

    public List<PictureBean> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureBean> picture) {
        this.picture = picture;
    }

    public List<PressBean> getPress() {
        return press;
    }

    public void setPress(List<PressBean> press) {
        this.press = press;
    }

    public static class MaleBean {
        /**
         * name : 玄幻
         * bookCount : 554199
         * monthlyCount : 21326
         * icon : /icon/玄幻_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F1228859_d14f18e849b34420904ead54936e440a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2107590%2F2107590_2607eaf03b2542ba88e4b75ac96bb12c.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41584%2F41584_873f1d8b2f7a447a8c59f3573094db1b.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }
    }

    public static class FemaleBean {
        /**
         * name : 古代言情
         * bookCount : 551415
         * monthlyCount : 15295
         * icon : /icon/古代言情_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2045755%2F2045755_7a7a750f61f64703977e72cca5c8dc90.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1505754%2F1505754_81b22622819e476fb78b2d760f94b617.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1158081%2F1158081_0340c4bbf5c144c885a089d96714753d.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }
    }

    public static class PictureBean {
        /**
         * name : 热血
         * bookCount : 849
         * monthlyCount : 126
         * icon : /icon/热血_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F168407%2F168407_749f2be713ea464193b3b4d8e314e00a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F181576%2F181576_db9f64dc8f2e4080a202f46f986cdbad.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2225872%2F2225872_67c9061a735f4846bb4cc98b7dd56026.png%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }
    }

    public static class PressBean {
        /**
         * name : 传记名著
         * bookCount : 5025
         * monthlyCount : 1234
         * icon : /icon/传记名著_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F783085%2F_783085_901809.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42798%2F42798_72627be42841400d89e32bf8db97ec34.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1209327%2F1209327_fd3412af2a534a3eb970432860e1d2bc.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }
    }
}
