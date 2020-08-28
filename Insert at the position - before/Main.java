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
void pos(int p,int d)
{
	struct Node *temp,*newnode;
  newnode=(struct Node*)malloc(sizeof(struct Node));
  newnode->data=d;
  newnode->next=NULL;
  temp=head;
  int i=0;
  if (head==NULL)
    head=newnode;
  else
  {
    if ((p-1)==0)
    {newnode->next=head;
    head=newnode;
    }
    else
    {
        while((p-1) >1)
        {
            temp=temp->next;
          p--;
        }
        newnode->next=temp->next;
        temp->next=newnode;
    }
  }
  

}
void display()
{
struct Node *temp=head;
  while(temp!=NULL)
  {
  cout<<temp->data<<"\n";
    temp=temp->next;
  }
}
int main()
{
  int d;
  while(1)
  {
    cin>>d;
    if(d>0)
      append(d);
    else
      break;
  }
  cout<<"Before inserting the value:\n";
  display();
  int p,val;
  cin>>p;
    cin>>val;
  pos(p,val);
  cout<<"Enter the position and value to be inserted:\n";
  cout<<"After inserting the value:\n";
  display();
  return 0;
}