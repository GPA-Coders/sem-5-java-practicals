package com.pratham;
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeInt(2);
			dout.writeInt(10);
			dout.flush();
			dout.close();
			s.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}