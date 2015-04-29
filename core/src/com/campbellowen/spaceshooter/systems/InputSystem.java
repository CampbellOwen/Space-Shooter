package com.campbellowen.spaceshooter.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.campbellowen.spaceshooter.components.InputComponent;
import com.campbellowen.spaceshooter.components.MovementComponent;

public class InputSystem extends IteratingSystem{
	private ImmutableArray<Entity> entities;
	private Vector2 tempVector = new Vector2();
	private ComponentMapper<InputComponent> im;
	private ComponentMapper<MovementComponent> vm;
	
	final float baseXVelocity = 500;
	final float baseYVelocity = 500;
	
	enum movementX{
		LEFT, RIGHT, STILL
	}

	
	public InputSystem() {
		super(Family.getFor(InputComponent.class));
		
		im = ComponentMapper.getFor(InputComponent.class);
		vm = ComponentMapper.getFor(MovementComponent.class);
	}
	

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		// TODO Auto-generated method stub
		InputComponent input = im.get(entity);
		MovementComponent movement = vm.get(entity);
		/*
		movementX stateX = movementX.STILL;
		if(movement.velocity.x < 0){
			stateX = movementX.LEFT;
		}
		else if (movement.velocity.x > 0){
			stateX = movementX.RIGHT;
		}
		
		/*
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			if(directionRight || (!directionRight && !Gdx.input.isKeyPressed(Keys.RIGHT))){
				movement.velocity.x = -baseXVelocity;

			}
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			if(!directionRight || (directionRight && Gdx.input.isKeyPressed(Keys.RIGHT))){
				movement.velocity.x = baseXVelocity;

			}
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)){
			movement.acceleration.x = -200;
			//movement.velocity.x = -baseXVelocity;
			if (movement.velocity.x <= -baseXVelocity ){
				movement.velocity.x = -baseXVelocity;
				movement.acceleration.x = 0;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)){
			//movement.velocity.x = baseXVelocity;
			
			movement.acceleration.x = 200;
			if (movement.velocity.x >= baseXVelocity ){
				movement.velocity.x = baseXVelocity;
				movement.acceleration.x = 0;
			}
		}
	
		if(!Gdx.input.isKeyPressed(Keys.LEFT) && !Gdx.input.isKeyPressed(Keys.RIGHT)){
			//movement.velocity.x = 0;
			if (movement.velocity.x == 0){
				stateX = movementX.STILL;
			}
			if(stateX == movementX.RIGHT){
				movement.acceleration.x = -200;
			}
			else if(stateX == movementX.LEFT){
				movement.acceleration.x = 200;
			}
			else{
				movement.acceleration.x = 0;
			}
			
			
		}
		*/
		

		
		
	}
}
