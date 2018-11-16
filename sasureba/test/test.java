/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sasureba.test;

import java.util.Scanner;

/**
 *
 * @author merarli
 */
public class test {

    public static void main(String[] args) {
        int make = 0;
        int kachi = 0;
        int count = 0;
        while (count < 100) {
            double user_hp = 600;
            double user_atk = 100;
            double mob_hp = 1000;
            double mob_atk = 200;

            while (user_hp > 0 && mob_hp > 0) {

//            Scanner scanner = new Scanner(System.in);
//            System.out.println("攻撃１(全力)か攻撃２(手加減)かを選択してください");
//            String key = scanner.next();
                String key = "1";

                //攻撃１の場合(全力)
                if (key.equals("1")) {
                    double rnd;
                    double min = 0.6;
                    double max = 0.8;
                    rnd = min + (Math.random() * (max - min));
                    System.out.println("全力で攻撃します");
                    //攻撃処理
                    mob_hp = mob_hp - (user_atk * rnd);

                    System.out.println("敵の残り体力：" + mob_hp);

                    if (mob_hp != 0) {
                        double rndm;
                        double mmin = 0.1;
                        double mmax = 0.8;
                        //randomメソッドでmin～maxの整数を生成
                        rndm = mmin + (Math.random() * (mmax - mmin));
                        System.out.println("敵の攻撃を受けた");
                        user_hp = user_hp - (mob_atk * rndm);
                        System.out.println("あなたの残り体力：" + user_hp);
                    }
                }

                //攻撃２の場合(手加減)
                if (key.equals("2")) {
                    double rnd;
                    double min = 0.6;
                    double max = 0.8;
                    //randomメソッドでmin～maxの整数を生成
                    rnd = min + (Math.random() * (max - min));
                    System.out.println("手加減して攻撃します");
                    //攻撃処理.
                    mob_hp = mob_hp - (user_atk * 0.6) * rnd;
                    System.out.println("敵の残り体力：" + mob_hp);

                    if (mob_hp != 0) {
                        double rndm;
                        double mmin = 0.1;
                        double mmax = 0.8;
                        rndm = mmin + (Math.random() * (mmax - mmin));
                        System.out.println("敵の攻撃を受けた");
                        user_hp = user_hp - (mob_atk * rndm) * 0.5;
                        System.out.println("あなたの残り体力：" + user_hp);
                    }
                }
            }//Battle終わり

//            if (user_hp < 0) {
//                make++;
//            }

            if (mob_hp < 0) {
                kachi++;
            }else{
                make++;
            }

            count++;
        }

        System.out.println("kachi: " + kachi);
        System.out.println("make: " + make);
    }

}
