package by.htp.task05.service;

import by.htp.task05.repository.Repository;
import by.htp.task05.repository.RepositoryEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

  public static final String NAME = "name";
  private static Service instance;

  public static synchronized Service getInstance() {
    if (instance == null) {
      instance = new Service();
    }
    return instance;
  }

  public List<String> findAppliancesByNameAndProperty(Map<String, String> filterParameters) {

    List<RepositoryEntry> applianceStructure = Repository.getInstance().getApplianceStructure();

    List<List<RepositoryEntry>> results = new ArrayList<>();

    for (Map.Entry<String, String> filterEntry : filterParameters.entrySet()) {

      List<RepositoryEntry> filterResults = new ArrayList<>();

      String filterName = filterEntry.getKey();
      String filterValue = filterEntry.getValue();

      if (filterName.equals(NAME)) {

        for (RepositoryEntry appliance : applianceStructure) {

          if (appliance.getName().equals(filterValue)) {
            filterResults.add(appliance);
          }
        }
      } else {

        for (RepositoryEntry appliance : applianceStructure) {

          Map<String, String> features = appliance.getFeatures();

          if (features.containsKey(filterName)
						&& features.get(filterName).equals(filterValue)) {
            filterResults.add(appliance);
          }
        }
      }
      results.add(filterResults);
    }

    List<RepositoryEntry> resultSet = new ArrayList<>();
    if (results.size() > 0) {
      resultSet = results.get(0);
    }

    for (int i = 1; i < results.size(); i++) {
      resultSet = intersection(resultSet, results.get(i));
    }

    return resultSet.stream().map(RepositoryEntry::toString)
                    .collect(Collectors.toList());
  }

  public List<RepositoryEntry> intersection(
    List<RepositoryEntry> list1,
    List<RepositoryEntry> list2) {
    List<RepositoryEntry> list = new ArrayList<>();

    for (RepositoryEntry t : list1) {
      if (list2.contains(t)) {
        list.add(t);
      }
    }

    return list;
  }
}

