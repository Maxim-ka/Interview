import geekbrains.task3.DoubleLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMyListIterator {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList (new Object[][]{
            {new int[]{5, 9, 6, 7, 3, 4, 6}, "[0, 5, 9, 6, 7, 3, 4]", "[9, 6, 7, 3, 4, 6, 0]"},
            {new int[]{10, 7, 35, 2, 48, 2, 2, 95, 2, 46, 5, 9, 2, 47}, "[0, 10, 7, 35, 2, 48, 2, 2, 95, 2, 46, 5, 9, 2]","[7, 35, 2, 48, 2, 2, 95, 2, 46, 5, 9, 2, 47, 0]"},
            {new int[]{11, 52, 9, 3, 3, 4, 5, 6, 0, 6, 3, 3, 69}, "[0, 11, 52, 9, 3, 3, 4, 5, 6, 0, 6, 3, 3]", "[52, 9, 3, 3, 4, 5, 6, 0, 6, 3, 3, 69, 0]"},
            {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 6, 6, 1}, "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 6, 6]", "[2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 6, 6, 1, 0]"},
            {new int[]{91, 4, 2, 3, 89, 2, 57}, "[0, 91, 4, 2, 3, 89, 2]", "[4, 2, 3, 89, 2, 57, 0]"},
        });
    }

    private int[] in;
    private String outPrev;
    private String outNext;

    public TestMyListIterator(int[] in, String outPrev, String outNext){
        this.in = in;
        this.outPrev = outPrev;
        this.outNext = outNext;
    }

    private final DoubleLinkedList<Integer> myLinkedList = new DoubleLinkedList<>();
    private final DoubleLinkedList<Integer>.MyListIterator myListIterator = myLinkedList.myListIterator();

    @Before
    public void createIterator(){
        if (!myLinkedList.isEmpty()) myLinkedList.clear();
        fillMyListIterator();
    }

    private void fillMyListIterator(){
        for (int i : in) {
            myListIterator.add(i);
        }
    }

    @Test
    public void testIteratorAdd(){
        Assert.assertEquals(in.length, myLinkedList.size());
        Assert.assertEquals(Arrays.toString(in), myLinkedList.toString());
    }

    @Test
    public void testIteratorHasNextAndNext(){
        testIteratorHasPreviousAndPrevious();
        int[] temp = new int[myLinkedList.size()];
        int i = 0;
        while (myListIterator.hasNext()){
            temp[i++] = myListIterator.next();
        }
        Assert.assertEquals(outNext, Arrays.toString(temp));
    }

    @Test
    public void testIteratorHasPreviousAndPrevious(){
        int[] temp = new int[myLinkedList.size()];
        int i = in.length - 1;
        while (myListIterator.hasPrevious()){
            temp[i--] = myListIterator.previous();
        }
        Assert.assertEquals(outPrev, Arrays.toString(temp));
    }

    @Test
    public void testIteratorPreviousIndex(){
//        while (myListIterator.hasNext()){
//            myListIterator.next();
//        }
//        while (myListIterator.hasPrevious()){
//            int number = myListIterator.previous();
//            if (number == in.length / 2) break;
//        }
//        Assert.assertEquals(index, myListIterator.previousIndex());
    }

    @Test
    public void testIteratorNextIndex(){
//        while (myListIterator.hasNext()){
//            myListIterator.next();
//        }
//        Assert.assertEquals(in.length, myListIterator.nextIndex());
    }

    @Test
    public void testIteratorRemove(){
//        while (myListIterator.hasNext()){
//            int number = myListIterator.next();
//            if (number == in.length / 2){
//                myListIterator.remove();
//            }
//        }
////        myListIterator.remove();
//        Assert.assertEquals(outRemoved, myLinkedList.toString());
    }

    @Test
    public void testIteratorSet(){
//        while (myListIterator.hasNext()){
//            int number = myListIterator.next();
//            if (myListIterator.nextIndex() == 1)  myListIterator.set(add);
//            if (number == in.length / 2) myListIterator.set(add);
//        }
//        myListIterator.set(add);
//        Assert.assertEquals(outSet, myLinkedList.toString());
    }
}
