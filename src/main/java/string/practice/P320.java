package string.practice;

/**
 * @ClassName P320
 * @Description TODO
 * @Author hylz
 * @Date 2021/6/1 18:08
 * @Version 1.0
 **/
public class P320 {

}

class TrieNode {
	public int path;
	public int end;
	public TrieNode[] map;

	public TrieNode() {
		path = 0;
		end = 0;
		map = new TrieNode[256];
	}
}

class Trie{
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	public void insert(String word){
		char[] w = word.toCharArray();
		TrieNode node = root;
		node.path++;
		for (int i=0;i<w.length;i++){
			if (node.map[w[i]] == null){
				node.map[w[i]] = new TrieNode();
			}
			node.path++;
			node = node.map[w[i]];
		}
		node.end++;
	}

	public boolean search(String word){
		char[] w = word.toCharArray();
		TrieNode node = root;
		for (int i=0;i<w.length;i++){
			if (node.map[w[i]] == null){
				return false;
			}
			node = node.map[w[i]];
		}
		return node.end != 0;
	}

	public void delete(String word){
		if (search(word)) {
			char[] w = word.toCharArray();
			TrieNode node = root;
			for (int i = 0; i < w.length; i++) {
				if (node.path-- == 1) {
					node.map = new TrieNode[256];
					node.end = 0;
					return;
				}
				node = node.map[w[i]];
			}
			node.end--;
		}
	}

}