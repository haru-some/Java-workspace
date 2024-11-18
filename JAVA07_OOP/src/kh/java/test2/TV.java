package kh.java.test2;

import java.util.Scanner;

public class TV {
	/*
	 TV 생성
	 속성 : 크기 / 전원 / 볼륨 / 채널
	 기능 : 전원 on, off / 채널 1증가 / 채널 1감소 / 숫자입력해서 채널변경 / 볼륨 1증가 / 볼륨 1감소
	 속성 -> 전역변수(클래스변수)로 생성
	 기능 -> 메소드로 생성
	 
	 */
	//전역변수는 지역변수와 다르게 선언하면 기본값 세팅이 되어있음(숫자 : 0, 문자 : ' ', 논리형 : false, 참조형 : null)
	
	private int inch;
	private boolean power; //false : 꺼짐 / true : 켜짐
	public int volume;
	private int channel;
	
	public void powerOnOff() {
		//현재 전원 상태를 반전(켜져있으면 끄고, 꺼져있으면 켜고)
		//true _> false / false -> true
		power = !power;
		if(power) {
			System.out.println("전원이 켜졌습니다.");
		}else {
			System.out.println("전원이 꺼졌습니다.");
		}
	}
	public void channelUp() {
		if(channel == 999) {
			channel = 0;
		}else {
			channel++;
		}
		System.out.println("현재 채널 : "+channel);
	}
	public void channelDown() {
		if(channel == 1) {
			channel = 999;
		}else {
			channel--;
		}
		System.out.println("현재 채널 : "+channel);
	}
	public void volumeUp() {
		if(volume != 5) {
			volume++;
		}
		System.out.println("현재 볼륨 : "+volume);
	}
	public void volumeDown() {
		if(volume != 0) {
			volume--;
		}
		System.out.println("현재 볼륨 : "+volume);
	}
	public void tvStart() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("========== 내가 만든 TV ==========");
			System.out.println("1. 전원버튼");
			System.out.println("2. 채널 올리기");
			System.out.println("3. 채널 내리기");
			System.out.println("4. 볼륨 올리기");
			System.out.println("5. 볼륨 내리기");
			System.out.println("6. 채널 입력하기");
			System.out.println("0. TV 버리기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				powerOnOff();
				break;
			case 2:
				if(power) {
					channelUp();
				}
				break;
			case 3:
				if(power) {
					channelDown();
				}
				break;
			case 4:
				if(power) {
					volumeUp();
				}
				break;
			case 5:
				if(power) {
					volumeDown();
				}
				break;
			case 6:
				if(power) {
					System.out.print("채널을 입력하세요 : ");
					int changeCh = sc.nextInt();
					if(0<=changeCh && changeCh<=999) {
						channel = changeCh;
					}
					System.out.println("현재 채널 : "+channel);
				}
				break;
			case 0:
				return;
			}
			
		}
	}
}
