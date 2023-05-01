import url_shortener
import numpy as np
import pandas as pd
import joblib

urll = "https://www.moneycontrol.com/news/india/coronavirus-india-news-today-live-updates-covid-19-cases-india-today-maharashtra-mumbai-gujarat-tamilnadu-nirmala-sitharaman-press-conference-5269421.html"
url_short = url_shortener.make_shorten(urll)
print(url_short)
#df = pd.read_csv('mum.csv')

#df2=df['url']
#url_short = url_shortener.make_shorten(df2)
#print(url_short)
#print('done')



#Opening the file that contains URLs
file = open('mum.txt', 'r')

#Reading all the URLs line-by-line
lines = file.readlines()

#Opening the file in which we will write the shortened URLS
file2 = open(r"url_file_shortened.txt","w+")

#Shortening each URL, printing n console and writing them in a text file
for url in lines:
    url_short = url_shortener.make_shorten(url.strip('\n'))
    print(url_short)
    file2.write(url_short)
    file2.write("\n")

#Closing bothe the files
file.close()
file2.close()








