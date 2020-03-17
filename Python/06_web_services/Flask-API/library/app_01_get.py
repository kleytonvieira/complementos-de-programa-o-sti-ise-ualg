from flask import Flask, jsonify, abort

app = Flask(__name__)


# lista de coisas ... mais tarde obter os dados da base de dados
things = [
    {
        'id': 1,
        'name': 'Prometheus',
        'local': '@lab. 163 / ISE /UAlg',
        'sensors': [
            {'sensor_name': 'mem_sensor', 'units': 'percent'},
            {'sensor_name': 'cpu_sensor', 'units': 'percent'}
        ]
    }
    ,
    {
        'id': 2,
        'name': 'Zeus',
        'local': '@lab. 163 / ISE /UAlg',
        'sensors': [
            {'sensor_name': 'temperature', 'units': 'numerical'},
            {'sensor_name': 'humidity', 'units': 'percent'}
        ]
    }
]

things_counter = 2

@app.route('/iot/api/v1.0/things/', methods=['GET'])
def get_things():
    # ver https://flask.palletsprojects.com/en/1.1.x/api/
    return jsonify({'things': things})



# ver https://flask.palletsprojects.com/en/1.1.x/api/#url-route-registrations
@app.route('/iot/api/v1.0/things/<int:thing_id>', methods=['GET'])
def get_thing(thing_id):

    thing = [t for t in things if t['id'] == thing_id] # pode ser otimizavel

    if len(thing) == 0:
        abort(404)
    return jsonify({'thing': thing[0]})


if __name__ == '__main__':
    app.run(debug=True)