/**
 * 
 */
package sugoroku;

/**
 *すごろくに使用されるマス目を表現する抽象基底クラス
 *
 */
public abstract class Cell {

	/**
	 * コンストラクタ（newできないのでprotectedにしておく）
	 */
	public Cell() {
	}
	/**
	 * なにかしらのイベントを実行できる予定　
	 @return イベント処理の結果何かがかわるかどうかの情報を返す予定
	 */
	public abstract Boolean doEvent( Coma coma );
	/**
	 * このマス目の表示名
	 * @return 表示文字列
	 */
	public abstract String getCaption();
	
	
}
