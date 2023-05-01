import numpy as np
import pandas as pd
import seaborn as sns

df= pd.read_csv('TEC_Placement_2022_Dataset.csv')
#df = df.reset_index()

#sns.pairplot(df,hue=df["Status"])

#sns.set_theme(style="ticks")

#df2 = sns.load_dataset('TEC_Placement_2022_Dataset.csv')
#sd=sns.pairplot(df2, hue="Status")
#print(sd)

b = df.shape
print(b)

#df.replace([np.inf, -np.inf], np.nan, inplace=True)


X = df.drop(columns=['Status'])
y = df['Status']

#X,y = df

#df = df.replace([np.inf, -np.inf], np.nan)
#df = df.dropna()
#df = df.reset_index()

#df = df.dropna(axis=0, how='any', thresh=None, subset=None, inplace=False)


#X = X.values.astype(np.float)
#y = y.values.astype(np.float)

from sklearn.model_selection import train_test_split

X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.2,random_state=2)
#X_train = X_train.replace((np.inf, -np.inf, np.nan), 0).reset_index(drop=True)


from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score
from sklearn.ensemble import RandomForestClassifier, RandomForestRegressor


rf = RandomForestClassifier()

rf.fit(X_train,y_train)

y_pred = rf.predict(X_test)

#Test_y = np.nan_to_num(y_test)


#rf.fit(X_train, y_train[:,0])
#print("classifier accuracy:", clf.score(X_test, y_test[:,11]))

#regr = RandomForestRegressor()
#regr.fit(X_train, y_train[:,1])
#print("regressor R^2:", regr.score(X_test, y_test[:,12]))

acc = accuracy_score(y_test,y_pred)
print('Accuracy: ',acc)
print('done')

result = rf.predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,12345,5,5]])
#result = rf.predict([[4,80,68.53,6.65,6.85,6,6.94,8,0,4,4]])
print(result)
