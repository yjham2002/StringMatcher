import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by a on 2017-04-09.
 */
public class AppMain {
    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();

        map.put("벚꽃", 1);
        map.put("봄", 1);
        map.put("봄바람", 1);
        map.put("황사", 1);
        map.put("커플", 1);
        map.put("미세먼지", 1);
        map.put("우울증", 1);
        map.put("사과", 1);
        map.put("배", 1);

        StringMatcher sMatcher = new StringMatcher("벚 꽃 이 피면 봄 바 람이 불어와서 눈이 아 프다 황사도  심해 서 스트레스를 받아 우 울 증 이 생긴다.", map);



    }
}
