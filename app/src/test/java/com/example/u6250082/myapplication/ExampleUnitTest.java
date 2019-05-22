package com.example.u6250082.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static com.example.u6250082.myapplication.GameLogic.chooseSnakePosition;
import static com.example.u6250082.myapplication.GameLogic.chooseWallPosition;
import static com.example.u6250082.myapplication.GameLogic.chooseBeanPosition;
import static org.junit.Assert.*;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/*u6250866
      YuWu*/
public class ExampleUnitTest {
    String answerForWall = "0,18,36,54,72,90,108,126,144,162,180,198,216,234,252,270,288,306,324,342,360,378,396,414,19,415,20,416,21,417,22,418,23,419,24,420,25,421,26,422,27,423,28,424,29,425,30,426,31,427,32,428,33,429,34,430,17,35,53,71,89,107,125,143,161,179,197,215,233,251,269,287,305,323,341,359,377,395,413,431,0,";
    String answerForSnake = "80,79,78,77,76,";
    int[] wall = {0,18,36,54,72,90,108,126,144,162,180,198,216,234,252,270,288,306,324,342,360,378,396,414,19,415,20,416,21,417,22,418,23,419,24,420,25,421,26,422,27,423,28,424,29,425,30,426,31,427,32,428,33,429,34,430,17,35,53,71,89,107,125,143,161,179,197,215,233,251,269,287,305,323,341,359,377,395,413,431,0};
    int[] snake = {80,79,78,77,76};
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testAddWall(){
        int[] wall =chooseWallPosition();
        String WallString = "";
        for (int i = 0;i<81;i++){
            WallString += wall[i] + ",";
        }
        assertEquals(answerForWall,WallString);
    }

    @Test
    public void testAddSnake(){
        int[] snake =chooseSnakePosition();
        String SnakeString = "";
        for (int i = 0;i<5;i++){
            SnakeString += snake[i] + ",";
        }
        assertEquals(answerForSnake,SnakeString);
    }
    @Test
    public void testAddBean(){
        ArrayList<Integer> wall0 = new ArrayList<>();
        ArrayList<Integer> snake0 = new ArrayList<>();
        for (int i = 0;i<81;i++){
            int num = wall[i];
            wall0.add(num);
        }
        for (int i = 0;i<5;i++){
            int num = snake[i];
            snake0.add(num);
        }
        final Integer answer = chooseBeanPosition(wall0,snake0);
        assertTrue(answer<396&&answer>18);
        assertEquals(false,wall0.contains(answer));
        assertEquals(false,snake0.contains(answer));
    }

}