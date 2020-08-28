#include <iostream>
using namespace std;
struct Node
{
    int data;
    struct Node*add;
};
struct Node*front=NULL,*rear=NULL;
void enqueue(int d)
{
    struct Node *temp,*newnode=(struct Node*)malloc(sizeof(struct Node));
    temp=rear;//use to store last node address
    newnode->data=d;
    newnode->add=NULL;
    if (front==NULL)
    front=rear=newnode;
    else
    {
    temp->add=newnode;
    rear=newnode;
    }
}  
void display()
{
    struct Node*temp=front;
    while(temp!=NULL)
    {
        cout<<temp->data<<" ";
        temp=temp->add;
    }
}
int main()
{
    int d,a;
  cin>>d;int t=d;
  
    while(t--){
        cin>>a;       
 enqueue(a);
    };
  cout<<"Enter the size of stack:\n";
  if (d!=0){
  cout<<"Enter the stack values:\n";
 cout<<"Queue elements are:\n";
  display();}
  
  
    return 0;
}