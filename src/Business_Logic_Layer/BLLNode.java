package Business_Logic_Layer;

import Data_Access_Layer.DBNode;
import Model_Layer.Node;

import java.util.List;

/**
 * Created by bjarke on 10/16/2014.
 */
public class BLLNode {

    private static DBNode dbNodeObj = new DBNode();

    public List<Node> getNodesById(List<Long> ids){
        try{
            return dbNodeObj.getNodesByIds(ids);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dbNodeObj.getNodesByIds(ids);
    }
}
