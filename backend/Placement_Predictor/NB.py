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

df.replace([np.inf, -np.inf], np.nan, inplace=True)


#X = df.drop(columns=['College_Id_TU4F','Branch','10th_%','12th_%','Degree_Sem_1_Cgpa','Degree_Sem_2_Cgpa','Degree_Sem_3_Cgpa','Degree_Sem_4_Cgpa','Degree_Sem_5_Cgpa','Programming_Skills','Communication_Skills_Out_Of_5','English_Grammar_Out_Of_5'])
X = df.drop(['Status'], axis='columns')
y = df['Status']

df = df.replace([np.inf, -np.inf], np.nan)
df = df.dropna()
df = df.reset_index()

df = df.dropna(axis=0, how='any', thresh=None, subset=None, inplace=False)


#X = X.values.astype(np.float)
#y = y.values.astype(np.float)

#from sklearn.model_selection import train_test_split
#X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.2,random_state=2)
#X_train = X_train.replace((np.inf, -np.inf, np.nan), 0).reset_index(drop=True)


#from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score


#from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split




X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.2,random_state=2)


from sklearn.naive_bayes import GaussianNB
gnb = GaussianNB().fit(X_train, y_train)
gnb_predictions = gnb.predict(X_test)



#knn = KNeighborsClassifier(n_neighbors=12)
#knn.fit(X_test,y_test)
#kn= knn.score(X_test,y_test)
#print('New accuracy',kn)

accuracy = gnb.score(X_test, y_test)
print('Accuracy is:',accuracy)

result = gnb.predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,1235,5,5]])
print(result)
result=""

from sklearn.metrics import confusion_matrix
gnb_predictions = gnb.predict(X_test)
cm = confusion_matrix(y_test, gnb_predictions)
print(cm)




import matplotlib.pyplot as plt
#X_train=np.arange(0,len(X_train),1)
#plt.scatter(X,y) #plot the points
#plt.title("Hours vs Score")
###plt.xlabel("Hours Studied")
##plt.ylabel("Scores Obtained")
#plt.grid(5)
#plt.show()
#rf = RandomForestClassifier()

#rf.fit(X_train,y_train)

#y_pred = rf.predict(X_test)

#Test_y = np.nan_to_num(y_test)


#acc = accuracy_score(y_test,y_pred)
#print('Accuracy: ',acc)
#print('done')