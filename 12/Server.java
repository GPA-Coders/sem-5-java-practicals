package com.pratham;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			int n1 = (int) dis.readInt();
			int n2 = (int) dis.readInt();
			int p1 = n1*n1;
			int p2 = n2*n2;
			System.out.println("Square of first number is :" + p1);
			System.out.println("Square of second number is :" + p2);
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

//Square of first number is :4
//Square of second number is :100