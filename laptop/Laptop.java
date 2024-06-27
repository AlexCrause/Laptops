package laptop;
//1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
//методы. Реализовать в java.
//2. Создать множество ноутбуков.
//3. Написать метод, который будет запрашивать у пользователя критерий (или критерии)
//фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
//хранить в Map. Например:
//      “Введите цифру, соответствующую необходимому критерию:
//          1 - ОЗУ
//          2 - Объем ЖД
//          3 - Операционная система
//          4 - Цвет …
//4. Далее нужно запросить минимальные значения для указанных критериев - сохранить
//параметры фильтрации можно также в Map.
//5. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
//условиям.

//Поля:
        //  1 - ОЗУ (RAM)
//          2 - Объем ЖД (Hard disk capacity)
//          3 - Операционная система (Operating system)
//          4 - Цвет (Color) …

//Методы:
//Геттеры: getRAM(), getHardDiskCapacity(), getColor() ...
//Сеттеры: setRAM(), setHardDiskCapacity(), setColor() ...

public class Laptop {
    private String brand;
    private int ram;
    private int hardDiskCapacity;
    private String operatingSystem;
    private String color;

    public Laptop (String brand, int ram, int hardDiskCapacity, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String result = "Марка: " + brand + System.lineSeparator()
                + "ОЗУ: " + ram + System.lineSeparator()
                + "Объём ЖД: " + hardDiskCapacity + System.lineSeparator()
                + "Операционная система: " + operatingSystem + System.lineSeparator()
                + "Цвет: " + color;
        return result;
    }
}
