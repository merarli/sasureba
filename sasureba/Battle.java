/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;

/**
 *
 * @author C0116116
 * @author c0114336
 */
public class Battle {

    double user_hp;
    double user_atk;
    double user_gpa;
    double mob_hp;
    double mob_atk;
    String mob_talk_start;
    String mob_talk_end;
    
    public Battle(double user_hp, double user_atk, double user_gpa, double mob_hp, double mob_atk, String mob_talk_start, String mob_talk_end) {
        this.user_hp = user_hp;
        this.user_atk = user_atk;
        this.user_gpa = user_gpa;
        this.mob_hp = mob_hp;
        this.mob_atk = mob_atk;
        this.mob_talk_start = mob_talk_start;
        this.mob_talk_end = mob_talk_end;
    }

    public double getUser_hp() {
        return user_hp;
    }

    public double getUser_atk() {
        return user_atk;
    }

    public double getUser_gpa() {
        return user_gpa;
    }

    public double getMob_hp() {
        return mob_hp;
    }

    public double getMob_atk() {
        return mob_atk;
    }

    public String getMob_talk_start() {
        return mob_talk_start;
    }

    public String getMob_talk_end() {
        return mob_talk_end;
    }

    public void setUser_hp(double user_hp) {
        this.user_hp = user_hp;
    }

    public void setUser_atk(double user_atk) {
        this.user_atk = user_atk;
    }

    public void setUser_gpa(double user_gpa) {
        this.user_gpa = user_gpa;
    }

    public void setMob_hp(double mob_hp) {
        this.mob_hp = mob_hp;
    }

    public void setMob_atk(double mob_atk) {
        this.mob_atk = mob_atk;
    }

    public void setMob_talk_start(String mob_talk_start) {
        this.mob_talk_start = mob_talk_start;
    }

    public void setMob_talk_end(String mob_talk_end) {
        this.mob_talk_end = mob_talk_end;
    }
    
}
