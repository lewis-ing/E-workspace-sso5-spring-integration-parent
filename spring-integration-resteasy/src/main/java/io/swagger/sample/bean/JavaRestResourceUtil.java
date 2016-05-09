package io.swagger.sample.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaRestResourceUtil {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public int getInt(int minVal, int maxVal, int defaultValue, String inputString) {
		int output = defaultValue;
		try {
			output = Integer.parseInt(inputString);
		} catch (Exception e) {
			output = defaultValue;
			logger.error(e.getMessage()+output, e);
		}
		if (output < minVal)
			output = minVal;
		if (maxVal == -1) {
			if (output < minVal){
				output = minVal;
			}
		} else if (output > maxVal){
			output = maxVal;
		}
		return output;
	}

	public long getLong(long minVal, long maxVal, long defaultValue, String inputString) {
		long output = defaultValue;
		try {
			output = Long.parseLong(inputString);
		} catch (Exception e) {
			output = defaultValue;
			logger.error(e.getMessage()+output, e);
		}

		if (output < minVal){
			output = minVal;
		}
		if (maxVal == -1) {
			if (output < minVal){
				output = minVal;
			}
		} else if (output > maxVal){
			output = maxVal;
		}
		return output;
	}

	public double getDouble(double minVal, double maxVal, double defaultValue, String inputString) {
		double output = defaultValue;
		try {
			output = Double.parseDouble(inputString);
		} catch (Exception e) {
			output = defaultValue;
			logger.error(e.getMessage()+output, e);
		}

		if (output < minVal)
			output = minVal;
		if (maxVal == -1) {
			if (output < minVal)
				output = minVal;
		} else if (output > maxVal)
			output = maxVal;
		return output;
	}

	public boolean getBoolean(boolean defaultValue, String booleanString) {
		boolean output = defaultValue;
		if (booleanString == null)
			output = defaultValue;

		// treat "", "YES" as "true"
		if ("".equals(booleanString))
			output = true;
		else if ("YES".equalsIgnoreCase(booleanString))
			output = true;
		else if ("NO".equalsIgnoreCase(booleanString))
			output = false;
		else {
			try {
				output = Boolean.parseBoolean(booleanString);
			} catch (Exception e) {
				output = defaultValue;
				logger.error(e.getMessage()+output, e);
			}
		}
		return output;
	}

	public Date getDate(Date defaultValue, String dateString) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return defaultValue;
		}
	}
}