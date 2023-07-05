package enumType.enumOverConst;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("++++++++++++++++++");
        constantMethod(1);
        constantMethod(3);
        constantMethod(100);
        constantMethod(200); //there is no CTE or RTE
        System.out.println("++++++++++++++++++");
//        enumMethod(TransactionTypeEnum.WITHDRAW);
//        enumMethod(TransactionTypeEnum.OTHER);
        enumMethod(TransactionTypeEnum.DEPOSIT);
        //when we use enums constants we will just see given options
    }
    //method for constant class
    private static void constantMethod(int i){
        if(i==TransactionTypeConstants.DEPOSIT){
            System.out.println("Money is deposited");
        }else if(i==TransactionTypeConstants.WITHDRAW){
            System.out.println("Money is withdrawn");
        }else if(i==TransactionTypeConstants.PAYMENT){
            System.out.println("Money is paid");
        }else if(i==TransactionTypeConstants.TRANSFER){
            System.out.println("Money is transferred");
        }else if(i==TransactionTypeConstants.OTHER){
            System.out.println("Other transaction");
        }
    }

    //method for enum

    private static void enumMethod(TransactionTypeEnum tt){

        switch (tt){
            case DEPOSIT:
                System.out.println("Money is deposited");
                break;
            case PAYMENT:
                System.out.println("Money is paid");
                break;
            case WITHDRAW:
                System.out.println("Money is withdrawn");
                break;
            case TRANSFER:
                System.out.println("Money is transferred");
                break;
            default:
                System.out.println("Other transaction");
        }
        System.out.println("Enum Name: "+ tt.name()); //prints name on screen
        System.out.println("Enum Ordinal Value: "+ tt.ordinal()); //prints ordinal or index value
        System.out.println("Enum Code Value: "+tt.getCode());

        //using ordinal() is risky because the order may change...



    }
}
