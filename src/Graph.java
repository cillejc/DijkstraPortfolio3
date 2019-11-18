import java.util.*;

import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }

    public Vertex getvertex(String s) {
        for (Vertex v : Vertices) {
            if (v.Name == s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge = new Edge(from, to);
        newedge.distance = dist;
        newedge.time = tim;
    }

    public Pair<Integer, Map<Vertex, Vertex>> ShortestDistance(Vertex source, Vertex zink) {
        Map<Vertex, Integer> DistanceMap = new HashMap<>();
        Map<Vertex, Vertex> PredecessorMap = new HashMap<>();
        Map<Vertex, Boolean> HandledMap = new HashMap<>();
        //Handled?
        Vertex current; //current vertex - placeholder
        ArrayList<Edge> EdgeListPlaceholder; // edgelist placeholder
        // initialize arrays
        for (Vertex v : Vertices) { //her kigger vi på alle vertices
            DistanceMap.put(v, 10000); //lav en infinity værdi
            PredecessorMap.put(v, null); //predecossormap sættes til null
            HandledMap.put(v,false);
        }
        DistanceMap.replace(source, 0); // her sættes start edge til 0 i listen

        //implement Dijkstra

        for (int count = 0; count <Vertices.size() && getmin(DistanceMap,HandledMap)!=null; count++) {
            current = getmin(DistanceMap,HandledMap); // her sættes current til den node vi er ved at kigge på
            EdgeListPlaceholder = current.OutEdges; //her gives EdgeList OutEdges værdi
            for(Edge e : EdgeListPlaceholder ){

                if (DistanceMap.get(current) + e.distance < DistanceMap.get(e.getTovertex())) {
                    DistanceMap.replace(e.getTovertex(),DistanceMap.get(current)+ e.distance);
                    PredecessorMap.replace(e.getTovertex(),current);
                }
            }


         HandledMap.replace(current,true);
        }

        Pair<Integer, Map<Vertex, Vertex>> result= new Pair<>(DistanceMap.get(zink), PredecessorMap);
        return result; //zink er destination
    }

    public Vertex getmin(Map<Vertex, Integer> qmap, Map<Vertex, Boolean> done) {

        Vertex vertex=null;
        int value = 10000;

        Collection entryset = qmap.entrySet();

        Iterator<Map.Entry<Vertex, Integer>> it = entryset.iterator();

        while (it.hasNext()) {
            Map.Entry<Vertex, Integer> e = it.next(); //key er første element, value er andet
            if (e.getValue() < value && !done.get(e.getKey())) {
                vertex = e.getKey();
                value = e.getValue();
            }
        }

        return vertex;
    }
}


class Vertex {
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();

    public Vertex(String id) {
        Name = id;
    }

    public void addOutEdge(Edge outedge) {
        OutEdges.add(outedge);
    }

    public ArrayList<Edge> getOutEdges() {
        return OutEdges;
    }
    /*@Override
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        if(o==null)  {
            return false;
        }

        if (getClass() != o.getClass()){
            return false;
        }
        Vertex v = (Vertex) o;
        return Objects.equals(Name,v.Name);
    }        */
}

class Edge {
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance = 0;
    public int time = 0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to) {
        fromvertex = from;
        tovertex = to;
        fromvertex.addOutEdge(this);
        //If not directional
        //tovertex.addOutEdge(this);
    }
}