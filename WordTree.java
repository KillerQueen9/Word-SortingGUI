//*******************************************************************I M P O R T********************************************************************************//
import java.util.SortedMap;
import java.util.TreeMap;
//***************************************************************************************************************************************************************//
/*
* Name: Liwen Cui
* Lab Instructor: Zhujun Li
* Lab Section: 212-11A
* 
*****************************************************************************************************************************************************************/
public class WordTree {
	SortedMap<Word,Word> Map = new TreeMap<Word, Word>();
	public void put(Word W) {
		Map.put(W, null);
	}
	public SortedMap<Word, Word> getMap(){
		return Map;
	}

}
