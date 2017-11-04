
package morsecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Brian Wells
 */

        
public class MorseCode {
    
public static void main(String[] args) throws FileNotFoundException, IOException {
     
    /* Character array holding the letters and number in english
    /
    */
    char[] AlphaNum = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                       'o','p','q','r','s','t','u','v','w','x','y','z','1','2','3',
                       '4','5','6','7','8','9','0',};
    
    /* String array holding the morse codes that represents each english value
    /  at the corresponding index locations of AlphaNum
    */

    String[] MorseCode ={".-","-...","-.-.","-..",".","..-.","--.","....","..",
                         ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                         "...","-","..-","...-",".--","-..-","-.--","--..",".----",
                         "..---","...--","....-",".....","-....","--...","---..","----.",
                         "-----",};
    
    Scanner in = new Scanner(System.in);
    
   
    // Asking user for desired approach
    System.out.println("Enter 1 to write manually or Enter 2 to read from a file");
    
    int a = in.nextInt(); // Value to check user's decision
    
    
    // Loop to force user to make a decision with correct entry
    while((a!=1 ) && (a!=2)){
    
    System.out.println("Invalid response, Enter 1 to manually enter code or 2 to read from file" );
    a = in.nextInt();
    
    }
    
    // If statement checking the users decison, if true the program will read from a file
    if(a==2){
    System.out.println("Enter file path");
    
    String x = in.nextLine(); // Dummy prompt without it, it doesnt reach prompt for filename
    String Filename = in.nextLine();
    
    File MorseFile = new File(Filename);
    
   /* Buffer reader to read the file text and then count the amount of lines it contains
    /
    */
   BufferedReader input = new BufferedReader( new InputStreamReader(new FileInputStream(MorseFile)));
   int y = 0;
   String[] sentence = null;
   
   while(input.readLine()!=null){
       y=y+1;
   } input.close();
   
   /* Buffer reader to read each line into loop to be translated then printed
   /
   */
   
   BufferedReader input2 = new BufferedReader( new InputStreamReader(new FileInputStream(MorseFile)));
   for(int c=0; c<y; c++){
   String[] inputcode = new String[y];
   
   inputcode[c] = input2.readLine();
   System.out.println("");
   
   /* Below is the process of printing out the translation of the morse code in file
   /
   */
   
    sentence = inputcode[c].split("\\|\\|");  // Array to seperate each letter entered in morse code
       
        for(int k=0; k<sentence.length; k++ ){
    
                for(int j = 0; j<MorseCode.length; j++){
                    
                    
                    
                    if(sentence[k].equals("")){
                        
                        System.out.print(" ");
                    }
                    
                    if(sentence[k].equals(MorseCode[j])){
                        
                        System.out.print(AlphaNum[j]);
                        
                    }
                }
        }
    }           input2.close();
    }
     
    
    // Code below is for user manually entering morse code due to if statement being false
    else{
    
    System.out.println("Enter morse code, Seperate each letter or number with a || an Seperate each word with |||| ");
   
    
    String w = in.nextLine(); // Dummy prompt without it it doesnt reach user prompt for morse code
    String typedcode = in.nextLine(); // The English sentence entered by user
    
    Scanner checker = new Scanner(typedcode); // Used to scan the string given by user
    
    
    /* Forces user to input valid morse code values ( . - || )
    /
    */
    
    while((!typedcode.contains("."))||(!typedcode.contains("-"))){
        
        System.out.println("Not valid, Enter morse code");
        typedcode = in.nextLine();
    }
    
    
    
    String[] sentence2 = typedcode.split("\\|\\|");  // Array to seperate each letter entered in morse code
        
        for(int r=0; r<sentence2.length; r++ ){
    
                for(int h = 0; h<MorseCode.length; h++){
                    
                    
                    
                    if(sentence2[r].equals("")){
                        
                        System.out.print("\t");
                    }
                    
                    if(sentence2[r].equals(MorseCode[h])){
                        
                        System.out.print(AlphaNum[h]);
                        
                    }
                   
                    
                
                }
        
        
        }
        
    
  } // IF statement to read file or write
    
    
} // Main method
} // MorseCode class