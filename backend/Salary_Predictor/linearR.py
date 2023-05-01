import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

data = pd.read_csv('TEC_Salary_Predictor.csv')
#data.head()

d = data.shape
print(d)


#from sklearn.preprocessing import LabelEncoder
#le_Branch = LabelEncoder()

#data['Branch_n'] = le_Branch.fit_transform(data['Branch'])

#print(data)

#data.to_csv('out.csv')



#data.isnull().sum()

plt.scatter(x = data.Branch , y=data.Salary)
plt.title("Student Data")
plt.xlabel("Student Branch")
plt.ylabel("Student Salary")
plt.show()

#data.mean()

#data = data.fillna(data.mean())
#data.isnull().sum()

#X = data.drop(columns = 'Salary')
X = data.drop(['Salary'], axis = 1)
y = data['Salary']

from sklearn.model_selection import train_test_split

X_train , X_test , y_train , y_test = train_test_split(X, y , random_state=42, test_size=0.2)
#X_train.shape , y_train.shape , X_test.shape , y_test.shape

from sklearn.linear_model import LinearRegression

lr = LinearRegression()
#lr.fit(X,y)
lr.fit(X_train,y_train)

#accuracy = lr.score(X_test , y_test)
#print(accuracy)

#pred = lr.predict(X_test)
#print(pred)

print('new line')

#print(y_test)


#data1 = pd.DataFrame(np.c_[X_test , y_test , pred] ,columns =[ 'Study Branch' , 'Original Salary' , 'Predicted Salary'])
#print(data1)

print('done done')


#import joblib

#joblib.dump(lr , 'Student_Salary.pkl')

#model = joblib.load('Student_Salary.pkl')

#result = model.predict([[ 1 ]])[0][0]
#print(result)


accuracy = lr.score(X_train,y_train)
print('done is all')
print('accuracy is:', accuracy)

#result = lr.predict([[2]])
#print(result)
#result=""


#print('new salamaaaaaaaaan')
#result2 = lr.predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,12345,5,5]])
#result2 = lr.predict([[2,63,60,8.78,9.13,8.78,9.13,8.70,123,4,4,1]])
#print('Salary is:',result2)
#result2=""

#result = lr.predict([[1,89.6,59.6,5.48,6.47,6.19,7.44,9.67,2,4,4]])

#result = lr.predict([[2,65,80.56,9.46,9.65,8.9,7.8,8,12345,5,5]])
#SALMAN
result = lr.predict([[2,65,80.56,9.46,9.65,9.46,9.65,8.70,1235,5,5]])
print('salary:', result)
result=""










