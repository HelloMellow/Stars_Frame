package com.stars.frame;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.ExceptionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

//主窗体
public class MainFrame implements WindowListener {

	private JFrame frame;
	private SystemTray systemTray;
	private TrayIcon trayIcon;

	public MainFrame()  {
		// 初始化窗体
		initializeFrame();
		// 初始化图标
		initializeIcon();
	}

	@Override
	public void windowOpened(WindowEvent event) {
	}

	@Override
	public void windowIconified(WindowEvent event) {
		// 托盘图标
		setIconState(true);
	}

	@Override
	public void windowDeiconified(WindowEvent event) {
	}

	@Override
	public void windowDeactivated(WindowEvent event) {

	}

	@Override
	public void windowClosing(WindowEvent event) {

	}

	@Override
	public void windowClosed(WindowEvent event) {

	}

	@Override
	public void windowActivated(WindowEvent event) {

	}

	// 初始化窗体
	private void initializeFrame() {
		String dx = null;
		try {
			if (dx.equals("")) {
			}

		} catch (Exception e) {
			StackTraceElement[] dx1 = e.getStackTrace();
			for (StackTraceElement item : dx1) {
				System.out.println(item);
			}
		}
		frame = new JFrame();
		frame.setTitle("星星之火务器程序");
		// 窗体大小
		frame.setBounds(0, 0, 500, 350);
		// 设置可见
		frame.setVisible(true);
		// 居中
		frame.setLocationRelativeTo(null);
		// 固定大小
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(this);
	}

	// 初始化图盘图标
	private void initializeIcon() {
		if (!SystemTray.isSupported()) {
			return;
		}
		ImageIcon icon = new ImageIcon("res/icon.png");
		trayIcon = new TrayIcon(icon.getImage());
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					// 托盘图标
					setIconState(false);
				}
			}
		});
		systemTray = SystemTray.getSystemTray();
	}

	// 托盘图标
	private void setIconState(boolean isShow) {
		try {
			if (isShow) {
				frame.setVisible(false);
				systemTray.add(trayIcon);
			} else {
				frame.setVisible(true);
				frame.setExtendedState(JFrame.NORMAL);
				frame.toFront();
				systemTray.remove(trayIcon);
			}
		} catch (AWTException e) {
		}
	}
}
