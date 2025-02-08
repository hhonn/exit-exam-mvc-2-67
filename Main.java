public class Main {
    public static void main(String[] args) {
        FoodDatabase database = new FoodDatabase(); // สร้างฐานข้อมูลอาหาร
        FoodView view = new FoodView();             // สร้างมุมมอง GUI
        FoodController controller = new FoodController(database, view); // สร้าง Controller

        controller.addSampleData();  // เพิ่มข้อมูลตัวอย่าง

        // เริ่มการทำงาน
        controller.handleUserInput(); // รับข้อมูลจากผู้ใช้
        controller.generateReport();  // สร้างรายงาน
    }
}