public class Word {

	private String gid = null ;
	
	/** LF 처리된 여부 **/
	private int boLF = 0 ;
	
	/** 순수 워드 **/
	private String orgWord = null ;
	
	/** 정규화 된 워드(이음동의어 처리) **/
	private String norWord = null ;
	
	public Word()
	{
		
	}
	
	public Word clone(){
		
		Word word = new Word() ;
		
		word.setOrgWord(orgWord) ;
		word.setNorWord(norWord) ;
		word.setBoLF(boLF) ;
		
		return word ;
	}
	
	public Word(String orgWord)
	{
		this.orgWord = orgWord ;
	}
	
	public Word(String orgWord,String norWord,int boLF)
	{
		this.orgWord = orgWord ;
		this.norWord = norWord ;
		this.boLF = boLF ;
	}	
	
	public int getBoLF()
	{
		return boLF;
	}

	public void setBoLF(int boLF)
	{
		this.boLF = boLF;
	}

	public String getOrgWord()
	{
		return orgWord;
	}

	public void setOrgWord(String orgWord)
	{
		this.orgWord = orgWord;
	}

	public String getNorWord()
	{
		return norWord;
	}

	public void setNorWord(String norWord)
	{
		this.norWord = norWord;
	}
	
	

}
