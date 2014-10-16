import Business_Logic_Layer.BLLMapmatch;
import Business_Logic_Layer.BLLNode;
import Business_Logic_Layer.BLLWay;
import Data_Access_Layer.DBConnect;
import Model_Layer.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjarke on 10/14/2014.
 */
public class Program {
    public static void main(String args[]) {

        DBConnect con = new DBConnect();
        con.connect();

        // All functions are then called from the business logic layer, which returns the calls from further down.
        // This is done to separate logic and create less dependencies.


        BLLWay bllWayObj = new BLLWay();

        List<Way> wayList = bllWayObj.getAllWays();

        for (int i = 0; i < wayList.size(); i++) {
            System.out.println("Id: " + wayList.get(i).getId() + " nodeId: " + wayList.get(i).getNode_ids());
        }







        // This object is ment to implement the mapmatching.
        // The mashine learning algorithm should get its own class as well in the Business Logic Layer
        // BLLMapmatch bllMapmatchObj = new BLLMapmatch();



        /*


        List<Long> nodeIds = new ArrayList<Long>();
        nodeIds.add(25248662L);
        nodeIds.add(25248785L);

        BLLNode bllNodeObj = new BLLNode();

        List<Node> nodeList = bllNodeObj.getNodesById(nodeIds);

        for (Node i : nodeList){
            System.out.println(i.getId());
            System.out.println(i.getLat());
            System.out.println(i.getLon());
        }
        */
    }
}
