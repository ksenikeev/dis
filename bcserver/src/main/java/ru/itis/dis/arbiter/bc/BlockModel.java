package ru.itis.dis.arbiter.bc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BlockModel {
    private String prevhash;
    private DataModel data;
    private String signature;
    private String ts;
    private String publickey;

    @JsonIgnore
    private BlockStat stat;

    // return as normalized JSON object
    public String toString() {
        return new StringBuilder().append("{")
                .append("\"prevhash\":\"").append(prevhash).append("\",")
                .append("\"data\":").append(data.toString()).append(",")
                .append("\"signature\":\"").append(signature).append("\",")
                .append("\"ts\":\"").append(ts).append("\",")
                .append("\"publickey\":\"").append(publickey).append("\"}")
                .toString();
    }
}
