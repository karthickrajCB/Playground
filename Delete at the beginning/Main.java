#include<iostream>
using namespace std;
struct Node
{
int data;
  struct Node *next;
}*head=NULL;
void append(int d)
{
	struct Node *temp,*newnode;
  newnode=(struct Node*)malloc(sizeof(struct Node));
  newnode->data=d;
  newnode->next=NULL;
  if(head==NULL)
    head=newnode;
  else
  {	  temp=head;
      while(temp->next!=NULL)
      {
      temp=temp->next;
      }
   temp->next=newnode;
   
  }
}

void del()
{
  head=head->next;
}
void display()
{
struct Node *temp=head;
  if  (temp==NULL)
    cout<<"No value to delete";
  else
  {
  while(temp!=NULL)
  {
  cout<<temp->data<<"\n";
    temp=temp->next;
  }
  }
}
int main()
{
  int d,c=0;
  while(1)
  {
    cin>>d;
    if(d>0)
    {append(d);
    c++;
    }
    else
      break;
  }
  int c1=1;
  cout<<"Before deletion:\n";
  display();
  while(c--)
  {
  del();
    cout<<"After "<<c1<<" deletion:\n";
    c1++;
  display();
  }
  return 0;
}