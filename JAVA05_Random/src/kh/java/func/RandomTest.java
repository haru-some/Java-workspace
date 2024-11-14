package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	public void test1() {
		// Random : 무작위 숫자
		// 자바에서 Random숫자 기능을 제공 : Random
		// 1. import java.util.Random
		// 2. Random r = new Random();
		Random r = new Random();
		int num1 = r.nextInt(); // int범위 내에서 무작위 숫자 1개 가져옴
		System.out.println("랜덤 수 : " + num1);
		// 기본메소드인 r.nextInt()를 사용하면 정수 전체범위 중 1개를 무작위로 가져옴
		// -> 경우의수가 매우많아서 활용이 어려움 -> random으로 가져오는 숫자의 범위를 조절가능
		// r.nextInt(숫자) : 해당 숫자 갯수만큼의 범위에서 랜덤수 1개를 가져옴
		// 범위숫자의 기준은 0부터 숫자갯수 만큼이 후보
		int num2 = r.nextInt(10);// 0에서부터 10개숫자중 랜덤으로 1개 가져옴(0~9)
		System.out.println("랜덤 수 : " + num2);
		int num3 = r.nextInt(13);// 0~12사이의 숫자중 랜덤으로 1개 가져옴
		System.out.println("랜덤 수 : " + num3);

		// 0~26 사이의 랜덤수를 추출해서 num4변수에 저장한 후 출력
		int num4 = r.nextInt(27);
		System.out.println("랜덤 수 : " + num4);

		// 1~10까지 중 한개의 랜덤수를 뽑고싶으면
		int num5 = r.nextInt(10) + 1;
		System.out.println("랜덤 수 : " + num5);
		// 범위 설정하는 방법
		// r.nextInt(숫자1)+숫자2;
		// 숫자1 : 랜덤 경우의 수
		// 숫자2 : 랜덤 시작 숫자

		// 10~30 중 랜덤수
		int num6 = r.nextInt(21) + 10;
		System.out.println("랜덤 수 : " + num6);

		char num7 = (char) (r.nextInt(24) + 97);
		System.out.println(num7);
	}

	public void exam1() {
		// 동전 앞/뒤 맞추기
		// 컴퓨터가 동전을 던져서 앞/뒤 중에 한개의 값을 갖고있고, 사용자가 맞추는 게임
		Random r = new Random(); // 컴퓨터의 앞/뒤를 랜덤으로 결정하기위해서 사용
		Scanner sc = new Scanner(System.in); // 사용자가 앞/뒤를 입력하게 하기위해서
		boolean power = true;
		int win = 0;
		int lose = 0;
		while (power) {
			System.out.println("=========== 동전 앞/뒤 맞추기 ===========");
			System.out.println("1. 게임시작");
			System.out.println("2. 전적보기");
			System.out.println("0. 게임종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				// 컴퓨터가 동전을 던진다 -> 앞/뒤 중 1개의 값을 가지면 됨 -> 경우의 수 2개중에 1개를 가짐
				int coin = r.nextInt(2) + 1;// 1 : 앞면 / 2 : 뒷면
				// System.out.println("coin : "+coin); 확인용 코드
				System.out.print("앞면/뒷면 선택하세요(1.앞면 / 2.뒷면) : ");
				int userSelect = sc.nextInt();

				System.out.println("정답 : " + (coin == 1 ? "앞면" : "뒷면"));
				if (coin == userSelect) {
					win++;
					System.out.println("정답입니다.");
				} else {
					lose++;
					System.out.println("오답");
				}
				break;
			case 2:
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				break;
			case 0:
				power = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}// switch 종료
		} // while 종료

	}

	public void exam2() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("== 가위 바위 보 게임 ==");
		System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
		int select = sc.nextInt();
		int computer = r.nextInt(3) + 1;
		switch (select) {
		case 1:
			System.out.println("======== 결과 ========");
			System.out.println("당신은 가위를 냈습니다.");
			if (computer == 1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신은 비겼습니다.");
			} else if (computer == 2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신이 졌습니다.");
			} else if (computer == 3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신이 이겼습니다.ㅠ.ㅠ");
			}
			break;
		case 2:
			System.out.println("======== 결과 ========");
			System.out.println("당신은 바위를 냈습니다.");
			if (computer == 1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신이 이겼습니다.ㅠ.ㅠ");
			} else if (computer == 2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신은 비겼습니다.");
			} else if (computer == 3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신이 졌습니다.");
			}
			break;
		case 3:
			System.out.println("======== 결과 ========");
			System.out.println("당신은 보를 냈습니다.");
			if (computer == 1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신이 졌습니다.");
			} else if (computer == 2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신이 이겼습니다.ㅠ.ㅠ");
			} else if (computer == 3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("==================");
				System.out.println("당신은 비겼습니다.");
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}

	}

	public void rsp() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		int win = 0;
		int lose = 0;
		int draw = 0;

		while (power) {
			System.out.println("== 가위 바위 보 게임 ==");
			System.out.println("1. 게임시작");
			System.out.println("2. 전적보기");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
				int user = sc.nextInt();
				int com = r.nextInt(3) + 1;
				// System.out.println("당신은 "+user+"를 냈습니다.");
				// System.out.println("컴퓨터는 "+com+"를 냈습니다.");
				System.out.println("======== 결과 ========");
				if (user == 1) {
					System.out.println("당신은 가위를 냈습니다.");
				} else if (user == 2) {
					System.out.println("당신은 바위를 냈습니다.");
				} else if (user == 3) {
					System.out.println("당신은 보를 냈습니다.");
				}
				switch (com) {
				case 1:
					System.out.println("컴퓨터는 가위를 냈습니다.");
					break;
				case 2:
					System.out.println("컴퓨터는 바위를 냈습니다.");
					break;
				case 3:
					System.out.println("컴퓨터는 보를 냈습니다.");
					break;
				}
				System.out.println("======================");
				// 이긴경우 : 가위(user==1) && 보(com==3) || 바위(user==2) && 가위(com==1)
				// || 보(user==3) && 바위(com==2)
				// 진경우 : user==1 && com==2 || user==2 && com==3 || user==3 && com==1
				// 비긴경우 : user==1 && com==1 || user==2 && com==2 || user==3 && com==3
				if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
					win++;
					System.out.println("당신이 이겼습니다.");
				} else if ((user == 1 && com == 2) || (user == 2 && com == 3) || (user == 3 && com == 1)) {
					lose++;
					System.out.println("당신이 졌습니다.");
				} else if (user == com) {
					draw++;
					System.out.println("비겼습니다.");
				}

				break;
			case 2:
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				System.out.println("DRAW: " + draw);
				break;
			case 3:
				break;
			case 0:
				power = false;
				break;
			}
		}
	}// 메소드 종료

	public void exam4() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		int count1 = 0;
		while (power) {
			System.out.println("==== Up & Down Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			int count2 = 0;
			switch (select) {
			case 1:
				System.out.println("<< Game Start >>");
				int rnum = r.nextInt(99) + 1;
				while (power) {
					count2++;
					System.out.print(count2 + " 회차 번호 입력 : ");
					int num = sc.nextInt();
					if (rnum > num) {
						System.out.println("<< UP >>");
					} else if (rnum < num) {
						System.out.println("<< DOWN >>");
					} else if (rnum == num) {
						System.out.println("<< 정답 >>");
						break;
					}
				}
				/*
				 * if(count1 == 0) { count1 = count2; }else { if(count2<count1) { count1 =
				 * count2; } }
				 */
				if (count1 == 0 || count2 < count1) {
					count1 = count2;
				}
				break;
			case 2:
				if (count1 == 0) {
					System.out.println("아직 기록이 없습니다.");
				} else if (count1 > 0) {
					System.out.println("현재 최고 기록은 " + count1 + "회 입니다");
				}
				break;
			case 3:
				power = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}

	public void exam5() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		int count1 = 0;
		int win = 0;
		int lose = 0;
		while (power) {
			System.out.println("==== Baskin Robbins31 Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			int num = 0;
			switch (select) {
			case 1:
				System.out.println("<< Game Start >>");
				while (num < 32) {
					System.out.println("<<Your Turn>>");
					System.out.print("Input Number : ");
					int user = sc.nextInt();
					if(user > 3 || user < 1) {
						System.out.println("1~3사이 값을 입력해주세요");
						continue;
					}
					for (int i = 0; i < user; i++) {
						num++;
						System.out.printf("%d!\n",num);
						if (num == 31) {
							System.out.println("패배!!!!!");
							lose++;
							break;
						}
					}
					if (num == 31) {
						break;
					}
					System.out.println("<< Computer Turn >>");
					int rnum = r.nextInt(3) + 1;
					for (int i = 0; i < rnum; i++) {
						num++;
						System.out.printf("%d!\n",num);
						if (num == 31) {
							System.out.println("승리!!!!!");
							win++;
							break;
						}
					}
					if (num == 31) {
						break;
					}
				}
				break;
			case 2:
				System.out.println("<<당신의 전적>>");
				System.out.printf("WIN : %d\n", win);
				System.out.printf("LOSE : %d\n", lose);
				break;
			case 3:
				power = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
	public void upAndDown() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		boolean power = true;
		int score = 0; // 점수기록용 변수
		while(power) {
			System.out.println("==== Up & Down Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				System.out.println("<< Game Start >>");
				int randomNum =r.nextInt(99)+1;//1~99사이의 숫자 중 정답숫자 1개 생성
				//System.out.println("정답숫자 : "+randomNum);
				int count = 1; // 게임 회차 계산용 변수
				while(true) {
					System.out.print(count+"회차 번호 입력 : ");
					int num = sc.nextInt();
					if(num < 1 || num > 99) {
						System.out.println("입력 범위 오류");
						continue; //아래코드 실행하지않고 반복문 조건처리 부분으로 이동
					}
					
					//up이 출력되는 경우 : 정답숫자보다 사용자가 입력한 숫자가 작은경우
					//down이 출력되는 경우 : 정답숫자보다 사용자가 입력한 숫자가 큰경우
					if(num < randomNum) {
						System.out.println("<< UP >>");
					}else if(num > randomNum) {
						System.out.println("<< DOWN >>");
					}else if(num == randomNum) {
						if(score == 0 || score > count) { //이전기록보다 적은회차로 정답을 맞출때만 갱신
							score = count;//정답을 맞추면 해당 회차를 기록
						}
						System.out.println("<< 정답 >>");
						break;
					}
					count++;
					
				}//번호입력을 반복하는 반복문 종료
				
				break;
			case 2:
				if(score == 0) {
					System.out.println("아직 기록이 없습니다.");
				}else {
				System.out.println("최고기록은 "+score+"회 입니다.");
				}
				break;
			case 3:
				power = false;
				break;//switch 종료
			}//switch(메뉴 선택에 따른 조건문) 종료

		}//while(전체 메뉴 반복문) 종료
		
	}//upAndDown 메소드 종료
	
	public void br31() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		boolean power = true;
		int win = 0;
		int lose = 0;
		while (power) {
			System.out.println("==== Baskin Robbins31 Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				//턴게임 -> 사용자와 컴퓨터가 1~3 사이의 숫자를 외치면 숫자가 하나씩 커지는 게임
				// -> 이때 31을 외치는쪽이 패배하는 게임
				int num = 0; //화면에 출력할 숫자
				while(true) {
					System.out.println("<< YOUR TURN >>");
					/* 구간반복을 하려면 while을 사용.
					while(true) {
						System.out.print("Input Number(1~3) : ");
						int userNum = sc.nextInt();
						if(userNum < 1 || userNum > 3) {
							System.out.println("1~3 사이 값을 입력해주세요.");
							continue; //없어도 아래코드가 없기때문에 같은 결과.
						}else {
							for(int i=0;i<userNum;i++) {
								num++;
								System.out.println(num+"!");
								if(num == 31) {
									lose++;
									System.out.println("패배");
									break;  // 출력을 멈춤
								}
							}
						}	
						break;	
					}
						
					}
					*/
					System.out.print("Input Number(1~3) : ");
					int userNum = sc.nextInt();
					if(userNum < 1 || userNum > 3) {
						System.out.println("1~3 사이 값을 입력해주세요.");
						continue;
					}
					for(int i=0;i<userNum;i++) {
						num++;
						System.out.println(num+"!");
						if(num == 31) {
							lose++;
							System.out.println("패배");
							break;  // 출력을 멈춤
						}
					}
					
					if(num == 31) {
						break; // 게임을 멈춤
					}
					/*
					if(userNum == 1) {
						for(int i=0;i<1;i++) {
							num++;
							System.out.println(num+"!");
						}
					}else if(userNum == 2) {
						for(int i=0;i<2;i++) {
							num++;
							System.out.println(num+"!");
						}
					}else if(userNum == 3) {
						for(int i=0;i<3;i++) {
							num++;
							System.out.println(num+"!");
						}
					}
					*/
					System.out.println("<< COMPUTER TURN >>");
					int comNum = r.nextInt(3)+1;
					for(int i=0;i<comNum;i++) {
						num++;
						System.out.println(num+"!");
						if(num == 31) {
							win++;
							System.out.println("승리");
							break;
						}
					}
					if(num == 31) {
						break;
					}
					
					/*
					if(comNum == 1) {
						System.out.println(userNum+1+"!");
					}else if(comNum == 2) {
						System.out.println(userNum+1+"!");
						System.out.println(userNum+1+1+"!");
					}else if(comNum == 3) {
						System.out.println(userNum+1+"!");
						System.out.println(userNum+1+1+"!");
						System.out.println(userNum+1+1+1+"!");
					}
					*/
				}
				break;
			case 2:
				System.out.println("WIN : "+win);
				System.out.println("LOSE : "+lose);
				break;
			case 3:
				power = false;
				break;
			}
	
		}//while(전체 메뉴 반복) 종료
		
	}//br31 메소드 종료
	
}//클래스 종료



















