/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;
import java.util.Random;

/**
 *
 * @author C0116116
 */
public class Wepon {   //金貴哉

    String name;
    String rank;
    double atk_min;
    double atk_max;
    double atk;

    public Wepon(String name, String rank, double atk_min, double atk_max) {
        this.name = name;
        this.rank = rank;
        this.atk_min = atk_min;
        this.atk_max = atk_max;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setAtk_min(double atk_min) {
        this.atk_min = atk_min;
    }

    public void setAtk_max(double atk_max) {
        this.atk_max = atk_max;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public double getAtk_min() {
        return atk_min;
    }

    public double getAtk_max() {
        return atk_max;
    }
    
    public double getAtk(){
        Random rand = new Random();
        int dif = (int)atk_max - (int)atk_min;
        double atk = rand.nextInt(dif) + atk_min ;
        //System.out.println(atk);
        return atk;    
    }

}
