import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.*;

/**
 * Created by a on 2017-04-09.
 */
public class StringMatcher extends ArrayList<WordSet>{

    private HashSet<String> resultSet;
    private String query;

    public StringMatcher(String query, Map<String, Integer> map){
        super();

        if(query == null) return;

        String shorten = query.replaceAll(" " , "").trim();

        this.query = shorten;

        Trie.TrieBuilder builder = Trie.builder();
        for(String s : map.keySet()){
            builder.addKeyword(s);
        }

        Trie trie = builder.build();

        Collection<Emit> emits = trie.parseText(this.query);

        resultSet = new HashSet<String>();

        for(Emit e : emits){
            resultSet.add(e.getKeyword());
        }

        setUp(getDependencyTable());
    }

    private HashMap<String, HashSet<String>> getDependencyTable(){

        HashMap<String, HashSet<String>> retVal = new HashMap<String, HashSet<String>>();

        Iterator<String> it = resultSet.iterator();
        while(it.hasNext()){
            retVal.put(it.next(), new HashSet<String>());
        }

        for(String key : retVal.keySet()){
            for(String dpKey : retVal.keySet()){
                if(key.contains(dpKey) && !key.equals(dpKey)) retVal.get(key).add(dpKey);
            }
        }

        ArrayList<String> toDelete = new ArrayList<String>();

        for(String key : retVal.keySet()){
            HashSet<String> unit = retVal.get(key);
            Iterator<String> it2 = unit.iterator();
//            int length = 0;
//            while(it2.hasNext()) length += it2.next().length();
            while(it2.hasNext()) toDelete.add(it2.next());
        }

//        for(String del : toDelete) retVal.put(del, new HashSet<String>());
        for(String del : toDelete) retVal.remove(del);

        for(String key : retVal.keySet()){
            HashSet<String> unit = retVal.get(key);
            Iterator<String> it2 = unit.iterator();
            System.out.print(key + " : "); // DEBUG
            while(it2.hasNext()){
                System.out.print(it2.next() + ", "); // DEBUG
            }
            System.out.println(); // DEBUG
        }

        return retVal;
    }

    private void setUp(HashMap<String, HashSet<String>> dependencyTable){
        WordSet set = new WordSet() ;

//        int combinationValue = 0;
//
//        Map<String, Boolean> combinationFilter = new HashMap<String, Boolean>();
//        for(String key : dependencyTable.keySet()){
//            if(dependencyTable.get(key).size() > 0) {
//                combinationFilter.put(key, true);
//                combinationValue++;
//            }
//        }

        set.setOrgKeyword(query) ;

        List<Word> words = new ArrayList<Word>();
        for(String key : dependencyTable.keySet()) {

            words.add(new Word(key));
//
//            if(dependencyTable.containsKey(key)){
//
//            }else{
//                words.add(new Word(key));
//            }

        }

        set.setWords(words);
        this.add(set);
    }

}
