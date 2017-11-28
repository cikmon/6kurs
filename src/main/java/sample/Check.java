/*
 * Java port of Bullet (c) 2008 Martin Dvorak <jezek2@advel.cz>
 * HelloWorld port by: Clark Dorman
 *
 * Bullet Continuous Collision Detection and Physics Library
 * Copyright (c) 2003-2008 Erwin Coumans  http://www.bulletphysics.com/
 *
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from
 * the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be
 *    misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */

package sample;

import com.bulletphysics.collision.broadphase.AxisSweep3;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;

import javax.vecmath.Vector3f;

/**
 * This is a Hello World program for running a basic Bullet physics simulation.
 * it is a direct translation of the C++ HelloWorld app.
 *
 * @author cdorman
 */
public class Check
{
	//private Transform transformOne=new Transform();
	//private Transform transformTwo=new Transform();

	//public Transform getTransformOne() {return transformOne;}

	//public Transform getTransformTwo() {return transformTwo;}

	public boolean start(Ploskosti object1, Ploskosti object2) {
		CollisionConfiguration collisionConfiguration = new DefaultCollisionConfiguration();
		CollisionDispatcher dispatcher = new CollisionDispatcher(
				collisionConfiguration);
		Vector3f worldAabbMin = new Vector3f(-10000, -10000, -10000);
		Vector3f worldAabbMax = new Vector3f(10000, 10000, 10000);
		int maxProxies = 1024;
		AxisSweep3 overlappingPairCache =
				new AxisSweep3(worldAabbMin, worldAabbMax, maxProxies);
		SequentialImpulseConstraintSolver solver = new SequentialImpulseConstraintSolver();
		DiscreteDynamicsWorld dynamicsWorld = new DiscreteDynamicsWorld(
				dispatcher, overlappingPairCache, solver,
				collisionConfiguration);
		dynamicsWorld.setGravity(new Vector3f(0, 0, 0));
		//object 1 size
		float coordX1=(float) object1.coordX();
		float coordY1=(float) object1.coordY();
		float coordZ1=(float) object1.coordZ();
		float dergX1=object1.angleX();
		float dergY1=object1.angleY();
		float dergZ1=object1.angleZ();
		float xo1=(float) object1.width(),yo1=(float) object1.haight(),zo1=(float) object1.lenght();
		CollisionShape groundShape = new BoxShape(new Vector3f(xo1, yo1, zo1));
		ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList<CollisionShape>();

		collisionShapes.add(groundShape);

		Transform groundTransform = new Transform();
		groundTransform.setIdentity();
		//object 1 coordinates

		//groundTransform.origin.set(new Vector3f((float)object1.coordX()*2+object1.width(), (float)object1.coordY()*2+object1.haight(),
			//	(float)object1.coordZ()*2+object1.lenght()));


		if(dergX1>0||(dergX1==0&&dergY1==0&&dergZ1==0)) {
			groundTransform.basis.rotX((float) Math.toRadians(-dergX1));
			float dX = (float) (Math.sqrt(yo1 * yo1 + zo1 * zo1) / 2);
			float angleBC = (float) (Math.toDegrees(Math.asin(zo1 / (2 * dX))));
			float dergg12 = -dergX1 + angleBC;
			float YrazX = (float) (dX * Math.cos(Math.toRadians(dergg12)) - dX * Math.cos(Math.toRadians(angleBC)));
			float ZrazX = (float) (dX * Math.sin(Math.toRadians(dergg12)) - dX * Math.sin(Math.toRadians(angleBC)));
			groundTransform.origin.set(coordX1*2 + xo1, coordY1*2 +yo1+ YrazX * 2, coordZ1*2 + zo1 + ZrazX * 2);
			//transformOne.basis.rotX((float) Math.toRadians(dergX1));
			//transformOne.origin.set(coordX1,coordY1,coordZ1);
			//Matrix4f rer= new Matrix4f();transformOne.getMatrix(rer);
		}else if(dergY1>0){
			groundTransform.basis.rotY((float)Math.toRadians(-dergY1) );
			float dY = (float) (Math.sqrt(xo1 * xo1 + zo1 * zo1) / 2);
			float angleY = (float) (Math.toDegrees(Math.asin(zo1 / (2 * dY))));
			float derggY = -dergY1 + angleY;
			float XrazY = (float) (dY * Math.cos(Math.toRadians(derggY)) - dY * Math.cos(Math.toRadians(angleY)));
			float ZrazY = (float) (dY * Math.sin(Math.toRadians(derggY)) - dY * Math.sin(Math.toRadians(angleY)));
			groundTransform.origin.set(coordX1*2 + xo1 + XrazY * 2, coordY1*2+yo1, coordZ1*2 + zo1  + ZrazY * 2);
		//	transformOne.basis.rotX((float) Math.toRadians(dergY1));
			//transformOne.origin.set(coordX1,coordY1,coordZ1);
		//	Matrix4f rer= new Matrix4f();transformOne.getMatrix(rer);
		}else if(dergZ1>0){
			groundTransform.basis.rotZ((float)Math.toRadians(dergZ1) );
			float dZ = (float) (Math.sqrt(xo1 * xo1 + yo1 * yo1) / 2);
			float angleZ = (float) (Math.toDegrees(Math.asin(xo1 / (2 * dZ))));
			float derggZ = -dergZ1 + angleZ;
			float XrazZ = (float) (dZ * Math.sin(Math.toRadians(derggZ)) - dZ * Math.sin(Math.toRadians(angleZ)));
			float YrazZ = (float) (dZ * Math.cos(Math.toRadians(derggZ)) - dZ * Math.cos(Math.toRadians(angleZ)));
			groundTransform.origin.set(coordX1*2+xo1+XrazZ*2, coordY1*2+yo1+YrazZ*2 ,  coordZ1*2+zo1);
		//	transformOne.basis.rotX((float) Math.toRadians(dergX1));
		//	transformOne.origin.set(coordX1,coordY1,coordZ1);
		//	Matrix4f rer= new Matrix4f();transformOne.getMatrix(rer);


			/*	System.out.println("d="+dZ * Math.sin(Math.toRadians(derggZ)));
				System.out.println("a="+dZ * Math.sin(Math.toRadians(angleZ)));
				System.out.println("X="+XrazZ);
				System.out.println("Y="+YrazZ);
				System.out.println("angleZ="+angleZ);
				System.out.println("dergZ="+derggZ);*/
		}









		{
			float mass = 0f;
			boolean isDynamic = (mass != 0f);

			Vector3f localInertia = new Vector3f(0, 0, 0);
			if (isDynamic) {
				groundShape.calculateLocalInertia(mass, localInertia);
			}
			DefaultMotionState myMotionState = new DefaultMotionState(groundTransform);
			RigidBodyConstructionInfo rbInfo = new RigidBodyConstructionInfo(
					mass, myMotionState, groundShape, localInertia);
			RigidBody body = new RigidBody(rbInfo);
			dynamicsWorld.addRigidBody(body);
		}

		{
			//obj 2 size
			float coordX=(float) object2.coordX();
			float coordY=(float) object2.coordY();
			float coordZ=(float) object2.coordZ();
			float dergX=object2.angleX();
			float dergY=object2.angleY();
			float dergZ=object2.angleZ();
			float xo=(float) object2.width(),yo=(float) object2.haight(),zo=(float) object2.lenght();

			CollisionShape colShape = new BoxShape(new Vector3f(xo,yo,zo));
			collisionShapes.add(colShape);


			Transform startTransform = new Transform();
			startTransform.setIdentity();

			float mass = 1f;

			boolean isDynamic = (mass != 0f);

			Vector3f localInertia = new Vector3f(0, 0, 0);
			if (isDynamic) {
				colShape.calculateLocalInertia(mass, localInertia);
			}
			//obj 2 coord

			if(dergX>0||(dergX==0&&dergY==0&&dergZ==0)) {
				startTransform.basis.rotX((float) Math.toRadians(-dergX));
				float dX = (float) (Math.sqrt(yo * yo + zo * zo) / 2);
				float angleBC = (float) (Math.toDegrees(Math.asin(zo / (2 * dX))));
				float dergg12 = -dergX + angleBC;
				float YrazX = (float) (dX * Math.cos(Math.toRadians(dergg12)) - dX * Math.cos(Math.toRadians(angleBC)));
				float ZrazX = (float) (dX * Math.sin(Math.toRadians(dergg12)) - dX * Math.sin(Math.toRadians(angleBC)));
				startTransform.origin.set(coordX*2 + xo, coordY*2 +yo+ YrazX * 2, coordZ*2 + zo + ZrazX * 2);
				//transformOne.basis.rotX((float) Math.toRadians(dergX));
				//transformOne.origin.set(coordX,coordY,coordZ);
				//Matrix4f rer= new Matrix4f();transformOne.getMatrix(rer);
				//System.out.print(rer.toString());
			}else if(dergY>0){
				startTransform.basis.rotY((float)Math.toRadians(-dergY) );
				float dY = (float) (Math.sqrt(xo * xo + zo * zo) / 2);
				float angleY = (float) (Math.toDegrees(Math.cos(zo / (2 * dY))));
				float derggY = -dergY + angleY;
				float XrazY = (float) (dY * Math.sin(Math.toRadians(derggY)) - dY * Math.sin(Math.toRadians(angleY)));
				float ZrazY = (float) (dY * Math.cos(Math.toRadians(derggY)) - dY * Math.cos(Math.toRadians(angleY)));
				startTransform.origin.set(coordX*2 + xo + XrazY * 2, coordY*2+yo, coordZ*2 + zo  + ZrazY * 2);
				//transformOne.basis.rotX((float) Math.toRadians(dergX));
				//transformOne.origin.set(coordX,coordY,coordZ);
				//Matrix4f rer= new Matrix4f();transformOne.getMatrix(rer);
			}else if(dergZ>0){
				startTransform.basis.rotZ((float)Math.toRadians(dergZ) );
				float dZ = (float) (Math.sqrt(xo * xo + yo * yo) / 2);
				float angleZ = (float) (Math.toDegrees(Math.asin(xo / (2 * dZ))));
				float derggZ = -dergZ + angleZ;
				float XrazZ = (float) (dZ * Math.sin(Math.toRadians(derggZ)) - dZ * Math.sin(Math.toRadians(angleZ)));
				float YrazZ = (float) (dZ * Math.cos(Math.toRadians(derggZ)) - dZ * Math.cos(Math.toRadians(angleZ)));
				startTransform.origin.set(coordX*2+xo+XrazZ*2, coordY*2+yo+YrazZ*2 ,  coordZ*2+zo);
				//transformOne.basis.rotX((float) Math.toRadians(dergX));
				//transformOne.origin.set(coordX,coordY,coordZ);
				//Matrix4f rer= new Matrix4f();transformOne.getMatrix(rer);

			/*	System.out.println("d="+dZ * Math.sin(Math.toRadians(derggZ)));
				System.out.println("a="+dZ * Math.sin(Math.toRadians(angleZ)));
				System.out.println("X="+XrazZ);
				System.out.println("Y="+YrazZ);
				System.out.println("angleZ="+angleZ);
				System.out.println("dergZ="+derggZ);*/
			}

			//transformOne=groundTransform;
			//transformTwo=startTransform;
			DefaultMotionState myMotionState = new DefaultMotionState(startTransform);
			RigidBodyConstructionInfo rbInfo = new RigidBodyConstructionInfo(
					mass, myMotionState, colShape, localInertia);

			RigidBody body = new RigidBody(rbInfo);
			dynamicsWorld.addRigidBody(body);


		}



		// Do some simulation
		float prov[][]= new float[3][4];
		int ii=0;
		for (int i=0; i<2; i++) {

			dynamicsWorld.stepSimulation(1.f / 60.f, 10);
			for (int j=dynamicsWorld.getNumCollisionObjects()-1; j>=0; j--)
			{
				CollisionObject obj = dynamicsWorld.getCollisionObjectArray().getQuick(j);
				RigidBody body = RigidBody.upcast(obj);
				if (body != null && body.getMotionState() != null) {
					Transform trans = new Transform();
					body.getMotionState().getWorldTransform(trans);
					//if(j%2!=0) {
						prov[0][ii] = trans.origin.x;
						prov[1][ii] = trans.origin.y;
						prov[2][ii] = trans.origin.z;
						ii++;

					////}
					System.out.printf("world pos = %f  ,  %f,  %f\n", trans.origin.x, trans.origin.y, trans.origin.z);
				}
			}
		}
		System.out.printf(
				"00="+prov[0][0]+" 10="+prov[1][0]+" 20="+prov[2][0]+"\n"+
				"01="+prov[0][1]+" 11="+prov[1][1]+" 21="+prov[2][1]+"\n"+
				"02="+prov[0][2]+" 12="+prov[1][2]+" 22="+prov[2][2]+"\n"+
				"03="+prov[0][3]+" 13="+prov[1][3]+" 23="+prov[2][3]);
		boolean provkorp;
		boolean provvjbul=prov[0][0]!=prov[0][2]||prov[1][0]!=prov[1][2]||prov[2][0]!=prov[2][2]||
						  prov[0][1]!=prov[0][3]||prov[1][1]!=prov[1][3]||prov[2][1]!=prov[2][3];


		return provvjbul;

	}

}
