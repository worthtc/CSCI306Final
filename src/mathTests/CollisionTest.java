package mathTests;

import static org.junit.Assert.*;
import junit.framework.Assert;
import mathGame.Missile;
import mathGame.Target;

import org.junit.Before;
import org.junit.BeforeClass;
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
	    targ.setx(x);
	    targ.sety(y);
	    assertTrue(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionWidthTrue(){
		int x = 40;
		int y= 5;
		A3.setX(x);
		A3.setY(y);
		targ.setwidth(x);
		targ.setheight(10);
		assertTrue(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionWidthTrueDiag(){
		int x = (targ.getwidth()/2);
		int y= targ.getheight()/2;
		A3.setX(x);
		A3.setY(y);
		targ.setwidth(x);
		targ.setheight(y);
		assertTrue(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionHeightTrue(){
		int x = 40;
		int y= 35;
		A3.setX(x);
		A3.setY(y);
		targ.setwidth(89);
		targ.setheight(y);
		assertTrue(A3.isColliding(targ));
	}
	@Test
	public void CollsionTestFail(){
		int x = 90;
		int y = 88;
		A3.setX(x);
		A3.setY(y);
		targ.setx(45);
		targ.sety(50);
		assertFalse(A3.isColliding(targ));
	}
	@Test
	public void CollsionTestFailY(){
		int x = 90;
		int y = 88;
		A3.setX(x);
		A3.setY(y);
		targ.setx(x);
		targ.sety(50);
		assertFalse(A3.isColliding(targ));
	}
	@Test
	public void CollsionTestFailX(){
		int x = 90;
		int y = 88;
		A3.setX(x);
		A3.setY(y);
		targ.setx(50);
		targ.sety(y);
		assertFalse(A3.isColliding(targ));
	}
	@Test
	public void CollisionHeightFail(){
		int x = 40;
		int y= 66;
		A3.setX(x);
		A3.setY(y);
		targ.setwidth(89);
		targ.setheight(65);
		assertFalse(A3.isColliding(targ));
		
	}
	@Test
	public void CollisionWidthFail(){
		int x = 30;
		int y= 30;
		A3.setX(x);
		A3.setY(y);
		targ.setwidth(20);
		targ.setheight(40);
		assertFalse(A3.isColliding(targ));
		
	}
}
