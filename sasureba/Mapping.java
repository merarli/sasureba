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

    public Mapping(String[][] map_data) {
        this.map_data = map_data;
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
