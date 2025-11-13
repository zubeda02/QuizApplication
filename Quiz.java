import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{

    String questions[][]=new String[25][5];
    String answers[][]=new String[25][2];
    String useranswers[][]=new String[25][1];
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup groupoptions;
    JButton Lifeline,next,Submit;

    public static int timer=30;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;

    String name;

    Quiz(String username){
        this.name=username;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
       JLabel image=new JLabel(i1);
       image.setBounds(0,0,1440,392);
       add(image);

        qno=new JLabel();
        qno.setBounds(100,450,50,30);
        qno.setFont(new Font("Times New Roman",Font.PLAIN,24));
        add(qno);

       question=new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Times New Roman",Font.PLAIN,24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between object's ";

        questions[10][0] = "Which statement is true about the finalize() method?";
        questions[10][1] = "It is guaranteed to be executed.";
        questions[10][2] = "It is called by the Garbage Collector before destroying the object.";
        questions[10][3] = "It is used to force object deletion.";
        questions[10][4] = "It is present in the String class.";

        questions[11][0] = "Which of these keywords is not part of exception handling in Java?";
        questions[11][1] = "try";
        questions[11][2] = "finally";
        questions[11][3] = "throw";
        questions[11][4] = "caught";

        questions[12][0] = "What is the size of the boolean data type in Java?";
        questions[12][1] = "1 byte";
        questions[12][2] = "2 bytes";
        questions[12][3] = "4 bytes";
        questions[12][4] = "Size is not precisely defined, but rather depends on the JVM.";

        questions[13][0] = "Which access modifier restricts a class member's access only to its own class?";
        questions[13][1] = "public";
        questions[13][2] = "protected";
        questions[13][3] = "private";
        questions[13][4] = "default";

        questions[14][0] = "Which one of the following is not a Java feature?";
        questions[14][1] = "Object-oriented";
        questions[14][2] = "Platform-independent";
        questions[14][3] = "Use of pointers";
        questions[14][4] = "Multithreaded";

        questions[15][0] = "Which operator is used to create an object in Java?";
        questions[15][1] = "new";
        questions[15][2] = "create";
        questions[15][3] = "alloc";
        questions[15][4] = "instance";

        questions[16][0] = "Which method is used to prevent any changes in a subclass from an inherited method?";
        questions[16][1] = "static";
        questions[16][2] = "abstract";
        questions[16][3] = "final";
        questions[16][4] = "void";

        questions[17][0] = "What does the transient keyword do in Java?";
        questions[17][1] = "It makes a variable's value non-serializable.";
        questions[17][2] = "It makes a method non-overridable.";
        questions[17][3] = "It indicates a short-lived variable.";
        questions[17][4] = "It specifies the variable is thread-local.";

        questions[18][0] = "Which class is the root of the Java class hierarchy?";
        questions[18][1] = "File";
        questions[18][2] = "System";
        questions[18][3] = "Object";
        questions[18][4] = "Class";

        questions[19][0] = "Which one of the following is an example of an Unchecked Exception?";
        questions[19][1] = "IOException";
        questions[19][2] = "SQLException";
        questions[19][3] = "FileNotFoundException";
        questions[19][4] = "NullPointerException";

        questions[20][0] = "The concept that allows a class to have more than one constructor with different parameter lists is called:";
        questions[20][1] = "Inheritance";
        questions[20][2] = "Encapsulation";
        questions[20][3] = "Method Overloading";
        questions[20][4] = "Constructor Overloading";

        questions[21][0] = "Which package provides the fundamental classes and interfaces for Java, including System and Object?";
        questions[21][1] = "java.io";
        questions[21][2] = "java.util";
        questions[21][3] = "java.lang";
        questions[21][4] = "java.net";

        questions[22][0] = "What will be the value of x after the following code runs: int x = 5; x++;";
        questions[22][1] = "5";
        questions[22][2] = "6";
        questions[22][3] = "4";
        questions[22][4] = "7";

        questions[23][0] = "Which keyword is used to refer to the object that invoked the current method?";
        questions[23][1] = "super";
        questions[23][2] = "parent";
        questions[23][3] = "this";
        questions[23][4] = "new";

        questions[24][0] = "Which mechanism in Java is used to achieve run-time polymorphism?";
        questions[24][1] = "Method Overloading";
        questions[24][2] = "Operator Overloading";
        questions[24][3] = "Constructor Overloading";
        questions[24][4] = "Method Overriding";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        // Question 10: Which statement is true about the finalize() method? (Option 2)
        answers[10][1] = "It is called by the Garbage Collector before destroying the object."; 
        
        // Question 11: Which of these keywords is not part of exception handling in Java? (Option 4)
        answers[11][1] = "caught"; 
        
        // Question 12: What is the size of the boolean data type in Java? (Option 4)
        answers[12][1] = "Size is not precisely defined, but rather depends on the JVM."; 
        
        // Question 13: Which access modifier restricts a class member's access only to its own class? (Option 3)
        answers[13][1] = "private"; 
        
        // Question 14: Which one of the following is not a Java feature? (Option 3)
        answers[14][1] = "Use of pointers"; 
        
        // Question 15: Which operator is used to create an object in Java? (Option 1)
        answers[15][1] = "new"; 
        
        // Question 16: Which method is used to prevent any changes in a subclass from an inherited method? (Option 3)
        answers[16][1] = "final"; 
        
        // Question 17: What does the transient keyword do in Java? (Option 1)
        answers[17][1] = "It makes a variable's value non-serializable."; 
        
        // Question 18: Which class is the root of the Java class hierarchy? (Option 3)
        answers[18][1] = "Object"; 
        
        // Question 19: Which one of the following is an example of an Unchecked Exception? (Option 4)
        answers[19][1] = "NullPointerException"; 
        
        // Question 20: The concept that allows a class to have more than one constructor with different parameter lists is called: (Option 4)
        answers[20][1] = "Constructor Overloading"; 
        
        // Question 21: Which package provides the fundamental classes and interfaces for Java, including System and Object? (Option 3)
        answers[21][1] = "java.lang"; 
        
        // Question 22: What will be the value of x after the following code runs: int x = 5; x++; (Option 2)
        answers[22][1] = "6"; 
        
        // Question 23: Which keyword is used to refer to the object that invoked the current method? (Option 3)
        answers[23][1] = "this"; 
        
        // Question 24: Which mechanism in Java is used to achieve run-time polymorphism? (Option 4)
        answers[24][1] = "Method Overriding";

        opt1=new JRadioButton();
        opt1.setBounds(120,520,700,30);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20)); 
        add(opt1);

         opt2=new JRadioButton();
        opt2.setBounds(120,560,700,30);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20)); 
        add(opt2);

        opt3=new JRadioButton();
        opt3.setBounds(120,600,700,30);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20)); 
        add(opt3);

        opt4=new JRadioButton();
        opt4.setBounds(120,640,700,30);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20)); 
        add(opt4);

        groupoptions=new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next=new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Times New Roman",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        Lifeline=new JButton("50 50 Lifeline");
        Lifeline.setBounds(1100,630,200,40);
        Lifeline.setFont(new Font("Times New Roman",Font.PLAIN,22));
        Lifeline.setBackground(new Color(30,144,255));
        Lifeline.setForeground(Color.WHITE);
        Lifeline.addActionListener(this);
        add(Lifeline);

        Submit=new JButton("Submit");
        Submit.setBounds(1100,710,200,40);
        Submit.setFont(new Font("Times New Roman",Font.PLAIN,22));
        Submit.setBackground(new Color(30,144,255));
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setEnabled(false);
        add(Submit);

        start(count);


        setVisible(true);

     }

     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given=1;
             if(groupoptions.getSelection()==null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }

           if(count==23){
                next.setEnabled(false);
                Submit.setEnabled(true);
           }


            count++;
            start(count);
        }else if(ae.getSource()==Lifeline){
          if(count==1||count==3||count==5||count==7||count==9||count==11||count==13||count==15||count==17||count==19||count==21||count==23||count==24){
             opt2.setEnabled(false);
             opt3.setEnabled(false);
          }
        else{
             opt1.setEnabled(false);
             opt4.setEnabled(false);
        }
        Lifeline.setEnabled(false);
      } else if(ae.getSource()==Submit){
         ans_given=1;
         if(groupoptions.getSelection()==null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
           
            for(int i=0;i<useranswers.length;i++){
               if(useranswers[i][0].equals(answers[i][1])){
                score+=10;
               }else{
                score+=0;
               }
            }
            setVisible(false);
            new Score(name,score);
      }
          
      }


     public void paint(Graphics g){
        super.paint(g);

        String time="Time Left - " + timer + "seconds";//30 Graphics
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman",Font.BOLD,25));

        if(timer>0){
            g.drawString(time,1100,500);
        }
        else{
            g.drawString("Times up!!!!",1100,500);
        }
        timer--;//29

        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given==1){
            ans_given=0;
            timer=30;
        }else if(timer<0){
            timer=30;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count==23){
                next.setEnabled(false);
                Submit.setEnabled(true);
           }
           if(count==24){//submit button
                if(groupoptions.getSelection()==null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
           
            for(int i=0;i<useranswers.length;i++){
               if(useranswers[i][0].equals(answers[i][1])){
                score+=10;
               }else{
                score+=0;
               }
            }
            setVisible(false);
            new Score(name,score);

           }else{//next button
           
            if(groupoptions.getSelection()==null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }
            count++;//0->1
            start(count);
        }}
     }

     public void start(int count){
       qno.setText("" + (count + 1) + ". ");
       question.setText(questions[count][0]);

       opt1.setText(questions[count][1]);
       opt1.setActionCommand(questions[count][1]);

       opt2.setText(questions[count][2]);
       opt2.setActionCommand(questions[count][2]);

       opt3.setText(questions[count][3]);
       opt3.setActionCommand(questions[count][3]);

       opt4.setText(questions[count][4]);
       opt4.setActionCommand(questions[count][4]);

       groupoptions.clearSelection();
     }

    public static void main(String args[]){
        new Quiz("User");
    
    
    }
}