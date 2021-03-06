package es.tid.topologyModuleBase;

import es.tid.tedb.MDTEDB;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.topologyModuleBase.database.TopologiesDataBase;
import es.tid.topologyModuleBase.management.TMManagementServer;
import es.tid.topologyModuleBase.plugins.TMPlugin;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Main class of the Topology Module 
 *  
 * @author jaume
 *
 */

public class TopologyModuleMain 
{
	public static void  main(String []args) throws FileNotFoundException {
		ArrayList<TMPlugin> pluginsList = new ArrayList<TMPlugin>();
		TopologyModuleParamsArray params;
		
		if (args.length >=1 ){
			params=new TopologyModuleParamsArray(args[0]);
		}else{
			params=new TopologyModuleParamsArray();
		}
		params.initialize();	
		
		
		TopologiesDataBase sTop = new TopologiesDataBase();
		
		//By default, create a multi-domain database, empty
		MultiDomainTEDB mdTed = new MDTEDB();
		sTop.setMdTed(mdTed);
		
		Lock lock = new ReentrantLock();	
		
		TMManagementServer TMms=new TMManagementServer(sTop,params,pluginsList);
		TMms.start();
		
		(new TMModuleInitiater(sTop, params, lock, pluginsList)).intiate();
		////////////////////////


	}
	
}
