// FoodController.java //
import java.time.LocalDate;
import java.util.List;

public class FoodController {
    private FoodDatabase database; // ฐานข้อมูลอาหาร
    private FoodView view;         // มุมมองการแสดงผล

    public FoodController(FoodDatabase database, FoodView view) {
        this.database = database;
        this.view = view;
    }

    // ฟังก์ชันสำหรับจัดการการกรอกข้อมูลจากผู้ใช้
    public void handleUserInput() {
        String foodCode = view.getFoodCodeInput(); // รับรหัสอาหารจากผู้ใช้

        // ตรวจสอบว่ารหัสอาหารเป็น 6 หลัก และไม่ขึ้นต้นด้วย 0 หรือไม่
        if (!foodCode.matches("\\d{6}") || foodCode.startsWith("0")) {
            view.displayError("Invalid food code! Must be 6 digits and not start with 0.");
            return;
        }

        Food food = database.findFoodByCode(foodCode); // ค้นหาอาหารในฐานข้อมูล

        if (food == null) {
            view.displayError("Food code not found.");
        } else {
            boolean isExpired = false;
            boolean isValid = false;

            // ตรวจสอบประเภทของอาหารและสถานะหมดอายุ
            switch (food.getCategory()) {
                case "Fresh":
                    isValid = ExpirationChecker.checkFreshFood(food);
                    break;
                case "Pickled":
                    isValid = ExpirationChecker.checkPickledFood(food);
                    break;
                case "Canned":
                    isValid = ExpirationChecker.checkCannedFood(food);
                    break;
            }

            isExpired = !isValid; // ตรวจสอบว่าอาหารหมดอายุหรือยัง
            String status = isExpired ? "Expired" : "Valid";
            view.displayMessage("Food Status: " + status);
        }
    }

    // ฟังก์ชันสำหรับสร้างรายงานของอาหารทั้งหมดในฐานข้อมูล
    public void generateReport() {
        List<Food> foods = database.getFoodList();
        int freshCount = 0, pickledCount = 0, cannedCount = 0;
        int expiredCount = 0, validCount = 0;

        for (Food food : foods) {
            boolean isExpired = false;

            switch (food.getCategory()) {
                case "Fresh":
                    if (!ExpirationChecker.checkFreshFood(food)) isExpired = true;
                    freshCount++;
                    break;
                case "Pickled":
                    if (!ExpirationChecker.checkPickledFood(food)) isExpired = true;
                    pickledCount++;
                    break;
                case "Canned":
                    if (!ExpirationChecker.checkCannedFood(food)) isExpired = true;
                    cannedCount++;
                    break;
            }

            if (isExpired) {
                expiredCount++;
            } else {
                validCount++;
            }
        }

        view.displayResults(freshCount, pickledCount, cannedCount, expiredCount, validCount);
    }

    // ฟังก์ชันสำหรับเพิ่มข้อมูลตัวอย่างเข้าในฐานข้อมูล
    public void addSampleData() {
    // เพิ่มข้อมูลอาหารสด (Fresh) เพิ่มเติมเพื่อให้ครบ 20 รายการ
    database.addFood(new Food("123466", "Fresh", LocalDate.of(2026, 4, 14)));
    database.addFood(new Food("123467", "Fresh", LocalDate.of(2025, 11, 20)));
    database.addFood(new Food("123468", "Fresh", LocalDate.of(2024, 10, 12)));
    database.addFood(new Food("123469", "Fresh", LocalDate.of(2027, 7, 18)));
    database.addFood(new Food("123470", "Fresh", LocalDate.of(2026, 9, 9)));
    database.addFood(new Food("123471", "Fresh", LocalDate.of(2025, 5, 25)));
    database.addFood(new Food("123472", "Fresh", LocalDate.of(2027, 1, 10)));
    database.addFood(new Food("123473", "Fresh", LocalDate.of(2026, 6, 2)));
    database.addFood(new Food("123474", "Fresh", LocalDate.of(2024, 12, 5)));
    database.addFood(new Food("123475", "Fresh", LocalDate.of(2027, 8, 30)));

    // เพิ่มข้อมูลอาหารดอง (Pickled) เพิ่มเติมเพื่อให้ครบ 20 รายการ
    database.addFood(new Food("234577", "Pickled", LocalDate.of(2027, 2, 5)));
    database.addFood(new Food("234578", "Pickled", LocalDate.of(2028, 4, 10)));
    database.addFood(new Food("234579", "Pickled", LocalDate.of(2026, 3, 18)));
    database.addFood(new Food("234580", "Pickled", LocalDate.of(2025, 8, 3)));
    database.addFood(new Food("234581", "Pickled", LocalDate.of(2027, 12, 25)));
    database.addFood(new Food("234582", "Pickled", LocalDate.of(2026, 1, 17)));
    database.addFood(new Food("234583", "Pickled", LocalDate.of(2027, 9, 12)));
    database.addFood(new Food("234584", "Pickled", LocalDate.of(2025, 7, 21)));
    database.addFood(new Food("234585", "Pickled", LocalDate.of(2026, 10, 4)));
    database.addFood(new Food("234586", "Pickled", LocalDate.of(2025, 4, 6)));

    // เพิ่มข้อมูลอาหารกระป๋อง (Canned) เพิ่มเติมเพื่อให้ครบ 20 รายการ
    database.addFood(new Food("345688", "Canned", LocalDate.of(2027, 5, 1)));
    database.addFood(new Food("345689", "Canned", LocalDate.of(2028, 9, 30)));
    database.addFood(new Food("345690", "Canned", LocalDate.of(2029, 7, 7)));
    database.addFood(new Food("345691", "Canned", LocalDate.of(2026, 8, 17)));
    database.addFood(new Food("345692", "Canned", LocalDate.of(2029, 10, 25)));
    database.addFood(new Food("345693", "Canned", LocalDate.of(2027, 6, 6)));
    database.addFood(new Food("345694", "Canned", LocalDate.of(2028, 1, 20)));
    database.addFood(new Food("345695", "Canned", LocalDate.of(2026, 2, 9)));
    database.addFood(new Food("345696", "Canned", LocalDate.of(2029, 5, 15)));
    database.addFood(new Food("345697", "Canned", LocalDate.of(2027, 11, 12)));
    }
}
