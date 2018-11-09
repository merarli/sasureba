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
<<<<<<< HEAD
        
        
        
        
=======
        //ユーザの作成
        User player = new User(500, 500, 1.0, "勇者", 100,100,0);
        
        //マップの作成
        String[][] map_data ={
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"},
            {"宇","宝","N","N","N"}
        };
        Mapping map = new Mapping(map_data);
        
        System.out.println(map.getMappingString());
        
        //playerのHPが0より大きい間ループ
        while(player.getHp_now() > 0){
            //テストですぐ抜けるようにした
            break;
        }
>>>>>>> 507c58e1b9fc9412cca0ef4d5eef4698193e5afc
    }
    
}
