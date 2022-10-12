#include<stdio.h>
//#include<iostream>
typedef struct 

{

    int roll; 

    char name[25];

    char branch;

    float marks;

    char grade;

}student;
void readStudent(student s1)
{
    printf("Enter roll no. : \n");
    scanf("%d", &s1.roll);
    printf("\nEnter name : \n");
    scanf("%s", s1.name);
    printf("\nEnter class : \n");
    scanf("%s", &s1.branch);
    printf("\nThe student with roll number %d is in branch %c\n", s1.roll, s1.branch);
}
class student

{

    int roll;               /***********************************/

    char name[25];          /** See, the changes have occured **/

    int branch;               /***** only in the hidden part *****/ 

    char grade;             /***********************************/  

public:

    void readStudent();     /*********************************/

                            /** User interface remains same **/

    void dispStudent();     /*********************************/

};
void main()
{
    student s1;
    readStudent(s1);
    printf("\n");
}
