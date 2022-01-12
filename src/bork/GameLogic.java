/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork;

import java.util.*;

public class GameLogic extends Player {

    static Scanner sc = new Scanner(System.in);
    static String strInput;

    static int intScore;

    static String[][] arrAnswers
            = {
                //start screen --0
                {"You awaken to find yourself on cold cobblestone. As you stand up you notice "
                    + "\n" + "that the small room is lit by two torches. To the north there is a door, "
                    + "\n" + "to the south a hole in the wall. \n"},
                // open door screen --1
                {"\n" + "You cautiously open the door and start to walk forward when your "
                    + "\n" + "foot catches a loose cobblestone."
                    + "\n\n" + "You fall and break your neck."
                    + "\n\n" + "You are dead."
                    + "\n\n" + "Thanks for playing BORK -- the immersive text adventure simulator \n"},
                //go through the hole screen --2
                {"\n" + "You're not big enough to go through the hole."
                    + "\n\n" + "What would you like to do? \n"},
                //take a torch screen --3
                {"\n" + "You lift the torch out of the wall sconce and open the door. Before you "
                    + "\n" + "stretches a dark corridor that fades into the inky, tenebrous, blackness. "
                    + "\n" + "You walk for what feels like an eternity before you realize that your torch "
                    + "\n" + "is beginning to burn out \n"},
                //keep walking screen --4
                {"\n" + "You press forward praying to the 3 gods of Diaz that your torch won't go out. Fortunately, "
                    + "\n" + "it doesn't. Ahead of your darkness gives way to light as a dull indigo glow illuminates the "
                    + "\n" + "corridor up ahead. You hear the sound of a large rock grinding against stone."
                    + "\n\n" + "What do you do? \n"},
                //keep walking 2 --5
                {"\n" + "As you walk towards the indigo glow, the corridor give way to a larger cavern, and the source "
                    + "\n" + "of the light becomes apparent... The room is lit by a massive luminescent lake. "
                    + "\n" + "Lapping at the lake is a unicorn."
                    + "\n\n" + "What do you do? \n"},
                //look at the unicorn --6
                {"\n" + "It looks like a unicorn."
                    + "\n\n" + "What would you like to do? \n"},
                //kill the unicorn --7
                {"\n" + "You win."
                    + "\n\n" + "Thanks for playing BORK -- the immersive text adventure simulator \n"},
                //pet the unicorn --8
                {"\n" + "You run your hand through the unicorn's mane. The unicorn softly whinnies and nuzzles your head in return. "
                    + "\n" + "His horn pokes you in the eye and you recoil in pain. As you do so, your foot catches a loose cobblestone"
                    + "\n\n" + "You fall and break your neck."
                    + "\n\n" + "You are dead."
                    + "\n\n" + "Thanks for playing BORK -- the immersive text adventure simulator \n"},
                //run back to get the other torch --9
                {"\n" + "You start to desperately run back to the main room, when your "
                    + "\n" + "foot catches a loose cobblestone."
                    + "\n\n" + "You fall and break your neck."
                    + "\n\n" + "You are dead."
                    + "\n\n" + "Thanks for playing BORK -- the immersive text adventure simulator \n"},
                //search for secret doors --10
                {"\n" + "There are no secret doors."
                    + "\n\n" + "What would you like to do? \n"},
                //draw sword --11
                {"\n" + "You sense that an evil most evil is coming down the corridor. As you wait, a loose cobblestone falls from the ceiling "
                    + "\n\n" + "It lands on your head and breaks your neck."
                    + "\n\n" + "You are dead."
                    + "\n\n" + "Thanks for playing BORK -- the immersive text adventure simulator \n"},
                //cast a spell --12
                {"\n" + "You do not know magic."
                    + "\n\n" + "What would you like to do? \n"}
            };

