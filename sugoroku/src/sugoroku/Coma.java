/**
 * 
 */
package sugoroku;

/**すごろくのプレイヤーと位置を表すコマクラス
 *
 */
public class Coma {
	/**
	 * プレイヤーの名前
	 */
	private String name;
	/**
	 * 現在位置
	 */
	private int position;
	private int point;
	/**
	 * コンストラクタ
	 * @param name　プライヤー名
	 */
	public Coma( String name ){
		this.name = name;
		this.position = 0;
	}
	/**
	 * このコマの現在位置を返します
	 * @return　位置を表す数値
	 */
	public int getPosition() {
		return this.position;
	}
	/**
	 * このコマが指定された分量 すすみます
	 * @param amount すすむ量
	 */
	public void proceed(int amount) {
		this.position += amount;
	}
	public void addPoint(int amount) {
		this.point += amount;
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println(name + "　は　" + amount + "　ポイントをゲットした。　しかし没収された　");
	}
	public void showProfile() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println( name + "：　はひふへほーーーーー！！！！　　　"  + position + "コマ目にいきたまえ！");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}