package by.htp.task05.dbreader;

	import java.io.*;
	import java.net.URISyntaxException;
	import java.net.URL;
	import java.nio.file.Paths;
	import java.util.HashMap;
	import java.util.Map;

	public class DBReader {


		private static Map<String, Map<String, String>> applianceStructure;


	    public DBReader() throws URISyntaxException, IOException{
	        readFromDB();
	    }

	    private void readFromDB() throws URISyntaxException, IOException {

	        ClassLoader classLoader = getClass().getClassLoader();
	        File file = new File(classLoader.getResource("resources/111.txt").getFile());

	        Map<String, Map<String, String>> appliance = new HashMap<>();

	        try (BufferedReader br =
	                     new BufferedReader(new FileReader(file))){

	            String line = br.readLine();
	            while (line != null){
	                Map<String, String> valueMap = new HashMap<>();
	                String[] splitLine = line.split(":");
	                String key = splitLine[0];
	                for (String keyValue : splitLine[1].split("\\,")){
	                    String[] keyValueArr = keyValue.split("=");

	                    valueMap.put(keyValueArr[0].trim(), keyValueArr[1].trim());
	                }
	                appliance.put(key.trim(), valueMap);
	            }
	        }
	        applianceStructure = appliance;
	    }

	    public static Map<String, Map<String, String>> getApplianceStructure(){
	        return applianceStructure;
	    }
	}
