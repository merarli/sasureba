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
public class Mapping {  //目良　賢志 田中、モハメド
    //ユーザの作成

    User player = new User(500, 500, 1.0, "勇者", 100, 0);

    //武器の作成
    Wepon note = new Wepon("ノート", "C", 110, 150);
    Wepon sankosyo = new Wepon("参考書", "A", 210, 250);
    Wepon kanpe = new Wepon("カンニングペーパー", "B", 160, 200);
    Wepon NotePC = new Wepon("ノートパソコン", "S", 260, 300);

    Mob uda = new Mob("うだりゅうじ", 300, 100, "RSAを手計算で求めよ", "解けただとぉ？");
    Mob kameda = new Mob("かめだひろゆき", 300, 100, "（壇上でくるくる回っている）", "(目が回って倒れた)");
    Mob shibata = new Mob("しばたちひろ", 300, 100, "わたしのAIと勝負です", "お見事です");
    Mob kikuchi = new Mob("きくちまさゆき", 300, 100, "私と勝負しましょう", "完敗です");
    Mob osana = new Mob("おさなゆうこ", 300, 100, "こちらのプログラムを組んでください", "素晴らしいですね");
    Mob matushita = new Mob("まつしたせんせい", 1000, 200, "魔王なので宇宙が理解できます", "まさか私が負けるとは……");

    Battle bt = new Battle();
    String[][] map_data;
    //プレイヤーの位置
    int player_x;
    int player_y;
    int sibou_flg;
    int hosu;

    public Mapping(String[][] map_data, int player_x, int player_y, int sibou_flg, int hosu) {
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

                    if (map_data[i][j].equals("宇")) {
                        //仮のHPデータをここに入れる
                        double tmp_hp;
                        System.out.println(uda.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), uda.getHp(), uda.getAtk());
                        //判定の関数に渡す
                        hantei(tmp_hp, uda.getTalk_end());
                    }
                    
                    if (map_data[i][j].equals("A")) {
                        /*ここだれか書いて！！！！！！！！*/
                        //Weponクラスに武器の攻撃力を決定してもらって
                        //攻撃力を返してもらい
                        player.setAtk(sankosyo.getAtk());
                        System.out.println("Aの武器を獲得");

                        //拾ったら武器を消す
                        map_data[i][j] = "N";
                    }

                    if (map_data[i][j].equals("C")) {
                        /*ここだれか書いて！！！！！！！！*/
                        //Weponクラスに武器の攻撃力を決定してもらって
                        //攻撃力を返してもらい
                        player.setAtk(note.getAtk());
                        System.out.println("Cの武器を獲得");

                        //拾ったら武器を消す
                        map_data[i][j] = "N";
                    }

                    if (map_data[i][j].equals("B")) {
                        /*ここだれか書いて！！！！！！！！*/
                        //Weponクラスに武器の攻撃力を決定してもらって
                        //攻撃力を返してもらい
                        player.setAtk(kanpe.getAtk());
                        System.out.println("Bの武器を獲得");

                        //拾ったら武器を消す
                        map_data[i][j] = "N";
                    }

                    if (map_data[i][j].equals("鍵")) {
                        player.setHold_key(1);
                        System.out.println("鍵を入手した");
                        map_data[i][j] = "N";
                    }

                    if (map_data[i][j].equals("宝")) {
                        if (player.getHold_key() == 1) {
                            player.setAtk(NotePC.getAtk());
                            System.out.println("宝箱が開いた" +"\n"+ "Sの武器を獲得");

                            //拾ったら武器を消す
                            map_data[i][j] = "N";
                            player.setHold_key(0);
                        }else{
                            System.out.println("鍵がないため開かない");
                        }
                    }

                    if (map_data[i][j].equals("S")) {
                        /*ここだれか書いて！！！！！！！！*/
                        //Weponクラスに武器の攻撃力を決定してもらって
                        //攻撃力を返してもらい
                        player.setAtk(NotePC.getAtk());
                        System.out.println("Sの武器を獲得");

                        //拾ったら武器を消す
                        map_data[i][j] = "N";
                    }

                    if (map_data[i][j].equals("宇")) {
                        //仮のHPデータをここに入れる
                        double tmp_hp;
                        System.out.println(uda.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), uda.getHp(), uda.getAtk());
                        //判定の関数に渡す
                        hantei(tmp_hp, uda.getTalk_end());
                    }

                    if (map_data[i][j].equals("亀")) {
                        //仮のHPデータをここにいれる
                        double tmp_hp;
                        System.out.println(kameda.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), kameda.getHp(), kameda.getAtk());
                        //判定の関数にわたす
                        hantei(tmp_hp, kameda.getTalk_end());
                    }

                    if (map_data[i][j].equals("志")) {
                        //仮のHPデータをここにいれる
                        double tmp_hp;
                        System.out.println(shibata.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), shibata.getHp(), shibata.getAtk());
                        //判定の関数にわたす
                        hantei(tmp_hp, shibata.getTalk_end());
                    }

                    if (map_data[i][j].equals("菊")) {
                        //仮のHPデータをここにいれる
                        double tmp_hp;
                        System.out.println(kikuchi.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), kikuchi.getHp(), kikuchi.getAtk());
                        //判定の関数にわたす
                        hantei(tmp_hp, kikuchi.getTalk_end());
                    }

                    if (map_data[i][j].equals("長")) {
                        //仮のHPデータをここにいれる
                        double tmp_hp;
                        System.out.println(osana.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), osana.getHp(), osana.getAtk());
                        //判定の関数にわたす
                        hantei(tmp_hp, osana.getTalk_end());
                    }

                    if (map_data[i][j].equals("魔")) {
                        //仮のHPデータをここにいれる
                        double tmp_hp;
                        System.out.println(matushita.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), matushita.getHp(), matushita.getAtk());
                        //判定の関数にわたす
                        hantei(tmp_hp, matushita.getTalk_end());
                    }
                    //HP全回復
                    if (map_data[i][j].equals("神")) {
                        System.out.println("クリムベルゲン先生によりHPが全回復した！");
                        player.setHp_now(player.getHp_max());
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

    private void hantei(double tmp_hp, String talk_end) {
        player.setHp_now(tmp_hp);
        //もし勝利してたら イベント
        if (tmp_hp > 0) {
            System.out.println("勝利した!!");
            System.out.println(talk_end);
//            System.out.println(talk_start);
            //GPA上昇させる
            player.setGpa(player.getGpa() + 0.1);
            System.out.println("プレイヤーのGPAが上昇した");
            System.out.println("プレイヤーGPA:" + player.getGpa());
            player.setHp_max(player.getHp_max() + 20);
            player.setHp_now(player.getHp_now() + 20);
            System.out.println("プレイヤーのHPが上昇した");
            System.out.println("プレイヤーHP:" + player.getHp_now());

        } else {
            //負けたときの処理
            System.out.println("負けた");

            /*続き書いて*/
            sibou_flg = 1;
        }
    }
}
