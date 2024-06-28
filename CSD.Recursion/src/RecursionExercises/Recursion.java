package RecursionExercises;

public class Recursion {

    int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    int findMin(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return Math.min(a[n - 1], findMin(a, n - 1));
    }

    int findSum(int a[], int n) {
        if (n - 1 == 0) {
            return a[0];
        } else {
            return a[n - 1] + findSum(a, n - 1);
        }

    }

    int isPalindrome(char a[], int n) {
        int m = a.length;
        if (n - 1 < m / 2) {
            return 1;
        }
        if (a[n - 1] != a[m - 1 - (n - 1)]) {
            return 0;
        } else {
            return isPalindrome(a, n - 1);
        }
    }

    void sort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    boolean binarySearch(int[] a, int x, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if (x == a[mid]) {
                return true;
            } else if (x > a[mid]) {
                return binarySearch(a, x, mid + 1, high);
            } else {
                return binarySearch(a, x, low, mid - 1);
            }
        }
    }

    int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    int power(int x, int n) {
        if (n == 1) {
            return x;
        } else {
            return x * power(x, n - 1);
        }
    }

    int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n >= 1) {
            return fib(n - 1) + fib(n - 2);
        }
        return 0;
    }

    double addReciprocals(int n) {
        if (n == 1) {
            return 1.0;
        } else {
            return 1.0 / n + addReciprocals(n - 1);
        }
    }

    int stirlingNumber(int n, int k) {
        if (n == 0 && k == 0) {
            return 1;
        }
        if (n > 0 && k == 0) {
            return 0;
        }
        if (n >= 0 && k > 0) {
            return stirlingNumber(n - 1, k - 1) - n * stirlingNumber(n - 1, k);
        }
        return 0;
    }
}
