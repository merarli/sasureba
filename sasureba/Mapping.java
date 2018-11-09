package sasureba;

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


    
    public void idou(String key){
        //上に移動したらなら
        if(key == "w"){
            
        }
    }
    
    
    
    public String getMappingString(){
        String output = "";
        for (int i = 0; i < this.map_data.length; i++) {
            for (int j = 0; j < this.map_data[i].length; j++) {
                output += "[";
                output += map_data[i][j];
                output += "]";
            }
            output += "\n";
        }
        return output;
    }
}
