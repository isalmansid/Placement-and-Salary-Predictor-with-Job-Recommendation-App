import numpy as np
import pandas as pd
import joblib

#df= pd.read_csv('mum.csv')



import pyshorteners



from pyshorteners import Shortener
#shortener = pyshorteners.Shortener()
#def generate_short(url):
 #   x = shortener.short(url)
  #  return x
df = pd.read_csv('mum.csv')
#for index,row in df.iterrows():
 #   x = Shortener.short(row[2])
  #  print(X)
   # print(df)


link = ''
pd.link = df['url']

s = pd.Series(df['url'])
a = np.array(s)

def __getattribute__(self, name):
    return self.__df__[url]

pd.link.astype(str).Series.str.startswith('http://', 'https://')


#df3 = df[df['url'].astype(str).map(len)==11 & df['url'].astype(str).str.startswith('1')]



shortener = pyshorteners.Shortener()

#link.startswith(('http://', 'https://'))


x = shortener.tinyurl.short(link.str.startswith('http://', 'https://'))
print(x)
#print('invalid')

