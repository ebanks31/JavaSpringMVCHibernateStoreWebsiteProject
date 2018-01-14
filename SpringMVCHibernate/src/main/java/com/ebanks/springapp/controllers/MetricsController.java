package com.ebanks.springapp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebanks.springapp.filters.MetricService;

/**
 * This class will keep track of the metrics of all REST calls and post on JSON string.
 */
public class MetricsController {

	/** The metric service. */
	@Autowired
	MetricService metricService;

	/**
	 * Gets the metrics based on status code.
	 * There is a URL filter that filters all request in order to form metrics based on hits on the REST end points.
	 *
	 * @return the metric
	 */
	@RequestMapping(value = "/metrics", method = RequestMethod.GET)
	@ResponseBody
	public Map getMetric() {
	    return metricService.getFullMetric();
	}
}
