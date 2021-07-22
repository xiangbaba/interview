package com.lzx;

/**
 * @author lzx
 * @create 2021-07-22 8:28
 */
public class MyTest {
	public static void main(String[] args) {
		//将1赋值给变量i
		int i = 1;
		//先把i加载到操作数栈,在局部变量表中执行++操作变成2,
		// 最后将操作数栈中i的值赋值到局部变量表中的i,此时1覆盖2,i变量还是1
		i = i++;
		//先把i加载到操作数栈,在局部变量表中执行++操作,
		//然后把将i的值赋值给j,此时i的值是2,j的值是1
		int j = i++;
		//先把等号右边的加载的操作数栈,把i加载到操作数组栈,i是2,
		// ++1先在局部变量表进行运算变成3,然后加载到操作数栈
		//i++先加载到操作数栈,在局部变量表中进行运算i变成4,然后i加载到操作数栈
		//在操作数栈中完成2+3*3运算,然后赋值给变量k
		//此时i是4,j是1,k是11
		int k = i+ ++i*i++;
		System.out.println(i);
		System.out.println(k);
		System.out.println(j);
	}
}
