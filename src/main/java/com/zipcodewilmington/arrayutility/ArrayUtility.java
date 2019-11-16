package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private ArrayList<E> arrayList;
    private E[] inputArray;

    public ArrayUtility(E[] arrayList){
        this.arrayList = new ArrayList<E>(Arrays.asList(arrayList));
        this.inputArray = arrayList; //ehhh....
    }

    public E[] removeValue(E valueToRemove){
        while(arrayList.contains(valueToRemove)) {
            this.arrayList.remove(valueToRemove);
        }
        return this.arrayList.toArray(Arrays.copyOf(inputArray,arrayList.size()));
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        Integer count = 0;
        //Find an appropriate way to accomplish this
        E[] mergedArr = (E[]) Arrays.copyOf(arrayList.toArray(), arrayList.size() + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, mergedArr, arrayList.size(), arrayToMerge.length);
        for (int i = 0; i < mergedArr.length; i++) {
            if (mergedArr[i] == valueToEvaluate){
                count++;
            }
        }
        return count;
    }


            public Integer getNumberOfOccurrences(E valuteToEvaluate){
        Integer count = 0;
        for(E current : arrayList){
            if(current.equals(valuteToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public E getMostCommonFromMerge(E [] arrayToMerge){
        E mostCommon = arrayList.get(0);
        Integer mostCommonCount = 0;
        //Find an appropriate way to accomplish this
        E[] mergedArr = (E[]) Arrays.copyOf(arrayList.toArray(), arrayList.size() + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, mergedArr,arrayList.size(),arrayToMerge.length);

        for(int i =0; i < mergedArr.length;i++){
            Integer currentCount = getNumberOfOccurrences(mergedArr[i]);
            if(currentCount > mostCommonCount){
                mostCommonCount = currentCount;
                mostCommon = mergedArr[i];
            }
        }
        return mostCommon;
    }
}
