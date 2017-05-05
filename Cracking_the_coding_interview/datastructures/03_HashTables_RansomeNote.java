// Hash Tables: Ransome Note
// https://www.hackerrank.com/challenges/ctci-ransom-note

import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        this.magazineMap = buildMap( magazine );
        this.noteMap = buildMap( note );
    }

    public Map<String, Integer> buildMap(String text) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] words = text.split(" ");
        for( int i = 0; i < words.length; i++ ){
            String word = words[ i ];
            Integer value = map.get( word );
            if( value == null ){
                map.put( word, 1 );
            } else {
                map.put( word, value+1 );
            }
        }

        return map;
    }

    public boolean solve() {

        boolean answer = true;
        for( Map.Entry<String, Integer> entry : this.noteMap.entrySet() ){
            String noteWord = entry.getKey();
            Integer noteWordValue = entry.getValue();
            if( this.magazineMap.get( noteWord ) < noteWordValue ){
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}

