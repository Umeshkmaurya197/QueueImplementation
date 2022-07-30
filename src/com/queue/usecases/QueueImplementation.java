package com.queue.usecases;

import java.util.Queue;

public class QueueImplementation<T> {
	Node<T> front;
	Node<T> rear;
	public int size;

	public QueueImplementation() {
		this.size = 0;
	}

	// enqueue the element -uc1
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		size++;
		if (front == null && rear == null) {
			front = rear = newNode;
			return;
		}
		rear.next = newNode;
		rear = rear.next;
	}

	// dequeue element -uc2
	public void removefront() {
		if (front == null && rear == null) {
			System.out.println(" Queue is empty ");
			return;
		}
		size--;
		front=front.next;
	}

	public void printQueue() {
		if (front == null && rear == null) {
			System.out.println("Queue is empty");
			return;
		}
		Node<T> currentNode = front;
		while (currentNode != null) {
			System.out.print(currentNode + " <- ");
			currentNode = currentNode.next;
		}
		System.out.println(" ");
	}
	// size of queue 
	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		QueueImplementation<Integer> queueImplementation = new QueueImplementation<Integer>();
		queueImplementation.add(56);
		queueImplementation.add(30);
		queueImplementation.add(70);

		queueImplementation.printQueue();// 56 <- 30 <- 70 <-
		System.out.println("Now size of queue :" + queueImplementation.getSize());//3

		queueImplementation.removefront();
		queueImplementation.printQueue();//30 <- 70 <- 
		System.out.println("Now size of queue :" + queueImplementation.getSize()); //2

		
	}
}
