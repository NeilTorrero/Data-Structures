package R_Tree;

import AVL.AVLTree;
import AVL.Node;
import Data.Post;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Test extends PApplet {

	private final int dimensionx = 1200;
	private final int dimensiony = 700;
	Tree tree = new Tree();
	byte leter = 65;
	Random rd = new Random();

	public static void main(String... args){
		Tree tree = new Tree();
		Post post = new Post();/*
		post.location = new Double[]{(double)100,(double)180};
		Post post1 = new Post();
		post1.location = new Double[]{(double)200,(double)300};
		Post post2 = new Post();
		post2.location = new Double[]{(double)100,(double)60};
		Post post3 = new Post();
		post3.location = new Double[]{(double)280,(double)200};
		Post post4 = new Post();
		post4.location = new Double[]{(double)281,(double)200};
		Post post5 = new Post();
		post5.location = new Double[]{(double)500,(double)400};
		tree.root = tree.insertion(post, tree.root);
		tree.root = tree.insertion(post1, tree.root);
		tree.root = tree.insertion(post2, tree.root);
		tree.root = tree.insertion(post4, tree.root);
		tree.root = tree.insertion(post3, tree.root);
		tree.root = tree.insertion(post5, tree.root);*/
		double x,y;
		int i = 0;
		Random rdm = new Random();
		for (i = 0; i < 7; i++) {
			post = new Post();
			x = (double) rdm.nextInt((1200) + 1);
			y = (double) rdm.nextInt((700) + 1);
			post.location = new Double[]{x,y};
			tree.root = tree.insertion(post, tree.root);
		}
		PApplet.main("R_Tree.Test",args);
	}

	public void settings(){
		size(dimensionx, dimensiony);
	}

	public void setup(){
		background(51);
		frameRate(30);
		Post post = new Post();
		post.location = new Double[]{(double)100,(double)180};
		Post post1 = new Post();
		post1.location = new Double[]{(double)200,(double)300};
		tree.root = new Region(post);
		tree.root.pointsLeaf[1] = post1;
		preOrder(tree.root);
	}

	public void draw() {
	}

	public void preOrder(Region region){
		int x,y;
		int rColor = rd.nextInt(256);
		int gColor = rd.nextInt(256);
		int bColor = rd.nextInt(256);

		if (region.isLeaf){
			for (int i = 0; i < region.pointsLeaf.length; i++) {
				if (region.pointsLeaf[i] != null){
					x = region.pointsLeaf[i].location[0].intValue();
					y = region.pointsLeaf[i].location[1].intValue();
					strokeWeight(3);
					stroke(rColor,gColor,bColor);
					point(x,y);
				}
			}
		}else{
			for (int i = 0; i < region.subRegions.length; i++) {
				if (region.subRegions[i] != null){
					preOrder(region);
					noFill();
					rect(Double.doubleToLongBits(region.max.x),Double.doubleToLongBits(region.max.y),Double.doubleToLongBits(region.min.x),Double.doubleToLongBits(region.max.y));
					textSize(20);
					if (leter == 91){
						leter = 65;
					}
					text((char)leter, 10, 30);
					leter++;
				}
			}
		}




	}
}