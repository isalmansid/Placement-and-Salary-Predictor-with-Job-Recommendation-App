from flask import Flask,request,jsonify
import numpy as np
import pickle

model = pickle.load(open('placement_model.pkl','rb'))

app = Flask(__name__)

@app.route('/')
def index():
    return "Hello world"

@app.route('/predict',methods=['POST'])
def predict():
    ssc_p = request.form.get('ssc_p')
    hsc_p = request.form.get('hsc_p')
    degree_p = request.form.get('degree_p')
    workex = request.form.get('workex')
    etest_p = request.form.get('etest_p')

    input_query = np.array([[ssc_p,hsc_p,degree_p,workex,etest_p]])
    result = model.predict(input_query)[0]
    return jsonify({'placement':str(result)})

if __name__ == '__main__':
    app.run(debug=True)


 #   result = {'ssc_p': ssc_p, 'hsc_p': hsc_p, 'degree_p': degree_p, 'workex': workex, 'etest_p': etest_p}
  #  return jsonify(result)
