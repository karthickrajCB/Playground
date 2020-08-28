#include <iostream>
#define d 256
using namespace std;
void RabinSearch(string text,string pattern,int q)
{
  int len_txt = text.length();
  int len_pat = pattern.length();
  int hash=1,hv_pat=0,hv_txt=0;
  int i,j;
  for(i=0;i<len_pat-1;i++)
    hash = (hash*d)%q;
  for(i=0;i<len_pat;i++)
  {
    hv_pat = (d * hv_pat + pattern[i])%q;
    hv_txt = (d * hv_txt + text[i])%q;
  }
  for(i=0;i<=len_txt-len_pat;i++)
  {
    if(hv_pat == hv_txt)
    {
      for(j=0;j<len_pat;j++)
      {
       if(text[i+j] != pattern[j])
          break;
      }
      if(j==len_pat)
        cout<<"Found pattern at index "<<i<<endl;
    }
    if(i < len_txt-len_pat)
    {
      hv_txt = (d*(hv_txt - text[i]*hash) + (text[i+len_pat]))%q;
      if(hv_txt<0)
        hv_txt = hv_txt + q;
    }
  }
}
int main() 
{
  string text,pattern;
  getline(cin,text);
  cin>>pattern;
  int q = 101;
  RabinSearch(text,pattern,q);
    return 0;
}