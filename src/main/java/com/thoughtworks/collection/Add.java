package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start, end;
        int sum = 0;
        if (leftBorder < rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        return IntStream.rangeClosed(start, end).filter(n -> n % 2 == 0).reduce(0, Integer::sum);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start, end;
        if (leftBorder < rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        return IntStream.rangeClosed(start, end).filter(n -> n % 2 == 1).reduce(0, Integer::sum);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = arrayList.stream().map(n -> n * 3 + 2).reduce(0, Integer::sum);
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(n -> {
            if (n % 2 == 1) {
                n = n * 3 + 2;
            }
            return n;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(n -> n % 2 == 1).map(n -> n * 3 + 5).reduce(0, Integer::sum);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum) / 2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        long num = arrayList.stream().filter(n -> n % 2 == 0).count();
        long index = num / 2;
        if (num % 2 == 0) {
            return arrayList.stream().filter(n -> n % 2 == 0).sorted().skip(index - 1).limit(2).collect(Collectors.averagingDouble(n -> n));
        } else {
            return arrayList.stream().filter(n -> n % 2 == 0).sorted().skip(index).findFirst().get();
        }
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(n -> n % 2 == 0).anyMatch(n -> n.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Stream<Integer> even = arrayList.stream().filter(n -> n % 2 == 0).sorted(Comparator.naturalOrder());
        Stream<Integer> odd = arrayList.stream().filter(n -> n % 2 == 1).sorted(Comparator.reverseOrder());
        return Stream.concat(even, odd).collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>(arrayList.get(0));
        for (int index = 1; index < arrayList.size(); index++) {
            result.add((arrayList.get(index - 1) + arrayList.get(index)) * 3);
        }
        return result;
    }
}
