import java.util.Arrays;

public class ArrayBase {

    public Integer[] MyArray;

    public ArrayBase(Integer size) {
        MyArray = new Integer[size];
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder("(");
            for(int i = 0 ; i<MyArray.length;i++){
                if(MyArray[i] != null)
                    sb.append(MyArray[i] + ", ");
            }
            sb.append(")");
            return sb.toString();

    }

    public void addOrdered(Integer deger, Integer indeks) throws IndexOutOfBoundsException{
        if(indeks < 0 || indeks >= MyArray.length+1)
            throw new IndexOutOfBoundsException("Illegal Index: " + indeks);

        Integer[] temp = new Integer[MyArray.length + 1];
        for(int i = 0 ; i< indeks ; i++){
            temp[i] = MyArray[i];
        }
        temp[indeks] = deger ;

        for(int i = indeks+1 ; i<temp.length;i++){
            temp[i] = MyArray[i-1];
        }
        MyArray = temp ;
    }
}