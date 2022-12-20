package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
       StringBuilder bob = new StringBuilder(str);
       str = bob.append(characters).toString();
       
    	return str;
    }
    
    public static String reverse(String str) {
    	StringBuilder bob = new StringBuilder(str);
    	str = bob.reverse().toString();
        return str;
        
    }
    
    public static String insert(String str, int index, char newChar) {
    	StringBuilder bob = new StringBuilder(str);
    	str = bob.insert(index, newChar).toString();
        return str;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	StringBuilder bob = new StringBuilder(str);
    	str = bob.delete(startIndex, endIndex).toString();
        return str;
    }
}