package com.campbellowen.spaceshooter.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;
import com.campbellowen.spaceshooter.components.MovementComponent;
import com.campbellowen.spaceshooter.components.PositionComponent;

public class MovementSystem extends IteratingSystem {
	private ImmutableArray<Entity> entities;
	private Vector2 tempVector = new Vector2();
	private ComponentMapper<PositionComponent> pm;
	private ComponentMapper<MovementComponent> vm;
	
	public MovementSystem() {
		super(Family.getFor(PositionComponent.class, MovementComponent.class));
		
		pm = ComponentMapper.getFor(PositionComponent.class);
		vm = ComponentMapper.getFor(MovementComponent.class);
	}
	

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		// TODO Auto-generated method stub
		PositionComponent position = pm.get(entity);
		MovementComponent movement = vm.get(entity);
		
		tempVector.set(movement.acceleration).scl(deltaTime);
		movement.velocity.add(tempVector);
		
		tempVector.set(movement.velocity).scl(deltaTime);
		position.pos.add(tempVector);
		
		System.out.print(movement.acceleration.x);
		System.out.print(" ");
		System.out.println(movement.velocity.x);
	}
}
