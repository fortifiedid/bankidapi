/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortifiedid.bankidapi.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Anders Andrén
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HintCode {

    outstandingTransaction("outstandingTransaction"), noClient("noClient"), started("started"), userSign("userSign"), expiredTransaction("expiredTransaction"), certificateErr("certificateErr"), userCancel("userCancel"), cancelled("cancelled"), startFailed("startFailed");

    private final String hintCode;
    private String status;

    private HintCode(String hintCode) {
        this.hintCode = hintCode;
    }
    

    @JsonProperty("status")
    private void setStatus(String status) {
        this.status = status;
    }

    public String toJson() throws JsonParserException {
        return new JsonParser().toJson(this);
    }

    public static HintCode parseJson(byte[] jsonData) throws JsonParserException {
        return new JsonParser().parse(jsonData, HintCode.class);
    }

    @JsonCreator
    public static HintCode forValues(@JsonProperty("hintCode") String hintCode) {
        for (HintCode tmpStatus : HintCode.values()) {

            if (tmpStatus.hintCode.equalsIgnoreCase(hintCode)) {
                return tmpStatus;
            }

        }

        return null;
    }
}
