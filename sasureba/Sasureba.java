/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;

/**
 *

 * @author merarli
 * @author takayama
 * @author TakayaKon
 * @author c0114336

 */
public class Sasureba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //プロローグ
        System.out.println("――僕の名前は『工科太郎』。実は卒業するための単位が足りなかったので留年しかけている。なので、どうにかして留年を回避するため、僕は松下先生と交渉することにした――\n" +
"\n" +
"太郎「お願いします！　卒業するための単位を僕に下さい！！」\n" +
"松下先生「いやー、そう言われてもねぇ。だってそれ、自業自得でしょ？」\n" +
"太郎「その通りですけど……でも、どうしても卒業したいんです！　だからお願いします！！」\n" +
"松下先生「うーん……そう言われても。だがなぁ……よし、じゃあこうしよう。私が作り出したダンジョンを攻略して私を倒したら、単位をあげる事を考えるとしよう」\n" +
"太郎「本当ですか！？　ありがとうございます！！」\n" +
"\n" +
"――こうして僕は松下先生が研究室に作り出したダンジョンを攻略する事になった。そのためにグリムベルゲン先生に頼み込んで協力してもらえることになったし、温情をくれた松下先生とこんな僕に協力してくれたグリムベルゲン先生のために、絶対に松下先生を倒してこの学校を卒業するんだ！！――");

        //勝敗条件
        System.out.println("勝利条件：松下先生を倒そう　敗北条件：太郎の敗北");
        
        //ユーザの作成
        User player = new User(500, 500, 1.0, "勇者", 100,100,0);
        
        //武器の作成
        Wepon No1 = new Wepon("ノート","C",110,150);
        
        //マップの作成
        String[][] map_data ={
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"}
        };
        
        Mapping map = new Mapping(map_data,0,0);
        
        System.out.println(map.getMappingString());
        
        //[playerのHPが0より大きい]&[歩数が50以下]間ループ　
        while(player.getHp_now() > 0 && player.getStep_count()>= 50){
            //テストですぐ抜けるようにした
            
//            break;
        map.idou();
        }
    }
    
}
