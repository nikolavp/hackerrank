package org.nikolavp.datastructures.graphtheory;

import java.math.BigInteger;
import java.util.*;

public class SubsetComponent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger[] d = new BigInteger[scanner.nextInt()];
        for (int i = 0; i < d.length; i++) {
            d[i] = new BigInteger(scanner.next());
        }

        int components = 0;
        for (DisjointSets set : calculateFor(d, 0)) {
            components += set.componentsCount;
        }
        System.out.println(components);
    }

    public static List<DisjointSets> calculateFor(BigInteger[] d, int from) {
        if (from == d.length) {
            // empty subset {} has 64 connected components (everyone is isolated)
            ArrayList<DisjointSets> result = new ArrayList<>();
            result.add(new DisjointSets(64));
            return result;
        }
        List<DisjointSets> result = calculateFor(d, from + 1);

        int size = result.size();
        for (int i = 0; i < size; i++) {
            DisjointSets newElement = DisjointSets.copyOf(result.get(i));
            BigInteger bigInteger = d[from];

            int lastSetBit = -1;
            for (int j = 0; j < bigInteger.bitLength(); j++) {
                boolean isSet = bigInteger.testBit(j);
                if (isSet) {
                    if (lastSetBit != -1) {
                        int root1 = newElement.find(j);
                        int root2 = newElement.find(lastSetBit);
                        newElement.union(root1, root2);
                    }
                    lastSetBit = j;
                }
            }

            result.add(newElement);
        }

        return result;
    }


    public static class DisjointSets {

        private int componentsCount = 0;
        private int[] array;

        private DisjointSets() {

        }

        /**
         * Construct a disjoint sets object.
         *
         * @param numElements the initial number of elements--also the initial
         *                    number of disjoint sets, since every element is initially in its own set.
         **/
        public DisjointSets(int numElements) {
            array = new int[numElements];
            for (int i = 0; i < array.length; i++) {
                array[i] = -1;
            }
            componentsCount = numElements;
        }

        public static DisjointSets copyOf(DisjointSets other) {
            DisjointSets disjointSets = new DisjointSets();
            disjointSets.array = Arrays.copyOf(other.array, other.array.length);
            disjointSets.componentsCount = other.componentsCount;
            return disjointSets;
        }

        /**
         * union() unites two disjoint sets into a single set.  A union-by-rank
         * heuristic is used to choose the new root.  This method will corrupt
         * the data structure if root1 and root2 are not roots of their respective
         * sets, or if they're identical.
         *
         * @param root1 the root of the first set.
         * @param root2 the root of the other set.
         **/
        public void union(int root1, int root2) {
            if (root1 == root2) {
                // nothing to do here.
                return;
            }
            // keep track of components for faster answering in the end
            componentsCount--;
            if (array[root2] < array[root1]) {
                array[root1] = root2;             // root2 is taller; make root2 new root
            } else {
                if (array[root1] == array[root2]) {
                    array[root1]--;            // Both trees same height; new one is taller
                }
                array[root2] = root1;       // root1 equal or taller; make root1 new root
            }
        }

        /**
         * find() finds the (int) name of the set containing a given element.
         * Performs path compression along the way.
         *
         * @param x the element sought.
         * @return the set containing x.
         **/
        public int find(int x) {
            if (array[x] < 0) {
                return x;                         // x is the root of the tree; return it
            } else {
                // Find out who the root is; compress path by making the root x's parent.
                array[x] = find(array[x]);
                return array[x];                                       // Return the root
            }
        }
    }
}
