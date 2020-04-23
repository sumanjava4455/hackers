public class StringManupulation {

	public static void main(String []args) throws IOException
	{
		package hackers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringManupulation {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Text:");
		String text = br.readLine();
		
		System.out.println("Prefix:");
		String prefix = br.readLine();
		System.out.println("Suffix:");
		String suffix = br.readLine();

        String result = calculateScore(text, prefix, suffix);
        System.out.println(result);
    }
 
    static String calculateScore(String text, String prefix, String suffix) {
 
        int n = text.length();
        int sl = suffix.length();
        int pl = prefix.length();
 
 
        Map<String, Integer> map = new HashMap<>();
 
        for(int i =0; i<n; i++) {
            for(int j = i+1; j<=n; j++) {
 
                String sub = text.substring(i,j);
 
                int ps = 0, ss = 0, subL = sub.length();
 
                for(int k =0; k < subL; k++) {
                    if(subL - k <= sl) {
                        if(sub.substring(k).equals(suffix.substring(0,subL-k))) {
                            ps = Math.max(subL-k, ps);
                        }
                    }
                }
 
                for(int k =0; k < subL; k++) {
                    if(k < pl) {
                        if(sub.substring(0,k+1).equals(prefix.substring(pl-k-1, pl))) {
                            ss = Math.max(k+1,ss);
                        }
                    }
                }
 
                if(map.get(sub)==null) {
                    map.put(sub, ps+ss);
                } else {
                    map.put(sub, Math.max(map.get(sub), ps+ss));
                }
            }
        }
        int m = -1;
        Set<String> keys = map.keySet();
 
        String[] arr = keys.toArray(new String[keys.size()]);
 
        Arrays.sort(arr);
        String ans = null;
        for(int i = 0; i<arr.length; i++) {
            if(m < map.get(arr[i])) {
                ans = arr[i];
                m = map.get(arr[i]);
            }
        }
 
        return ans;
    }
	}


