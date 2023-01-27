package util;

import java.util.*;

/**
 * カードゲームワールドユーティリティクラス
 * @author S.Ota
 */
public class CardGameWorldUtil {
   
    /**
     * <<"世界"が話す>>
     * @param words 表示させる言葉
     */
    public static void speakWorld(String words) {
        System.out.println("<< " + words + " >>");
    }

    /**
     * 『支配人が話す』
     * @param words 表示させる言葉
     */
    public static void speakManager(String words) {
        System.out.println("『" + words + "』");
    }

    /**
     * 【 タイトル表示 】
     * @param words 表示させるタイトル
     */
    public static void title(String words) {
        System.out.println("【 " + words + " 】");
    }

    /**
     * 横線生成
     * @param mark 表示させるマーク
     * @param times 表示させる回数
     */
    public static void yokosen(String mark, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(mark);
        }
        System.out.println();
    }

    /**
     * 画面切り替え時の「====」表示
     */
    public static void changeScreen() {
        System.out.println();
        CardGameWorldUtil.yokosen("=", 55);
    }

    /**
     * アクション（選択肢2つ:入力文字は<F><f><J><j>に固定）
     * @param act1   アクション1
     * @param act2   アクション2
     */
    public static String twoAction(String act1, String act2) {
        Scanner stdIn = new Scanner(System.in);

        String action1 = act1;
        String action2 = act2;

        System.out.println("-------------------- <<action>> --------------------");
        System.out.printf("<%s>の場合は「F」or「f」/ <%s>の場合は「J」or「j」\n", action1, action2);
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        String action;
        do {
            System.out.printf("<%s> or <%s>：", action1, action2);
            action = stdIn.next();
        } while (!action.equals("F") && !action.equals("f") && !action.equals("J") && !action.equals("j"));

        return action;
    }
    
    /**
     * アクション（選択肢2つ）
     * @param act1   アクション1
     * @param act2   アクション2
     * @param ini1_1 アクション1用の入力文字1つ目
     * @param ini1_2 アクション1用の入力文字2つ目
     * @param ini2_1 アクション2用の入力文字1つ目
     * @param ini2_2 アクション2用の入力文字2つ目
     */
    public static String twoAction(String act1, String act2, String ini1_1, String ini1_2, String ini2_1, String ini2_2) {
        Scanner stdIn = new Scanner(System.in);

        String action1 = act1;
        String action2 = act2;
        String initial1_1 = ini1_1;
        String initial1_2 = ini1_2;
        String initial2_1 = ini2_1;
        String initial2_2 = ini2_2;

        System.out.println("-------------------- <<action>> --------------------");
        System.out.printf("<%s>の場合は「%s」or「%s」/ <%s>の場合は「%s」or「%s」\n", action1, initial1_1, initial1_2, action2, initial2_1, initial2_2);
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        String action;
        do {
            System.out.printf("<%s> or <%s>：", action1, action2);
            action = stdIn.next();
        } while (!action.equals(initial1_1) && !action.equals(initial1_2) && !action.equals(initial2_1) && !action.equals(initial2_2));

        return action;
    }

    /**
     * 選択肢から選んでください。
     */
    public static void NotChoice() {
        System.out.println();
        CardGameWorldUtil.yokosen("-", 55);
        System.out.println();
        System.out.println("※ 選択肢から選んでください。");
        CardGameWorldUtil.yokosen("-", 55);
    }

    /**
     * 例外（※ 整数値を入力してください。）
     * いつか例外クラスを作成…
     */
    public static void wordIME() {
        CardGameWorldUtil.yokosen("-", 55);
        System.out.println();
        System.out.println("※ 整数値を入力してください。");
        CardGameWorldUtil.yokosen("-", 55);
    }
    
    /**
     * 例外（※ 整数値を入力してください。）
     * いつか例外クラスを作成…
     */
    public static void wordE(Exception e) {
        System.out.println();
        System.out.println("※ 例外検知 >>> " + e.getMessage());
        System.exit(1);
    }

}
