import java.time.LocalDate;

public class ExpirationChecker {

    // ฟังก์ชันตรวจสอบว่าอาหารสดยังไม่หมดอายุหรือไม่
    public static boolean checkFreshFood(Food food) {
        LocalDate today = LocalDate.now();
        return !food.getExpirationDate().isBefore(today); // เช็คว่าอาหารยังไม่หมดอายุ
    }

    // ฟังก์ชันตรวจสอบว่าอาหารดองยังไม่หมดอายุหรือไม่
    public static boolean checkPickledFood(Food food) {
        LocalDate today = LocalDate.now();
        return food.getExpirationDate().getYear() > today.getYear() || 
               (food.getExpirationDate().getYear() == today.getYear() && food.getExpirationDate().getMonthValue() >= today.getMonthValue());
    }

    // ฟังก์ชันตรวจสอบว่าอาหารกระป๋องยังไม่หมดอายุหรือไม่
    public static boolean checkCannedFood(Food food) {
        LocalDate today = LocalDate.now();
        LocalDate extendedExpirationDate = food.getExpirationDate().withDayOfYear(365).plusMonths(9);
        return extendedExpirationDate.isAfter(today);
    }
}
