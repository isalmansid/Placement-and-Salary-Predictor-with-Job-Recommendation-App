import pandas as pd
import numpy as np

import seaborn as sns
import matplotlib.pyplot as plt

from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.naive_bayes import MultinomialNB

# Transformers
from sklearn.feature_extraction.text import CountVectorizer,TfidfVectorizer
# Others
from sklearn.model_selection import train_test_split
from sklearn.pipeline import Pipeline
from sklearn.metrics import accuracy_score,classification_report,confusion_matrix,plot_confusion_matrix

df = pd.read_csv("TEC_Placement_2022_Dataset.csv")

from sklearn.multioutput import MultiOutputClassifier
from sklearn.datasets import make_regression
from sklearn.multioutput import MultiOutputRegressor
from sklearn.ensemble import GradientBoostingRegressor


X, y = make_regression(n_samples=13, n_targets=2, random_state=1)
pr = MultiOutputRegressor(GradientBoostingRegressor(random_state=0)).fit(X, y).predict(X)

#print(pr)

result = MultiOutputRegressor(GradientBoostingRegressor(random_state=0)).fit(X, y).predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,12345,5,5,5,5]])
#result = rf.predict([[4,80,68.53,6.65,6.85,6,6.94,8,0,4,4]])
print(result)


#import neattext.functions as nfx

#df['Branch'] = df['Branch'].str.lower()
#Xfeatures = df['Branch']
#ylabels = df[['Status','Salary']]

#x_train,x_test,y_train,y_test = train_test_split(Xfeatures,ylabels,test_size=0.2,random_state=2)

#pipe_lr = Pipeline(steps=[('cv',CountVectorizer()), ('lr_multi',MultiOutputClassifier(LogisticRegression()))])

#pipe_lr.fit(x_train,y_train)

#print('score is:')
#pipe_lr.score(x_test,y_test)

