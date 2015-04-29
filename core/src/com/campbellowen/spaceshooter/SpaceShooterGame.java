package com.campbellowen.spaceshooter;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.campbellowen.spaceshooter.components.InputComponent;
import com.campbellowen.spaceshooter.components.MovementComponent;
import com.campbellowen.spaceshooter.components.PositionComponent;
import com.campbellowen.spaceshooter.components.TextureComponent;
import com.campbellowen.spaceshooter.systems.InputSystem;
import com.campbellowen.spaceshooter.systems.MovementSystem;
import com.campbellowen.spaceshooter.systems.RenderSystem;

public class SpaceShooterGame extends ApplicationAdapter {
	Texture playerTexture;
	PooledEngine engine;
	Entity player;

	@Override
	public void create () {
		OrthographicCamera camera = new OrthographicCamera(1024, 576);
		camera.position.set(320, 240, 0);
		camera.update();
		
		playerTexture = new Texture("player64.png");
		
		engine = new PooledEngine();
		engine.addSystem(new MovementSystem());
		engine.addSystem(new RenderSystem(camera));
		engine.addSystem(new InputSystem());
		

	
		
		spawnPlayer();
		
		
		
	}
	
	public void spawnPlayer(){
		player = engine.createEntity();
		player.add(new PositionComponent(50,50));
		player.add(new TextureComponent(new TextureRegion(playerTexture)));
		player.add(new MovementComponent());
		player.add(new InputComponent());
	
		engine.addEntity(player);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		engine.update(Gdx.graphics.getDeltaTime());
	}
}
