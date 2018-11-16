/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author C0116116
 * @author c0114336
 */
public class Battle {   //田中 亮

    double user_hp;
    double user_atk;
    double user_gpa;
    double mob_hp;
    double mob_atk;
    String mob_talk_start;
    String mob_talk_end;

    public Battle() {

    }

    public double Battle(double user_hp, double user_atk, double mob_hp, double mob_atk, String mob_talk_start, String mob_talk_end) {
        this.user_hp = user_hp;
        this.user_atk = user_atk;
//        this.user_gpa = user_gpa;
        this.mob_hp = mob_hp;
        this.mob_atk = mob_atk;
        this.mob_talk_start = mob_talk_start;
        this.mob_talk_end = mob_talk_end;

        while (this.user_hp == 0 || this.mob_hp == 0) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("攻撃１(全力)か攻撃２(手加減)かを選択してください");
            String key = scanner.next();

            //攻撃１の場合(全力)
            if (key.equals("1")) {
                double rnd;
                double min = 0.6;
                double max = 0.8;
                //randomメソッドでmin～maxの整数を生成
                rnd = min + (Math.random() * (max - min));
                this.user_atk *= 1; //攻撃力変更
                System.out.println("全力で攻撃します");
                //攻撃処理
                this.mob_hp = this.mob_hp - (this.user_atk * rnd);

                if (this.mob_hp != 0) {
                    double rndm;
                    double mmin = 0.1;
                    double mmax = 0.8;
                    //randomメソッドでmin～maxの整数を生成
                    rndm = mmin + (Math.random() * (mmax - mmin));
                    System.out.println("敵の攻撃を受けた");
                    this.user_hp = this.user_hp - (this.mob_atk * rndm);
                }
            }

            //攻撃２の場合(手加減)
            if (key.equals("2")) {
                double rnd;
                double min = 0.6;
                double max = 0.8;
                //randomメソッドでmin～maxの整数を生成
                rnd = min + (Math.random() * (max - min));
                this.user_atk *= 0.6;
                System.out.println("手加減して攻撃します");
                //攻撃処理.
                this.mob_atk *= 0.6;
                this.mob_hp = this.mob_hp - (this.user_atk * rnd);

                if (this.mob_hp != 0) {
                    double rndm;
                    double mmin = 0.1;
                    double mmax = 0.8;
                    rndm = mmin + (Math.random() * (mmax - mmin));
                    System.out.println("敵の攻撃を受けた");
                    this.user_hp = this.user_hp - (this.mob_atk * rndm)*0.5;
                }
            }
        }

        //この間に入力を受け取って戦って終了したらuser_hpを返して
        //テスト
        //System.out.println("プレイヤーは死んだ");
        //this.user_hp = 0;
        //テスト
        return user_hp;
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
