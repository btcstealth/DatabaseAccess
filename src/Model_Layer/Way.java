package Model_Layer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjarke on 10/14/2014.
 */
public class Way {
    private long id;
    private List<Long> node_ids = new ArrayList<Long>();

    public Way() {
    }

    public Way(long id, List<Long> node_ids) {

        this.id = id;
        this.node_ids = node_ids;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getNode_ids() {
        return node_ids;
    }

    public void setNode_ids(List<Long> node_ids) {
        this.node_ids = node_ids;
    }
}
