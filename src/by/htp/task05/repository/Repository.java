package by.htp.task05.repository;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.net.URISyntaxException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class Repository {


		public static Map<String, Map<String, String>> applianceStructure;

		public List<String>  findAppliancesByNameAndProperty(Map<String, String> filterParameters){
	        Map<String, Map<String, String>> applianceStructure = DBReader.getApplianceStructure();

	        List<Map<String, String>> results = new ArrayList<>();
	        for (Map.Entry<String, String> entry : filterParameters.entrySet()) {

	            String key = entry.getKey();
	            if (key.equals("name")) {
	                results.add(applianceStructure.get(entry.getValue()));
	            }
	        }

	        for(Map<String, String> result : results) {

	            if (result ){
	            for (Map.Entry<String, String> entry : result.entrySet()) {

	                boolean exist = true;
	                for (Map.Entry<String, String> filterEntry : filterParameters.entrySet()) {
	                    if (entry.entry.getKey(filterEntry.getKey()))
	                }
	            }
	            }
	        }

	        applianceStructure.
	    }


	    public List<String> intersection(List<String> list1, List<String> list2) {
	        List<String> list = new ArrayList<>();

	        for (String t : list1) {
	            if(list2.contains(t)) {
	                list.add(t);
	            }
	        }

	        return list;
	    }

	}

