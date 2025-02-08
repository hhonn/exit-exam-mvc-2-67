import java.time.LocalDate;

// Food class เก็บข้อมูลเกี่ยวกับอาหาร
public class Food {
    private String foodCode;       // รหัสอาหาร (เลข 6 หลัก)
    private String category;       // ประเภทอาหาร (อาหารสด, อาหารดอง, อาหารกระป๋อง)
    private LocalDate expirationDate; // วันหมดอายุของอาหาร

    // คอนสตรัคเตอร์ของ Food ใช้ในการสร้างอาหารใหม่
    public Food(String foodCode, String category, LocalDate expirationDate) {
        this.foodCode = foodCode;
        this.category = category;
        this.expirationDate = expirationDate;
    }

    // Getter สำหรับการเข้าถึงข้อมูล
    public String getFoodCode() {
        return foodCode;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
