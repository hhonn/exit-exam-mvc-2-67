import javax.swing.*;

public class FoodView {

    // ฟังก์ชันรับข้อมูลรหัสอาหารจากผู้ใช้
    public String getFoodCodeInput() {
        return JOptionPane.showInputDialog("Enter Food Code (6-digit):");
    }

    // ฟังก์ชันแสดงข้อความในกรณีที่มีข้อมูลหรือสถานะที่ต้องการแสดง
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // ฟังก์ชันแสดงข้อความข้อผิดพลาด
    public void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // ฟังก์ชันแสดงผลลัพธ์การตรวจสอบอาหารทั้งหมด
    public void displayResults(int freshCount, int pickledCount, int cannedCount, int expiredCount, int validCount) {
        String resultMessage = "Fresh: " + freshCount + "\nPickled: " + pickledCount + "\nCanned: " + cannedCount +
                "\nExpired: " + expiredCount + "\nValid: " + validCount;
        JOptionPane.showMessageDialog(null, resultMessage);
    }
}
