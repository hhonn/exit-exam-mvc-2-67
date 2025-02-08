import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FoodDatabase {
    private List<Food> foodList;

    public FoodDatabase() {
        foodList = new ArrayList<>();
        // เพิ่มข้อมูลอาหารตัวอย่าง
        foodList.add(new Food("123456", "Fresh", LocalDate.of(2025, 12, 31)));
        foodList.add(new Food("654321", "Pickled", LocalDate.of(2024, 6, 30)));
        foodList.add(new Food("111111", "Canned", LocalDate.of(2026, 1, 1)));

        // เพิ่มข้อมูลอาหารสด (Fresh) เพิ่มเติมเพื่อให้ครบ 20 รายการ
        foodList.add(new Food("123466", "Fresh", LocalDate.of(2026, 4, 14)));
        foodList.add(new Food("123467", "Fresh", LocalDate.of(2025, 11, 20)));
        foodList.add(new Food("123468", "Fresh", LocalDate.of(2024, 10, 12)));
        foodList.add(new Food("123469", "Fresh", LocalDate.of(2027, 7, 18)));
        foodList.add(new Food("123470", "Fresh", LocalDate.of(2026, 9, 9)));
        foodList.add(new Food("123471", "Fresh", LocalDate.of(2025, 5, 25)));
        foodList.add(new Food("123472", "Fresh", LocalDate.of(2027, 1, 10)));
        foodList.add(new Food("123473", "Fresh", LocalDate.of(2026, 6, 2)));
        foodList.add(new Food("123474", "Fresh", LocalDate.of(2024, 12, 5)));
        foodList.add(new Food("123475", "Fresh", LocalDate.of(2027, 8, 30)));

        // เพิ่มข้อมูลอาหารดอง (Pickled) เพิ่มเติมเพื่อให้ครบ 20 รายการ
        foodList.add(new Food("234577", "Pickled", LocalDate.of(2027, 2, 5)));
        foodList.add(new Food("234578", "Pickled", LocalDate.of(2028, 4, 10)));
        foodList.add(new Food("234579", "Pickled", LocalDate.of(2026, 3, 18)));
        foodList.add(new Food("234580", "Pickled", LocalDate.of(2025, 8, 3)));
        foodList.add(new Food("234581", "Pickled", LocalDate.of(2027, 12, 25)));
        foodList.add(new Food("234582", "Pickled", LocalDate.of(2026, 1, 17)));
        foodList.add(new Food("234583", "Pickled", LocalDate.of(2027, 9, 12)));
        foodList.add(new Food("234584", "Pickled", LocalDate.of(2025, 7, 21)));
        foodList.add(new Food("234585", "Pickled", LocalDate.of(2026, 10, 4)));
        foodList.add(new Food("234586", "Pickled", LocalDate.of(2025, 4, 6)));

        // เพิ่มข้อมูลอาหารกระป๋อง (Canned) เพิ่มเติมเพื่อให้ครบ 20 รายการ
        foodList.add(new Food("345688", "Canned", LocalDate.of(2027, 5, 1)));
        foodList.add(new Food("345689", "Canned", LocalDate.of(2028, 9, 30)));
        foodList.add(new Food("345690", "Canned", LocalDate.of(2029, 7, 7)));
        foodList.add(new Food("345691", "Canned", LocalDate.of(2026, 8, 17)));
        foodList.add(new Food("345692", "Canned", LocalDate.of(2029, 10, 25)));
        foodList.add(new Food("345693", "Canned", LocalDate.of(2027, 6, 6)));
        foodList.add(new Food("345694", "Canned", LocalDate.of(2028, 1, 20)));
        foodList.add(new Food("345695", "Canned", LocalDate.of(2026, 2, 9)));
        foodList.add(new Food("345696", "Canned", LocalDate.of(2029, 5, 15)));
        foodList.add(new Food("345697", "Canned", LocalDate.of(2027, 11, 12)));
    }

    // ฟังก์ชันสำหรับค้นหาข้อมูลอาหารตามรหัส
    public Food findFoodByCode(String code) {
        for (Food food : foodList) {
            if (food.getFoodCode().equals(code)) {
                return food;
            }
        }
        return null; // ไม่พบอาหาร
    }

    // ฟังก์ชันสำหรับดึงรายการอาหารทั้งหมด
    public List<Food> getFoodList() {
        return foodList;
    }

    // ฟังก์ชันสำหรับเพิ่มอาหาร
    public void addFood(Food food) {
        foodList.add(food);
    }
}
