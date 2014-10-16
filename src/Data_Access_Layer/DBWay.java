package Data_Access_Layer;

import Model_Layer.Node;
import Model_Layer.Way;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjarke on 10/14/2014.
 */
public class DBWay {
    private Connection con;
    DBNode dbNodeObj = new DBNode();

    public DBWay() {
        con = DBConnect.getInstance().getDBcon();
    }

    public List<Way> getAllWays() {
        long[] longArray;
        List<Long> longList = new ArrayList<Long>();
        List<Way> waysList = new ArrayList<Way>();
        String tempString[];
        long tempLong = 0;
        String nodeIdString;

        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM planet_osm_ways");

            while (res.next()){
                Way way = new Way();
                way.setId(res.getLong("id"));
                nodeIdString = res.getString("nodes");
                tempString = nodeIdString.split(",");

                for (int i = 0; i < tempString.length; i++){
                    tempString[i] = tempString[i].replaceAll("[{}]","");
                    tempLong = (long) (Long.parseLong(tempString[i]));
                    longList.add(tempLong);
                }

                List<Long> nodeList = new ArrayList<Long>(longList);
                way.setNode_ids(nodeList);
                way.setAssocNodes(dbNodeObj.getNodesByIds(nodeList));

                // Clear the list after each while iteration
                longList.clear();
                waysList.add(way);
            }

        }
        catch (SQLException se){
            System.out.println(se);
            se.printStackTrace();
        }
        catch (NumberFormatException ne){
            ne.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return waysList;
    }
}
