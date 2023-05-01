from flask import Flask,request,jsonify
import numpy as np
import pickle

model = pickle.load(open('placement_model_dt.pkl','rb'))

app = Flask(__name__)

@app.route('/')
def index():
    return "Greetings from Mohd. Salman"

@app.route('/predict',methods=['POST'])
def predict():
    Branch = request.form.get('Branch')
    SSC= request.form.get('SSC')
    HSC_DIPLOMA = request.form.get('HSC_DIPLOMA')
    Degree_Sem_1_Cgpa = request.form.get('Degree_Sem_1_Cgpa')
    Degree_Sem_2_Cgpa = request.form.get('Degree_Sem_2_Cgpa')
    Degree_Sem_3_Cgpa = request.form.get('Degree_Sem_3_Cgpa')
    Degree_Sem_4_Cgpa = request.form.get('Degree_Sem_4_Cgpa')
    Degree_Sem_5_Cgpa = request.form.get('Degree_Sem_5_Cgpa')
    Programming_Skills = request.form.get('Programming_Skills')
    Communication_Skills_Out_Of_5 = request.form.get('Communication_Skills_Out_Of_5')
    English_Grammar_Out_Of_5 = request.form.get('English_Grammar_Out_Of_5')


    input_query = np.array([[Branch,SSC,HSC_DIPLOMA,Degree_Sem_1_Cgpa,Degree_Sem_2_Cgpa,Degree_Sem_3_Cgpa,Degree_Sem_4_Cgpa,Degree_Sem_5_Cgpa,Programming_Skills,Communication_Skills_Out_Of_5,English_Grammar_Out_Of_5]])
    result = model.predict(input_query)[0]
    return jsonify({'placement':str(result)})

if __name__ == '__main__':
    app.run(debug=True)


 #   result = {'ssc_p': ssc_p, 'hsc_p': hsc_p, 'degree_p': degree_p, 'workex': workex, 'etest_p': etest_p}
  #  return jsonify(result)
