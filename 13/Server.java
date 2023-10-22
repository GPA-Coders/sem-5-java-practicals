package com.pratham;
import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(12345);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String s1 = (String) dis.readUTF();
			System.out.println("From Client :" + s1);
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Client");
			dout.flush();
			dout.close();
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}