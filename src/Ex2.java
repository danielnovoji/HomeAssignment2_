public class Ex2 {public static final String VALID_START1 = "05";
    public static final String VALID_START2 = "9725";
    public static final  int ERROR_TYPE=0;
    public static final  int TYPE_1=1;
    public static final  int TYPE_2=2;
    public static final  int TYPE_3=3;


    public static void main(String[] args) {
        System.out.println(properNumber("050-6551823",2));


    }
    public static String properNumber(String phoneNumber, int type) {
        String result = phoneNumber;
        if (type==TYPE_1){
            result = subString(phoneNumber, 0, 3) + "-" + subString(phoneNumber, 3, phoneNumber.length());

        } else if (type==TYPE_3) {
            result ="0"+ subString(phoneNumber, 3, 5) + "-" + subString(phoneNumber, 5, phoneNumber.length());
        }
        return result;
    }


    public static boolean isValidLength(String phoneNumber) {
        boolean valid = false;
        if (phoneNumber.length() >= 10 && phoneNumber.length() <= 12) {
            valid = true;
        }
        return valid;
    }

    public static int checkType(String number) {
        int type=ERROR_TYPE;//0
        String type1And2 = subString(number, 0, 2);
        String type3 = subString(number, 0, 4);
        if (equals(type1And2,VALID_START1)){
            if (number.charAt(3)=='-'){
                type=TYPE_2;//2
            }
            else {
                type=TYPE_1;//1
            }
        }
        else if(equals(type3,VALID_START2)){//9725
            type = TYPE_3;//3
        }
        return type;
    }
    public static int validPhoneNumber(String phoneNumber){
        int type=checkType(phoneNumber);
        if(type!=ERROR_TYPE && isValidLength(phoneNumber)){
            if (type==TYPE_1|| type==TYPE_3){
                if (!numCheck(phoneNumber)){
                    type=ERROR_TYPE;
                }
            }
            else if(type==TYPE_2){
                if (!numCheck(subString(phoneNumber,2,3))|| !numCheck(subString(phoneNumber,4,phoneNumber.length()))){
                    type=ERROR_TYPE;
                }
            }
        }
        return type;
    }
    public static boolean numCheck(String a){
        boolean num = true;
        for (int i=0; i<a.length();i++){
            if (a.charAt(i)<'0'|| a.charAt(i)>'9'){
                num=false;
                break;
            }
        }
        return num;
    }
    public static boolean charCheck(String a){
        boolean valid = true;
        for (int i=0; i<a.length();i++){
            if (a.charAt(i)<'A'&& a.charAt(i)>'Z'){
                valid=false;
                break;
            }
        }
        return valid;
    }


    public static String subString(String a, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += a.charAt(i);
        }
        return result;
    }

    public static boolean equals(String a, String b) {
        boolean isEqual = false;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    isEqual = true;
                } else {
                    isEqual = false;
                    break;
                }

            }
        }
        return isEqual;
    }
}

