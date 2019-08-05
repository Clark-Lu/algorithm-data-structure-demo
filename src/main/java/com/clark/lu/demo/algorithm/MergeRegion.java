package com.clark.lu.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by LuChang
 * 2019/8/5 17:28
 */
public class MergeRegion {

    public static int[][] merge(int[][] intervals){
        if (intervals.length <= 1){
            return intervals;
        }
        List<Region> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            Region region = new Region(intervals[i][0],intervals[i][1]);
            list.add(region);
        }
        list.sort((o1, o2) -> {
            if (o1.start < o2.start){
                return -1;
            }else if (o1.start > o2.start){
                return 1;
            }else {
                return 0;
            }
        });
        List<Region> mergedList = merge(list.get(0), list.get(1));
        for (int i = 2; i < list.size(); i++) {
            List<Region> merge = merge(mergedList.get(mergedList.size() - 1), list.get(i));
            if (merge.size() == 1){
                mergedList.set(mergedList.size()-1,merge.get(0));
            }else {
                mergedList.add(merge.get(1));
            }
        }
        int[][] result = new int[mergedList.size()][2];
        for (int i = 0; i < mergedList.size(); i++) {
            result[i][0] = mergedList.get(i).start;
            result[i][1] = mergedList.get(i).end;
        }
        return result;
    }

    private static List<Region> merge(Region region1,Region region2){
        List<Region> list = new ArrayList<>(2);
        if (region1.end >= region2.start){
            if (region1.end >= region2.end){
                list.add(region1);
            }else {
                Region region = new Region(region1.start,region2.end);
                list.add(region);
            }
        }else {
            list.add(region1);
            list.add(region2);
        }
        return list;
    }
    static class Region{

        private int start;

        private int end;

        public Region(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

    }



}
