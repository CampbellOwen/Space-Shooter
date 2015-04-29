package com.campbellowen.spaceshooter.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

public class PositionComponent extends Component implements Poolable {

	public Vector2 pos = new Vector2(0.0f, 0.0f);
	
	public PositionComponent(){
		
	}
	public PositionComponent(float x, float y){
		this.pos.set(x, y);
	}
	@Override
	public void reset() {
		pos.set(0.0f, 0.0f);
	}

}
