package com.campbellowen.spaceshooter.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

public class MovementComponent extends Component implements Poolable {

	public Vector2 velocity = new Vector2(0.0f, 0.0f);
	public Vector2 acceleration = new Vector2(0.0f, 0.0f);
	
	
	@Override
	public void reset() {
		velocity.x = 0.0f;
		velocity.y = 0.0f;
		
		acceleration.x = 0.0f;
		acceleration.y = 0.0f;
	}

}
