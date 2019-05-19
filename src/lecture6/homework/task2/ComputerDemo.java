package lecture6.homework.task2;

class ComputerDemo {

    public static void main(String[] args) {

        Computer laptop = new Computer();

        laptop.operatingSystem = "Ubuntu 19.04";
        laptop.freeMemory = 4096;
        laptop.hardDiskMemory = 131_072;
        laptop.year = 2014;
        laptop.price = 1000;
        laptop.isNotebook = true;

        Computer pc = new Computer();

        pc.operatingSystem = "Windows 10";
        pc.freeMemory = 8192;
        pc.hardDiskMemory = 525_288;
        pc.year = 2015;
        pc.price = 1500;
        pc.isNotebook = false;

        laptop.useMemory(1024);

        pc.changeOperatingSystem("Windows 7");

        System.out.println("-----");
        System.out.printf("Is Notebook %b\n", laptop.isNotebook);
        System.out.printf("Year: %d\n", laptop.year);
        System.out.printf("Price: %d\n", laptop.price);
        System.out.printf("OS: %s\n", laptop.operatingSystem);
        System.out.printf("Free Memory %d:\n", laptop.freeMemory);
        System.out.printf("HDD Memory: %d\n", laptop.hardDiskMemory);

        System.out.println("-----");
        System.out.printf("Is Notebook %b\n", pc.isNotebook);
        System.out.printf("Year: %d\n", pc.year);
        System.out.printf("Price: %d\n", pc.price);
        System.out.printf("OS: %s\n", pc.operatingSystem);
        System.out.printf("Free Memory %d:\n", pc.freeMemory);
        System.out.printf("HDD Memory: %d\n", pc.hardDiskMemory);
    }
}
