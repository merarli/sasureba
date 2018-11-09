/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;

/**
 *
 * @author Co116161
 */
public class Mob { //高山　縁
    String name;
    double hp;
    double atk;
    String talk_start;
    String talk_end;

    public Mob(String name, double hp, double atk, String talk_start, String talk_end) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.talk_start = talk_start;
        this.talk_end = talk_end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public String getTalk_start() {
        return talk_start;
    }

    public void setTalk_start(String talk_start) {
        this.talk_start = talk_start;
    }

    public String getTalk_end() {
        return talk_end;
    }

    public void setTalk_end(String talk_end) {
        this.talk_end = talk_end;
    }
    
    
    
    
}
