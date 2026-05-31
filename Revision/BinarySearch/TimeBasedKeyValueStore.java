package Revision.BinarySearch;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TimeBasedKeyValueStore {
    static class TimeMap {

    Map<String,List<Integer>> keyVsTimes;
    Map<Integer,String> timesVsValues;

    public TimeMap() {
        keyVsTimes = new HashMap<>();
        timesVsValues = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        timesVsValues.put(timestamp,value);
        keyVsTimes.computeIfAbsent(key,k->new ArrayList<>()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!keyVsTimes.containsKey(key)) return "";
        int timesInMap = getFromLowerBound(keyVsTimes.get(key) ,timestamp);
        if(!timesVsValues.containsKey(timesInMap)) return "";
        return timesVsValues.get(timesInMap);
    }

    public int getFromLowerBound(List<Integer> times , int target){
        int l=0,r=times.size()-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(target == times.get(m)) return times.get(m);
            if(target < times.get(m)) r=m-1;
            else l=m+1;
        }
        return r<0 ? -1 : times.get(r);
    }

    }
    
    public static void main(String[] args){
        TimeMap tm = new TimeMap();

        /*
        tm.set("ctondw","ztpearaw",1);
        tm.set("vrobykydll","hwliiq",2);
        tm.set("gszaw","ztpearaw",3);
        tm.set("ctondw","gszaw",4);
        System.out.println(tm.get("gszaw",5));
        */

        tm.set("foo","bar",1);
        System.out.println(tm.get("foo",1));
        System.out.println(tm.get("foo",3));
        tm.set("foo","bar1",4);
        System.out.println(tm.get("foo",4));
        System.out.println(tm.get("foo",5));

    }
}
// [[],["ctondw","ztpearaw",1],["vrobykydll","hwliiq",2],["gszaw","ztpearaw",3],["ctondw","gszaw",4],["gszaw",5],["ctondw",6],["ctondw",7],["gszaw",8],["vrobykydll",9],["ctondw",10],["vrobykydll","kcvcjzzwx",11],["vrobykydll",12],["ctondw",13],["vrobykydll",14],["ztpearaw","zondoubtib",15],["kcvcjzzwx","hwliiq",16],["wtgbfvg","vrobykydll",17],["hwliiq","gzsiivks",18],["kcvcjzzwx",19],["ztpearaw",20]]