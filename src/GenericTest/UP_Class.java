package GenericTest;

/* <? super T> 与 <? extends T> 的区别，
 *  T 代表一个给定的类 
 * */
import java.util.*;



public class UP_Class {

    class A1 {}
    class A2 {}
    class A3 {}
    class A4 {}
    class B1 extends A1 {}
    class B2 extends A1 {}
    class B3 extends A3 {}
    class B4 extends A4 {}
    class C1 extends B2 {}
    class C2 extends B2 {}
    class C3 extends B3 {}
    class D1 extends C1 {}
    class D2 extends C2 {}
    class E1 extends D1 {}
    class E2 extends D1 {}
    class E3 extends D2 {}
    class E4 extends D2 {}

    public static void main(String args[]) {
        /********************************************
         * 此处 extends 表示 有上界的统配符 ?，上界为 C2
         * 由此定义的引用 listUpper可以作为
         * 接下来的 7 种 子泛型类型的 ArrayList 的引用来使用。
         **********************************************/
        List<? extends C2> listUpper;// 统配符 ? 的上界为 C2
        listUpper = new ArrayList<C2>();// 能存储 C2 D2 E3 E4
        listUpper = new ArrayList<D2>();// 能存储 D2 E3 E4
        listUpper = new ArrayList<E3>();
        listUpper = new ArrayList<E4>();
        /*************************************************
         * super 表示有下界的统配符 ? ，下界为 C2 ，
         * 由此定义的引用 listLower 可以作为
         * 接下来的 7 种 子泛型类型的 ArrayList 的引用来使用。
         ***************************************************/
        List<? super C2> listLower;
        listLower = new ArrayList<A1>(); // 能存储 A1 B1 B2 C1 C2 D1 D2 E1 E2 E3 E4
        listLower = new ArrayList<B2>(); // 能存储 B2 C1 C2 D1 D2 E1 E2 E3 E4
        listLower = new ArrayList<C2>();// 能存储 D2 E3 E4

    }
}
