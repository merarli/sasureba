
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;

/**
 *
 *
 * @author merarli
 * @author takayama
 * @author TakayaKon
 * @author c0114336
 *
 */
public class Sasureba {//目良

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //プロローグ
        System.out.println("――僕の名前は『工科太郎』。実は卒業するための単位が足りなかったので留年しかけている。なので、どうにかして留年を回避するため、僕は松下先生と交渉することにした――\n"
                + "\n"
                + "太郎「お願いします！　卒業するための単位を僕に下さい！！」\n"
                + "松下先生「いやー、そう言われてもねぇ。だってそれ、自業自得でしょ？」\n"
                + "太郎「その通りですけど……でも、どうしても卒業したいんです！　だからお願いします！！」\n"
                + "松下先生「うーん……そう言われても。だがなぁ……\n"
                + "よし、じゃあこうしよう。私が作り出したダンジョンを攻略して私を倒したら、単位をあげる事を考えるとしよう」\n"
                + "太郎「本当ですか！？　ありがとうございます！！」\n"
                + "\n"
                + "――こうして僕は松下先生が研究室に作り出したダンジョンを攻略する事になった。\n"
                + "そのためにグリムベルゲン先生に頼み込んで協力してもらえることになったし。\n"
                + "温情をくれた松下先生とこんな僕に協力してくれたグリムベルゲン先生のためにもｄ、絶対に松下先生を倒してこの学校を卒業するんだ！！"
                + "\n"
                + "\n"
                + "松下「さて……ギター弾きながら最下層で待つとするか」"
                + "\n"
                + "\n");

        System.out.println("マップ内に存在する様々な武器を拾い、敵を倒しレベルを上げて松下先生を倒そう" 
                + "\n" + "マップのどこかに存在するグリムベルゲン先生を探し出すと回復してくれるぞ！　しかし連続では使用できないので注意しよう" 
                + "\n" + "宝箱は鍵がないと開けられないぞ！　宝箱の中には強力な武器が入っているため是非とも手にいれよう");

        //勝敗条件
        System.out.println("勝利条件：松下先生を倒そう　敗北条件：勇者の敗北");


        //マップの作成
        String[][] map_data = {
            {"N ", "N ", "N ", "N ", "N "},
            {"菊", "志", "N ", "B ", "N "},
            {"長", "B ", "N ", "鍵", "宝"},
            {"亀", "N ", "C ", "N ", "宇"},
            {"神", "N ", "A ", "N ", "魔"},};

        Mapping map = new Mapping(map_data, 0, 0, 0, 0, 0);

        System.out.println(map.getMappingString());

        //[playerのHPが0より大きい]&[歩数が50以下]間ループ　
//        while (player.getHp_now() > 0 && player.getStep_count() >= 50) {
        while (map.getSibou_flg() == 0 && map.getHosu() < 50 && map.getBoss_flg() == 0) {
            System.out.println(map.getHosu());
            //テストですぐ抜けるようにした

//            break;
            map.idou();
        }
        if (map.getBoss_flg() == 1) {
            System.out.println("松下先生を無事倒した");
        } else if (map.getHosu() < 0) {
            System.out.println("留年した");
        } else if (map.getSibou_flg() == 1) {
//            System.out.println("敗北した");
        }

    }

}
