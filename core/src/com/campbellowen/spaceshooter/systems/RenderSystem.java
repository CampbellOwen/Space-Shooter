package com.campbellowen.spaceshooter.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.campbellowen.spaceshooter.components.PositionComponent;
import com.campbellowen.spaceshooter.components.TextureComponent;

public class RenderSystem extends EntitySystem {
	private ImmutableArray<Entity> entities;

	private SpriteBatch batch;
	private OrthographicCamera camera;

	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<TextureComponent> tm = ComponentMapper.getFor(TextureComponent.class);
	
	public RenderSystem(OrthographicCamera camera) {
		batch = new SpriteBatch();

		this.camera = camera;
	}

	@Override
	public void addedToEngine (Engine engine) {
		entities = engine.getEntitiesFor(Family.getFor(PositionComponent.class, TextureComponent.class));
	}
	
	@Override
	public void removedFromEngine (Engine engine) {

	}
	
	@Override
	public void update(float deltaTime){
		PositionComponent position;
		TextureComponent texture;

		camera.update();

		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		for (int i = 0; i < entities.size(); ++i) {
			Entity e = entities.get(i);

			position = pm.get(e);
			texture= tm.get(e);

			batch.draw(texture.region, position.pos.x, position.pos.y);
		}

		batch.end();
	}


}
