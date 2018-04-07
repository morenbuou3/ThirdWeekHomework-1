package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left <= right) {
            return IntStream.iterate(left, n -> n + 1).limit(right - left + 1).boxed().collect(Collectors.toList());
        } else {
            return IntStream.iterate(left, n -> n - 1).limit(left - right + 1).boxed().collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left <= right) {
            return IntStream.iterate(left, n -> n + 1).limit(right - left + 1).boxed().filter(n -> n % 2 == 0).collect(Collectors.toList());
        } else {
            return IntStream.iterate(left, n -> n - 1).limit(left - right + 1).boxed().filter(n -> n % 2 == 0).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).skip(array.length - 1).boxed().collect(Collectors.toList()).get(0);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).filter(n -> Arrays.stream(secondArray).boxed().collect(Collectors.toList()).contains(n)).boxed().collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        return Stream.concat(Arrays.stream(firstArray), Arrays.stream(secondArray)).distinct().collect(Collectors.toList());
    }
}
