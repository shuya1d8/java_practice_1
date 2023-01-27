import java.util.Scanner;
import util.CardGameWorldUtil;

/**
 * トップ画面で選択した際に確認をするクラス
 */
public class Confirmation {
    /**
     * 次の動作に移行するかの確認
     * @param name
     */
    public static Boolean confirm(String name) {
        Scanner stdIn = new Scanner(System.in);

        CardGameWorldUtil.yokosen("-", 55);
        System.out.println();
        System.out.printf("「%s」でよろしいですか？\n", name);
        System.out.println();
        System.out.println("<進む>の場合は「F」or「f」/ <戻る>の場合は「J」or「j」");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        String action;
        do {
            System.out.printf("<進む> or <戻る>：");
            action = stdIn.next();
        } while (!action.equals("F") && !action.equals("f") && !action.equals("J") && !action.equals("j"));

        Boolean conf = false;
        if (action.equals("F") || action.equals("f")) {
            conf = true;
        }

        return conf;
    }
}
