#include <iostream>
using namespace std;
struct Node
{
    int data;
    struct Node*add;
};
struct Node*head=NULL;
void append(int d)
{
    struct Node*newnode=(struct Node*)malloc(sizeof(struct Node));
    newnode->data=d;
    newnode->add=NULL;
    newnode->add=head;
    head=newnode;
}  
void display()
{
    struct Node*temp=head;
    while(temp!=NULL)
    {
        cout<<temp->data<<" ";
        temp=temp->add;
    }
}
int main()
{
    int d;
    do{
        cin>>d;
        if(d>-1)
       
 append(d);
    }while(d!=-1);
    display();
    return 0;
}