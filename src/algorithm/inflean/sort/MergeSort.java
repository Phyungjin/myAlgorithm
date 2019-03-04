package algorithm.inflean.sort;
import java.util.Arrays;

public class MergeSort {
    
    public MergeSort() {        
        int[] data = {4,3,2,1};
        mergeSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
    
    void mergeSort(int data[], int p, int r) {
        if(p < r){
            int q =(p+r)/2;
            mergeSort(data, p, q);
            mergeSort(data, q+1, r);
            merge(data, p, q, r);
        }
    }
    
    void merge(int data[], int p, int q, int r) {
        int i=p;
        int j=q+1;
        int k=p;
        int[] tmp = new int[data.length];
        while(i<=q && j<=r) {
            if(data[i] <= data[j]){
                tmp[k++] = data[i++];
            }else {
                tmp[k++] = data[j++];
            }
        }
        
        while(i<=q)
            tmp[k++] = data[i++];
        
        while(j<=r)
            tmp[k++] = data[j++];
        
        for(int n=p ; n<=r ; n++)
            data[n] = tmp[n];
        
        System.out.println("data >>> " + Arrays.toString(data));
    }
}


/*
Devide and Conquer - 분할정복법
 - merge sort, quick sort, heap sort

** 분할정복법은 본질적으로 recursion을 사용

분할 : 해결하고자 하는 문제를 작은 크기의 동일한 문제로 분할
정복 : 각각의 문제를 순환적으로 해결 (recursion)
합병 : 작은 문제의 해를 합하여(merge) 원래 문제에 대한 해를 구함

*/

/*
Merge sort에서는 Merge할 때가 중요!
--> 추가배열(배열3(k))을 이용하고 정렬된 두 배열(배열1(i), 배열2(j))을 Merge
A[i], A[j] 중 작은 값이 A[k]로

<pseudo code - Merge Sort>

mergeSort(A[], p, r) // 배열 A[p...r]을 정렬한다.
{
    if (p < r) then {
        q <- (p+r)/2;  ----(1) >> p, r의 중간 지점 계산
        mergeSort(A, p, q); ----(2) >> 전반부 정렬
        mergeSort(A, q+1, r); ----(3) >> 후반부 정렬
        merge(A, p, q, r); ----(4) >> 합병
    }
}

merge(A[], p, q, r)
{
    정렬되어 있는 두 배열 A[p...q]와 A[q+1...r]을 합하여
    정렬된 하나의 배열 A[p...r]을 만든다.
}

- 시간복잡도
    T(n) = 
        { 0 if(n=1)
        { T([n/2]) + T([n/2]) + n otherwise.
        
    T(n) = O(nlog2n)
*/