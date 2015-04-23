package mathTests;

import static org.junit.Assert.*;
import mathGame.Missile;
import mathGame.Target;

import org.junit.Before;
import org.junit.Test;

public class CollisionTest {
	Missile A3;
	Target targ;
	@Before
	public void SetUp(){
		A3 = new Missile();
		targ = new Target();
	}
	@Test
	public void CollsionTestTrue() {
		int x = 85;
		int y = 90;
		A3.setX(x);
		A3.setY(y);
	    targ.setX(x);
	    targ.setY(y);
	    assertTrue(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionWidthTrue(){
		int x = 40;
		int y= 5;
		A3.setX(x);
		A3.setY(y);
		targ.setWidth(x);
		targ.setHeight(10);
		assertTrue(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionWidthTrueDiag(){
		int x = (targ.getWidth()/2);
		int y= targ.getHeight()/2;
		A3.setX(x);
		A3.setY(y);
		targ.setWidth(x);
		targ.setHeight(y);
		assertTrue(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionHeightTrue(){
		int x = 40;
		int y= 35;
		A3.setX(x);
		A3.setY(y);
		targ.setWidth(89);
		targ.setHeight(y);
		assertTrue(A3.isColliding(targ));
	}
	@Test
	public void CollsionTestFail(){
		int x = 90;
		int y = 88;
		A3.setX(x);
		A3.setY(y);
		targ.setX(45);
		targ.setY(50);
		assertFalse(A3.isColliding(targ));
	}
	@Test
	public void CollsionTestFailY(){
		int x = 90;
		int y = 88;
		A3.setX(x);
		A3.setY(y);
		targ.setX(x);
		targ.setY(50);
		assertFalse(A3.isColliding(targ));
	}
	@Test
	public void CollsionTestFailX(){
		int x = 90;
		int y = 88;
		A3.setX(x);
		A3.setY(y);
		targ.setX(50);
		targ.setY(y);
		assertFalse(A3.isColliding(targ));
	}
	@Test
	public void CollisionHeightFail(){
		int x = 40;
		int y= 66;
		A3.setX(x);
		A3.setY(y);
		targ.setWidth(89);
		targ.setHeight(65);
		assertFalse(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionWidthFail(){
		int x = 30;
		int y= 30;
		A3.setX(x);
		A3.setY(y);
		targ.setWidth(20);
		targ.setHeight(40);
		assertFalse(A3.isColliding(targ));
		
	}
}
