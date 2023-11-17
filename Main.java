import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Acer", 8, 256, "win11", "red"));
        laptops.add(new Laptop("Asus", 16, 1000, "win10", "green"));
        laptops.add(new Laptop("Apple", 32, 512, "macOS", "silver"));
        laptops.add(new Laptop("Dell", 16, 256, "noOS", "blue"));
        laptops.add(new Laptop("HP", 8, 500, "win11", "black"));

        filterLaptops(laptops);
    }

    public static void filterLaptops(Set<Laptop> laptops) {
        Map<String, String> filter = new HashMap<>();
        filter.put("1", "RAM");
        filter.put("2", "HDD");
        filter.put("3", "OS");
        filter.put("4", "Color");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number ");
        System.out.println("1 - RAM");
        System.out.println("2 - HDD");
        System.out.println("3 - OS");
        System.out.println("4 - Color");
        String userInput = scanner.nextLine();
        

        if (filter.containsKey(userInput)) {
            String selectedFilter = filter.get(userInput);
            System.out.println("Filter for " + selectedFilter);
            String minValue = scanner.nextLine();

            Set<Laptop> filteredLaptops = new HashSet<>();
            switch (selectedFilter) {
                case "RAM":
                    int minRam = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getRam() >= minRam) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    
                    break;
                case "HDD":
                    int minHddSize = Integer.parseInt(minValue);
                    for (Laptop laptop : laptops) {
                        if (laptop.getHddSize() >= minHddSize) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    
                    break;
                case "OS":
                    for (Laptop laptop : laptops) {
                        if (laptop.getOs().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    
                    break;
                case "Color":
                    for (Laptop laptop : laptops) {
                        if (laptop.getColor().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    
                    break;
            
                default:
                    System.out.println("Invalid input");
                    return;
                
            }

            if (filteredLaptops.isEmpty()) {
                System.out.println("No laptops");
            } else {
                for (Laptop laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }
        }
    }
}
