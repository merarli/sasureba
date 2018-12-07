package sasureba;

import java.util.Scanner;
import java.util.Random;

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

    Mob uda = new Mob("うだりゅうじ", 300, 100, "「RSAを手計算で求めよ」", "「解けただとぉ？」");
    Mob kameda = new Mob("かめだひろゆき", 300, 100, "（壇上でくるくる回っている）", "(目が回って倒れた)");
    Mob shibata = new Mob("しばたちひろ", 300, 100, "「わたしのAIと勝負です」", "「お見事です」");
    Mob kikuchi = new Mob("きくちまさゆき", 300, 100, "「私と勝負しましょう」", "「完敗です」");
    Mob osana = new Mob("おさなゆうこ", 300, 100, "「こちらのプログラムを組んでください」", "「素晴らしいですね」");
    Mob matushita = new Mob("まつしたせんせい", 1000, 200, "「魔王なので宇宙が理解できます」", "「まさか私が負けるとは……」");
    Mob goast = new Mob("ゆうれい", 300, 100, "「再勝負です」", "「また負けるとは……」");

    Battle bt = new Battle();
    String[][] map_data;
    //プレイヤーの位置
    int player_x;
    int player_y;
    int sibou_flg;
    int hosu;
    int boss_flg;
    int seigen = 0;

    private int[][] asiato = {
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    public Mapping(String[][] map_data, int player_x, int player_y, int sibou_flg, int hosu, int boss_flg) {
        this.map_data = map_data;
        this.player_x = player_x;
        this.player_y = player_y;
        this.sibou_flg = sibou_flg;
        this.hosu = hosu;
        this.boss_flg = boss_flg;
    }

    public int getBoss_flg() {
        return boss_flg;
    }

    public void setBoss_flg(int boss_flg) {
        this.boss_flg = boss_flg;
    }

    public int getSibou_flg() {
        return sibou_flg;
    }

    public void setSibou_flg(int sibou_flg) {
        this.sibou_flg = sibou_flg;
    }

    public void idou() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("w/a/s/dを入力してください(移動)");
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
                this.hosu++;
                System.out.println(this.hosu + "歩移動しました");
                seigen++;
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
                System.out.println(this.hosu + "歩移動しました");
                seigen++;
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
                System.out.println(this.hosu + "歩移動しました");
                seigen++;
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
                System.out.println(this.hosu + "歩移動しました");
                seigen++;
            }
        }
        
        asiato[player_y][player_x] = 1;
        System.out.println(getMappingString());

    }

    public String getMappingString() {
        String output = "";
        for (int i = 0; i < this.map_data.length; i++) {
            for (int j = 0; j < this.map_data[i].length; j++) {

                if (player_x == j && player_y == i) {

                    if (map_data[i][j].equals(" A  ")) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("ランクAの武器を発見した" + "\n" + "取得する場合はyを、しない場合はnを入力してください");
                        String key = scanner.next();
                        //Weponクラスに武器の攻撃力を決定してもらって
                        //攻撃力を返してもらい
                        if (key.equals("y")) {
                            player.setAtk(sankosyo.getAtk());
                            System.out.println("各種参考書を見つけた\n"
                                    + "「心強い武器だけどやっぱり重いな」\n"
                                    + "太郎の攻撃力が" + player.getAtk() + "に変化した");
                            //拾ったら武器を消す
                            map_data[i][j] = "----";
                        } else if (key.equals("n")) {
                            map_data[i][j] = " A  ";
                        }
                    }

                    if (map_data[i][j].equals(" C  ")) {
                        
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("ランクCの武器を発見した" + "\n" + "取得する場合はyを、しない場合はnを入力してください");
                        String key = scanner.next();
                        if (key.equals("y")) {
                            player.setAtk(note.getAtk());
                            System.out.println("授業内容をメモしたノートを発見した\n"
                                    + "「ノートの整理はしっかりしないとね」\n"
                                    + "太郎の攻撃力が" + player.getAtk() + "に変化した");
                            map_data[i][j] = "----";
                        } else if (key.equals("n")) {
                            map_data[i][j] = " C  ";
                        }
                    }

                    if (map_data[i][j].equals(" B  ")) {
                        
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("ランクBの武器を発見した" + "\n" + "取得する場合はyを、しない場合はnを入力してください");
                        String key = scanner.next();
                        if (key.equals("y")) {
                            player.setAtk(kanpe.getAtk());
                            System.out.println("カンニングペーパーの作成に成功した\n"
                                    + "「これでテストはばっちりだ！！」\n"
                                    + "太郎の攻撃力が" + player.getAtk() + "に変化した");
                            map_data[i][j] = "----";
                        } else if (key.equals("n")) {
                            map_data[i][j] = " C  ";
                        }
                    }

                    if (map_data[i][j].equals(" 鍵 ")) {
                        
                        player.setHold_key(1);
                        System.out.println("鍵を入手した");
                        map_data[i][j] = "----";
                    }

                    if (map_data[i][j].equals(" 宝 ")) {
                        
                        if (player.getHold_key() == 1) {

                            Scanner scanner = new Scanner(System.in);
                            System.out.println("宝箱を発見した\n"
                                    + "鍵を持っているため開ける事ができます。開けますか？\n"
                                    + "開ける場合はyを、開けない場合はnを入力してください");
                            String key = scanner.next();
                            if (key.equals("y")) {
                                player.setAtk(NotePC.getAtk());
                                System.out.println("宝箱が開いた\n"
                                        + "パソコンの充電器を発見し、パソコンが使用可能になった\n"
                                        + "「なんで宝箱に充電器なんて入れたんだろう」\n"
                                        + "太郎の攻撃力が" + player.getAtk() + "に変化した");

                                //拾ったら武器を消す
                                map_data[i][j] = "----";
                                player.setHold_key(0);
                            } else if (key.equals("n")) {
                                System.out.println("宝箱を放置しておくことにした");
                            }
                        } else {
                            System.out.println("宝箱を見つけた" + "\n" + "鍵がないため開かない");
                        }
                    }

                    if (map_data[i][j].equals("幽霊")) {
                        
                        Random r = new Random();
                        int a = r.nextInt(5);
                        if (a == 0) {
                            double tmp_hp;
                            System.out.println(goast.talk_start);
                            tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), goast.getHp(), goast.getAtk());
                            //判定の関数に渡す
                            hantei(tmp_hp, goast.getTalk_end());
                            map_data[i][j] = "幽霊";
                        }
                    }

                    if (map_data[i][j].equals("宇田")) {
                        
                        //仮のHPデータをここに入れる
                        double tmp_hp;
                        System.out.println(uda.talk_start);
                        //データをセットしてBattle開始
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), uda.getHp(), uda.getAtk());
                        //判定の関数に渡す
                        hantei(tmp_hp, uda.getTalk_end());
                        map_data[i][j] = "幽霊";
                    }

                    if (map_data[i][j].equals("亀田")) {
                        
                        double tmp_hp;
                        System.out.println(kameda.talk_start);
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), kameda.getHp(), kameda.getAtk());
                        hantei(tmp_hp, kameda.getTalk_end());
                        map_data[i][j] = "幽霊";
                    }

                    if (map_data[i][j].equals("柴田")) {
                        
                        double tmp_hp;
                        System.out.println(shibata.talk_start);
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), shibata.getHp(), shibata.getAtk());
                        hantei(tmp_hp, shibata.getTalk_end());
                        map_data[i][j] = "幽霊";
                    }

                    if (map_data[i][j].equals("菊池")) {
                        
                        double tmp_hp;
                        System.out.println(kikuchi.talk_start);
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), kikuchi.getHp(), kikuchi.getAtk());
                        hantei(tmp_hp, kikuchi.getTalk_end());
                        map_data[i][j] = "幽霊";
                    }

                    if (map_data[i][j].equals("長名")) {
                        
                        double tmp_hp;
                        System.out.println(osana.talk_start);
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), osana.getHp(), osana.getAtk());
                        hantei(tmp_hp, osana.getTalk_end());
                        map_data[i][j] = "幽霊";
                    }

                    if (map_data[i][j].equals("松下")) {
                        
                        double tmp_hp;
                        System.out.println(matushita.talk_start);
                        tmp_hp = bt.Battle(player.getHp_now(), player.getAtk(), matushita.getHp(), matushita.getAtk());
                        hantei(tmp_hp, matushita.getTalk_end());
                        if (player.getHp_now() > 0) {
                            boss_flg = 1;
                        }
                    }
                    //HP全回復
                    if (map_data[i][j].equals("ｸﾞﾘﾑ")) {
                        
                        if (seigen >= 5) {
                            player.setHp_now(player.getHp_max());
                            System.out.println("クリムベルゲン先生によりHPが全回復した！");
                            seigen = 0;
                        } else {
                            System.out.println("クリムベルゲン先生は外出中だ！回復できなかった");
                        }
                    }


                    try {
                        if (map_data[i + 1][j].equals("松下")) {
                            System.out.println("ギターの音が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (map_data[i - 1][j].equals("松下")) {
                            System.out.println("ギターの音が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (map_data[i][j + 1].equals("松下")) {
                            System.out.println("ギターの音が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (map_data[i][j - 1].equals("松下")) {
                            System.out.println("ギターの音が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                    try {
                        if (map_data[i + 1][j].equals("ｸﾞﾘﾑ")) {
                            System.out.println("オランダ語が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (map_data[i - 1][j].equals("ｸﾞﾘﾑ")) {
                            System.out.println("オランダ語が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (map_data[i][j + 1].equals("ｸﾞﾘﾑ")) {
                            System.out.println("オランダ語が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (map_data[i][j - 1].equals("ｸﾞﾘﾑ")) {
                            System.out.println("オランダ語が聞こえる");
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                } else {

                }
                
                //初期はマッピングしない
                if(i == player_y && j == player_x){
                    output += "[";
                    output += "太郎";
                    output += "]"; 
                }else if (asiato[i][j] == 1) {
                    output += "[";
                    output += map_data[i][j];
                    output += "]";
                }else{
                    output += "[";
                    output += "＠＠";
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
            System.out.println("プレイヤーGPA:" + String.format("%.1f", player.getGpa()));
            System.out.println("太郎のGPAが上昇した");
            System.out.println("現在のGPA:" + String.format("%.1f",player.getGpa()));
            player.setHp_max(player.getHp_max() + 20);
            player.setHp_now(player.getHp_now() + 20);
            System.out.println("太郎のHPが上昇した");
            System.out.println("現在のHP:" + (int) player.getHp_now());

        } else {
            //負けたときの処理
            System.out.println("負けた");

            /*続き書いて*/
            sibou_flg = 1;
        }
    }
}
