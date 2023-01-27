/**
 * カードゲームに必要なもの
 * @author S.Ota
 */
public class CardGameRoots implements CardGameIF {
    private String title;

    /**
     * コンストラクタ
     * @param title ゲーム名
     */
    public CardGameRoots(String title) {
        this.title = title;
    }

    
    /**
     * ゲーム名のゲッター
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 【 タイトル表示 】
     * @param words 表示させるタイトル
     */
    @Override public void introduce() {
        System.out.println("【 " + getTitle() + " 】");
    }

}
