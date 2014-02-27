package com.digitaslbi.flappyunicorn;

import com.digitaslbi.flappyunicorn.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Unicorn extends PlayableCharacter {
	private Rainbow rainbow;
	public static Bitmap globalBitmap;
	private static int sound = 1;

	public Unicorn(GameView view, Context context) {
		super(view, context);
		if(globalBitmap == null){
			globalBitmap = createBitmap(context.getResources().getDrawable(R.drawable.unicorn));
		}
		this.bitmap = globalBitmap;
		this.width = this.bitmap.getWidth();
		this.height = this.bitmap.getHeight()/3;
		this.y = context.getResources().getDisplayMetrics().heightPixels / 2;
		
		this.rainbow = new Rainbow(view, context);
		
		if(sound == -1){
			sound = Game.soundPool.load(context, R.raw.cow, 1);
		}
	}
	
	private void playSound(){
		Game.soundPool.play(sound, MainActivity.volume, MainActivity.volume, 0, 0, 1);
	}

	@Override
	public void onTab(){
		super.onTab();
		playSound();
		rainbow.col = 0;
	}
	
	@Override
	public void move(){
		super.move();
		
		// move rainbow
		rainbow.y = this.y;
		rainbow.x = this.x - rainbow.width;
		rainbow.move();
		
		// manage frames
		if(speedY > getTabSpeed() / 3 && speedY < getMaxSpeed() * 1/3){
			row = 0;
		}else if(speedY > 0){
			row = 1;
		}else{
			row = 2;
		}
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		rainbow.draw(canvas);
	}
}
