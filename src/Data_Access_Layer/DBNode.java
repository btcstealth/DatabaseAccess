package Data_Access_Layer;

import Model_Layer.Node;
import com.sun.deploy.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjarke on 10/14/2014.
 */
public class DBNode {
    private Connection con;

    public DBNode() {
        con = DBConnect.getInstance().getDBcon();
    }

    public List<Node> getNodesByIds(List<Long> ids){

        List<Node> nodeList = new ArrayList<Node>();
        String idsString = formatIdsToString(ids);

        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT id, lat, lon FROM planet_osm_nodes WHERE id IN (" + idsString + ")");

            while (res.next()){
                Node nodeObj = new Node();
                nodeObj.setId(res.getLong("id"));
                nodeObj.setLat(res.getDouble("lat"));
                nodeObj.setLon(res.getDouble("lon"));
                nodeList.add(nodeObj);
            }

        }
        catch (SQLException se){
            se.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return nodeList;
    }

    public String formatIdsToString(List<Long> ids){
        String tempIdString = "";

        /*
        for (int i = 0; i < ids.size(); i++){
            tempIdString += ids.get(i).toString() + ",";
        }
        */

        for (Long i : ids) {
            tempIdString += i.toString() + ",";
        }
        tempIdString = tempIdString.substring(0,tempIdString.length()-1);

        return tempIdString;
    }

}
