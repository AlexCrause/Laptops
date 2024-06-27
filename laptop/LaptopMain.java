package laptop;

import java.util.*;

public class LaptopMain {
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("Dell", 4,128, "linux", "Red");
        Laptop laptop2 = new Laptop("Apple", 8,256, "macOS", "Grey");
        Laptop laptop3 = new Laptop("HP", 12,512, "Windows 10 Pro", "Black");
        Laptop laptop4 = new Laptop("Lenovo", 16,1024, "Windows 11", "White");
        Laptop laptop5 = new Laptop("Asus", 8,256, "Windows 10 Pro", "Silver");

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5));
//        for (Laptop laptop : laptops) {
//            System.out.println(laptop);
//            System.out.println();
//        }
        Map<String, Object> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ (ГБ)");
        System.out.println("2 - Объем ЖД (ГБ)");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.print("Ваш выбор: ");


        Scanner scanner = new Scanner(System.in);
        int criteria = scanner.nextInt();
        scanner.nextLine();

        switch (criteria) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ (4, 8, 12, 16): ");
                //System.out.println();
                int ram = scanner.nextInt();
                filters.put("ram", ram);
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД (128, 256, 512, 1024): ");
                int storage = scanner.nextInt();
                filters.put("storage", storage);
                break;
            case 3:
                System.out.print("Введите операционную систему (linux, macOS, Windows 10 Pro, Windows 11): ");
                String os = scanner.nextLine();
                filters.put("os", os);
                break;
            case 4:
                System.out.print("Введите цвет (Red, Grey, Black, White, Silver): ");
                String color = scanner.nextLine();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор.");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);

        if (filteredLaptops.isEmpty()) {
            System.out.println();
            System.out.println("Нет ноутбуков, соответствующих заданным критериям.");
        } else {
            System.out.println();
            System.out.println("Ноутбуки, соответствующие заданным критериям:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println();
                System.out.println(laptop);
                System.out.println();
            }
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Map.Entry<String, Object> filter : filters.entrySet()) {
            switch (filter.getKey()) {
                case "ram":
                    int minRam = (int) filter.getValue();
                    filteredLaptops.removeIf(laptop -> laptop.getRam() < minRam);
                    break;
                case "storage":
                    int minStorage = (int) filter.getValue();
                    filteredLaptops.removeIf(laptop -> laptop.getHardDiskCapacity() < minStorage);
                    break;
                case "os":
                    String os = (String) filter.getValue();
                    filteredLaptops.removeIf(laptop -> !laptop.getOperatingSystem().equalsIgnoreCase(os));
                    break;
                case "color":
                    String color = (String) filter.getValue();
                    filteredLaptops.removeIf(laptop -> !laptop.getColor().equalsIgnoreCase(color));
                    break;
            }
        }

        return filteredLaptops;
    }
}
