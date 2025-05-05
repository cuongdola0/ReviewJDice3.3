package DiceSum;

import java.util.logging.Logger;

/**
 * DiceSum đại diện cho việc kết hợp hai lần gieo xúc xắc.
 * <p>
 * Bổ sung chức năng:
 * - Logging sử dụng java.util.logging
 * - Kiểm tra dữ liệu đầu vào (validation)
 * - Phương thức tiện ích getTotal() để tính tổng điểm
 * - Cải thiện thông báo toString() cho thân thiện người dùng
 * </p>
 */
public class DiceSum extends DieRoll {
    private static final Logger logger = Logger.getLogger(DiceSum.class.getName());

    private DieRoll r1;
    private DieRoll r2;

    /**
     * Tạo một đối tượng DiceSum từ hai lần gieo xúc xắc.
     *
     * @param r1 Đối tượng DieRoll đầu tiên (không được null)
     * @param r2 Đối tượng DieRoll thứ hai (không được null)
     * @throws IllegalArgumentException nếu một trong hai đối tượng là null
     */
    public DiceSum(DieRoll r1, DieRoll r2) {
        super(); // hoặc super(0, 0, 0) nếu DieRoll yêu cầu constructor có 3 int
        if (r1 == null || r2 == null) {
            logger.severe("Không được truyền vào null cho r1 hoặc r2.");
            throw new IllegalArgumentException("DieRoll không được null.");
        }
        this.r1 = r1;
        this.r2 = r2;
        logger.info("Đã tạo DiceSum với: r1 = " + r1 + ", r2 = " + r2);
    }

    /**
     * Thực hiện hai lần gieo xúc xắc và trả về kết quả kết hợp.
     *
     * @return RollResult là kết quả hợp nhất của hai lần gieo
     */
    @Override
    public RollResult makeRoll() {
        RollResult result1 = r1.makeRoll();
        RollResult result2 = r2.makeRoll();
        logger.info("Kết quả gieo r1: " + result1 + " | Kết quả gieo r2: " + result2);
        return result1.andThen(result2);
    }

    /**
     * Trả về chuỗi mô tả kết quả hai lần gieo xúc xắc.
     *
     * @return Chuỗi kết quả của r1 và r2
     */
    @Override
    public String toString() {
        return "Kết quả DiceSum: [" + r1.toString() + "] và [" + r2.toString() + "]";
    }

    /**
     * Phương thức tiện ích: tính tổng điểm của hai lần gieo xúc xắc.
     *
     * @return tổng điểm từ cả hai lần gieo
     */
    public int getTotal() {
        RollResult result = makeRoll();
        int total = result.getTotal(); // giả sử RollResult có phương thức getTotal()
        logger.info("Tổng điểm của hai lần gieo: " + total);
        return total;
    }
}
