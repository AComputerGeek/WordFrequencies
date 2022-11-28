import edu.duke.*;
import java.util.ArrayList;

/**
* 
* @author: Amir Armion
* 
* @version: V.01
* 
*/
public class WordFrequencies 
{
    private ArrayList<String>  words;
    private ArrayList<Integer> frequencies;

    // Constructor
    public WordFrequencies()
    {
        words       = new ArrayList<>();
        frequencies = new ArrayList<>();
    }

    public void findUniqueWord()
    {
        FileResource resource = new FileResource();

        for(String word: resource.words())
        {
            word           = word.toLowerCase();
            int wordIndex  = words.indexOf(word);

            if(wordIndex == -1)
            {
                words.add(word);
                frequencies.add(1);
            }
            else
            {                
                int indexValue = frequencies.get(wordIndex);
                frequencies.set(wordIndex, indexValue + 1);
            }
        }
    }

    public void test()
    {
        words.clear();
        frequencies.clear();
        findUniqueWord();
        System.out.println("\n- All words: " + words.size());

        System.out.println();

        for(int i = 0; i < words.size(); i++)
        {
            System.out.println("Word " + i + ": " + words.get(i) + ": " + frequencies.get(i));
        }
    }

    public void findMax()
    {
        words.clear();
        frequencies.clear();
        findUniqueWord();
        
        int maxVal      = 0;
        int maxValIndex = 0;
        
        for(int i = 0; i < frequencies.size(); i++)
        {
            if(frequencies.get(i) > maxVal)
            {
                maxVal      = frequencies.get(i);
                maxValIndex = i;
            }
        }

        System.out.println("The Max word and its frequency is: " + words.get(maxValIndex) + " / " + maxVal); 
    }
}
