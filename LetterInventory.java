//to do
public class LetterInventory{
	private int[] inventory = new int[26];
	private int size;
	//constructor
	public LetterInventory(){
		size=0;
	}
	public LetterInventory(String data) {
		size=0;
		for(int i=0;i<data.length();i++){
			if(Character.toLowerCase(data.charAt(i))-'a'<26&&Character.toLowerCase(data.charAt(i))-'a'>-1){
				inventory[Character.toLowerCase(data.charAt(i))-'a']++;
				size++;
			}
		}
	}
	public int size(){
		return size;
	}	
	public boolean isEmpty(){
		return size==0;
	}
	public int get(char letter) throws IllegalArgumentException {
		if(Character.toLowerCase(letter)-'a'>25||Character.toLowerCase(letter)-'a'<0) throw new IllegalArgumentException(Character.toString(letter));
		return inventory[Character.toLowerCase(letter)-'a'];
	}
	public String toString(){
		String body ="";
		for(int i=0;i<26;i++){
			for(int j=0;j<inventory[i];j++){
				body+=Character.toString((char)(i+'a'));
			}
		}
		return "["+body+"]";
	}
	public void set(char letter, int value) throws IllegalArgumentException{
		//If a non-alphabetic character is passed, your method should throw an IllegalArgumentException.
		if(Character.toLowerCase(letter)-'a'>25||Character.toLowerCase(letter)-'a'<0||value<0) throw new IllegalArgumentException(Character.toString(letter));
		int oldSize=inventory[Character.toLowerCase(letter)-'a'];
		inventory[Character.toLowerCase(letter)-'a']=value;
		size=size+value-oldSize;
	}
	public LetterInventory add(LetterInventory other){
		LetterInventory res = new LetterInventory();
		for(int i=0;i<26;i++){
			res.set((char)(i+'a'),this.get((char)(i+'a'))+other.get((char)(i+'a')));
		}
		return res;
	}
	public LetterInventory subtract(LetterInventory other){
		LetterInventory res = new LetterInventory();
		for(int i=0;i<26;i++){
			if(this.get((char)(i+'a'))-other.get((char)(i+'a'))<0) return null;
			res.set((char)(i+'a'),this.get((char)(i+'a'))-other.get((char)(i+'a')));
		}
		return res;
	}
	public double getLetterPercentage(char letter)throws IllegalArgumentException{
		if(Character.toLowerCase(letter)-'a'>25||Character.toLowerCase(letter)-'a'<0) throw new IllegalArgumentException(Character.toString(letter));
		double res=this.get(letter)/size;
		return res;
	}

}