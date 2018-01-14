package com.ebanks.springapp.filters;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class MetricService.
 */
@Service
public class MetricService{

    /** The metric map. */
    private ConcurrentMap<String, ConcurrentHashMap<Integer, Integer>> metricMap;

    /**
     * Increases the count based on number of HTTP status codes
     *
     * @param request the request
     * @param status the status
     */
    public void increaseCount(String request, int status) {
        ConcurrentHashMap<Integer, Integer> statusMap = metricMap.get(request);
        if (statusMap == null) {
            statusMap = new ConcurrentHashMap<Integer, Integer>();
        }

        Integer count = statusMap.get(status);

        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        statusMap.put(status, count);
        metricMap.put(request, statusMap);
    }

    /**
     * Gets the full metric.
     *
     * @return the full metric
     */
    public Map getFullMetric() {
        return metricMap;
    }

}
