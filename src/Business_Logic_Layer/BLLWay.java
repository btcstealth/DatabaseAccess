package Business_Logic_Layer;

import Data_Access_Layer.DBWay;
import Model_Layer.Way;

import java.util.List;

/**
 * Created by bjarke on 10/14/2014.
 */
public class BLLWay {
    private static DBWay dbWayObj = new DBWay();

    public List<Way> getAllWays(){
        try{
            return dbWayObj.getAllWays();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dbWayObj.getAllWays();
    }
}
