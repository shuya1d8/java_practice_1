/**
 * 旧トランプカードクラス
 * @author S.Ota
 */
public class OldTrumpCard {
    // ジョーカーありのトランプ束 全53枚
    private String[] trumpJk = {
        "Joker", 
        "♠1", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠11", "♠12", "♠13", 
        "♡1", "♡2", "♡3", "♡4", "♡5", "♡6", "♡7", "♡8", "♡9", "♡10", "♡11", "♡12", "♡13", 
        "♢1", "♢2", "♢3", "♢4", "♢5", "♢6", "♢7", "♢8", "♢9", "♢10", "♢11", "♢12", "♢13", 
        "♣1", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10", "♣11", "♣12", "♣13", 
    };

    // ジョーカーなしのトランプ束 全52枚
    private String[] trumpNoJk = {
        "♠1", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠11", "♠12", "♠13", 
        "♡1", "♡2", "♡3", "♡4", "♡5", "♡6", "♡7", "♡8", "♡9", "♡10", "♡11", "♡12", "♡13", 
        "♢1", "♢2", "♢3", "♢4", "♢5", "♢6", "♢7", "♢8", "♢9", "♢10", "♢11", "♢12", "♢13", 
        "♣1", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10", "♣11", "♣12", "♣13", 
    };
    
    // ♠スペードのトランプ束 全13枚
    private String[] trumpSpade = {"♠1", "♠2", "♠3", "♠4", "♠5", "♠6", "♠7", "♠8", "♠9", "♠10", "♠11", "♠12", "♠13"};
    
    // ♡ハートのトランプ束 全13枚
    private String[] trumpHeart = {"♡1", "♡2", "♡3", "♡4", "♡5", "♡6", "♡7", "♡8", "♡9", "♡10", "♡11", "♡12", "♡13"};
    
    // ♢ダイヤのトランプ束 全13枚
    private String[] trumpDiamond = {"♢1", "♢2", "♢3", "♢4", "♢5", "♢6", "♢7", "♢8", "♢9", "♢10", "♢11", "♢12", "♢13"};
    
    // ♣クラブのトランプ束 全13枚
    private String[] trumpClub = {"♣1", "♣2", "♣3", "♣4", "♣5", "♣6", "♣7", "♣8", "♣9", "♣10", "♣11", "♣12", "♣13"};
    
    // 二次元配列バージョンのジョーカーなしのトランプ束 全52枚
    private String[][] trump = {
        trumpSpade,
        trumpHeart,
        trumpDiamond,
        trumpClub,
    };

    /**
     * コンストラクタ
     */
    OldTrumpCard() {

    }

    public String[] getTrumpJk() {
        return trumpJk;
    }

    public String[] getTrumpNoJk() {
        return trumpNoJk;
    }
    public String[][] getTrump() {
        return trump;
    }

    public String[] getTrumpSpade() {
        return trumpSpade;
    }

    public String[] getTrumpHeart() {
        return trumpHeart;
    }

    public String[] getTrumpDiamond() {
        return trumpDiamond;
    }

    public String[] getTrumpClub() {
        return trumpClub;
    }
}