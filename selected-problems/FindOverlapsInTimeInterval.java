import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class FindOverlapsInTimeInterval {
    public static void main(String args[]){

        // to find if the intervals overlap
        int[] start = { 6, 1, 2, 4 }, end = { 8, 3, 4, 7 };
        System.out.println(isOverlapping(start, end));

        int[] start2 = { 1, 7, 4, 10 }, end2 = { 3, 9, 6, 13 };
        System.out.println(isOverlapping(start2, end2));


        // to merge the overlapping intervals
        Interval[] intervals = {
            new Interval(6,8),
            new Interval(1,9),
            new Interval(2,4),
            new Interval(4,7),
        };
        mergeOverlappedIntervals(intervals);
        // System.out.println(mergeOverlappedIntervals(intervals));
    }

    /*
        start[] = stores the starting points of the intervals
        end[] = stores the ending points of the intervals
        to find if the intervals overlap
    */
    public static boolean isOverlapping(int[] start, int[] end) {
        int sLen = start.length, eLen = end.length;
        if(sLen != eLen)    
            return false;
        int max_time = Integer.MIN_VALUE;
        for(int i = 0; i < end.length; i++)
            if(max_time <  end[i])
                max_time = end[i];
        
        int[] arr = new int[max_time+2];

        for(int i = 0; i < end.length; i++) {
            int u = start[i], v = end[i];
            arr[u]++;
            arr[v+1]--;
        }
        
        // int maxOverlap = 0, index = -1;

        for(int i = 1; i < end.length; i++) {
            arr[i] += arr[i-1];
            if(arr[i] >= 2)
                return true;

            /*
                To find the maximum overlaps remove the check for overlapping
                uncomment below code 
            */

            // if(arr[i] > maxOverlap) {
            //     maxOverlap = arr[i];
            //     index = i;
            // }
        }

        /* 
            to find maximum overlaps return below commented values
            
            maxOverlap - for getting the maximum overlaps at a given time
            index - for getting the point where maximum overlaps occur

        */

        return false;
    }
    
    /*
        intervals[] = stores the intervals of the input
        to merge the overlapping intervals
    */
    public static void mergeOverlappedIntervals (Interval[] intervals) {
        int n = intervals.length;
        if(n == 0)
            return;

        Stack<Interval> stack = new Stack<>();

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        stack.push(intervals[0]);

        for(int i = 1; i < n; i++){
            Interval interval = stack.peek();

            if(interval.end < intervals[i].start)
                stack.push(intervals[i]);
            else if(interval.end < intervals[i].end){
                interval.end = intervals[i].end;
            }
        }
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            Interval interval = stack.pop();
            System.out.print(" "+ interval.start+" -> "+interval.end+":");            
        }
        System.out.println(stack);
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}