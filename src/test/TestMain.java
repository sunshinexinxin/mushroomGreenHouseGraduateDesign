package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anke on 2017/10/16.
 */
public class TestMain {
    public static void main(String[] args){

        ArrayList mushRoomList = new ArrayList();
        mushRoomList.add("1");
        mushRoomList.add("2");
        mushRoomList.add("3");
        System.out.println(mushRoomList);
        Map mushRoomMaps = new HashMap<>();
        Map mushRoomMap = new HashMap<>();
        for (int i = 0; i < mushRoomList.size(); i++) {
            mushRoomMap.put("mushroomLat", mushRoomList.get(i));
            System.out.println(mushRoomMap);
            mushRoomMaps.put("point"+(i+1),mushRoomMap);
            System.out.println(mushRoomMaps);
            mushRoomMap.clear();
        }
    }
}
