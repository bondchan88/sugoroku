/**
 * 
 */
package sugoroku;

/**
 * ふつうなマスの実装クラス
 * @author 3d170
 *
 */
public class NomalCell extends Cell {

	/**
	 * コンストラクタ
	 */
	public NomalCell() {
	}

	@Override
	public Boolean doEvent(Coma coma) {
		coma.addPoint(100);//とりあえず適当に
		return true;
	}

	@Override
	public String getCaption() {
		return "□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□"
				+ "\r\nひいいいいいい　ハリケーンがごうごうとうなっている。"
				+ "\r\n（心の声）　もし巻き込まれたらぐちゃぐちゃじゃないかあ（大汗）"
				+ "\r\n□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□";
	}

}
