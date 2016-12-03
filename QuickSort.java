//simon
//12/03/2016
package com.mypackage;

import java.util.Scanner;

public class QuickSort {
private Scanner scanner=null;
private Integer[] intArray=null;
private Integer size;
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort quickSort=new QuickSort();
		quickSort.enterValues();
		quickSort.sort();
		quickSort.print();
	}
	public QuickSort() {
		super();
		// TODO Auto-generated constructor stub
		scanner=new Scanner(System.in);
	}
	private void enterValues() {
		// TODO Auto-generated method stub
		System.out.println("size ?");
		size=scanner.nextInt();
		intArray=new Integer[size];
		System.out.println("values ?");
		for(Integer index = 0; index < size; index++){
			intArray[index]=scanner.nextInt();
		}
	} 
	private void print() {
		// TODO Auto-generated method stub
		System.out.print("sorted array = ");
		for(Integer indexK=0;indexK<intArray.length;indexK++){
			System.out.print("\t"+intArray[indexK]);
		}
	}
	private void sort() {
		// TODO Auto-generated method stub
		quickSort(0,intArray.length-1);
	}
	private void quickSort(int start, int end) {
		// TODO Auto-generated method stub
		if(start == end){
			return;
			}
		else{
			Integer pivot=intArray[start];
			Integer indexI=start+1;
			Integer indexJ=end;
			while(!(indexJ<indexI)){
				if(intArray[indexI]<=pivot){
					indexI++;
				}
				else{
					if(intArray[indexJ]<pivot){
					  swap(indexI,  indexJ);
					}
				}
				if(intArray[indexJ]>=pivot){
					indexJ--;
				}
				else{
					if((indexI<=end) && (indexI<indexJ) && (intArray[indexI]>pivot)){ //if no first condition array out of index
//						if second condition misses it makes bad decision i will iterate and condition check only after this loop
						  swap(indexI,  indexJ);
						}
				}
			}
			swap(start,indexJ);
			if(indexJ==start){ //at the end if like 123 pattern, indexI at 1 so index j not move to -1
			  quickSort(indexJ+1, end);
			}
			else if(indexJ==end){ //like pattern 321 
				quickSort(start, indexJ-1);
			}
			else{
				quickSort(start, indexJ-1); //recursive calling 2 partions
				quickSort(indexJ+1, end);
			}
		}
	}
	private void swap(Integer indexI, Integer indexJ) {
		// TODO Auto-generated method stub
		Integer tempValue;
		tempValue=intArray[indexI];
		intArray[indexI]=intArray[indexJ];
		intArray[indexJ]=tempValue;
	}

}
