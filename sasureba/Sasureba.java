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
        while(player.getHp_now() > 0 && player.getStep_count()<= 50){
            //テストですぐ抜けるようにした
            break;
        }
    }
    
}
