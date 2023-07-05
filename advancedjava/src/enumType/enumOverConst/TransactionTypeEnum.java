package enumType.enumOverConst;

//predefined set of values which will never be updated
// users cannot add more options, user only sees the given option
public enum TransactionTypeEnum {

    DEPOSIT(5), //DEPOSIT + TRANSFER =20
    WITHDRAW(10),

    TRANSFER(15),
    PAYMENT(20),
    OTHER(100);

    private final int code;

    //constructor to set values for constants
    private TransactionTypeEnum(int code) {
        this.code = code;
    }

    //getter

    public int getCode() {
        return code;
    }
}
