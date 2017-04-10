import java.util.ArrayList;
import java.util.List;

public class WordSet {
	private String gid = null ;
	
	/** 오리지널 키워드 **/ 
	private String orgKeyword = null ;
	/** 정규화 된 키워드(클리링완료된) **/
	private String norKeyword = null ;
	
	/** words 중에서 가장 긴 word 의 길이 **/
	private int maxWordLen = 0 ;
	
	/** 순서있음 **/
	private List<Word> words = new ArrayList<Word>() ;
			
	/** 보유도 **/
	private double weight = 0.0 ;
	
	public WordSet()
	{
		
	}
	
	public WordSet clone()
	{
		WordSet wordSet = new WordSet() ;
		
		wordSet.orgKeyword	= this.orgKeyword ;
		wordSet.norKeyword	= this.norKeyword ;
		wordSet.maxWordLen	= this.maxWordLen ;
		wordSet.weight 		= this.weight ;
		
		List<Word> newWords = new ArrayList<Word>() ;
		
		for(Word word : words)
		{
			newWords.add(word.clone()) ;
		}
		
		wordSet.setWords(newWords) ;
		
		return wordSet ;
	}
	
	public String getNorKeyword()
	{
		return norKeyword;
	}

	public void setNorKeyword(String norKeyword)
	{
		this.norKeyword = norKeyword;
	}

	public String getOrgKeyword()
	{
		return orgKeyword;
	}

	public void setOrgKeyword(String orgKeyword)
	{
		this.orgKeyword = orgKeyword;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public void addWord(Word word) 
	{
		words.add(word) ;
	}
	
	public int getMaxWordLen()
	{
		return maxWordLen;
	}

	public void setMaxWordLen(int maxWordLen)
	{
		this.maxWordLen = maxWordLen;
	}

	public List<Word> getWords()
	{
		return words;
	}

	public void setWords(List<Word> words)
	{
		this.words = words;
	}

}
