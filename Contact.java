import java.io.*;
import java.util.*;

public class Contact{
    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> response = new ArrayList<>();
        for(int i=0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String action = query.get(0);
            String key = query.get(1);
            if( action == "add"){
                for (int j = 1; j <= key.length(); j++){
                    String sub = key.substring(0, j);
                    if (map.get(sub) == null){
                        map.put(sub, 1);
                    } else {
                        map.put(sub, map.get(sub) + 1);
                    }
                }
            }else if(action == "find"){
                if (map.get(key) == null){
                    response.add(0);
                } else {
                    response.add(map.get(key));
                }
            }
        }
        return response;
    }

    public static void main(String[] args) throws IOException {

        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("add");
        query1.add("hack");
        queries.add(query1);
        List<String> query2 = new ArrayList<>();
        query2.add("add");
        query2.add("hackerrank");
        queries.add(query2);
        List<String> query3 = new ArrayList<>();
        query3.add("find");
        query3.add("hac");
        queries.add(query3);
        List<String> query4 = new ArrayList<>();
        query4.add("find");
        query4.add("hak");
        queries.add(query4);
        List<Integer> result = contacts(queries);
        System.out.println(result);
    }
}
