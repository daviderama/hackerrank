public static int numberNeeded(String first, String second) {
    // counter for all the letters of the english alphabet
    int[] lettersCounter = new int[26];
    char c;
    for( int i = 0; i < first.length(); i++ ){
        c = first.charAt(i);
        lettersCounter[ c - 'a' ]++;
    }
    for( int i = 0; i < second.length(); i++ ){
        c = second.charAt(i);
        lettersCounter[ c - 'a' ]--;
    }

    int sum = 0;
    for( int i = 0; i < lettersCounter.length; i++ ){
        sum += Math.abs( lettersCounter[i] );
    }

    return sum;
}
