class MergeSort {
    int[] a = {12, 89, 47, 96, 45, 33, 128};
    int[] b = new int[a.length];

    void merging(int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        while (i <= mid) {
            b[k++] = a[i++];
        }

        while (j <= high) {
            b[k++] = a[j++];
        }

        for (i = low; i <= high; i++) {
            a[i] = b[i];
        }
    }

    void sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            merging(low, mid, high);
        }
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int n = obj.a.length;

        System.out.println("Array before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(obj.a[i] + " ");
        }
        System.out.println();

        obj.sort(0, n - 1);

        System.out.println("Array after sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(obj.a[i] + " ");
        }
    }
}
