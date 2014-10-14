import Business_Logic_Layer.BLLMapmatch;
import Business_Logic_Layer.BLLWay;
import Model_Layer.*;

import java.util.List;

/**
 * Created by bjarke on 10/14/2014.
 */
public class Program {
    public static void main(String args[]) {

        //DBConnect connection = new DBConnect();
        //DBWay dbWayObj = new DBWay();

        // All functions are then called from the business logic layer, which returns the calls from further down.
        // This is done to separate logic and create less dependencies.
        BLLWay bllWayObj = new BLLWay();

        List<Way> wayList = bllWayObj.getAllWays();

        for (int i = 0; i < wayList.size(); i++) {
            System.out.println("Id: " + wayList.get(i).getId() + " nodeId: " + wayList.get(i).getNode_ids());
        }

        // This object is ment to implement the mapmatching.
        // The mashine learning algorithm should get its own class as well in the Business Logic Layer
        BLLMapmatch bllMapmatchObj = new BLLMapmatch();

    }
}
