import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.MakeSmallGraph();
        Graph b = TestGraph.MakeBigGraph();
        Vertex source = g.getvertex("A");
        Vertex zink = g.getvertex("F");
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(source, zink);
        Vertex current =zink;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(zink);
        while ((current != source) && (results.getValue().get(current)!=null))
        {
            current=results.getValue().get(current);
            Path.add(0,current);
        }
        for(Vertex v : Path)
        {
            System.out.print( v.Name);
            if (v!=zink)
                System.out.print("->");
        }



    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        final Vertex A=mygraph.addvertex("A");
        final Vertex B= mygraph.addvertex("B");
        final Vertex C =mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        final Vertex F = mygraph.addvertex("F");

        mygraph.newedge(A,B,1,2);
        mygraph.newedge(A,C, 5,1);
        mygraph.newedge(A,D, 4,6);
        mygraph.newedge(B,C, 3,2);
        mygraph.newedge(B,D, 2,3);
        mygraph.newedge(B,E, 2,4);
        mygraph.newedge(C,F, 1,8);
        mygraph.newedge(C,E, 2,2);
        mygraph.newedge(D,F, 2,7);
        mygraph.newedge(E,F, 3,6);


        return mygraph;

    }

    public Graph MakeBigGraph()
    {
        Graph mygraph2 = new Graph();
        final Vertex en=mygraph2.addvertex("1");
        final Vertex to= mygraph2.addvertex("2");
        final Vertex tre =mygraph2.addvertex("3");
        final Vertex fire = mygraph2.addvertex("4");
        final Vertex fem = mygraph2.addvertex("5");
        final Vertex seks = mygraph2.addvertex("6");
        final Vertex syv = mygraph2.addvertex("7");
        final Vertex otte = mygraph2.addvertex("8");
        final Vertex ni = mygraph2.addvertex("9");
        final Vertex ti = mygraph2.addvertex("10");

        mygraph2.newedge(en,to,10,0);
        mygraph2.newedge(en,fire,20,0);
        mygraph2.newedge(en,fem,20,0);
        mygraph2.newedge(en,seks,5,0);
        mygraph2.newedge(en,syv,15,0);
        mygraph2.newedge(to,tre,5,0);
        mygraph2.newedge(to,fire,10,0);
        mygraph2.newedge(tre,to,15,0);
        mygraph2.newedge(tre,fire,5,0);
        mygraph2.newedge(fire,fem,10,0);
        mygraph2.newedge(fem,seks,5,0);
        mygraph2.newedge(syv,seks,10,0);
        mygraph2.newedge(otte,en,5,0);
        mygraph2.newedge(otte,to,15,0);
        mygraph2.newedge(otte,syv,5,0);
        mygraph2.newedge(ni,to,15,0);
        mygraph2.newedge(ni,otte,20,0);
        mygraph2.newedge(ni,ti,10,0);
        mygraph2.newedge(ti,to,5,0);
        mygraph2.newedge(ti,tre,15,0);



        return mygraph2;
    }
}
