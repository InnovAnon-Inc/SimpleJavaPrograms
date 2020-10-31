package com.innovanon.sjp;

public interface CompareCondition<T extends Comparable<T>> {
	/* public */ boolean compare (T a, T b) ;
}
