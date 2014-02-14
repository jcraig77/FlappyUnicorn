package com.digitaslbi.flappyunicorn;

import android.content.Context;

public class PowerUp extends Sprite {
	public PowerUp(GameView view, Context context) {
		super(view, context);
		init();
	}
	
	private void init(){
		this.x = view.getWidth() * 4/5;
		this.y = 0 - this.height;
		this.speedX = - view.getSpeedX();
		this.speedY = view.getSpeedX() * 2 / 3;
	}
}
