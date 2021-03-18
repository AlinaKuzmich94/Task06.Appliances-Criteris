package by.htp.task05.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

  public static final String RESOURCES = "resources/111.txt";
  private static List<RepositoryEntry> applianceStructure;

  private static Repository instance;

  public static synchronized Repository getInstance() {
    if (instance == null) {
      instance = new Repository();
    }
    return instance;
  }

  private Repository() {
    readFromDB();
  }

  private void readFromDB() {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(RESOURCES).getFile());

    List<RepositoryEntry> appliance = new ArrayList<>();

    try (BufferedReader br =
           new BufferedReader(new FileReader(file))) {

      String line;
      while ((line = br.readLine()) != null) {

        Map<String, String> valueMap = new HashMap<>();
        String[] splitLine = line.split(":");

        if (splitLine.length > 1) {

          String key = splitLine[0];

          for (String keyValue : splitLine[1].split("\\,")) {

            String[] keyValueArr = keyValue.split("=");

            if (keyValueArr.length > 1) {
              valueMap.put(keyValueArr[0].trim(), keyValueArr[1].trim());
            }
          }
          appliance.add(new RepositoryEntry(key.trim(), valueMap));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    applianceStructure = appliance;
  }

  public static List<RepositoryEntry> getApplianceStructure() {
    return applianceStructure;
  }
}