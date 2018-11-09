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

        //上に移動したらなら
        if (key == "w") {
            if (player_y == 0) {
                System.out.println("そこへは移動できません");
            } else {
                this.player_y++;
            }
        }

        //下に移動したなら
        if (key == "s") {
            if (player_y == 4) {
                System.out.println("そこへは移動できません");
            } else {
                this.player_y--;
            }
        }

        //右に移動したなら
        if (key == "d") {
            if (player_x == 4) {
                System.out.println("そこへは移動できません");
            } else {
                this.player_x++;
            }
        }

        //左に移動したなら
        if (key == "a") {
            if (player_y == 0) {
                System.out.println("そこへは移動できません");
            } else {
                this.player_x++;
            }
        }
        
        System.out.println(getMappingString());
        
    }

    public String getMappingString() {
        String output = "";
        for (int i = 0; i < this.map_data.length; i++) {
            for (int j = 0; j < this.map_data[i].length; j++) {

                if (player_x == i && player_x == j) {
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
