package com.pratham;
import java.net.*;
import java.io.*;



public class Client {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("From Server :" + str);
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			Socket s = new Socket("localhost", 12345);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hi Server");
			dout.flush();
			dout.close();
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
