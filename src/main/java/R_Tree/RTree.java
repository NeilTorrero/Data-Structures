package R_Tree;

import AVL.Node;

public class RTree {
    static final int MIN = 2;
    static final int MAX = 4;
    static final int HEIGHT_SCREEN = 500;
    static final int WIDTH_SCRREN = 500;
    NodeRTree root;


    public RTree() {
        root = new NodeRTree(true);
    }

    public void insert(Point p) {
        root.insertInside(p);
    }

    /**
     * Funcion que inserta un punto
     * TODO Pasarlo a otro tipo de estructura.
     *
     * @return NodeToActualizate
     */

}


