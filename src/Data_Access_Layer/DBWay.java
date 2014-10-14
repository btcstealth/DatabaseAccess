package Data_Access_Layer;

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
                Way ways = new Way();
                ways.setId(res.getLong("id"));
                nodeIdString = res.getString("nodes");
                tempString = nodeIdString.split(",");
                for (int i = 0; i < tempString.length; i++){
                    tempString[i] = tempString[i].replaceAll("[{}]","");
                    //System.out.println(tempString[i]);
                    tempLong = (long) (Long.parseLong(tempString[i]));
                    longList.add(tempLong);
                }

                List<Long> nodeList = new ArrayList<Long>(longList);
                ways.setNode_ids(nodeList);

                // Clear the list after each while iteration
                longList.clear();
                waysList.add(ways);
                System.out.println(waysList.size());

                /*
                longArray = (int[])(res.getArray("nodes").getArray());

                for (int i = 0; i < longArray.length; i ++){
                    longList.add(intArray[i]);
                }
                ways.setNode_ids(intList);
                */
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
