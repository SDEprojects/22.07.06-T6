package com.advantage.ghoul;

public class Splashscreen {
    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";  // Text Reset
    private String splashArt = "                                                                                                     \n" +
            "  ****           *   *                          * ***        *                                ***     \n" +
            " *  *************  **                         *  ****  *   **                                  ***    \n" +
            "*     *********    **                        *  *  ****    **                                   **    \n" +
            "*     *  *         **                       *  **   **     **                                   **    \n" +
            " **  *  **         **                      *  ***          **           ****    **   ****       **    \n" +
            "    *  ***         **  ***      ***       **   **          **  ***     * ***  *  **    ***  *   **    \n" +
            "   **   **         ** * ***    * ***      **   **   ***    ** * ***   *   ****   **     ****    **    \n" +
            "   **   **         ***   ***  *   ***     **   **  ****  * ***   *** **    **    **      **     **    \n" +
            "   **   **         **     ** **    ***    **   ** *  ****  **     ** **    **    **      **     **    \n" +
            "   **   **         **     ** ********     **   ***    **   **     ** **    **    **      **     **    \n" +
            "    **  **         **     ** *******       **  **     *    **     ** **    **    **      **     **    \n" +
            "     ** *      *   **     ** **             ** *      *    **     ** **    **    **      **     **    \n" +
            "      ***     *    **     ** ****    *       ***     *     **     **  ******      ******* **    **    \n" +
            "       *******     **     **  *******         *******      **     **   ****        *****   **   *** * \n" +
            "         ***        **    **   *****            ***         **    **                             ***  \n" +
            "                          *                                       *                                   \n" +
            "                         *                                       *                                    \n" +
            "                        *                                       *                                     \n" +
            "                       *                                       *                                      \n" +
            "                                                                               ";

    public void display(){
        System.out.println(GREEN + splashArt);
        System.out.println(RESET);
   }
}