package by.htp.task05.controller;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class Controller {

	    private Service service = new Service();

	    public List<String> findAppliances(String request){

	        Map<String, String> filterParameters = new HashMap<>();
	        String[] parameters = request.split("&");
	        for (String parameter : parameters){
	            String[] keyValue = parameter.split("=");
	            filterParameters.put(keyValue[0], keyValue[1]);
	        }



	        return service.findAppliances(filterParameters);
	    }
	}

