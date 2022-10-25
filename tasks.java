package Sem3.Homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class tasks {

  public static void main(String[] args) {
    task3Function();
  }


  public static void task1Function() {
    int[] initArray = {5, 7, 0, 6, 4, 2, 3, 9, 1};
    initArray = sortArrayMerge(initArray);
    StringBuilder logMessage = new StringBuilder();
    for (int i : initArray) {
      logMessage.append(i + " ");
    }
    Logger logger = Logger.getAnonymousLogger();
    logger.info(logMessage.toString());
  }

  public static int[] sortArrayMerge(int[] arrayA) {
    if (arrayA == null) {
      return null;
    }
    if (arrayA.length < 2) {
      return arrayA;
    }
    int[] arrayB = new int[arrayA.length / 2];
    int[] arrayC = new int[arrayA.length - arrayA.length / 2];
    System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
    System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);
    arrayB = sortArrayMerge(arrayB);
    arrayC = sortArrayMerge(arrayC);
    return mergeArrays(arrayB, arrayC);
  }

  public static int[] mergeArrays(int[] arrayB, int[] arrayC) {
    int currentPositionB = 0;
    int currentPositionC = 0;
    int[] arrayA = new int[arrayB.length + arrayC.length];
    for (int i = 0; i < arrayA.length; i++) {
      if (currentPositionB == arrayB.length) {
        arrayA[i] = arrayC[currentPositionC];
        currentPositionC++;
      } else if (currentPositionC == arrayC.length) {
        arrayA[i] = arrayB[currentPositionB];
        currentPositionB++;
      } else if (arrayB[currentPositionB] < arrayC[currentPositionC]) {
        arrayA[i] = arrayB[currentPositionB];
        currentPositionB++;
      } else {
        arrayA[i] = arrayC[currentPositionC];
        currentPositionC++;
      }
    }
    return arrayA;
  }


  public static void task2Function() {
    final int COUNT_NUMBERS = 20;
    Random random = new Random();
    List<Integer> initList = new ArrayList();
    for (int i = 0; i < COUNT_NUMBERS; i++) {
      initList.add(random.nextInt(10));
    }
    initList = deleteEven(initList);
    Logger logger = Logger.getAnonymousLogger();
    logger.info(String.valueOf(initList));
  }

  public static List deleteEven(List initList) {
    for (int i = 0; i < initList.size(); i++) {
      if ((Integer) initList.get(i) % 2 == 0) {
        initList.remove(i);
        i--;
      }
    }
    return initList;
  }


  public static void task3Function() {
    final int COUNT_NUMBERS = 20;
    Random random = new Random();
    List<Integer> initList = new ArrayList();
    for (int i = 0; i < COUNT_NUMBERS; i++) {
      initList.add(random.nextInt(10));
    }
    int maxOfList = initList.get(0);
    int minOfList = initList.get(0);
    float averageOfList = initList.get(0);
    for (int i = 1; i < initList.size(); i++) {
      averageOfList += initList.get(i);
      if (maxOfList < initList.get(i)) {
        maxOfList = initList.get(i);
      }
      if (minOfList > initList.get(i)) {
        minOfList = initList.get(i);
      }
    }
    averageOfList = averageOfList / COUNT_NUMBERS;
    Logger logger = Logger.getAnonymousLogger();
    logger.info(String.valueOf(initList));
    logger.info("Max = " + String.valueOf(maxOfList));
    logger.info("Min = " + String.valueOf(minOfList));
    logger.info("Average = " + String.valueOf(averageOfList));
  }
}
