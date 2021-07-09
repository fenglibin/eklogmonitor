package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

/**
 * esIndex和kibanaId的映射关系
 * @author fenglibin
 *
 */
public class EsIndexKibanaIdMapResponse {

    private String esIndex;

    private String kibanaId;

    public String getEsIndex() {
        return esIndex;
    }

    public void setEsIndex(String esIndex) {
        this.esIndex = esIndex;
    }

    public String getKibanaId() {
        return kibanaId;
    }

    public void setKibanaId(String kibanaId) {
        this.kibanaId = kibanaId;
    }
}