    static String[][] arrChoices
            = {
                //start screen --0
                {"1) OPEN THE DOOR", "2) TAKE A TORCH", "3) GO THROUGH THE HOLE", "4) TAKE A NAP \n"},
                //open door screen --1
                {"1) START OVER \n"},
                //go through the hole screen --2 
                {"1) OPEN THE DOOR", "2) TAKE A TORCH", "3) TAKE A NAP \n"},
                //take a torch screen --3
                {"1) KEEP WALKING", "2) SEARCH FOR SECRET DOORS", "3) RUN BACK TO GET ANOTHER TORCH \n"},
                //keep walking --4
                {"1) KEEP WALKING", "2) DRAW SWORD", "3) CAST A SPELL \n"},
                //keep walking 2 --5
                {"1) LOOK AT THE UNICORN", "2) PET THE UNICORN", "3) KILL THE UNICORN \n"},
                //kill the unicorn --6
                {"1) EXIT GAME", "2) PLAY AGAIN \n"},
                //search for secret doors --7
                {"1) KEEP WALKING", "2) RUN BACK TO GET THE OTHER TORCH \n"},
                //cast a spell --8
                {"1) KEEP WALKING", "2) DRAW SWORD"},
                //look at the unicorn --9
                {"1) PET UNICORN", "2) KILL UNICORN"}
            };

    public static void welcomeScreen() {

        System.out.println("                                                                      \n"
                + ":::::::::::::::::        :::::::::      ::::::::::::::::    ::::::::    :::::::\n"
                + "::::::::::::::::::     :::::::::::::    :::::::::::::::::   ::::::::    :::::::\n"
                + ":::::::::::::::::::  :::::::::::::::::  ::::::::::::::::::  ::::::::    :::::::\n"
                + "::::::::     :::::: ::::::::::::::::::: :::::::     ::::::: ::::::::   ::::::::\n"
                + "  ::::::     :::::: ::::::::   ::::::::  ::::::     ::::::: ::::::::  :::::::::\n"
                + "  ::::::     :::::: :::::::     :::::::  ::::::     :::::::  ::::::: :::::::   \n"
                + "  ::::::::::::::::: :::::::     :::::::  :::::::::::::::::   ::::::::::::::    \n"
                + "  ::::::::::::::::  :::::::     :::::::  ::::::::::::::::    :::::::::::::     \n"
                + "  ::::::::::::::::: :::::::     :::::::  :::::::::::::::::   :::::::::::::     \n"
                + "  ::::::     :::::: :::::::     :::::::  ::::::     :::::::  ::::::::::::::    \n"
                + "  ::::::     :::::: :::::::     :::::::  ::::::     :::::::  ::::::: :::::::   \n"
                + "  ::::::     :::::: ::::::::   ::::::::  ::::::     ::::::: ::::::::  :::::::::\n"
                + "::::::::::::::::::: ::::::::::::::::::: :::::::     ::::::: ::::::::   ::::::::\n"
                + ":::::::::::::::::::  :::::::::::::::::  :::::::     ::::::: ::::::::    :::::::\n"
                + "::::::::::::::::::     :::::::::::::    :::::::     ::::::: ::::::::    :::::::\n"
                + ":::::::::::::::::        :::::::::      :::::::     ::::::: ::::::::    :::::::");

        System.out.println("\n\n" + "*******************************************************************************");

        if (Objects.isNull(getStrUsername())) {
            System.out.println("-------- Welcome to BORK, the immersive text-based adventure simulator --------"
                    + "\n" + "*******************************************************************************");
            System.out.print("\n\n" + "Please enter your username >> ");
            strInput = sc.next();
            setStrUsername(strInput);

            startGame();
        } else {
            System.out.println("\n\n" + "Welcome back, " + getStrUsername() + " your previous score was: " + getIntScore()
                    + "\n\n" + "What would you like to do?"
                    + "\n" + "1) Go again"
                    + "\n" + "2) Exit");
            strInput = sc.next();

            if (strInput.equals("1")) {

                setIntScore(0);
                startGame();

            } else {
                System.exit(0);
            }
        }

    }

