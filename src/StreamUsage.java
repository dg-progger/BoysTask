import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>();
        boys.add(new Boy("Николай", 68));

        boys.add(new Boy("Пётр", 53));

        boys.add(new Boy("Василий", 25));

        boys.add(new Boy("Михаил", 19));

        boys.add(new Boy("Алексей", 6));

        boys.add(new Boy("Николай", 86));

        boys.add(new Boy("Пётр", 35));

        boys.add(new Boy("Михаил", 111));

        boys.add(new Boy("Алексей", 22));

        boys.add(new Boy("Михаил", 1));

        boys.add(new Boy("Яков", 30));

        Map<String, Integer> filteredBoys = boys.stream()
                .filter(boy -> boy.getAge() >= 18)
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(4)
                .collect(Collectors.toMap(
                        Function.identity(),
                        boyName -> Collections.frequency(
                                boys.stream().map(Boy::getName).collect(Collectors.toList()),
                                boyName
                        ) - 1));


        for (Map.Entry<String, Integer> entry : filteredBoys.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue().toString());
        }
    }
}

