package com.lzx;

import java.util.LinkedList;

/**
 * @author lzx
 * @create 2021-08-02 9:04
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode heroNode = new HeroNode(1, "zs","zs" );
		HeroNode heroNode2 = new HeroNode(2, "ls", "ls");
		HeroNode heroNode3 = new HeroNode(3, "ww", "ww");
		singleLinkedList.add(heroNode);
		singleLinkedList.add(heroNode2);
		singleLinkedList.add(heroNode3);
		singleLinkedList.deleteLastOne();
		singleLinkedList.show();
	}
}
class SingleLinkedList{
	/**
	 * 定义头结点
	 */
	private HeroNode head = new HeroNode(0, "", "");

	/**
	 * 添加节点到单向链表
	 * 1.找到当前链表的最后节点
	 * 2.将最后的节点next指向添加的节点
	 */
	public void add(HeroNode node){
		//定义指针
		HeroNode pointer = head;
		//遍历
		while (pointer.next!=null){
			pointer = pointer.next;
		}
		//添加节点到最后
		pointer.next = node;
	}
	/**
	 * 显示单向链表
	 */
	public void show(){
		//定义指针
		HeroNode pointer = head.next;
		if (pointer==null){
			System.out.println("链表为空");
		}
		while (pointer!=null){
			System.out.println(pointer);
			pointer = pointer.next;
		}

	}
	/**
	 * 删除末尾节点
	 */
	public void deleteLastOne(){
		//定义指针
		HeroNode pointer = head.next;
		if (pointer==null){
			System.out.println("链表为空");
		}
		while (pointer!=null){
			if (pointer.next==null){
				pointer=null;
				break;
			}
			pointer = pointer.next;
		}
	}
}

/**
 * 定义HeroNode节点对象
 */
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	public HeroNode() {
	}


	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				'}';
	}
}