    public static void startGame() {

        //Display the start screen
        System.out.println(arrAnswers[0][0]);

        for (int i = 0; i < 4; i++) {

            System.out.println(arrChoices[0][i]);

        }

        strInput = sc.next();

        //start screen if structure
        if (strInput.equals("1")) {

            //open the door
            System.out.println(arrAnswers[1][0]);
            System.out.println(arrChoices[1][0]);

            strInput = sc.next();

            if (strInput.equals("1")) {

                welcomeScreen();

            }

        } else if (strInput.equals("2")) {

            //take a torch
            System.out.println(arrAnswers[3][0]);

            for (int i = 0; i < 3; i++) {

                System.out.println(arrChoices[3][i]);

            }

            strInput = sc.next();

            if (strInput.equals("1")) {

                //keep walking
                System.out.println(arrAnswers[4][0]);
                for (int i = 0; i < 3; i++) {
                    System.out.println(arrChoices[4][i]);
                }

                strInput = sc.next();
                generateScore();

                if (strInput.equals("1")) {

                    //keep walking 2
                    System.out.println(arrAnswers[5][0]);
                    for (int i = 0; i < 3; i++) {
                        System.out.println(arrChoices[5][i]);
                    }

                    generateScore();
                    strInput = sc.next();

                    if (strInput.equals("1")) {

                        //look at the unicorn
                        System.out.println(arrAnswers[6][0]);
                        for (int i = 0; i < 2; i++) {
                            System.out.println(arrChoices[9][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        } else if (strInput.equals("2")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        }

                    } else if (strInput.equals("2")) {

                        //pet the unicorn
                        System.out.println(arrAnswers[8][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    } else if (strInput.equals("3")) {

                        //kill the unicorn
                        System.out.println(arrAnswers[7][0]);
                        System.out.println(arrChoices[6][0]);

                        generateScore();
                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    }

                } else if (strInput.equals("2")) {

                    //draw sword  
                    System.out.println(arrAnswers[11][0]);
                    System.out.println(arrChoices[1][0]);

                    strInput = sc.next();

                    if (strInput.equals("1")) {
                        welcomeScreen();
                    }

                } else if (strInput.equals("3")) {

                    //cast a spell  
                    System.out.println(arrAnswers[12][0]);
                    for (int i = 0; i < 2; i++) {
                        System.out.println(arrChoices[8][i]);
                    }

                    strInput = sc.next();

                    if (strInput.equals("1")) {

                        //keep walking 2
                        System.out.println(arrAnswers[5][0]);
                        for (int i = 0; i < 3; i++) {
                            System.out.println(arrChoices[5][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //look at the unicorn
                            System.out.println(arrAnswers[6][0]);
                            for (int i = 0; i < 2; i++) {
                                System.out.println(arrChoices[9][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            } else if (strInput.equals("2")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            }

                        } else if (strInput.equals("2")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        } else if (strInput.equals("3")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        }

                    } else if (strInput.equals("2")) {

                        //draw sword  
                        System.out.println(arrAnswers[11][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }
                    }
                }

            } else if (strInput.equals("2")) {

                //search for secret doors
                System.out.println(arrAnswers[10][0]);
                for (int i = 0; i < 2; i++) {
                    System.out.println(arrChoices[7][i]);
                }

                strInput = sc.next();

                if (strInput.equals("1")) {

                    //keep walking
                    System.out.println(arrAnswers[4][0]);
                    for (int i = 0; i < 3; i++) {
                        System.out.println(arrChoices[4][i]);
                    }

                    strInput = sc.next();
                    generateScore();

                    if (strInput.equals("1")) {

                        //keep walking 2
                        System.out.println(arrAnswers[5][0]);
                        for (int i = 0; i < 3; i++) {
                            System.out.println(arrChoices[5][i]);
                        }

                        generateScore();
                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //look at the unicorn
                            System.out.println(arrAnswers[6][0]);
                            for (int i = 0; i < 2; i++) {
                                System.out.println(arrChoices[9][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            } else if (strInput.equals("2")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            }

                        } else if (strInput.equals("2")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        } else if (strInput.equals("3")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        }

                    } else if (strInput.equals("2")) {

                        //draw sword  
                        System.out.println(arrAnswers[11][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    } else if (strInput.equals("3")) {

                        //cast a spell  
                        System.out.println(arrAnswers[12][0]);
                        for (int i = 0; i < 2; i++) {
                            System.out.println(arrChoices[8][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //keep walking 2
                            System.out.println(arrAnswers[5][0]);
                            for (int i = 0; i < 3; i++) {
                                System.out.println(arrChoices[5][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //look at the unicorn
                                System.out.println(arrAnswers[6][0]);
                                for (int i = 0; i < 2; i++) {
                                    System.out.println(arrChoices[9][i]);
                                }

                                strInput = sc.next();

                                if (strInput.equals("1")) {

                                    //pet the unicorn
                                    System.out.println(arrAnswers[8][0]);
                                    System.out.println(arrChoices[1][0]);

                                    strInput = sc.next();

                                    if (strInput.equals("1")) {
                                        welcomeScreen();
                                    }
                                } else if (strInput.equals("2")) {

                                    //kill the unicorn
                                    System.out.println(arrAnswers[7][0]);
                                    System.out.println(arrChoices[6][0]);

                                    generateScore();
                                    strInput = sc.next();

                                    if (strInput.equals("1")) {
                                        welcomeScreen();
                                    }
                                }

                            } else if (strInput.equals("2")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }

                            } else if (strInput.equals("3")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }

                            }

                        } else if (strInput.equals("2")) {

                            //draw sword  
                            System.out.println(arrAnswers[11][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        }
                    }

                } else if (strInput.equals("2")) {

                    //run back to get the other torch
                    System.out.println(arrAnswers[9][0]);
                    System.out.println(arrChoices[1][0]);

                    strInput = sc.next();

                    if (strInput.equals("1")) {
                        welcomeScreen();
                    }
                }

            } else if (strInput.equals("3")) {

                //run back to get the other torch
                System.out.println(arrAnswers[9][0]);
                System.out.println(arrChoices[1][0]);

                strInput = sc.next();

                if (strInput.equals("1")) {
                    welcomeScreen();
                }

            }

        } else if (strInput.equals("3")) {

            //go through the hole
            System.out.println(arrAnswers[2][0]);
            for (int i = 0; i < 3; i++) {
                System.out.println(arrChoices[2][i]);
            }

            strInput = sc.next();

            if (strInput.equals("1")) {

                //open the door
                System.out.println(arrAnswers[1][0]);
                System.out.println(arrChoices[1][0]);

                strInput = sc.next();

                if (strInput.equals("1")) {

                    welcomeScreen();

                }

            } else if (strInput.equals("2")) {

                //take a torch
                System.out.println(arrAnswers[3][0]);

                for (int i = 0; i < 3; i++) {

                    System.out.println(arrChoices[3][i]);

                }

                strInput = sc.next();

                if (strInput.equals("1")) {

                    //keep walking
                    System.out.println(arrAnswers[4][0]);
                    for (int i = 0; i < 3; i++) {
                        System.out.println(arrChoices[4][i]);
                    }

                    generateScore();
                    strInput = sc.next();

                    if (strInput.equals("1")) {

                        //keep walking 2
                        System.out.println(arrAnswers[5][0]);
                        for (int i = 0; i < 3; i++) {
                            System.out.println(arrChoices[5][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //look at the unicorn
                            System.out.println(arrAnswers[6][0]);
                            for (int i = 0; i < 2; i++) {
                                System.out.println(arrChoices[9][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            } else if (strInput.equals("2")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            }

                        } else if (strInput.equals("2")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        } else if (strInput.equals("3")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        }

                    } else if (strInput.equals("2")) {

                        //draw sword  
                        System.out.println(arrAnswers[11][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    } else if (strInput.equals("3")) {

                        //cast a spell  
                        System.out.println(arrAnswers[12][0]);
                        for (int i = 0; i < 2; i++) {
                            System.out.println(arrChoices[8][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //keep walking 2
                            System.out.println(arrAnswers[5][0]);
                            for (int i = 0; i < 3; i++) {
                                System.out.println(arrChoices[5][i]);
                            }

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //look at the unicorn
                                System.out.println(arrAnswers[6][0]);
                                for (int i = 0; i < 2; i++) {
                                    System.out.println(arrChoices[9][i]);
                                }

                                strInput = sc.next();

                                if (strInput.equals("1")) {

                                    //pet the unicorn
                                    System.out.println(arrAnswers[8][0]);
                                    System.out.println(arrChoices[1][0]);

                                    strInput = sc.next();

                                    if (strInput.equals("1")) {
                                        welcomeScreen();
                                    }
                                } else if (strInput.equals("2")) {

                                    //kill the unicorn
                                    System.out.println(arrAnswers[7][0]);
                                    System.out.println(arrChoices[6][0]);

                                    generateScore();
                                    strInput = sc.next();

                                    if (strInput.equals("1")) {
                                        welcomeScreen();
                                    }
                                }

                            } else if (strInput.equals("2")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }

                            } else if (strInput.equals("3")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }

                            }

                        } else if (strInput.equals("2")) {

                            //draw sword  
                            System.out.println(arrAnswers[11][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        }
                    }

                } else if (strInput.equals("2")) {

                    //search for secret doors
                    System.out.println(arrAnswers[10][0]);
                    for (int i = 0; i < 2; i++) {
                        System.out.println(arrChoices[7][i]);
                    }

                    strInput = sc.next();

                    if (strInput.equals("1")) {

                        //keep walking 2
                        System.out.println(arrAnswers[5][0]);
                        for (int i = 0; i < 3; i++) {
                            System.out.println(arrChoices[5][i]);
                        }

                        generateScore();
                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //look at the unicorn
                            System.out.println(arrAnswers[6][0]);
                            for (int i = 0; i < 2; i++) {
                                System.out.println(arrChoices[9][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            } else if (strInput.equals("2")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            }

                        } else if (strInput.equals("2")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        } else if (strInput.equals("3")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        }

                    } else if (strInput.equals("2")) {

                        //run back to get the other torch
                        System.out.println(arrAnswers[9][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }
                    }

                } else if (strInput.equals("3")) {

                    //run back to get the other torch
                    System.out.println(arrAnswers[9][0]);
                    System.out.println(arrChoices[1][0]);

                    strInput = sc.next();

                    if (strInput.equals("1")) {
                        welcomeScreen();
                    }

                }
            } else if (strInput.equals("3")) {

                takeNap();
            }

        } else if (strInput.equals("4")) {

            //take a nap
            startGame();

        }

    }

    public static void takeNap() {

        //go through the hole
        System.out.println(arrAnswers[2][0]);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrChoices[2][i]);
        }

        strInput = sc.next();

        if (strInput.equals("1")) {

            //open the door
            System.out.println(arrAnswers[1][0]);
            System.out.println(arrChoices[1][0]);

            strInput = sc.next();

            if (strInput.equals("1")) {

                welcomeScreen();

            }

        } else if (strInput.equals("2")) {

            //take a torch
            System.out.println(arrAnswers[3][0]);

            for (int i = 0; i < 3; i++) {

                System.out.println(arrChoices[3][i]);

            }

            strInput = sc.next();

            if (strInput.equals("1")) {

                //keep walking
                System.out.println(arrAnswers[4][0]);
                for (int i = 0; i < 3; i++) {
                    System.out.println(arrChoices[4][i]);
                }

                strInput = sc.next();

                if (strInput.equals("1")) {

                    //keep walking 2
                    System.out.println(arrAnswers[5][0]);
                    for (int i = 0; i < 3; i++) {
                        System.out.println(arrChoices[5][i]);
                    }

                    generateScore();
                    strInput = sc.next();

                    if (strInput.equals("1")) {

                        //look at the unicorn
                        System.out.println(arrAnswers[6][0]);
                        for (int i = 0; i < 2; i++) {
                            System.out.println(arrChoices[9][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        } else if (strInput.equals("2")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        }

                    } else if (strInput.equals("2")) {

                        //pet the unicorn
                        System.out.println(arrAnswers[8][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    } else if (strInput.equals("3")) {

                        //kill the unicorn
                        System.out.println(arrAnswers[7][0]);
                        System.out.println(arrChoices[6][0]);

                        generateScore();
                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    }

                } else if (strInput.equals("2")) {

                    //draw sword  
                    System.out.println(arrAnswers[11][0]);
                    System.out.println(arrChoices[1][0]);

                    strInput = sc.next();

                    if (strInput.equals("1")) {
                        welcomeScreen();
                    }

                } else if (strInput.equals("3")) {

                    //cast a spell  
                    System.out.println(arrAnswers[12][0]);
                    for (int i = 0; i < 2; i++) {
                        System.out.println(arrChoices[8][i]);
                    }

                    strInput = sc.next();

                    if (strInput.equals("1")) {

                        //keep walking 2
                        System.out.println(arrAnswers[5][0]);
                        for (int i = 0; i < 3; i++) {
                            System.out.println(arrChoices[5][i]);
                        }

                        generateScore();
                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //look at the unicorn
                            System.out.println(arrAnswers[6][0]);
                            for (int i = 0; i < 2; i++) {
                                System.out.println(arrChoices[9][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            } else if (strInput.equals("2")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            }

                        } else if (strInput.equals("2")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        } else if (strInput.equals("3")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        }

                    } else if (strInput.equals("2")) {

                        //draw sword  
                        System.out.println(arrAnswers[11][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }
                    }
                }

            } else if (strInput.equals("2")) {

                //search for secret doors
                System.out.println(arrAnswers[10][0]);
                for (int i = 0; i < 2; i++) {
                    System.out.println(arrChoices[7][i]);
                }

                strInput = sc.next();

                if (strInput.equals("1")) {

                    //keep walking
                    System.out.println(arrAnswers[4][0]);
                    for (int i = 0; i < 3; i++) {
                        System.out.println(arrChoices[4][i]);
                    }

                    strInput = sc.next();
                    generateScore();

                    if (strInput.equals("1")) {

                        //keep walking 2
                        System.out.println(arrAnswers[5][0]);
                        for (int i = 0; i < 3; i++) {
                            System.out.println(arrChoices[5][i]);
                        }

                        generateScore();
                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //look at the unicorn
                            System.out.println(arrAnswers[6][0]);
                            for (int i = 0; i < 2; i++) {
                                System.out.println(arrChoices[9][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            } else if (strInput.equals("2")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }
                            }

                        } else if (strInput.equals("2")) {

                            //pet the unicorn
                            System.out.println(arrAnswers[8][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        } else if (strInput.equals("3")) {

                            //kill the unicorn
                            System.out.println(arrAnswers[7][0]);
                            System.out.println(arrChoices[6][0]);

                            generateScore();
                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }

                        }

                    } else if (strInput.equals("2")) {

                        //draw sword  
                        System.out.println(arrAnswers[11][0]);
                        System.out.println(arrChoices[1][0]);

                        strInput = sc.next();

                        if (strInput.equals("1")) {
                            welcomeScreen();
                        }

                    } else if (strInput.equals("3")) {

                        //cast a spell  
                        System.out.println(arrAnswers[12][0]);
                        for (int i = 0; i < 2; i++) {
                            System.out.println(arrChoices[8][i]);
                        }

                        strInput = sc.next();

                        if (strInput.equals("1")) {

                            //keep walking 2
                            System.out.println(arrAnswers[5][0]);
                            for (int i = 0; i < 3; i++) {
                                System.out.println(arrChoices[5][i]);
                            }

                            strInput = sc.next();

                            if (strInput.equals("1")) {

                                //look at the unicorn
                                System.out.println(arrAnswers[6][0]);
                                for (int i = 0; i < 2; i++) {
                                    System.out.println(arrChoices[9][i]);
                                }

                                strInput = sc.next();

                                if (strInput.equals("1")) {

                                    //pet the unicorn
                                    System.out.println(arrAnswers[8][0]);
                                    System.out.println(arrChoices[1][0]);

                                    strInput = sc.next();

                                    if (strInput.equals("1")) {
                                        welcomeScreen();
                                    }
                                } else if (strInput.equals("2")) {

                                    //kill the unicorn
                                    System.out.println(arrAnswers[7][0]);
                                    System.out.println(arrChoices[6][0]);

                                    generateScore();
                                    strInput = sc.next();

                                    if (strInput.equals("1")) {
                                        welcomeScreen();
                                    }
                                }

                            } else if (strInput.equals("2")) {

                                //pet the unicorn
                                System.out.println(arrAnswers[8][0]);
                                System.out.println(arrChoices[1][0]);

                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }

                            } else if (strInput.equals("3")) {

                                //kill the unicorn
                                System.out.println(arrAnswers[7][0]);
                                System.out.println(arrChoices[6][0]);

                                generateScore();
                                strInput = sc.next();

                                if (strInput.equals("1")) {
                                    welcomeScreen();
                                }

                            }

                        } else if (strInput.equals("2")) {

                            //draw sword  
                            System.out.println(arrAnswers[11][0]);
                            System.out.println(arrChoices[1][0]);

                            strInput = sc.next();

                            if (strInput.equals("1")) {
                                welcomeScreen();
                            }
                        }
                    }

                } else if (strInput.equals("2")) {

                    //run back to get the other torch
                    System.out.println(arrAnswers[9][0]);
                    System.out.println(arrChoices[1][0]);

                    strInput = sc.next();

                    if (strInput.equals("1")) {
                        welcomeScreen();
                    }
                }

            } else if (strInput.equals("3")) {

                //run back to get the other torch
                System.out.println(arrAnswers[9][0]);
                System.out.println(arrChoices[1][0]);

                strInput = sc.next();

                if (strInput.equals("1")) {
                    welcomeScreen();
                }

            }
        } else if (strInput.equals("3")) {

            takeNap();
        }

    }

}
