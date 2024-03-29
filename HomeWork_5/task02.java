/*
 Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
 Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
 Отсортировать по убыванию популярности.
 */

 package HomeWork_5;

 import java.util.Comparator;
 import java.util.LinkedHashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.stream.Collectors;
 
 public class task02 {
     public static void main(String[] args) {
         List<String> workers = List.of("Иван", "Пётр", "Антон", "Антон", "Антон", "Иван", "Пётр", "Иван", "Пётр", "Иван",
                 "Пётр", "Иван", "Пётр", "Иван", "Пётр");
         System.out.println(repeat(workers));
     }
 
     public static Map<String, Integer> repeat(List<String> workers) {
         Map<String, Integer> repeatNameCount = new LinkedHashMap<>();
 
         for (int i = 0; i < workers.size(); i++) {
             if (repeatNameCount.containsKey(workers.get(i))) {
                 repeatNameCount.put(workers.get(i), repeatNameCount.get(workers.get(i)) + 1);
             } else {
                 repeatNameCount.put(workers.get(i), 1);
             }
         }
 
         Map<String, Integer> sortedMap = repeatNameCount.entrySet().stream()
                 .sorted(Comparator.comparingInt(e -> -e.getValue()))
                 .collect(Collectors.toMap(
                         Map.Entry::getKey,
                         Map.Entry::getValue,
                         (a, b) -> {
                             throw new AssertionError();
                         },
                         LinkedHashMap::new));
         return sortedMap;
     }
 
 }
