// stack Expression Evalution:
/*
Integer ascii values:
	'0' -> 48
    '1' -> 49
    '2' -> 50
    '3' -> 51
    '4' -> 52
    '5' -> 53
    '6' -> 54
    '7' -> 55
    '8' -> 56
    '9' -> 57
Operators ascii value
	'*' -> 42
    '+' -> 43
    '-' -> 45
    '/' -> 47
1. whether it is a number or not
	* convert that character number into integer number
    * insert it inside our stack memory

*/
#include<iostream>
using namespace std;
class Node
{
  public:
  	int data;
  	Node *next;
}*head = NULL;
void insert(int val)
{
  Node *temp = head;
  //create memory for Node
  Node *newnode = new Node();
  //insert the values
  newnode->data = val;
  newnode->next = NULL;
  //link between nodes
  if(head == NULL)
    head = newnode;
  else
  {
    head = newnode;
    newnode->next = temp;
  }
}
int pop() 
{
  if(head == NULL)
    return 0;
  else
  {
    Node *temp = head;
    head = temp->next;
    temp->next = NULL;
    int a = temp->data;
    free(temp);
    return a;
  }
}
int main()
{
  string str;
  cin>>str;//56+7-
  for(int i=0;i<str.length();i++)
  {
    if(str[i]>=48 && str[i]<=57)
    {
      int a = str[i] - '0';
      insert(a);
    }
    else if(str[i]>=42 && str[i]<=47)
    {
      int a = pop();
      int b = pop();
      switch(str[i])
      {
        case '+': insert(a+b);break;
        case '-': insert(a-b);break;
        case '*': insert(a*b);break;
        case '/': insert(a/b);break;
      }
    }
  }
  cout<<"Answer is "<<pop();
  return 0;
}