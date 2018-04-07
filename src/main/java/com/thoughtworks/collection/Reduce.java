package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    public double getAverage() {
        return arrayList.stream().collect(Collectors.averagingDouble(Integer::intValue));
    }

    public double getOrderedMedian() {
        int index = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            return arrayList.stream().sorted().skip(index - 1).limit(2).collect(Collectors.averagingDouble(n -> n));
        } else {
            return arrayList.stream().sorted().skip(index).findFirst().get();
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(n -> n % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean flag1 = this.arrayList.stream().filter(n -> !arrayList.contains(n)).collect(Collectors.toList()).isEmpty();
        boolean flag2 = arrayList.stream().filter(n -> !this.arrayList.contains(n)).collect(Collectors.toList()).isEmpty();
        return flag1 && flag2;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {
        for (int i = 0; i < arrayList.size(); i++) {
            singleLink.addTailPointer(arrayList.get(i));
        }
        int index = arrayList.size();
        if (index % 2 == 0) {
            int result = singleLink.getNode(index / 2) + singleLink.getNode(index / 2 + 1);
            return (double) result / 2;
        } else {
            return (double) singleLink.getNode(index / 2 + 1);
        }
    }

    public int getLastOdd() {
        long count = arrayList.stream().filter(n -> n % 2 != 0).count();
        return arrayList.stream().filter(n -> n % 2 != 0).skip(count - 1).findFirst().get();
    }

    public int getIndexOfLastOdd() {
        int index = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                index = i;
                break;
            }
        }
        return index;
    }
}
