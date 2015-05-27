package com.stars.main;

import java.awt.EventQueue;

import com.stars.frame.MainFrame;

public class MainEntrance {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
