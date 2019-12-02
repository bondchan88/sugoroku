package sugoroku;

import java.util.Random;
import java.util.Scanner;

/**
 * すごろくチャレンジ
 * @author 3d170
 *
 */
public class Main {
	/**
	 * すごろくインスタンスで使用する　乱数発生装置
	 */
	private Random rand = new Random();
	
	/**
	 * すごろくインスタンスで使用する　入力装置
	 */
	private Scanner input = new Scanner(System.in);
	/**
	 * すごろくのマス目配列
	 */
	private Cell[] path;
	/**
	 * プレイヤーのコマ
	 */
	private Coma player;
	
	/**
	 * すごろくのメインプログラム
	 * @param args
	 */	
	public static void main(String[] args) {
		//　マス目があるはず
		//　ふりだし・あがり・その他いろいろなマスがあるはず

		//　どの位置にいるから記録しておく必要があるはず
		//　お金の概念は入れるかな？
		//　どんなマスが存在しているのか　画面にでたほうがいいよね
		// 競争するなら、それぞれのプレイヤーの位置がどこかわからないとね		
		//	Main m = new Main();
		//	m.run(); この二つは同じ意味↓
		new Main().run();		
	}
	/**
	 * すごろくプログラムの動作
	 */
	private void run() {
		
		initGame();
		// ターンを繰り返し
		do {
			showPath();
					
			//プレイヤーがダイスをふる
			System.out.println("--------------------------------------------------"
					+ "\r\nさて、🎲サイコロをを振りたまえ🎲　　・・　そしてENTERを押しなさい"
					+ "\r\n-------------------------------------------------");
			input.nextLine();//入力まち（データは読み取らない）-
			int proceed = rand.nextInt(4) + 1;//1~4のどれか適当に
			System.out.println( "∵∵∵∵∵∵∵■■■■■■■■■■■■■■■■∵∵∵∵∵∵∵∵" );
			System.out.println( "∵∵∵∵∵∵∵▶▶　　" + proceed + "がでたようだね" +"   ◀◀∵∵∵∵∵∵∵");
			
			System.out.println( "∵∵∵∵∵∵∵■■■■■■■■■■■■■■■■∵∵∵∵∵∵∵∵" );
			
			// コマを出目分進める
			player.proceed(proceed);
			
			int pos = player.getPosition();//全部使ってよいわけではない。変えていいところと悪いところがある。
			if( pos< path.length) {
				Cell now = path [pos];
				//どんなマスに来たのか情報を出す
				System.out.println( path[pos].getCaption() );
				//マスに割り振られたイベントが発動する
				now.doEvent(player);
				player.showProfile();
			}
						
			//もしゴールだったらゲーム終了
			boolean goal = path.length - 1 <= player.getPosition();
			if( goal ) {
				System.out.println("終わりや・・・どっちにしろ終わりや");
				break;
			}
			
		} while(true);
		exitGame();
	}
	
	/**
	 * 現状のすごろく状態を表示する
	 */
	private void showPath() {
		for (int i = 0; i < path.length; i++) {
			if( i < 10){
				System.out.print(" ");
			}
			System.out.print( i + " "); 
		}
		System.out.println();
		
		for (int i = 0; i < path.length; i++) {
			if( i != player.getPosition() ) {
				System.out.print("   ");
			}else {
				System.out.print(" * ");
			}
		}
		System.out.println();//改行
	}
	
	/**
	 * ゲームが終わった時の処理
	 */
	private void exitGame() {
		System.out.println("ΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘ");
		System.out.println("■■■■■■■■■■■■■　■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■　■■■■■■■■■■■■■");
		System.out.println("■■■■■■　　　　　　　　　　　 　　■■■■■■");
		System.out.println("■■■■■■　　　　　　　　　　　 　　■■■■■■");
		System.out.println("■■■■■■　　　　　　　　　　　 　　■■■■■■");
		System.out.println("■■■■■■　　脱出できたYOH！  ■■■■■■");
		System.out.println("■■■■■■　　　　　　♥　　　　 　　■■■■■■");
		System.out.println("■■■■■■　　　　　　　　　　　 　　■■■■■■");
		System.out.println("■■■■■■　　　　　　　　　　　 　　■■■■■■");
		System.out.println("■■■■■■■■■■■■■　■■■■■■■■■■■■■");
		System.out.println("■■■■■■■■■■■■■　■■■■■■■■■■■■■");
		System.out.println("ΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘΘ");
		System.out.println("                   Congrats");
	}
	/**
	 * ゲームを始めるための下準備
	 */
	private void initGame() {
/*		path =  new Cell[20];
		path[0] = new StartCell();
		for (int i = 1; i < path.length-1; i++) {
			//とりあえず　通常マスでつくっておこうかな？
			path[i] = new NomalCell();	
			if(i%2 ==0) {
				path[i] = new ReturnCell();
			}
		}
		path[path.length-1] = new GoalCell();
*/
		path =  new Cell[] {
				new StartCell(),
				new syakunetujigokuCell(),
				new ReturnCell(),
				new NomalCell(),
				new NomalCell(),
				new tengokuCell(),
				new ReturnCell(),
				new ReturnCell(),
				new tengokuCell(),
				new NomalCell(),
				new ReturnCell(),
				new NomalCell(),
				new ReturnCell(),
				new NomalCell(),
				new ReturnCell(),
				new tengokuCell(),
				new ReturnCell(),
				new syakunetujigokuCell(),
				new ReturnCell(),
				new NomalCell(),
				new tengokuCell(),
				new NomalCell(),
				new ReturnCell(),
				new tengokuCell(),
				new NomalCell(),
				new ReturnCell(),
				new NomalCell(),
				new tengokuCell(),
				new syakunetujigokuCell(),
				new syakunetujigokuCell(),
				new tengokuCell(),
				new NomalCell(),
				new ReturnCell(),
				new NomalCell(),
				new ReturnCell(),
				new ReturnCell(),
				new GoalCell()
			
		};
		
		player = new Coma("　バイキンマン　");
		System.out.println( path[0].getCaption() );
		
	}

}
