package com.algorithm.service;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgorithmService {

    int[] cardinalitySort(int[] arr);

    int[] quickSort(int[] arr);

    void mergeSort(int left, int right, int mid) ;
}
