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

//������
public class MainFrame implements WindowListener {

	private JFrame frame;
	private SystemTray systemTray;
	private TrayIcon trayIcon;

	public MainFrame()  {
		// ��ʼ������
		initializeFrame();
		// ��ʼ��ͼ��
		initializeIcon();
	}

	@Override
	public void windowOpened(WindowEvent event) {
	}

	@Override
	public void windowIconified(WindowEvent event) {
		// ����ͼ��
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

	// ��ʼ������
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
		frame.setTitle("����֮����������");
		// �����С
		frame.setBounds(0, 0, 500, 350);
		// ���ÿɼ�
		frame.setVisible(true);
		// ����
		frame.setLocationRelativeTo(null);
		// �̶���С
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(this);
	}

	// ��ʼ��ͼ��ͼ��
	private void initializeIcon() {
		if (!SystemTray.isSupported()) {
			return;
		}
		ImageIcon icon = new ImageIcon("res/icon.png");
		trayIcon = new TrayIcon(icon.getImage());
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					// ����ͼ��
					setIconState(false);
				}
			}
		});
		systemTray = SystemTray.getSystemTray();
	}

	// ����ͼ��
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
