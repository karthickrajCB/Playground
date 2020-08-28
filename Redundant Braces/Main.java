//Redundant Braces:
#include<iostream>
using namespace std;
class Node
{public:
    char data;
    Node *next;
}*head = NULL;
void insert(char data)
{
    Node *temp = head;
    Node *newnode = new Node();
    newnode->data = data;
    newnode->next = NULL;
    if(head == NULL)
        head = newnode;
    else
    {
        newnode->next = temp;
        head = newnode;
    }
}
char pop()
{
    if(head != NULL)
    {
        Node *temp = head;
        head = temp->next;
        temp->next = NULL;
	char a = temp->data;
        free(temp);
	return a;
    }
}
int check_brackets(string str) 
{ 
    for (int i=0;i<str.length();i++)
    { 
        if (str[i] == ')')
        { 
            char t = pop(); 
            int flag = 1; 
            while (t != '(')
            { 
                if (t == '+' || t == '-' || t == '*' || t == '/') 
                    flag = 0; 
                t = pop(); 
            }
            if (flag == 1) 
                return 1; 
        } 
        else
            insert(str[i]); 
    } 
    return 0; 
} 
int main()
{
    string s;
    cin>>s; 
    if (check_brackets(s) == 1) 
        printf("Yes"); 
    else
        printf("No");
    return 0;
}