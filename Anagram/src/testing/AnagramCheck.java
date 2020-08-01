package testing;

public class AnagramCheck {
	
	public String isAnagram(String a, String b) {
		
		a = a.toLowerCase();
	    b = b.toLowerCase();
		
		boolean isAna = false;
	    int aCheck[] = new int[256];
	    int bCheck[] = new int[256];
	    
	    if(a.length() == b.length()){
	      for(int i = 0; i<a.length(); ++i){
	        aCheck[a.charAt(i)]++;
	        bCheck[b.charAt(i)]++;
	      }
	      
	      for(int i = 0; i<a.length(); ++i){
	        if(aCheck[a.charAt(i)] == bCheck[a.charAt(i)]){
	          isAna = true;
	        }  
	        else{
	          isAna = false;
	          break;
	        }
	      }
	    }
	    if(isAna==false) return "Not an Anagram.";
	    else return "Anagram!";
	}

}
