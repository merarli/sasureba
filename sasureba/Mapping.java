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
public class Mapping {  //目良　賢志
    //ユーザの作成

    User player = new User(500, 500, 1.0, "勇者", 100, 0);

    //武器の作成
    Wepon note = new Wepon("ノート", "A", 110, 150);

    Mob uda = new Mob("うだりゅうじ", 300, 100, "RSAを手計算で求めよ", "解けただとぉ？");

    Battle bt = new Battle();
    String[][] map_data;
    //プレイヤーの位置
    int player_x;
    int player_y;
    int sibou_flg;
    int hosu;

    public Mapping(String[][] map_data, int player_x, int player_y,int sibou_flg,int hosu) {
        this.map_data = map_data;
        this.player_x = player_x;
        this.player_y = player_y;
        this.sibou_flg = sibou_flg;
        this.hosu = hosu;
    }
    

    public int getSibou_flg() {
        return sibou_flg;
    }

    public void setSibou_flg(int sibou_flg) {
        this.sibou_flg = sibou_flg;
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
                this.hosu++;
            }
        }

        //右に移動したなら
        if (key.equals("d")) {
            if (player_x == 4) {
                System.out.println("そこへは移動できません");
            } else {
                System.out.println("右に移動しました");
                player_x = player_x + 1;
                hosu++;
            }
        }

        //左に移動したなら
        if (key.equals("a")) {
            if (player_x == 0) {
                System.out.println("そこへは移動できません");
                this.hosu++;
            } else {
                System.out.println("左に移動しました");
                player_x = player_x - 1;
                hosu++;
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

                    if (map_data[i][j].equals("A")) {
                        /*ここだれか書いて！！！！！！！！*/
                        //Weponクラスに武器の攻撃力を決定してもらって
                        //攻撃力を返してもらい
                        player.setAtk(note.getAtk());
                        System.out.println("Aの武器を獲得");

                        //拾ったら武器を消す
                        map_data[i][j] = "N";
                    }

                    if (map_data[i][j].equals("宇")) {
                        //仮のHPデータをここにいれる
                        double tmp_hp;
                        System.out.println(uda.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), uda.getHp(), uda.getAtk());
                        //判定の関数にわたす
                        hantei(tmp_hp,uda.getTalk_end());
                    }

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

    public int getHosu() {
        return hosu;
    }

    public void setHosu(int hosu) {
        this.hosu = hosu;
    }

    private void hantei(double tmp_hp,String talk_end) {
        
        //もし勝利してたら イベント
        if (tmp_hp < 1) {
            System.out.println("勝利した!!");
//            System.out.println(talk_start);
            //GPA上昇させる
            player.setGpa(player.getGpa() + 0.1);
            System.out.println("プレイヤーのGPAが上昇した");
            player.setHp_max(player.getHp_max() + 20);
            player.setHp_now(player.getHp_now() + 20);
            System.out.println("プレイヤーのHPが上昇した");
            
        } else {
            //負けたときの処理
            System.out.println("負けた");
            System.out.println(talk_end);
            /*続き書いて*/
            sibou_flg = 1;
        }
    }
}
