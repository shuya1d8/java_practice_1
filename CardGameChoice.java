import java.util.*;
import util.CardGameWorldUtil;

/**
 * 遊べるカードゲーム
 * @author S.Ota
 */
public class CardGameChoice {

    /**
     * 遊べるカードゲームが格納されたリストを返す
     * @return
     */
    public static List<String> cardGameList() {
        List<String> cardGameList = new ArrayList<>();

        cardGameList.add("トランプ当て");
        cardGameList.add("簡易版ブラックジャック");
        
        return cardGameList;
    }

    /**
     * リストに格納されたカードゲームを表示させる（選択番号・世界を去る あり）
     */
    public static void cardGameChoice() {
        CardGameWorldUtil.title("遊べるカードゲーム");
        CardGameWorldUtil.yokosen("↓ ", 15);
        for (int i = 0; i < cardGameList().size(); i++) {
            System.out.printf("<%s> %s\n", (i + 1), cardGameList().get(i));
        }
        System.out.println();
        System.out.println("<0> 世界を去る");
        CardGameWorldUtil.yokosen("~ ", 15);
    }
}
