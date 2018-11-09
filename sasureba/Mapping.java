package sasureba;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author merarli
 */
public class Mapping {

    String[][] map_data;
    //プレイヤーの位置
    int player_x;
    int player_y;

    public Mapping(String[][] map_data, int player_x, int player_y) {
        this.map_data = map_data;
        this.player_x = player_x;
        this.player_y = player_y;
    }

    public void idou() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wasdを入力してください(移動)");
        String key = scanner.next();
        
        System.out.println("key: " + key);
        System.out.println("player_x: " + player_x);
        System.out.println("player_y: " + player_y);
        

        //上に移動したらなら
        if (key.equals("w")) {
            if (player_y == 0) {
                System.out.println("そこへは移動できません");
            } else {
                System.out.println("上に移動しました");
                player_y = player_y - 1;
            }
        }

        //下に移動したなら
        if (key.equals("s")) {
            if (player_y == 4) {
                System.out.println("そこへは移動できません");
            } else {
                System.out.println("下に移動しました");
                player_y = player_y + 1;
            }
        }

        //右に移動したなら
        if (key.equals("d")) {
            if (player_x == 4) {
                System.out.println("そこへは移動できません");
            } else {
                System.out.println("右に移動しました");
                player_x = player_x + 1;
            }
        }

        //左に移動したなら
        if (key.equals("a")) {
            if (player_y == 0) {
                System.out.println("そこへは移動できません");
            } else {
                System.out.println("左に移動しました");
                player_x = player_x - 1;
            }
        }
        
        System.out.println(getMappingString());
        
    }

    public String getMappingString() {
        String output = "";
        for (int i = 0; i < this.map_data.length; i++) {
            for (int j = 0; j < this.map_data[i].length; j++) {

                if (player_x == j && player_y == i) {
                    output += "[";
                    output += "勇";
                    output += "]";
                } else {
                    output += "[";
                    output += map_data[i][j];
                    output += "]";
                }

            }
            output += "\n";
        }
        return output;
    }
}
