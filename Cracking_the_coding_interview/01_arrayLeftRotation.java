// Solution found reasoning on paper
public static int[] arrayLeftRotation(int[] a, int n, int k) {
    int i = a.length-1;
    int j;
    int[] result = new int[n];

    while( i >= 0 ) {
        j = i - k;
        if( j < 0 )
            j = n + j;

        result[j] = a[i];
        i--;
    }

    return result;
}

// Solution found when realized that was actually modular arithmetic
public static int[] arrayLeftRotation(int[] a, int n, int k) {
    int j;
    int[] result = new int[n];
    for( int i=0; i < a.length; i++ ){
        j = (i + k) % n;

        result[i] = a[j];
    }

    return result;
}
