import pandas as pd
import numpy as np

import seaborn as sns
import matplotlib.pyplot as plt

from sklearn.linear_model import LogisticRegression
#from sklearn.tree import DecisionTreeClassifier
#from sklearn.neighbors import KNeighborsClassifier
#from sklearn.naive_bayes import MultinomialNB

# Transformers
#from sklearn.feature_extraction.text import CountVectorizer,TfidfVectorizer
# Others
#from sklearn.model_selection import train_test_split
#from sklearn.pipeline import Pipeline
#from sklearn.metrics import accuracy_score,classification_report,confusion_matrix,plot_confusion_matrix

df = pd.read_csv("TEC_Salary_Predictor.csv")
d = df.shape
print(d)

#from sklearn.multioutput import MultiOutputClassifier
from sklearn.datasets import make_regression
#from sklearn.multioutput import MultiOutputRegressor
#from sklearn.ensemble import GradientBoostingRegressor


#X, y = make_regression(n_samples=12, n_targets=2, random_state=1)
#pr = MultiOutputRegressor(GradientBoostingRegressor(random_state=0)).fit(X, y).predict(X)

#print(pr)

#result = MultiOutputRegressor(GradientBoostingRegressor(random_state=0)).fit(X, y).predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,12345,5,5,5,5]])
#result = rf.predict([[4,80,68.53,6.65,6.85,6,6.94,8,0,4,4]])
#print(result)


#import neattext.functions as nfx

#df['Branch'] = df['Branch'].str.lower()
#Xfeatures = df['Branch']
#ylabels = df[['Status','Salary']]

#x_train,x_test,y_train,y_test = train_test_split(Xfeatures,ylabels,test_size=0.2,random_state=2)

#pipe_lr = Pipeline(steps=[('cv',CountVectorizer()), ('lr_multi',MultiOutputClassifier(LogisticRegression()))])

#pipe_lr.fit(x_train,y_train)

#print('score is:')
#pipe_lr.score(x_test,y_test)

from sklearn import preprocessing
from sklearn import utils


#df.mean()

#df = df.fillna(df.mean())
#df.isnull().sum()


X = df.drop(['Salary'], axis = 1)
y = df['Salary']


#df = df.replace([np.inf, -np.inf], np.nan)
#df = df.dropna()
#df = df.reset_index()

#df = df.dropna(axis=0, how='any', thresh=None, subset=None, inplace=False)

from sklearn.model_selection import train_test_split

X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.2,random_state=51)
#knn = KNeighborsClassifier(n_neighbors=12)
#knn.fit(X_test,y_test)
#kn= knn.score(X_test,y_test)
#print('New accuracy',kn)



#convert y values to categorical values

#lab = preprocessing.LabelEncoder()
#y_transformed = lab.fit_transform(y)

#view transformed values
#print(y_transformed)

#from sklearn.linear_model import LogisticRegression

from sklearn import preprocessing
from sklearn import utils

#lab_enc = preprocessing.LabelEncoder()
#encoded = lab_enc.fit_transform(y)
#print(utils.multiclass.type_of_target(y))
#print(utils.multiclass.type_of_target(y.astype('int')))
#print(utils.multiclass.type_of_target(encoded))




#lab_enc = preprocessing.LabelEncoder()
#training_scores_encoded = lab_enc.fit_transform(y)
#print(training_scores_encoded)
#print(utils.multiclass.type_of_target(y))
#print(utils.multiclass.type_of_target(y.astype('int')))
#print(utils.multiclass.type_of_target(training_scores_encoded))


classifier = LogisticRegression(solver='liblinear')
classifier.fit(X_train,y_train)

#np.ravel()

cl= classifier.score(X,y)
print('New accuracy',cl)




#result = classifier.predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,1235,5,5]])
#salman
#result = classifier.predict([[2,65,80.56,9.46,9.65,9.46,9.65,8.70,1235,5,5]])
#aarti

result = classifier.predict([[1,89.6,59.6,5.48,6.47,6.19,7.44,9.67,2,4,4]])

print('salary: ', result)
result=""




