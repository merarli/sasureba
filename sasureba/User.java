/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;

/**
 *
 * @author merarli
 */


public class User {
    double hp_now;
    double hp_max;
    double gpa;
    String name;
    int atk;
    int step_count;
    int hold_key;

    public User(double hp_now, double hp_max, double gpa, String name, int atk, int step_count, int hold_key) {
        this.hp_now = hp_now;
        this.hp_max = hp_max;
        this.gpa = gpa;
        this.name = name;
        this.atk = atk;
        this.step_count = step_count;
        this.hold_key = hold_key;
    }

    public double getHp_now() {
        return hp_now;
    }

    public void setHp_now(double hp_now) {
        this.hp_now = hp_now;
    }

    public double getHp_max() {
        return hp_max;
    }

    public void setHp_max(double hp_max) {
        this.hp_max = hp_max;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getStep_count() {
        return step_count;
    }

    public void setStep_count(int step_count) {
        this.step_count = step_count;
    }

    public int getHold_key() {
        return hold_key;
    }

    public void setHold_key(int hold_key) {
        this.hold_key = hold_key;
    }
    
    

    
}
