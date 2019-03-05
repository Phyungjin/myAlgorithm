package algorithm.inflean.sort;
import java.util.Arrays;

public class QuickSort {
    public QuickSort() {
        int[] data = {7,6,5,4,3,2,1};
        quickSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
    
    void quickSort(int[] data, int p, int  r) {
        if(p<r) {
            int q = partition(data, p, r);
            quickSort(data, p, q-1);
            quickSort(data, q+1, r);
        }
    }
    
    int partition(int[] data, int p, int r) {
        int i = p-1;
        int x = data[r];
        for(int j=p ; j<r ; j++ ) {
            if(x >= data[j]) { // exchange
                i++;
                int tmp = data[j];
                data[j] = data[i];
                data[i] = tmp;
            }
        }
        
        int tmp = x;
        data[r] = data[++i];
        data[i] = tmp;
        return i;
    }
}

/*
분할정복법 - Quick Sort
(일단 여기선 pivot을 기준을 맨 끝값으로 하겠음.)
1. 분할
Merge Sort와 달리 기준 값을 pivot
pivot보다 작은 값   pivot보다 큰 값으로 분할

2. 정복
각 부분을 recursion으로 정렬

3. 합병
nothing to do

quick sort에서 중요한 것은 pivot을 기준으로 partition설정

<pseudo code - Quick Sort>
quickSort(A[], p, r)
{
    if(p<r) then {
        q = partition(A, p, r); >> 분할
        quickSort(A, p, q-1); >> 왼쪽 부분배열 정렬
        quickSort(A, q+1, r); >> 오른쪽 부분배열 정렬   
    }
}

배열 A[p...r]의 원소들을 A[r]을 기준으로 양쪽으로 재배치하고
    A[r]이 자리한 위치를 return
    
    if A[j] >= x
        j <- j+1;
    else
        i <- i+1;
        exchange A[i] and A[j];
        j <- j+1; 
        
partition(A[], p, r)
{
    x <- A[r];
    i <- p-1;
    for j<-p to r-1
    if A[j] <= x then
        i<-i+1;
        exchange A[i] and A[j];
    exchange A[i+1] and A[r];
    return i+1;
}

partition하는데 걸리는 시간은 n-1 비교연산

시간 복잡도

<최악의 경우>
- 항상 한 쪽은 0개, 다른 쪽은 n-1개로 분할되는 경우
T(n) = T(0) + T(n-1) + O(n)
     = T(n-1) + O(n)
     = T(n-2) + T(n-1) + O(n-1) + O(n)
     = O(1) + O(2) + ... + O(n-1) + O(n)
     = O(n^2)

- 이미 정렬된 입력 데이터 (마지막 원소를 pivot으로 선택하는 경우)

<최선의 경우>
- 항상 절반으로 분할되는 경우
T(n) = 2T(n/2) + O(n)
     = O(nlogn)
     
Q) 항상 한쪽이 적어도 1/9 이상이 되도록 분할된다면?

**첫번째 값이나 마지막 값을 피봇으로 선택
    >> 이미 정렬된 데이터 혹은 거꾸로 정렬된 데이터가 최악의 경우
    >> 현실의 데이터는 랜덤하지 않으므로 (거꾸로) 정렬된 데이터가 입력으로 들어올 가능성은 매우 높음
    >> 따라서 좋은 방법이라고 할 수 없음
    
** Median of Three
    >> 첫번째 값과 마지막 값, 그리고 가운데 값 중에서 중간값(median)을 피봇으로 선택
    >> 최악의 경우 시간복잡도가 달라지지는 않음

** Randomized QuickSort
    >> 피봇을 랜덤하게 선택
    >> no worst case instance, but worst case execution
    >> 평균 시간복잡도 O(NlogN)
*/