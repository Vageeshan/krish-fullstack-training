package com.system.waterdrop;

import java.util.Arrays;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-19 09:39 AM Tuesday
 **/
public class WaterDrop {
    public static void waterDrop(int[][] array, int input, int problemOption) {
        double[] array_1 = new double[7];
        double[] array_2 = new double[7];
        double[] array_3 = new double[7];
        int i = 0, k = 0;
        switch (problemOption) {
            case 1:
                array_2[input - 1] = 100;
                while (i < 7) {
                    int l = 0;
                    while (l < 7) {
                        if (array[i][l] == 0) {
                            array_1[l] += array_2[l];
                        } else {
                            if (l == 0) {
                                array_1[l + 1] = (array_1[l + 1] + (array_2[l] / 2.0));
                            } else if (l == 6) {
                                array_1[l - 1] = (array_1[l - 1] + (array_2[l] / 2.0));
                            } else {
                                array_1[l - 1] = (array_1[l - 1] + (array_2[l] / 2.0));
                                array_1[l + 1] = (array_1[l + 1] + (array_2[l] / 2.0));
                            }
                        }
                        l++;
                    }

                    array_2 = Arrays.copyOf(array_1, array_1.length);
                    array_1 = Arrays.copyOf(array_3, array_3.length);
                    i++;
                }
                while (k < 7) {
                    System.out.println("........................." + (k + 1) + ":" + array_2[k]);
                    k++;
                }
                break;
            case 2:
                array_2[input - 1] = 100;
                while (i < 7) {
                    int m = 0;
                    while (m < 7) {

                        if (array[i][m] == 0) {
                            array_1[m] += array_2[m];
                        } else {
                            int itr = m;
                            while (itr >= 0) {
                                if (array[i][itr] == 0) {
                                    array_1[itr] = array_1[itr] + (array_2[m] / 2.0);
                                    break;
                                }
                                itr--;
                            }
                            int d = m;
                            while (d < 7) {
                                if (array[i][d] == 0) {
                                    array_1[d] = array_1[d] + (array_2[m] / 2.0);
                                    break;
                                }
                                d++;
                            }
                        }
                        m++;
                    }
                    array_2 = Arrays.copyOf(array_1, array_1.length);
                    array_1 = Arrays.copyOf(array_3, array_3.length);
                    i++;
                }
                while (k < 7) {
                    System.out.println(".........................." + (k + 1) + ":" + array_2[k]);
                    k++;
                }
                break;
            default:
                throw new IllegalArgumentException("Please enter valid input");
        }
    }


    public static void main(String[] args) {
        int[][] array = {{0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}};
        waterDrop(array, 5, 2);
    }
}
