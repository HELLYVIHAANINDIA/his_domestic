package com.hisd.common.utility;

import java.util.logging.Logger;

import org.flywaydb.core.Flyway;

public class FlywayInitializer {
	
	private static final Logger logger = Logger.getAnonymousLogger();
	
	private Flyway flyway;
	private boolean applyRepair = false;
	
	public void init()
	{
		// first calling repair 
		if(applyRepair)
		{
			logger.info("Starting flyway: repair");
//			flyway.repair();
		}
		
		// then calling migrate
		logger.info("Starting flyway: migrate");
		int number = 0;
//		number = flyway.migrate();
		logger.info("Total migration applied: " + number);
	}

	public Flyway getFlyway() {
		return flyway;
	}

	public void setFlyway(Flyway flyway) {
		this.flyway = flyway;
	}

	public boolean isApplyRepair() {
		return applyRepair;
	}

	public void setApplyRepair(boolean applyRepair) {
		this.applyRepair = applyRepair;
	}
}
