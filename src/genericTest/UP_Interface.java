package genericTest;

/* <? super T> 与 <? extends T> 的区别，
 *  T 代表一个给定的接口
 * https://www.cnblogs.com/guanghuiqq/p/11208809.html
 * */
import java.util.*;
interface A1{}
interface A2{}
interface A3{}
interface A4{}

interface B1 extends A1{}
interface B2 extends A1,A2{}
interface B3 extends A3,A4{}
interface B4 extends A4{}

interface C1 extends B2{}
interface C2 extends B2,B3{}
interface C3 extends B3{}

interface D1 extends C1,C2{}
interface D2 extends C2{}

interface E1 extends D1{}
interface E2 extends D1{}
interface E3 extends D2{}
interface E4 extends D2{}

public class UP_Interface {
    public static void main(String args[]) { 
        /********************************************
         * 此处 extends 表示 有上界的统配符 ?，上界为  C2
         * 由此定义的引用 listUpper可以作为 
         * 接下来的 7 种 子泛型类型的 ArrayList 的引用来使用。 
         **********************************************/
        List<? extends C2> listUpper;//上界统配符 ?， 上界为  C2
        listUpper=new ArrayList<C2>();//能存储 C2 D1 D2 E1 E2 E3 E4
        listUpper=new ArrayList<D1>();//能存储    D1    E1 E2  
        listUpper=new ArrayList<D2>();//能存储       D2       E3 E4
        listUpper=new ArrayList<E1>();//能存储          E1             
        listUpper=new ArrayList<E2>();//能存储             E2             
        listUpper=new ArrayList<E3>();//能存储                E3             
        listUpper=new ArrayList<E4>();//能存储				     E4
                             
        /*************************************************
         * super 表示有下界的统配符 ? ，下界为  C2 ， 
         * 由此定义的引用 listLower 可以作为 
         * 接下来的 7 种 子泛型类型的 ArrayList 的引用来使用。  
         ***************************************************/
        List<? super C2> listLower;
        listLower=new ArrayList<A1>(); //能存储 A1          B1 B2       C1 C2    D1 D2 E1 E2 E3 E4
        listLower=new ArrayList<A2>(); //能存储    A2          B2       C1 C2    D1 D2 E1 E2 E3 E4
        listLower=new ArrayList<A3>(); //能存储       A3          B3       C2 C3 D1 D2 E1 E2 E3 E4
        listLower=new ArrayList<A4>(); //能存储          A4       B3 B4    C2 C3 D1 D2 E1 E2 E3 E4
        listLower=new ArrayList<B2>(); //能存储                B2       C1 C2    D1 D2 E1 E2 E3 E4
        listLower=new ArrayList<B3>(); //能存储                   B3       C2 C3 D1 D2 E1 E2 E3 E4
        listLower=new ArrayList<C2>();// 能存储                            C2    D1 D2 E1 E2 E3 E4
    }
}
